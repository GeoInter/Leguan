package thb.fbi.leguan.simulation;

import java.nio.ByteBuffer;
import java.util.HashMap;
import java.util.TreeMap;

/**
 * class for memory storage (only data, instruction is seperate in ProgramStatement)
 */
public class Memory {

    private static TreeMap<Long, Byte> dataStorage = new TreeMap<Long, Byte>(); // uses keys -> keys as address
    /** lock addresses; boolean indicates if changed by other store instruction than STXR */
    private static HashMap<Long, Boolean> lockStorage = new HashMap<Long, Boolean>();
    public static long dataAdressMin = 10000;

    private static MemoryObserver observer;

    /**
     * resets the memory by clearing the hashmap
     */
    public static void reset() {
        dataStorage.clear();
        notifyObserver(-1, -1);
    }

    /**
     * set Controller as observer
     * @param observer controller class that implements the MemoryObserver
     */
    public static void setObserver(MemoryObserver observer) {
        Memory.observer = observer;
    }

    /**
     * notify Observer for changes in HashMap
     */
    public static void notifyObserver(long address, int nrOfBytes) {
        observer.update(dataStorage, address, nrOfBytes);
    }

    /**
     * Adds address (double word) to locked storage
     * @param address address of memory (double word) to lock
     */
    public static void addLockedStorage(long address) {
        for(int i = 0; i < 8; i++) {
            lockStorage.put(address+i, false);
        }
    }

    /**
     * update locked storage (STUR** instruction accessed locked memory)
     * @param address address of memory
     * @param size number of bytes changed (1, 2, 4 or 8)
     */
    public static void updateLockedStorage(long address, int size) {
        for(int i = 0; i < size; i++) {
            if(lockStorage.containsKey(address+i)) {
                lockStorage.put(address+i, true);
            }
        }
    }

    /**
     * check locked storage and returns whether lock storage was changes prior or not
     * @param address
     * @return boolean indicating if locked storage was changed by non-STXR instruction
     */
    public static boolean checkLockedStorage(long address) {
        for(int i = 0; i < 8; i++) {
            if(lockStorage.containsKey(address)) {
                if(lockStorage.get(address)) {
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * clear locked storage
     * @param address address of memory (double word) to unlock
     */
    public static void clearLockedStorage(long address) {
        for(int i = 0; i < 8; i++) {
            lockStorage.remove(address+i);
        }
    }

    /**
     * loads a single Byte from data
     * @param address to point to memory/ index/ key of hashmap 
     * @return 1 byte value of memory
     */
    public static byte loadByte(long address) {
        return getByte(address);
    }

    /**
     * loads 2 Bytes/ half word from data
     * @param address to point to memory/ index/ key of hashmap
     * @return 2 byte value of memory
     */
    public static long loadHalfword(long address) {
        byte[]bytes = new byte[2];
        for(int i = 0; i < bytes.length; i++) {
            bytes[i] = getByte(address + i);
        }
        return combineBytes(bytes);
    }

    /**
     * loads 4 Bytes/ a word from data
     * @param address to point to memory/ index/ key of hashmap
     * @return 4 byte value of memory
     */
    public static long loadWord(long address) {
        byte[]bytes = new byte[4];
        for(int i = 0; i < bytes.length; i++) {
            bytes[i] = getByte(address + i);
        }
        return combineBytes(bytes);
    }

    /**
     * loads 8 Bytes/ a double word from data
     * @param address to point to memory/ index/ key of hashmap
     * @return 8 byte value of memory
     */
    public static long loadDWord(long address) {
        byte[]bytes = new byte[8];
        for(int i = 0; i < bytes.length; i++) {
            bytes[i] = getByte(address + i);
        }
        return combineBytes(bytes);
    }

    /**
     * loads 8 Bytes/ a double word from data and locks the addresses
     * @param address to point to memory/ index/ key of hashmap
     * @return 8 byte value of memory
     */
    public static long loadExclusive(long address) {
        addLockedStorage(address);
        byte[]bytes = new byte[8];
        for(int i = 0; i < bytes.length; i++) {
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
     * @param address
     * @return
     */
    private static byte getByte(long address) {
        Byte data = dataStorage.get(address);
        if(data == null) {
            return 0;
        }
        return data;
    }

    /**
     * combines an array of bytes into a single long value (Big Endian)
     * ARMv8 supports both Little and Big Endian, this implementation supports BE only
     * @param bytes array of bytes to be combined, first element will be highest byte
     * @return bytes combined into a single long value
     */
    private static long combineBytes(byte[] bytes) {
        long result = bytes[0];
        for(int i = 1; i < bytes.length; i++) {
            if(bytes[i] < 0) { // when bytes[i] is negative and is casted to long, it will have many leading 1s, changing the bitwise OR operation
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
     * puts/ stores a Byte into memory
     * @param address to point to memory/ index/ key of hashmap
     * @param value to be stored in memory
     */
    public static void storeByte(long address, byte value) {
        dataStorage.put(address, value);
        updateLockedStorage(address, 1);
        notifyObserver(address, 1);
    }

    /**
     * puts/ stores 2 Bytes/ Half word into memory
     * @param address to point to memory/ index/ key of hashmap
     * @param value to be stored in memory
     */
    public static void storeHalfword(long address, short value) {
        byte[] bytes = ByteBuffer.allocate(2).putShort(value).array();
        for(int i = 0; i < bytes.length; i++) {
            dataStorage.put(address+i, bytes[i]);
        }
        updateLockedStorage(address, 2);
        notifyObserver(address, 2);
    }

    /**
     * puts/ stores 4 Bytes/ a word into memory
     * @param address to point to memory/ index/ key of hashmap
     * @param value to be stored in memory
     */
    public static void storeWord(long address, int value) {
        byte[] bytes = ByteBuffer.allocate(4).putInt(value).array();
        for(int i = 0; i < bytes.length; i++) {
            dataStorage.put(address+i, bytes[i]);
        }
        updateLockedStorage(address, 4);
        notifyObserver(address, 4);
    }

    /**
     * puts/ stores 8 Bytes/ double word into memory
     * @param address to point to memory/ index/ key of hashmap
     * @param value to be stored in memory
     */
    public static void storeDWord(long address, long value) {
        byte[] bytes = ByteBuffer.allocate(8).putLong(value).array();
        for(int i = 0; i < bytes.length; i++) {
            dataStorage.put(address+i, bytes[i]);
        }
        updateLockedStorage(address, 8);
        notifyObserver(address, 8);
    }

    /**
     * store double word to memory and return boolean wheter operation was successful or not
     * @param address to point to memory/ index/ key of hashmap
     * @param value to be stored in memory
     * @return boolean indicating if operation was successful or not 
     */
    public static boolean storeExclusive(long address, long value) {
        if(! checkLockedStorage(address)) { // successful operation
            byte[] bytes = ByteBuffer.allocate(8).putLong(value).array();
            for(int i = 0; i < bytes.length; i++) {
                dataStorage.put(address+i, bytes[i]);
            }
            clearLockedStorage(address);
            notifyObserver(address, 8);
            return true;
        } else { // failed operation
            return false;
        }
    }
}
