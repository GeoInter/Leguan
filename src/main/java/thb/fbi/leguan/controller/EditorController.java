package thb.fbi.leguan.controller;

import java.time.Duration;
import java.util.Collection;
import java.util.Collections;
import java.util.concurrent.ExecutorService;
import java.util.function.IntFunction;

import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTreeWalker;
import org.fxmisc.flowless.VirtualizedScrollPane;
import org.fxmisc.richtext.CodeArea;
import org.fxmisc.richtext.LineNumberFactory;
import org.fxmisc.richtext.model.PlainTextChange;
import org.fxmisc.richtext.model.StyleSpans;
import org.fxmisc.richtext.model.StyleSpansBuilder;
import org.reactfx.EventStream;
import org.reactfx.util.Try;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.concurrent.Task;
import javafx.fxml.FXML;
import javafx.scene.input.ScrollEvent;
import javafx.scene.layout.StackPane;
import javafx.scene.shape.Circle;
import thb.fbi.leguan.parser.SyntaxHighlighter;
import thb.fbi.leguan.parser.antlr.LegV8Lexer;
import thb.fbi.leguan.parser.antlr.LegV8Parser;
import thb.fbi.leguan.simulation.Simulator;
import thb.fbi.leguan.simulation.SimulatorSingleton;
import thb.fbi.leguan.utility.ExecutorServiceProvider;

public class EditorController {

    @FXML
    StackPane codeStackPane;

    private Circle assembleIndicator;

    private CodeArea codeArea;

    private EditorCanvas editorCanvas;

    // default font size in pt
    private final short defaultFontSize = 11;
    private short currentFontSize = defaultFontSize;
    private final short maxFontSize = 19;
    private final short minFontSize = 9;

    private VirtualizedScrollPane<CodeArea> codeAreaScrollPane;

    private ExecutorService executorService;

    private Simulator simulator = SimulatorSingleton.getSimulator();

    @FXML
    public void initialize() {
        executorService = ExecutorServiceProvider.getExecutorService();

        codeArea = new CodeArea();
        codeAreaScrollPane = new VirtualizedScrollPane<CodeArea>(codeArea);
        codeStackPane.getChildren().add(codeAreaScrollPane);

        IntFunction<String> lineNumberFormat = (digits -> " %" + digits + "d\t");
        codeArea.setParagraphGraphicFactory(LineNumberFactory.get(codeArea, lineNumberFormat));
        codeArea.setLineHighlighterOn(true);
        codeArea.textProperty().addListener(new ChangeListener<String>() {

            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                simulator.getIsCodeChanged().set(true);
                assembleIndicator.setId("codeStatus_changed");
            }

        });

        EventStream<PlainTextChange> textChanges = codeArea.plainTextChanges();

        textChanges.successionEnds(Duration.ofMillis(500))
                .supplyTask(this::computeHighlightingAsync)
                .awaitLatest(textChanges)
                .subscribe(this::applyHighlighting);

        editorCanvas = new EditorCanvas(codeArea, codeAreaScrollPane);
        codeStackPane.getChildren().add(editorCanvas);

        // TODO: Fix Event not being triggered
        codeArea.addEventFilter(ScrollEvent.ANY, scroll -> {
            System.out.println("Scrolling Detected");
            editorCanvas.reposition(codeAreaScrollPane.getEstimatedScrollY(),
                    codeAreaScrollPane.getTotalHeightEstimate(), scroll.getDeltaY());
        });
        /*codeArea.estimatedScrollYProperty().addListener((obs, oldVal, newVal) -> {
            //System.out.println("Scrolled Y to: " + newVal);
            //editorCanvas.reposition(codeAreaScrollPane.getEstimatedScrollY(),
            //        codeAreaScrollPane.getTotalHeightEstimate(), newVal);
        });*/

        restoreDefaultFontSize();
    }

    private Task<StyleSpans<Collection<String>>> computeHighlightingAsync() {
        String code = codeArea.getText();

        Task<StyleSpans<Collection<String>>> task = new Task<StyleSpans<Collection<String>>>() {
            @Override
            protected StyleSpans<Collection<String>> call() throws Exception {
                return computeHighlighting(code);
            }
        };
        executorService.execute(task);
        return task;
    }

    private static StyleSpans<Collection<String>> computeHighlighting(String text) {
        if (text.length() > 0) {
            CharStream input = CharStreams.fromString(text);
            LegV8Lexer lexer = new LegV8Lexer(input);
            lexer.getErrorListeners().clear();
            // parse
            CommonTokenStream tokens = new CommonTokenStream(lexer);
            LegV8Parser parser = new LegV8Parser(tokens);
            parser.getErrorListeners().clear();
            parser.setBuildParseTree(true);
            LegV8Parser.MainContext mainContext = parser.main();

            ParseTreeWalker walker = new ParseTreeWalker();
            SyntaxHighlighter syntaxHighlighter = new SyntaxHighlighter(text.length());
            walker.walk(syntaxHighlighter, mainContext);
            return syntaxHighlighter.getStyles();
        } else {
            StyleSpansBuilder<Collection<String>> objectStyleSpansBuilder = new StyleSpansBuilder<>();
            objectStyleSpansBuilder.add(Collections.emptyList(), 0);
            return objectStyleSpansBuilder.create();
        }
    }

    private void applyHighlighting(Try<StyleSpans<Collection<String>>> taskTry) {
        StyleSpans<Collection<String>> highlighting = taskTry.get();
        if (highlighting.getSpanCount() > 0) {
            codeArea.setStyleSpans(0, highlighting);
        }
    }

    public CodeArea getCodeArea() {
        return this.codeArea;
    }

    public String getCodeAreaText() {
        return codeArea.getText();
    }

    public VirtualizedScrollPane<CodeArea> getVirtualizedScrollPane() {
        return codeAreaScrollPane;
    }

    public void setAssembleIndicator(Circle assembleIndicator) {
        this.assembleIndicator = assembleIndicator;
    }

    public void setIsEnabledLineHighlighter(boolean isEnabled) {
        editorCanvas.setVisible(isEnabled);
    }

    public void setLineNumber(int lineNumber) {
        editorCanvas.setLineNumber(lineNumber);
    }

    public void increaseFontSize() {
        if (currentFontSize < maxFontSize) {
            currentFontSize++;
            codeArea.setStyle("-fx-font-size: " + currentFontSize + "pt;");
            editorCanvas.setCurrentLineHeight(currentFontSize);
        }
    }

    public void decreaseFontSize() {
        if (currentFontSize > minFontSize) {
            currentFontSize--;
            codeArea.setStyle("-fx-font-size: " + currentFontSize + "pt;");
            editorCanvas.setCurrentLineHeight(currentFontSize);
        }
    }

    public void restoreDefaultFontSize() {
        currentFontSize = defaultFontSize;
        codeArea.setStyle("-fx-font-size: " + currentFontSize + "pt;");
        editorCanvas.setCurrentLineHeight(currentFontSize);
    }
}
