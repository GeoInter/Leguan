package thb.fbi.simulation;

import java.util.HashMap;

/**
 * Observer Interface specifically for Memory and its Controller
 */
public interface MemoryObserver {
    public void update(HashMap<Long, Byte> data);
}
