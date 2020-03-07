 
/**
 * This is a demonstration of how NOT to write multi-threaded programs.
 * It is a program that purposely causes deadlock between two threads that
 * are both trying to acquire locks for the same two resources.
 * To avoid this sort of deadlock when locking multiple resources, all threads
 * should always acquire their locks in the same order.
 **/
public class Deadlock {
    public static void main(String[] args) {
        // These are the two resource objects we'll try to get locks for
        final Object resource1 = "resource1";
        final Object resource2 = "resource2";
        // Here's the first thread.  It tries to lock resource1 then resource2
        Thread t1 = new Thread() {
		public void run() {
			System.out.println("Thread 1: waiting to get lock on resource 1");
		    // Lock resource 1
		    synchronized(resource1) {
			System.out.println("Thread 1: locked resource 1");
			
			// Pause for a bit,give the other thread a chance to run.  
			 
			try { Thread.sleep(50); }
			catch (InterruptedException e) {}
			
			System.out.println("Thread 1: waiting to get lock on resource 2");
			// Now wait 'till we can get a lock on resource 2
			synchronized(resource2) {
			    System.out.println("Thread 1: locked resource 2");
			}
			System.out.println("Thread 1: End..");
		    }
		}
	    };
        
        // Here's the second thread.  It tries to lock resource2 then resource1
        Thread t2 = new Thread() {
		public void run() {
		    // This thread locks resource 2 in the beginning
			System.out.println("Thread 2: waiting to get lock on resource 2");
		    synchronized(resource1) {
			System.out.println("Thread 2: locked resource 2");
			
			// Then it pauses  
			try { Thread.sleep(50); }
			catch (InterruptedException e) {}
			
			//Then it tries to lock resource1.But wait! Thread1
			//has locked the resource1, and won't release it 'till it
			//gets a lock on resource2. This thread holds the
			// lock on resource2, and won't release it 'till it
			// gets resource1.This an impasse. Neither
			// thread can continue, keep waiting to get the lock  and the program freezes up.
			System.out.println("Thread 2: waiting to get lock on resource 1");
			synchronized(resource2) {
			    System.out.println("Thread 2: locked resource 1");
			}
			System.out.println("Thread 2: End..");
		    }
		}
	    };
        
        // Start the two threads. If all goes as planned, deadlock will occur, 
        // and the program will never come out.
        t1.start(); 
        t2.start();
    }
}
