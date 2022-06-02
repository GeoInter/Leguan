package thb.fbi.simulation;

import java.util.HashMap;

public interface MemoryObserver {
    public void update(HashMap<Long, Byte> data);
}
