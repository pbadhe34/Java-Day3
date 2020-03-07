/**
 * Prints the number of finalized objects using PhantomReferences
 */
import java.lang.ref.*;

public class FinalizeWithPhantomRefs {
    static class TestObject { 
	static int nObjectsFinalized = 0;	
    }

    static ReferenceQueue<TestObject> q = new ReferenceQueue<TestObject>();

    static int tmp;
    private static void doStuff(Object o) {
	tmp += o.hashCode();
    }

    public static void main(String[] args) {
	

	for (int i =0; i < 1000; i++) {
	    TestObject o = new TestObject();
	    PhantomReference<TestObject> pr = new PhantomReference<TestObject>(o, q);
	    doStuff(o);
	    o = null;
	    System.out.println("Main calling GC..");
	    System.gc();
	}
	
	Thread finalizerThread = new Thread() {
		public void run() {
		    for (;;) {
			try {
			    Reference ref = q.remove(); //block until PhantomRef is available
			    System.out.println("Thread has recd the PhantomRef object .");
			    System.err.println("Regular ref finalized count in thread is  "+(++TestObject.nObjectsFinalized));
			} catch (InterruptedException e) {
		        }
		   }		 
	    }
	};
	finalizerThread.start();
    }
}
