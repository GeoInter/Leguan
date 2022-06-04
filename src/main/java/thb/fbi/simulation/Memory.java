package thb.fbi.simulation;

import java.nio.ByteBuffer;
import java.util.TreeMap;

/**
 * class for memory storage (only data, instruction is seperate in ProgramStatement)
 */
public class Memory {

    private static TreeMap<Long, Byte> dataStorage = new TreeMap<Long, Byte>(); // uses keys -> keys as address
    public static long dataAdressMin = 10000;

    private static MemoryObserver observer;

    /**
     * resets the memory by clearing the hashmap
     */
    public static void reset() {
        dataStorage.clear();
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
    public static void notifyObserver() {
        observer.update(dataStorage);
    }

    /**
     * loads a single Byte from data
     * @param address to point to memory/ index/ key of hashmap 
     * @return
     */
    public static byte loadByte(long address) {
        return getByte(address);
    }

    /**
     * loads 2 Bytes/ half word from data
     * @param address to point to memory/ index/ key of hashmap
     * @return
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
     * @return
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
     * @return
     */
    public static long loadDWord(long address) {
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
     * combines an array of bytes into a single long value
     * @param bytes array of bytes to be combined, first element will be highest byte
     * @return bytes combined into a single long value
     */
    private static long combineBytes(byte[] bytes) {
        long result = bytes[0];
        System.out.println("start: " + result);
        System.out.println("0 iteration: " + Long.toBinaryString(result));
        for(int i = 1; i < bytes.length; i++) {
            result = (((result) << 8) | bytes[i]);
            System.out.println(i + " iteration: " + Long.toBinaryString(result));
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
        notifyObserver();
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
        notifyObserver();
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
        notifyObserver();
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
        notifyObserver();
    }
}
