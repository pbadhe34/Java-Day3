
  
  ///Test threads with synchronized access
 public class SyncTestCaller
 {
     
  public static void main(String args[])throws InterruptedException
   { 
    System.out.println("Starting callers here...");
     System.out.println(" ");
  /* //Test with synchronized resource access
    SyncCallMe  target = new SyncCallMe();   
    Caller thread1 = new Caller(target,"Welcme To ");
    Caller thread2 = new Caller(target,"Synchronized");  
    Caller thread3 = new Caller(target,"World");
 */
  //Test with thread synchronized access on shared object
    //The shared resource doesnot have  synchronized access
    //But the threads can manage with synchronized access
    
    
    CallMe  target = new  CallMe();   
    SyncCaller thread1 = new SyncCaller(target,"Hi ");
    SyncCaller  thread2 = new SyncCaller(target,"Synchronized");  
    SyncCaller  thread3 = new SyncCaller(target,"Message");


      //Thread.sleep(3000);
      //System.out.println(" ");
      //System.out.println("Now wait for the callers here.. ");
       //wait for the threads here
      thread1 .t.join();
      thread2 .t.join();
      thread3 .t.join();
     
      //System.out.println("This is the End ");
      

   } 
  }