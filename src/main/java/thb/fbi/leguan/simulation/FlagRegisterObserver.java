package thb.fbi.leguan.simulation;

/**
 * Observer Interface specifically for FlagRegister and its Controller
 */
public interface FlagRegisterObserver {
    public void update(boolean n, boolean z, boolean c, boolean v);
    
}
