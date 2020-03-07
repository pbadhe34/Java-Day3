
  
  
 public class TestPriority
 {
    

  public static void main(String args[])throws InterruptedException
   { 
      System.out.println("Starting the two clicker threads   ");
     Thread thread = Thread.currentThread();
       thread.setPriority(Thread.MAX_PRIORITY);
        Clicker t1 = new Clicker(Thread.NORM_PRIORITY + 3);
        Clicker t2 = new Clicker(Thread.NORM_PRIORITY - 3);
       t1.startThread();
       t2.startThread();
      System.out.println("Now check the Clicker counts  ");
       Thread.sleep(2000);
       t1.stopThread();
       t2.stopThread();

    
      System.out.println("Wait for the Clickers to terminate...  ");

      t1.t.join();
      t2.t.join();
     
     System.out.println("Low Priority Thread clicks were  : "+t2.click);
     System.out.println("Hi Priority Thread clicks were  : "+t1.click);
      
     System.out.println("Current Thread is stopped   ");
     
   } 
  }