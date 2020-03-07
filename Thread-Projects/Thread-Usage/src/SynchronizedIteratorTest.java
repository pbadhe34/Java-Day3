import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
 
/**
 * This test program illustrates how a collection's iterator fails fast
 * and throw ConcurrentModificationException
 *  
 *
 */
public class SynchronizedIteratorTest {
 
   // private List<Integer> list = new ArrayList<>();
    
    List<String> safeList = Collections.synchronizedList(new ArrayList<>());
    
  // adds some elements to the list using Iterator
    
    Iterator<String> SyncIterator = safeList.iterator(); 
 
     
 
    public void runUpdateThread() {
        Thread thread1 = new Thread(new Runnable() {
 
            public void run() {
            	for (int i = 0; i < 10_000; i++) {
            		System.out.println("Updating List");
            		safeList.add("Data "+i);
                }
            }
        });
 
        thread1.start();
    }
 
 
    public void runIteratorThread() {
        Thread thread2 = new Thread(new Runnable() {
        	
        	//Although the safeList is thread-safe, its iterator is not, so we should manually add synchronized andthe iterators of the synchronized collections are fail-fast.
        	 
        	        	
        	public void run() {
                ListIterator<String> iterator = safeList.listIterator();
                System.out.println("\n***Itertaing over the list");
                synchronized (safeList) {
            	    while (iterator.hasNext()) {
            	        String next = iterator.next();
            	        System.out.println(next);
            	    }
            	}
            }
        	
            /*public void run() {
                ListIterator<String> iterator = safeList.listIterator();
                while (iterator.hasNext()) {
                    String value = iterator.next();
                    System.out.println(value);
                }
            }*/
        });
 
        thread2.start();
    }
 
    public static void main(String[] args) {
    	SynchronizedIteratorTest tester = new SynchronizedIteratorTest();
 
        
        tester.runUpdateThread();
        
        tester.runIteratorThread();
    }
}


 
 

