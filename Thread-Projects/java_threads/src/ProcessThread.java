
  
  
 public class ProcessThread extends Thread
 {
    int number ;
   ProcessThread(int num)
    {
    number  = num;
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