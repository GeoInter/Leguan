package thb.fbi.leguan.controller;

import org.fxmisc.flowless.VirtualizedScrollPane;
import org.fxmisc.richtext.CodeArea;

import javafx.scene.layout.Pane;
import javafx.scene.shape.Rectangle;

/**
 * Overlay Canvas for CodeArea/ Text Editor
 * Allows for highlighting a line
 */
public class EditorCanvas extends Pane {

    private int lineNumber = 0;
    private Rectangle highlighRectangle;
    private VirtualizedScrollPane<CodeArea> scrollpane;
    /* estimated line height constant, depends on CSS sytling of codeArea text */
    private final double defaultLineHeight = 19;
    private double currentLineHeight = defaultLineHeight;

    public EditorCanvas(CodeArea codeArea, VirtualizedScrollPane<CodeArea> scrollpane) {
        super();
        this.scrollpane = scrollpane;
        highlighRectangle = new Rectangle();
        highlighRectangle.setHeight(currentLineHeight);
        highlighRectangle.widthProperty().bind(codeArea.widthProperty());
        highlighRectangle.setY(0);
        highlighRectangle.setId("highlight-code");
        highlighRectangle.setPickOnBounds(false);
        highlighRectangle.setDisable(true);
        highlighRectangle.setVisible(false);
        getChildren().add(highlighRectangle);
        setPickOnBounds(false);
    }

    public void setLineHighlightingVisible(boolean isVisible) {
        highlighRectangle.setVisible(isVisible);
    }

    public void setLineNumber(int lineNumber) {
        this.lineNumber = lineNumber;
        highlighRectangle.setVisible(true);
        reposition(scrollpane.getEstimatedScrollY(), 0, 0);
    }

    public int getLineNumber() {
        return this.lineNumber;
    }

    /**
     * repositions the whole canvas for highlighting a different line in the text editor
     * @param scrollPosition position of the scrollbar
     * @param scrollPaneHeight height of scrollpane (not only viewport, but the overall (hidden) height)
     * @param scrollAmount amount of scrolling (e.g. mousewheel movement equals x pixels)
     */
    public void reposition(double scrollPosition, double scrollPaneHeight, double scrollAmount) {
        /*
         * add delta to estimatedScrollPosition to get an exact position when scrollbar
         * is not at top or bottom. EstimatedScrollPosition is only correct for the
         * top/bottom position of scrollbar, but incorrect for all other positions
         * 
         * When scrollPosition is lower than scrollAmount causes a displacement
         * (scrolling to top, but actually some pixels are missing to reach top)
         * 
         * Similar displacement for bottom: When scrollbar almost at end, the highlighter
         * is displaced. In that case set the position to the actual end
         * 
         * When Scrollbar is not present (all text fits into codeArea) no further 
         * repositioning is needed
         */
        if(scrollPaneHeight < getHeight()) {
            scrollAmount = 0;
        } else if(scrollPosition <= 39 && scrollAmount > 0) {
            scrollAmount = 0;
            scrollPosition = 0;
        } else if((scrollPaneHeight - getHeight()) == scrollPosition && scrollAmount < 0) {
            scrollAmount = 0;
        } else if((scrollPaneHeight - getHeight()-39) <= scrollPosition && scrollAmount < 0) {
            scrollAmount = 0;
            scrollPosition = scrollPaneHeight - getHeight();
        }
        double  newYPos = (this.lineNumber * currentLineHeight) - scrollPosition + scrollAmount;
        translateYProperty().set(newYPos);
    }

    public double getCurrentLineHeight() {
        return currentLineHeight;
    }

    public void setCurrentLineHeight(double lineHeight) {
        currentLineHeight = lineHeight;
    }
}
