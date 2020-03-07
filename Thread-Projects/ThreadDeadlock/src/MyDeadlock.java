 

public class MyDeadlock implements Runnable
{
  String me;
  MyDeadlock other;

  public synchronized void sayHello()
  {
    //print out hello from this thread then sleep one second.
    System.out.println(me + " says hello");
    try {Thread.sleep(1000);}
    catch (InterruptedException e) {}
  }

  public void init(String name, MyDeadlock friend)
  {
    //We have a name, and a reference to the other Deadlock object
    //so that we can call each other
    me = name;
    other = friend;
  }

  public static void main(String args[])
  {
    //wait 200 ms as default)
    int wait = args.length == 0 ? 200 : Integer.parseInt(args[0]);

    MyDeadlock d1 = new MyDeadlock();
    MyDeadlock d2 = new MyDeadlock();

    //make sure the Deadlock objects know each other
    d1.init("d1", d2);
    d2.init("d2", d1);

    Thread d1Thread = new Thread(d1);
    Thread d2Thread = new Thread(d2);

    //Start the first thread, then wait  and start second 
    d1Thread.start();
    try {Thread.sleep(wait);}
    catch (InterruptedException e) {}
    d2Thread.start();
  }

  public synchronized void run()
  {
    //We say we’re starting, then sleep half a second.
    System.out.println("Starting thread " + me);
    try {Thread.sleep(500);}
    catch (InterruptedException e) {}

    //Then we say we’re calling the other guy’s hello(), and do so
    System.out.println("Calling hello from " + me + " to " + other.me);
    other.sayHello();
    System.out.println("Ending thread " + me);
  }
}
