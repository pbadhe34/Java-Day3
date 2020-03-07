
  
  
 public class Clicker implements Runnable
 {
   int click = 0;
   Thread t;
   public volatile boolean running = true;
    public Clicker(int p)
    {
     t = new Thread(this);
     t.setPriority(p);
    }
     
   public void run()
    {
     while(running)
     click++;
     }

  public void stopThread()
    {
      running = false;
    }
   public void startThread()
    {
      t.start();
    }

  public static void main(String args[])throws InterruptedException
   { 
     System.out.println("Info about the current Thread...");
     Thread thread = Thread.currentThread();
     System.out.println("The Current thread is  :"+thread);
     thread.setName("New Thread Name");
      System.out.println("The Current thread after name change is  :"+thread);
     System.out.println("Now I am sleeping for 2 secs");
     Thread.sleep(2000);
    System.out.println("I am awake now...");
     System.out.println("The Current thread is live  : :"+thread.isAlive());
     int priority = thread.getPriority();
     System.out.println("The Current thread priority is  :"+priority);
     System.out.println("The Current thread  is Daemon : :"+thread.isDaemon());
     System.out.println("If The Current thread  is suspended now... ");
     System.out.println("Who will invoke me then...?");
     //thread.suspend();
     System.out.println("Joining The Current thread  ");
     //thread.join();
     thread.stop();
      System.out.println("Is the Thread stopped ?  ");
     
   } 
  }