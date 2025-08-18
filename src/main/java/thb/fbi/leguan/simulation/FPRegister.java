package thb.fbi.leguan.simulation;

/**
 * Class reprensting a Assembler register
 * which holds double and single precision floating point values
 */
public class FPRegister extends Register {

    private float floatValue;

    private double doubleValue;

    private Base singlePrecisionNumberFormat = Base.DEC;

    private Base doublePrecisionNumberFormat = Base.DEC;

    private FPRegisterObserver observer;

    public FPRegister(String name, int id) {
        this.id = id;
        this.name = name;
    }

    public String getSinglePrecisionValueAsString() {
        if (this.singlePrecisionNumberFormat == Base.DEC) {
            return Float.toString(getSPValue());
        }
        return this.getShownValueAsString(Float.floatToRawIntBits(getSPValue()), this.singlePrecisionNumberFormat, 32);
    }

    public String getDoublePrecisionValueAsString() {
        if (this.doublePrecisionNumberFormat == Base.DEC) {
            return Double.toString(getDPValue());
        }
        return this.getShownValueAsString(Double.doubleToRawLongBits(getDPValue()), this.doublePrecisionNumberFormat);
    }

    @Override
    public synchronized void reset() {
        floatValue = 0;
        doubleValue = 0;

        this.observer.update(getSinglePrecisionValueAsString(),
                getDoublePrecisionValueAsString());
    }

    public synchronized void setSinlgePrecisionValue(float value) {
        floatValue = value;
        // Set lower 32bits of the double precision register value
        long doublePrecisionValue = Double.doubleToRawLongBits(doubleValue);
        int singlePrecisionValue = Float.floatToRawIntBits(floatValue);
        // clear lower half for the next step
        doublePrecisionValue = doublePrecisionValue & 0xFFFFFFFF00000000L;
        // override the lower half with the float value
        doublePrecisionValue = doublePrecisionValue | singlePrecisionValue;
        doubleValue = Double.longBitsToDouble(doublePrecisionValue);

        this.observer.update(getSinglePrecisionValueAsString(),
                getDoublePrecisionValueAsString());
    }

    public synchronized void setDoublePrecisionValue(double value) {
        doubleValue = value;
        // Copy lower 32bits into the single precision register value
        long doublePrecisionValue = Double.doubleToRawLongBits(value);
        long singlePrecisionValue = 0x00000000FFFFFFFF & doublePrecisionValue;
        floatValue = Float.intBitsToFloat((int) singlePrecisionValue);

        this.observer.update(getSinglePrecisionValueAsString(),
                getDoublePrecisionValueAsString());
    }

    public float getSPValue() {
        return floatValue;
    }

    public double getDPValue() {
        return doubleValue;
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
