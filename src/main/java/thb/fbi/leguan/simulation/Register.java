package thb.fbi.leguan.simulation;

import java.text.NumberFormat;

import javafx.beans.property.SimpleBooleanProperty;

public abstract class Register {
    /** name of the register */
    protected String name;
    /** number/ id/ index of the register */
    protected int id;
    /** Property for indicating if register is in use or can be grayed out in UI */
    protected SimpleBooleanProperty isUsed = new SimpleBooleanProperty(true);

    // TODO: Use a NumberFormatter instead of insert into the String 
    /**
     * Updates the shown value in UI
     * delimites binary and hex number in pairs of 4
     * formats decimal with set Locale (points/ commas)
     * @param value to show in UI
     */
    protected String getShownValueAsString(long value, Base numberFormat) {
        StringBuilder str;
        switch(numberFormat) {
            case BIN: // binary (space delimited in pairs of 4)
                String bin = Long.toBinaryString(value);
                str = new StringBuilder(bin);
                for(int i = bin.length()-4; i > 0; i-= 4) {
                    str.insert(i, " ");
                }
                str.insert(0, "0b");
                return str.toString();
            case HEX: // hexadecimal (space delimited in pairs of 4)
                String hex = Long.toHexString(value).toUpperCase();
                str = new StringBuilder(hex);
                for(int i = hex.length()-4; i > 0; i-= 4) {
                    str.insert(i, " ");
                }
                str.insert(0, "0x");
                return str.toString();
            case uDEC: // unsigned decimal (point delimited in pairs of 3)
                String unsigned = Long.toUnsignedString(value);
                str = new StringBuilder(unsigned);
                for(int i = unsigned.length()-3; i > 0; i-= 3) {
                    str.insert(i, ".");
                }
                str.insert(0, "u ");
                return str.toString();
            case ASCII: 
                throw new IllegalArgumentException("Usage of ASCII in register is not yet supported");
            case DEC: // signed decimal
            default:
                NumberFormat nf = NumberFormat.getInstance();
                return nf.format(value);
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public SimpleBooleanProperty getIsUsed() {
        return isUsed;
    }

    public void setIsUsed(Boolean isUsed) {
        this.isUsed.set(isUsed);
    }
}
