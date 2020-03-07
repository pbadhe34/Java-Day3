
  
  //Test the threads without communication
 public class TestLetters
 {
     
  public static void main(String args[])throws InterruptedException
   {
    System.out.println("Starting here..");

    MailBox m = new MailBox();
    PostMan p = new PostMan(m);
    HouseOwner h = new HouseOwner(m);
     p.start();
     Thread.sleep(3000);
     h.start();
     
   } 
  }