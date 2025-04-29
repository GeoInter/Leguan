package thb.fbi.leguan.controller;

import java.util.HashMap;
import java.util.Map;

import org.fxmisc.flowless.VirtualizedScrollPane;
import org.fxmisc.richtext.CodeArea;

import javafx.scene.layout.Pane;
import javafx.scene.shape.Rectangle;
import thb.fbi.leguan.data.InstructionPosition;

/**
 * Overlay Canvas for CodeArea/ Text Editor
 * Allows for highlighting a line
 */
public class EditorCanvas extends Pane {

    private int lineNumber = 0;
    private Rectangle highlighRectangle;
    private VirtualizedScrollPane<CodeArea> scrollpane;
    /**
     * estimated lineHeights depending on the set font size
     * 
     * Purely determined by try and error since caret postion of codearea
     * seems always off. Currently there is no way to determine the needed
     * size programmatically.
     */
    private final Map<Integer, Double> lineHeights = new HashMap<>();
    private double currentLineHeight = 0;

    public EditorCanvas(CodeArea codeArea, VirtualizedScrollPane<CodeArea> scrollpane) {
        super();
        this.scrollpane = scrollpane;

        lineHeights.put(9, 15.0);
        lineHeights.put(10, 16.0);
        lineHeights.put(11, 19.0);
        lineHeights.put(12, 19.0);
        lineHeights.put(13, 20.0);
        lineHeights.put(14, 23.0);
        lineHeights.put(15, 24.0);
        lineHeights.put(16, 26.0);
        lineHeights.put(17, 27.0);
        lineHeights.put(18, 28.0);
        lineHeights.put(19, 31.0);

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

    public void setLineNumber(InstructionPosition position) {
        if (position != null) {
            if (position.isOneLine()) {
                highlighRectangle.setHeight(currentLineHeight);
            } else {
                int diff = (position.getEndingLineNumber() - position.getStartingLineNumber()) + 1;
                highlighRectangle.setHeight(currentLineHeight * diff);
            }
            this.lineNumber = position.getStartingLineNumber();
            highlighRectangle.setVisible(true);
            reposition(scrollpane.getEstimatedScrollY(), 0, 0);
        }
    }

    public int getLineNumber() {
        return this.lineNumber;
    }

    /**
     * repositions the whole canvas for highlighting a different line in the text
     * editor
     * 
     * @param scrollPosition   position of the scrollbar
     * @param scrollPaneHeight height of scrollpane (not only viewport, but the
     *                         overall (hidden) height)
     * @param scrollAmount     amount of scrolling (e.g. mousewheel movement equals
     *                         x pixels)
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
         * Similar displacement for bottom: When scrollbar almost at end, the
         * highlighter
         * is displaced. In that case set the position to the actual end
         * 
         * When Scrollbar is not present (all text fits into codeArea) no further
         * repositioning is needed
         */
        if (scrollPaneHeight < getHeight()) {
            scrollAmount = 0;
        } else if (scrollPosition <= 39 && scrollAmount > 0) {
            scrollAmount = 0;
            scrollPosition = 0;
        } else if ((scrollPaneHeight - getHeight()) == scrollPosition && scrollAmount < 0) {
            scrollAmount = 0;
        } else if ((scrollPaneHeight - getHeight() - 39) <= scrollPosition && scrollAmount < 0) {
            scrollAmount = 0;
            scrollPosition = scrollPaneHeight - getHeight();
        }
        double newYPos = (this.lineNumber * currentLineHeight) - scrollPosition + scrollAmount;
        translateYProperty().set(newYPos);
    }

    public double getCurrentLineHeight() {
        return currentLineHeight;
    }

    public void setCurrentLineHeight(int fontSize) {
        double lineHeight = lineHeights.get(fontSize);
        if (lineHeight != 0) {
            currentLineHeight = lineHeight;
            highlighRectangle.setHeight(lineHeight);
        }
        reposition(scrollpane.getEstimatedScrollY(), 0, 0);
    }
}
