package thb.fbi;

public enum Base
{
    DEC(10), 
    HEX(16), 
    BIN(2);
    
    private int value;
    
    private Base(final int value) {
        this.value = value;
    }
    
    public int getValue() {
        return this.value;
    }
}
