  
import app.Business;


//To Avoid Deadlocks use BusinessSimple insetead of Business objects

public class DeadLock1 {
    public static void main(String[] args) {
        Business business = new Business();
 
        Thread t1 = new Thread(new Runnable() {
            public void run() {
                business.foo();
            }
        });
 
        t1.start();
 
        Thread t2 = new Thread(new Runnable() {
            public void run() {
                business.bar();
            }
        });
 
        t2.start();
    }
}

 
 

 