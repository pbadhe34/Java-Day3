 

import java.util.*;

//simple test just accesse the thread local vector, adds the
//thread specific string to it, and sleeps for two seconds before
//again accessing the thread local and printing out the value.

public class ThreadLocalUse  implements Runnable
{
  static int ThreadCount = 0;

  public void run()
  {
	Vector v;
    String s = "This is thread " + ThreadCount++;
    
  //get the current thread vector from ThredaLocal property for current thread
    //v = getVectorLocally();
    
    //get the current thread vector from vector pool manager use it and return it ..
    v = poolManager.getVector();
    v.addElement(s);
    poolManager.returnVector(v);
    
    System.out.println("The current vector size after addition value is  "+v.size());
    
    //v = getVectorLocally();
    v = poolManager.getVector();
    v.addElement(s);
    poolManager.returnVector(v);
    try{Thread.sleep(2000);}catch(Exception e){System.out.println("Thread sleeping error..");}
    
    //v = getVectorLocally();
    v = poolManager.getVector();
    v.addElement(s);
    poolManager.returnVector(v);
    System.out.println("The vector size is  "+v.size());
    System.out.println("The vector data contained is  "+v);
  }
  
  private static ThreadLocal localVectors = new ThreadLocal();
  public static Vector getVectorLocally()
  {
     //Lazily initialized version. Get the thread local object
     Vector v = (Vector) localVectors.get();
     if (v == null)
     {
       //First time. So create a vector and set the thread local
       v = new Vector();
       localVectors.set(v);
     }
     return v;
  }
  private static Hashtable hvectors = new Hashtable();
   
  public static Vector getVectorFromTable()
  {
     //Lazily initialized version. Get the thread local object
     Vector v = (Vector) hvectors.get(Thread.currentThread());
     if (v == null)
     {
       //First time. So create a vector and set the thread local
       v = new Vector();
       hvectors.put(Thread.currentThread(), v);
     }
     return v;
  }
  private static VectorPoolManager poolManager = new VectorPoolManager(3);
  public static void main(String[] args)
  {
	  //create no of threads and start them...
    try
    {
      for (int i = 0; i < 5; i++)
      {
        (new Thread(new ThreadLocalUse())).start();
        try{Thread.sleep(200);}catch(Exception e){}
      }
    }
    catch(Exception e){e.printStackTrace();}
  }

  

  
}
