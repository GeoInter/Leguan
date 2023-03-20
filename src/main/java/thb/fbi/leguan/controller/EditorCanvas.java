package thb.fbi.leguan.controller;

import org.fxmisc.flowless.VirtualizedScrollPane;
import org.fxmisc.richtext.CodeArea;

import javafx.scene.control.SplitPane;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Rectangle;

public class EditorCanvas extends Pane {

    private int lineNumber = 69;
    private Rectangle highlighRectangle;
    /* estimated line height constant, depends on CSS sytling of codeArea text */
    private int estimatedLineHeight = 16;

    public EditorCanvas(SplitPane splitPane, VirtualizedScrollPane<CodeArea> scrollPane) {
        super();
        setPickOnBounds(false);
        highlighRectangle = new Rectangle();
        highlighRectangle.setHeight(18);
        highlighRectangle.widthProperty().bind(splitPane.widthProperty()); // maybe just set instead of bind? AND
                                                                           // subtract size of scrollbar
        highlighRectangle.setY(0);
        highlighRectangle.setId("highlight-code");
        highlighRectangle.setPickOnBounds(false);
        highlighRectangle.setDisable(true);
        // highlighRectangle.setVisible(false);
        getChildren().add(highlighRectangle);
        setPickOnBounds(false);
    }

    public void draw() {
        highlighRectangle.setVisible(true);
    }

    public void setLineNumber(int lineNumber) {
        this.lineNumber = lineNumber;
        reposition(0, 0, 0);
    }

    public int getLineNumber() {
        return this.lineNumber;
    }

    public void reposition(double scrollPosition, double scrollPaneHeight, double scrollAmount) {
        /*
         * add delta to estimatedScrollPosition to get an exact position when scrollbar
         * is not at top or bottom. EstimatedScrollPosition is only correct for the
         * top/bottom position of scrollbar, but incorrect for all other positions
         */
        if(scrollPosition <= 0) {
            scrollAmount = 0;
        } else if((scrollPaneHeight - getHeight()) == scrollPosition) {
            scrollAmount = 0;
        }
        double  newYPos = (this.lineNumber * estimatedLineHeight) - scrollPosition + scrollAmount;
        translateYProperty().set(newYPos);
    }
}
