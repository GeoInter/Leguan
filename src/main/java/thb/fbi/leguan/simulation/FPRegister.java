package thb.fbi.leguan.simulation;

import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleFloatProperty;

/**
 * Class reprensting a Assembler register
 * which holds double and single precision floating point values
 */
public class FPRegister extends Register {

    private SimpleFloatProperty floatValueProperty = new SimpleFloatProperty(0);

    private SimpleDoubleProperty doubleValueProperty = new SimpleDoubleProperty(0);

    private Base singlePrecisionNumberFormat = Base.DEC;

    private Base doublePrecisionNumberFormat = Base.DEC;

    private FPRegisterObserver observer;

    public FPRegister(int id) {
        this.id = id;
        this.name = "SP" + 0;
    }

    public String getSinglePrecisionValueAsString() {
        if (this.singlePrecisionNumberFormat == Base.DEC) {
            return Float.toString(getSPValue());
        }
        return this.getShownValueAsString(Float.floatToRawIntBits(getSPValue()), this.singlePrecisionNumberFormat);
    }

    public String getDoublePrecisionValueAsString() {
        if (this.doublePrecisionNumberFormat == Base.DEC) {
            return Double.toString(getDPValue());
        }
        return this.getShownValueAsString(Double.doubleToRawLongBits(getDPValue()), this.doublePrecisionNumberFormat);
    }

    public synchronized void reset() {
        floatValueProperty.set(0);
        doubleValueProperty.set(0);

        this.observer.update(getSinglePrecisionValueAsString(),
                getDoublePrecisionValueAsString());
    }

    public synchronized void setSinlgePrecisionValue(float value) {
        floatValueProperty.set(value);
        // Set lower 32bits of the double precision register value
        long doublePrecisionValue = Double.doubleToRawLongBits(doubleValueProperty.get());
        int singlePrecisionValue = Float.floatToRawIntBits(floatValueProperty.get());
        // clear lower half for the next step
        doublePrecisionValue = doublePrecisionValue & 0xFFFFFFFF00000000L;
        // override the lower half with the float value
        doublePrecisionValue = doublePrecisionValue | singlePrecisionValue;
        doubleValueProperty.set(Double.longBitsToDouble(doublePrecisionValue));

        this.observer.update(getSinglePrecisionValueAsString(),
                getDoublePrecisionValueAsString());
    }

    public synchronized void setDoublePrecisionValue(double value) {
        doubleValueProperty.set(value);
        // Copy lower 32bits into the single precision register value
        long doublePrecisionValue = Double.doubleToRawLongBits(value);
        long singlePrecisionValue = 0x00000000FFFFFFFF & doublePrecisionValue;
        floatValueProperty.set(Float.intBitsToFloat((int) singlePrecisionValue));

        this.observer.update(getSinglePrecisionValueAsString(),
                getDoublePrecisionValueAsString());
    }

    public float getSPValue() {
        return floatValueProperty.get();
    }

    public double getDPValue() {
        return doubleValueProperty.get();
    }

    public Base getSinglePrecisionNumberFormat() {
        return singlePrecisionNumberFormat;
    }

    public void setSinglePrecisionNumberFormat(Base singlePrecisionNumberFormat) {
        this.singlePrecisionNumberFormat = singlePrecisionNumberFormat;
    }

    public Base getDoublePrecisionNumberFormat() {
        return doublePrecisionNumberFormat;
    }

    public void setDoublePrecisionNumberFormat(Base doublePrecisionNumberFormat) {
        this.doublePrecisionNumberFormat = doublePrecisionNumberFormat;
    }

    public void setObserver(FPRegisterObserver observer) {
        this.observer = observer;
    }

}
