package thb.fbi.simulation;

/**
 * class for UI - all controller access the same controller
 * implements the singleton pattern
 */
public class SimulatorFactory {

    private static Simulator simulator;

    private SimulatorFactory() {}

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
