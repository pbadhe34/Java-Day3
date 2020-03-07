
  
  
 public class TestDeadLock implements Runnable
 {
   FirstThread a = new FirstThread();
   SecondThread b = new SecondThread();

   TestDeadLock()throws Exception
   {
    Thread.currentThread().setName("my Main Thread");
    Thread t = new Thread(this,"Racing Thread");
    t.start();
    a.startProcess(b);
    System.out.println("A has acquired lock on B");
    System.out.println("Main thread continues...");
    } 
     
   public void run()
   {
  try
    {
    b.startJob(a);
    System.out.println("Racing Thread continues here..");
    }
     catch(Exception e)
     {
       System.out.println("Exception in Racing Thread  "+e);

     }

   }
  public static void main(String args[])throws Exception
   {
    new TestDeadLock();
   }

}

     