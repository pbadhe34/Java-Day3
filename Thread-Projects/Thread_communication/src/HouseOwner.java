
  
  
 public class HouseOwner extends Thread
 {
    MailBox mailbox;
  public HouseOwner(MailBox m)
  {
   this.mailbox = m;
   }

  public void run()
  {
    int letters = 0;
    
    while(true)
		try {
			mailbox.getLetter();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

  }
}
   