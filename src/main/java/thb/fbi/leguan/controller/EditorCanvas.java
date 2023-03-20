package thb.fbi.leguan.controller;

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
    /* estimated line height constant, depends on CSS sytling of codeArea text */
    private final int estimatedLineHeight = 16;

    public EditorCanvas(CodeArea codeArea) {
        super();
        highlighRectangle = new Rectangle();
        highlighRectangle.setHeight(18);
        highlighRectangle.widthProperty().bind(codeArea.widthProperty());
        highlighRectangle.setY(0);
        highlighRectangle.setId("highlight-code");
        highlighRectangle.setPickOnBounds(false);
        highlighRectangle.setDisable(true);
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