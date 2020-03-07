package app;

public class Business {
	 
    private Object lock1 = new Object();
    private Object lock2 = new Object();
 
    public void foo() {
        synchronized (lock1) {
            synchronized (lock2) {
                System.out.println("Inside lock2 with Foo");
            }
        }
    }
 
    public void bar() {
        synchronized (lock2) {
            synchronized (lock1) {
                System.out.println("Inside lock1 with bar");
            }
        }
    }
}