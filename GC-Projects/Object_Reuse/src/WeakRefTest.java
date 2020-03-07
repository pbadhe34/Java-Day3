 

import java.util.*;
import java.lang.ref.*;

public class WeakRefTest
{
	 private static String name ;
	 
  public static void main(String[] args)
  {
    try
    {
      Reference ref1 = new WeakReference(new Integer(5));
      Reference ref2 = new SoftReference(new Integer(6));
      
      Object obj = new Account();
      
      System.out.println(ref1 + " : " + ref1.get());
      System.out.println(ref2 + " : " + ref2.get());
      System.out.println("Local Object is + " + obj);

     obj = null;
      //ref3 = null;
     //System.gc();
      
      int REPEAT = args.length > 0 ? Integer.parseInt(args[0]) : 10000000;
      Integer ic;
      for (int i = 0; i < REPEAT; i++)
        ic = new Integer(i);
      
      System.out.println(ref1 + " : " + ref1.get());
      System.out.println(ref2 + " : " + ref2.get());
      System.out.println("ref3 now is  + "+obj);

    }
    catch(Exception e){e.printStackTrace();}
  }

}
