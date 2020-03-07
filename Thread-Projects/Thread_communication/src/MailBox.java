
  
  //Shared object resource with synchronized methods to control access

 public class MailBox  
 {
    int letter = 0;     
    

  public synchronized int getLetter()throws Exception
    {
        System.out.println("Got the letter  "+letter);
        Thread.sleep(500);
        return letter;
    }
   public synchronized void putLetter(int n)throws Exception
    {
       this.letter = n;
       Thread.sleep(1500);
       System.out.println("Put the letter  "+letter);
        
    }

   }