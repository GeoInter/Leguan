package thb.fbi.simulation;

/** 
 * \brief class for reprenting possible numberformats
 * 
 * numberformats are used in UI for displaying register value as Binary(2), Decimal(10) or Hexdecimal(16)
 */
public enum Base
{
    BIN(2),
    DEC(10), 
    HEX(16);
    
    private int value;
    
    private Base(final int value) {
        this.value = value;
    }
    
    public int getValue() {
        return this.value;
    }
}
