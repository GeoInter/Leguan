package thb.fbi.leguan.data;

public class InstructionPosition {

    private int startingLineNumber;

    private int endingLineNumber;

    public InstructionPosition(int startingLineNumber, int endingLineNumber) {
        this.startingLineNumber = startingLineNumber;
        this.endingLineNumber = endingLineNumber;
    }

    public boolean isOneLine() {
        if (startingLineNumber == endingLineNumber) return true;
        return false;
    }

    public int getStartingLineNumber() {
        return startingLineNumber;
    }

    public void setStartingLineNumber(int startingLineNumber) {
        this.startingLineNumber = startingLineNumber;
    }

    public int getEndingLineNumber() {
        return endingLineNumber;
    }

    public void setEndingLineNumber(int endingLineNumber) {
        this.endingLineNumber = endingLineNumber;
    }

}
