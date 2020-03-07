
  
  
 public class TestProcess
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
    System.out.println("SetData will be done by another thread and processData in the current thread ..");
   
     ProcessThread thread = new ProcessThread(100); 

     thread.start();

     ProocessData();
   } 
  }