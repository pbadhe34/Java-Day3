
  
  //Shared resource across the threads
 public class CallMe  
 {
     

  public void call(String msg)throws InterruptedException
    {
        System.out.print("[");
        Thread.sleep(2000);

        System.out.print(msg);

        System.out.println("]");      

    
    }
}