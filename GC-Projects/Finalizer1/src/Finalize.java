
/**
 * Prints the number of finalized objects
 */
public class Finalize {
    static class TestObject { 
	static int nObjectsFinalized = 0;
	
	protected void finalize() throws Throwable {
	    System.err.println("Objects getting finalized are :  "+(++nObjectsFinalized));
	    
	}
    }

    static int tmp;
    private static void doStuff(Object o) {
	tmp += o.hashCode();
    }

    public static void main(String[] args) throws InterruptedException {
	for (;;) {
	    TestObject o = new TestObject();
	    doStuff(o);
	    Thread.sleep(1000);
	    o = null;
	    System.gc();
	}
    }
}
