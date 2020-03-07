
  
  //Modified shared resource with synchronized methods
 public class SyncCallMe  extends CallMe
 {
   
  public synchronized void call(String msg)throws InterruptedException
    {
        System.out.print("[");
        Thread.sleep(2000);

        System.out.print(msg);

        System.out.println("]");      

    
    }
}