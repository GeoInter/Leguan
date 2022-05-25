package thb.fbi.simulation;

import java.util.HashMap;

/**
 * class for memory storage (only data, instruction is seperate in ProgramStatement)
 */
public class Memory {

    public static HashMap<Integer, Byte> dataStorage = new HashMap<Integer, Byte>(); // uses keys -> keys as address
    // uses put() method to add elements

}
