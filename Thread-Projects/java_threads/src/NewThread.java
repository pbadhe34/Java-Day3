//Here is newThread class

class NewThread implements Runnable
{
    String threadName;
     
    NewThread(String name)
    {
        threadName = name;
        System.out.println("New Thread created : " );        
    }
    
    //Here is run() method
    public void run()
    {
        try
        {
            for(int i=15;i>0;i--)
            {
                System.out.println(threadName + " : " + i);
                Thread.sleep(400);
            }
        }
        catch(InterruptedException e)
        {
			System.out.println("");
			System.out.println("My name is "+threadName);
            System.out.println("Who dared to wake me up ?  " + e);
			System.out.println("");
        } 
        System.out.println(threadName  + "  thread is exiting");
    }
}