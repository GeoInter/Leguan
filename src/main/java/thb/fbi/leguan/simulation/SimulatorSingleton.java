package thb.fbi.leguan.simulation;

/**
 * class for UI - all controller access the same controller
 * implements the singleton pattern
 */
public class SimulatorSingleton {

    private static Simulator simulator;

    private SimulatorSingleton() {}

    /**
     * gets the current used simulator instance for the whole app
     * @return Simulator
     */
    public static Simulator getSimulator() {
        if(simulator == null) {
            simulator = new Simulator();
        }
        return simulator;
    }

    /**
     * resets the simulator, GarbageCollection automatically destroys old instance
     */
    public static void resetSimulator() {
        simulator = null;
    }
}
