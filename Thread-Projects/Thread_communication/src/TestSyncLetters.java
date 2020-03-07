
  
   //Test the threads with communication via shared object
 public class TestSyncLetters
 {
     
  public static void main(String args[])throws InterruptedException
   {
    System.out.println("Starting here..");

    SyncMailBox m = new SyncMailBox();
    PostMan p = new PostMan(m);
    HouseOwner h = new HouseOwner(m);
      h.start();
     Thread.sleep(3000);
     p.start();
     
     
   } 
  }