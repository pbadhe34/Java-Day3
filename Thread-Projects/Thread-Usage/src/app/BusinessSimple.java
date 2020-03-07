package app;

public class BusinessSimple {
	 
    private Object lock1 = new Object();
    private Object lock2 = new Object();
public void foo() {
    synchronized (lock1) {
        synchronized (lock2) {
            System.out.println("with foo");
        }
    }
}
 
public void bar() {
    synchronized (lock1) {
        synchronized (lock2) {
            System.out.println("with bar");
        }
     }
    }
 }