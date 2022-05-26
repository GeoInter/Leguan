package thb.fbi.simulation;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.HashMap;

/**
 * class for memory storage (only data, instruction is seperate in ProgramStatement)
 */
public class Memory {

    private static HashMap<Long, Byte> dataStorage = new HashMap<Long, Byte>(); // uses keys -> keys as address
    // uses put() method to add elements

    // TODO: test for null/ non-allocated bytes

    /**
     * resets the memory by clearing the hashmap
     */
    public static void resetMemmory() {
        dataStorage.clear();
    }

    /**
     * loads a single Byte from data
     * @param address to point to memory/ index/ key of hashmap 
     * @return
     */
    public static byte loadByte(long address) {
        return dataStorage.get(address);
    }

    /**
     * loads 2 Bytes/ half word from data
     * @param address to point to memory/ index/ key of hashmap
     * @return
     */
    public static long loadHalfword(long address) {
        byte[]bytes = new byte[2];
        bytes[0] = dataStorage.get(address);
        bytes[1] = dataStorage.get(address+1);
        return combineBytes(bytes);
    }

    /**
     * loads 4 Bytes/ a word from data
     * @param address to point to memory/ index/ key of hashmap
     * @return
     */
    public static long loadWord(long address) {
        byte[]bytes = new byte[4];
        bytes[0] = dataStorage.get(address);
        bytes[1] = dataStorage.get(address+1);
        bytes[2] = dataStorage.get(address+2);
        bytes[3] = dataStorage.get(address+3);
        return combineBytes(bytes);
    }

    /**
     * loads 8 Bytes/ a double word from data
     * @param address to point to memory/ index/ key of hashmap
     * @return
     */
    public static long loadDWord(long address) {
        byte[]bytes = new byte[8];
        bytes[0] = dataStorage.get(address);
        bytes[1] = dataStorage.get(address+1);
        bytes[2] = dataStorage.get(address+2);
        bytes[3] = dataStorage.get(address+3);
        bytes[4] = dataStorage.get(address+4);
        bytes[5] = dataStorage.get(address+5);
        bytes[6] = dataStorage.get(address+6);
        bytes[7] = dataStorage.get(address+7);
        return combineBytes(bytes);
    }

    /**
     * combines an array of bytes into a single long value
     * @param bytes array of bytes to be combined, first element will be highest byte
     * @return bytes combined into a single long value
     */
    private static long combineBytes(byte[] bytes) {
        ByteBuffer bb = ByteBuffer.allocate(bytes.length);
        bb.order(ByteOrder.nativeOrder());
        for (byte b : bytes) {
            bb.put(b);
        }
        long result = bb.getLong();
        return result;
    }

    /**
     * puts/ stores a Byte into memory
     * @param address to point to memory/ index/ key of hashmap
     * @param value to be stored in memory
     */
    public static void storeByte(long address, byte value) {
        dataStorage.put(address, value);
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
    }

    /**
     * puts/ stores 8 Bytes/ double word into memory
     * @param address to point to memory/ index/ key of hashmap
     * @param value to be stored in memory
     */
    public static void storeDWord(long address, long value) {
        byte[] bytes = ByteBuffer.allocate(4).putLong(value).array();
        for(int i = 0; i < bytes.length; i++) {
            dataStorage.put(address+i, bytes[i]);
        }
    }

    // for later Testing
    public String toString() {
        return dataStorage.toString();
    }
}
