
  
  
 public class TestRunnableProcess
 {
     
  public static void ProocessData()throws InterruptedException
  {
    
   for(int i = 0; i < 5; i++)
    {
     System.out.println("The Number processed  is  : "+i);
    Thread.sleep(1000);
    }

   }
  public static void main(String args[])throws InterruptedException
   {
    System.out.println("SetData will be done by another Runnable thread and processData in the current thread ..");
   
     ProcessRunnableThread Runthread = new ProcessRunnableThread(100); 

     Thread thread  = new Thread(Runthread);

     thread.start();

     ProocessData();
   } 
  }