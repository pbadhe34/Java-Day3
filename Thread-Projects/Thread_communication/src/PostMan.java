
  
  
 public class PostMan extends Thread
 {
    MailBox mailbox;
  public PostMan(MailBox m)
  {
   this.mailbox = m;
   }

  public void run()
  {
    int letters = 0;
    
    while(true)
		try {
			mailbox.putLetter(++letters);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

  }
}
   