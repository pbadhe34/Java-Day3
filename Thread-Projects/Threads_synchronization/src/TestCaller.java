
  
  //Test threads with non-synchronized access
 public class TestCaller
 {
     
  public static void main(String args[])throws InterruptedException
   { 
    System.out.println("Starting callers here...");
     System.out.println(" ");
    CallMe target = new CallMe();    
    Caller thread1 = new Caller(target,"Welcome to ");
    Caller thread2 = new Caller(target,"Non-Synchronized");  
    Caller thread3 = new Caller(target,"World");

      System.out.println(" ");
      System.out.println("Now wait for the callers here.. ");
      thread1 .t.join();
      thread2 .t.join();
      thread3 .t.join();
     
      System.out.println("This is the End ");
      

   } 
  }