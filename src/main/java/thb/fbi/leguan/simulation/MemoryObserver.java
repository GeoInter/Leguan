package thb.fbi.leguan.simulation;

import java.util.TreeMap;

/**
 * Observer Interface specifically for Memory and its Controller
 */
public interface MemoryObserver {
    public void update(TreeMap<Long, Byte> newData, long changedAddress, int changedBytes);
}
