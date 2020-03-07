import app.Business;

//To Avoid Deadlocks use BusinessSimple insetead of Business objects
 
public class DeadLock2 {
    public static void main(String[] args) {
        Business business = new Business();
 
        for (int i = 0; i < 10; i++) {
            new Thread(new Runnable() {
                public void run() {
                    business.foo();
                }
            }).start();
        }
 
        for (int i = 0; i < 10; i++) {
            new Thread(new Runnable() {
                public void run() {
                    business.bar();
                }
            }).start();
        }
    }
}

 