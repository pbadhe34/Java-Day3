
  
  
 public class SyncCaller implements Runnable
 {
   String msg;
   CallMe target;
   Thread t;    
    
    public SyncCaller(CallMe c,String s)
    {
   
     target = c;
     msg = s;
     t = new Thread(this);
     t.start();
    

    }
     
   public void run()
    {
   try
     {
       synchronized(target)
       {
        target.call(msg);  
       }    
     }
     catch(InterruptedException e)
     {
     System.out.println("Exception in Caller  :"+e);
      }
  }
}

  