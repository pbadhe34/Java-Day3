
  
  //Modified Shared object resource with communication control  
 //between threads

 public class SyncMailBox extends MailBox
 {
    int letter = 0;     
    boolean empty = false;

  public synchronized int getLetter()throws Exception
    {
     if(!(empty))
       {
    	 //Release the lock on shared object if
    	 //no letters available for reading and wait for notification from PostMan Thread
         wait();
       }
        System.out.println("Got the letter  "+letter);
        empty = false;
        Thread.sleep(1000);
       //What happens if following line is commented ?
        //Get the letter and notify the other waiting thread
        //i.e. the PostMan that mailBox is ready to put the letters
        notify();
        return letter;
    }
   public synchronized void putLetter(int n)throws Exception
    {
      if(empty)
       {
    	 //Release the lock on shared object if
     	 //MailBox is full so cannot put the letters
    	  //and wait for notification from HouseOwner Thread
         wait();
       }
       this.letter = n;
       empty = true;
       Thread.sleep(1000);       
       System.out.println("Put the letter  "+letter);
 //What happens if following line is commented ?
       //Put the letter and notify the other waiting thread
       //i.e. the HouseOwner that mailBox is full to get the letters
       notify();
        
    }

   }