
  
  //Using Second Thread Resource
 public class FirstThread
 {
    
  public synchronized void startProcess(SecondThread sec)throws Exception
  {
    String name = Thread.currentThread().getName();
    System.out.println(name + "  Entered FirstThread.startProcess");
    Thread.sleep(1000); 
     System.out.println("Trying to call SecondThread.last");
    sec.last();
  }
   public synchronized void last()throws Exception
   {     
    System.out.println("Inside  FirstThread.last");    
   }
    
  }