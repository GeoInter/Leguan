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

    /**
     * Updates the shown value in UI
     * delimites binary and hex number in pairs of 4
     * formats decimal with set Locale (points/ commas)
     * @param value to show in UI
     * @param numberFormat
     */
    protected String getShownValueAsString(long value, Base numberFormat) {
        return getShownValueAsString(value, numberFormat, 64);
    }

    /**
     * Updates the shown value in UI
     * delimites binary and hex number in pairs of 4
     * formats decimal with set Locale (points/ commas)
     * @param value to show in UI
     * @param numberFormat
     * @param size maximum number of bits the string should contain
     */
    protected String getShownValueAsString(long value, Base numberFormat, int size) {
        StringBuilder str;
        int length = 0;
        switch(numberFormat) {
            case BIN: // binary (space delimited in pairs of 4)
                String bin = Long.toBinaryString(value);
                str = new StringBuilder(bin);

                // remove digits if length exceeds specified size
                if (str.length() > size) {
                    str.delete(0, size);
                }

                // insert space every 4 digits
                length = str.length();
                for(int i = length - 4; i > 0; i-= 4) {
                    str.insert(i, " ");
                }

                str.insert(0, "0b");
                return str.toString();
            case HEX: // hexadecimal (space delimited in pairs of 4)
                String hex = Long.toHexString(value).toUpperCase();
                str = new StringBuilder(hex);

                // remove digits if length exceeds specified size
                // in hexadecimal a digits equals 4 bit
                if (str.length() > size / 4) {
                    str.delete(0, size / 4);
                }

                // insert space every 4 digits
                length = str.length();
                for(int i = length - 4; i > 0; i-= 4) {
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
                throw new IllegalArgumentException("Usage of ASCII in integer register is not yet supported");
            case DEC: // signed decimal
            default:
                NumberFormat nf = NumberFormat.getInstance();
                return nf.format(value);
        }
    }

    public abstract void reset();

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

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + id;
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Register other = (Register) obj;
        if (id != other.id)
            return false;
        return true;
    }
}
