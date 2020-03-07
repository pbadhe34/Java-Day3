import java.io.*;
 
 
 class Worker {
 
    public synchronized void work() {
        String name = Thread.currentThread().getName();
        String fileName = name + ".txt";
 
        try (
            BufferedWriter writer = new BufferedWriter(new FileWriter(fileName));
        ) {
            writer.write("Thread " + name + " wrote this mesasge");
        } catch (IOException ex) {
            ex.printStackTrace();
        }
 
        while (true) {
            System.out.println(name + " is working");
        }
    }
}

/**
 * StarvationExample.java
 * This class is used to demonstrate starvation situation. *  
 */
public class StarvationExample {
 
    public static void main(String[] args) {
        Worker worker = new Worker();
 
        for (int i = 0; i < 10; i++) {
            new Thread(new Runnable() {
                public void run() {
                    worker.work();
                }
            }).start();
        }
    }
}

/*A solution to solve this starvation problem is to make the current thread waits for a specified amount of time
so other threads have chance to acquire the lock on the Worker object:
*/

class WorkerSimple {
	 
    public synchronized void work() {
        String name = Thread.currentThread().getName();
        String fileName = name + ".txt";
 
        try (
            BufferedWriter writer = new BufferedWriter(new FileWriter(fileName));
        ) {
            writer.write("Thread " + name + " wrote this mesasge");
        } catch (IOException ex) {
            ex.printStackTrace();
        }
 
        while (true) {
            System.out.println(name + " is working");
         
            try {
                wait(1000);
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }
         
        }
    }
}

