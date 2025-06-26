package thb.fbi.leguan.service;

import java.util.ArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * class for providing ExecutorServices for Threading 
 */
public class ExecutorServiceProvider {

    private static ArrayList<ExecutorService> services = new ArrayList<ExecutorService>();

    /**
     * gets new ExecutorService Instance (SingleThread)
     * @return SingleThread ExecutorService
     */
    public static ExecutorService getExecutorService() {
        ExecutorService service = Executors.newSingleThreadExecutor();
        services.add(service);
        return service;
    }

    /*
     * shutdowns all executor services
     */
    public static void shutdownAllExecutorServices() {
        for (ExecutorService executorService : services) {
            executorService.shutdownNow();
        }
    }
    
}
