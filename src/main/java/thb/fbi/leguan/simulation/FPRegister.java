package thb.fbi.leguan.simulation;

import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleFloatProperty;

public class FPRegister {

    public SimpleFloatProperty floatValueProperty = new SimpleFloatProperty(0);

    public SimpleDoubleProperty doubleValueProperty = new SimpleDoubleProperty(0);

    public FPRegister(float floatValue, double doubleValue) {
        floatValueProperty.set(floatValue);
        doubleValueProperty.set(doubleValue);
    }

    public synchronized void setSPValue(float value) {
        floatValueProperty.set(value);
        // Set lower 32bits of the double precision register value
        long doublePrecisionValue = Double.doubleToRawLongBits(doubleValueProperty.get());
        int singlePrecisionValue = Float.floatToRawIntBits(floatValueProperty.get());
        // clear lower half for the next step
        doublePrecisionValue = doublePrecisionValue & 0xFFFFFFFF00000000L;
        // override the lower half with the float value
        doublePrecisionValue = doublePrecisionValue | singlePrecisionValue;
        doubleValueProperty.set(Double.longBitsToDouble(doublePrecisionValue));
    }

    public synchronized void setDPValue(double value) {
        doubleValueProperty.set(value);
        // Copy lower 32bits into the single precision register value
        long doublePrecisionValue = Double.doubleToRawLongBits(value);
        long singlePrecisionValue = 0x00000000FFFFFFFF & doublePrecisionValue;
        floatValueProperty.set(Float.intBitsToFloat((int) singlePrecisionValue));
    }

    public float getSPValue() {
        return floatValueProperty.get();
    }

    public double getDPValue() {
        return doubleValueProperty.get();
    }
    
}
