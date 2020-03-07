import java.util.concurrent.*;
 
 
  
 
 
/**
 * SimpleExecutorServiceExample.java
 * This program demonstrates how to create a single-threaded executor
 *  
 */
public class SimpleExecutorService {
 
    public static void main(String[] args) {
        ExecutorService pool = Executors.newSingleThreadExecutor();
 
        Callable<Integer> task = new Callable<Integer>() {
            public Integer call() {
                try {
                    // fake computation time
                    Thread.sleep(5000);
                } catch (InterruptedException ex) {
                    ex.printStackTrace();
                }
 
                return 1000;
            }
        };
 
        Future<Integer> result = pool.submit(task);
 
        try {
 
            Integer returnValue = result.get();
 
            System.out.println("Return value = " + returnValue);
 
        } catch (InterruptedException | ExecutionException ex) {
            ex.printStackTrace();
        }
 
        pool.shutdown();
    }
}