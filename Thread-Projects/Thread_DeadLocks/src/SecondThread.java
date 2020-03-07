
  
  //Using First Thread Resource
 public class SecondThread
 {
    
  public synchronized void startJob(FirstThread fi)throws Exception
  {
    String name = Thread.currentThread().getName();
    System.out.println(name + "    Entered SecondThread.startJob");
    Thread.sleep(1000); 
    System.out.println("Trying to call FirstThread.last");
    fi.last();
  }
   public synchronized void last()throws Exception
   {     
    System.out.println("Inside  SecondThread.last");    
   }
    
  }