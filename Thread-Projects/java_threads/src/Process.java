
  
  
 public class Process
 {
    int number ;
  public void setData(int num)throws InterruptedException
  {
   this.number = num;
   for(int i = 0; i < 5; i++)
    {
     System.out.println("The Number set is  : "+i);
    Thread.sleep(1000);
    }

   }
  public void ProocessData()throws InterruptedException
  {
    
   for(int i = 0; i < 5; i++)
    {
     System.out.println("The Number processed  is  : "+i);
    Thread.sleep(1000);
    }

   }
  public static void main(String args[])throws InterruptedException
   {
    System.out.println("Starting here..");
    Process p = new Process();
     p.setData(100);
     p.ProocessData();
   } 
  }