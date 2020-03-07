 

public class ThreadTest {
    
     
    public static void main(String args[])
    {
        NewThread ob1 = new NewThread("First");
        NewThread ob2 = new NewThread("Second");
		Thread t1= new Thread(ob1,ob1.threadName);
		Thread t2= new Thread(ob2,ob2.threadName);
        try
        {
			t1.start();
			t2.start();
            Thread.sleep(1000);
			System.out.println("Suspending thread First");
            t1.suspend();            
            Thread.sleep(1000);
			System.out.println("Resuming thread First");
            t1.resume();
            
            
            System.out.println("Suspending thread Second");
			t2.suspend();
            Thread.sleep(1000);
			System.out.println("Resuming thread Second");
            t2.resume();

			System.out.println("Interrupting thread First");
			t1.interrupt();


            
         
			System.out.println("Waiting for threads to finish");
		    t2.join();
		    t1.join();

        }
        catch(Exception e)
        {
            System.out.println("Interrupted exception " + e);
        }
        
        System.out.println("Main thread exiting");
        
    }
}

 