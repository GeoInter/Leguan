package thb.fbi.pipeline_visualizer.pipeline;

import java.io.Serializable;
import java.nio.ByteBuffer;
import java.util.HashMap;
import java.util.TreeMap;

/**
 * class for memory storage
 */
public class Memory implements Serializable {

    private TreeMap<Long, Byte> dataStorage;
    private HashMap<Long, Boolean> lockStorage;

    public Memory() {
        this.dataStorage = new TreeMap<Long, Byte>();
        this.lockStorage = new HashMap<Long, Boolean>();
    }

    /**
     * Adds address (double word) to locked storage
     * 
     * @param address address of memory (double word) to lock
     */
    public void addLockedStorage(long address) {
        for (int i = 0; i < 8; i++) {
            this.lockStorage.put(address + i, false);
        }
    }

    /**
     * update locked storage (STUR** instruction accessed locked memory)
     * 
     * @param address address of memory
     * @param size    number of bytes changed (1, 2, 4 or 8)
     */
    public void updateLockedStorage(long address, int size) {
        for (int i = 0; i < size; i++) {
            if (this.lockStorage.containsKey(address + i)) {
                this.lockStorage.put(address + i, true);
            }
        }
    }

    /**
     * check locked storage and returns whether lock storage was changes prior or
     * not
     * 
     * @param address
     * @return boolean indicating if locked storage was changed by non-STXR
     *         instruction
     */
    public boolean checkLockedStorage(long address) {
        for (int i = 0; i < 8; i++) {
            if(this.lockStorage.containsKey(address)) {
                if (this.lockStorage.get(address)) {
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * clear locked storage
     * 
     * @param address address of memory (double word) to unlock
     */
    public void clearLockedStorage(long address) {
        for (int i = 0; i < 8; i++) {
            this.lockStorage.remove(address + i);
        }
    }

    /**
     * loads specified number of Bytes
     * 
     * @param address to point to memory/ index/ key of hashmap
     * @return specified number of bytes value of memory
     */
    public long loadBytes(long address, byte bytesToAccess) {
        byte[] bytes = new byte[bytesToAccess];
        for (int i = 0; i < bytes.length; i++) {
            bytes[i] = getByte(address + i);
        }
        return combineBytes(bytes);
    }

    /**
     * loads 8 Bytes/ a double word from data and locks the addresses
     * 
     * @param address to point to memory/ index/ key of hashmap
     * @return 8 byte value of memory
     */
    public long loadExclusive(long address) {
        addLockedStorage(address);
        byte[] bytes = new byte[8];
        for (int i = 0; i < bytes.length; i++) {
            bytes[i] = getByte(address + i);
        }
        return combineBytes(bytes);
    }

    /**
     * gets a single Byte
     * 
     * because the HashMap uses the Byte class instead
     * of the primitive datatype byte, accessing a empty
     * index results in a NullpointerException
     * 
     * @param address
     * @return
     */
    private byte getByte(long address) {
        Byte data = this.dataStorage.get(address);
        if (data == null) {
            return 0;
        }
        return data;
    }

    /**
     * combines an array of bytes into a single long value (Big Endian)
     * ARMv8 supports both Little and Big Endian, this implementation supports BE
     * only
     * 
     * @param bytes array of bytes to be combined, first element will be highest
     *              byte
     * @return bytes combined into a single long value
     */
    private long combineBytes(byte[] bytes) {
        long result = bytes[0];
        for (int i = 1; i < bytes.length; i++) {
            if (bytes[i] < 0) { // when bytes[i] is negative and is casted to long, it will have many leading
                                // 1s, changing the bitwise OR operation
                long b = bytes[i];
                b = b & 255; // 255 = first 8 bit set
                result = (((result) << 8) | b);
            } else {
                result = (((result) << 8) | bytes[i]);
            }
        }
        return result;
    }

    /**
     * puts/ stores specified number of Bytes into memory
     * 
     * @param address to point to memory/ index/ key of hashmap
     * @param value   to be stored in memory
     */
    public void storeBytes(long address, long value, byte numberOfBytes) {
        byte[] bytes = ByteBuffer.allocate(numberOfBytes).putLong(value).array();
        for (int i = 0; i < bytes.length; i++) {
            this.dataStorage.put(address + i, bytes[i]);
        }
        updateLockedStorage(address, numberOfBytes);
    }

    /**
     * store double word to memory and return boolean wheter operation was
     * successful or not
     * 
     * @param address to point to memory/ index/ key of hashmap
     * @param value   to be stored in memory
     * @return boolean indicating if operation was successful or not
     */
    public boolean storeExclusive(long address, long value) {
        if (!checkLockedStorage(address)) { // successful operation
            byte[] bytes = ByteBuffer.allocate(8).putLong(value).array();
            for (int i = 0; i < bytes.length; i++) {
                this.dataStorage.put(address + i, bytes[i]);
            }
            clearLockedStorage(address);
            return true;
        } else { // failed operation
            return false;
        }
    }

    public String toString() {
        return this.dataStorage.toString();
    }

    public String[][] to2DStringArray() {
        String memoryString[][] = new String[dataStorage.size()][2];
        int i = 0;
        for (Long index : dataStorage.keySet()) {
            memoryString[i][0] = index.toString();
            memoryString[i][1] = Byte.toString(getByte(index));
            i++;
        }
        return memoryString;
    }
}
