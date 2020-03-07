
  
  
 public class ProcessRunnableThread implements Runnable
 {
    int number ;
   ProcessRunnableThread(int num)
    {
    number  = num;
    System.out.println("This is Runnable object ");
    }
  public void setData( )throws InterruptedException
  {
    
   for(int i = 0; i < 5; i++)
    {
     System.out.println("The Number set is  : "+i);
    Thread.sleep(1000);
    }

   }
   public void run()
     {
       try
       {
       setData( );
        }
        catch(InterruptedException e)
       {
         System.out.println("The Exception in process thread is "+e.getMessage());
        }
     }
   
  }