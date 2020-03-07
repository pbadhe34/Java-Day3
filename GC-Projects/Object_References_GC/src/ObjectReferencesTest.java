 

import java.util.*;
import java.lang.ref.*;

public class ObjectReferencesTest
{
	  
	 static Account globalObj= new Account(999);
	 static Address adrG = new Address("hhhh");
	  
	 
  public static void main(String[] args)
  {
	  //Account obj4 = null;
    try
    {
    	
      
    	
      ReferenceQueue queue = new ReferenceQueue();          
      
      
      /*Reference ref1 = new WeakReference(new Integer(5));
      Reference ref2 = new SoftReference(6, queue);//auto boxing done    
     
*/      
     
      Account obj1 = new Account(100);//local scoped object
      
      Account obj2 = new Account(200);
      Reference ref2 = new WeakReference(obj2);      
     
      
      Account obj4 = new Account(300); 
      
     // globalObj = obj4;
      
      obj4.setAdress(adrG);
      
      
      Reference ref4 = new PhantomReference(obj4, queue);
      
      //Reference ref44  = new SoftReference(obj4);  
      
      Account obj5 = new Account(400);     
     // Reference ref5  = new SoftReference(new Account(400)); //local scoped anonymous temp  object
      
      Reference ref5  = new SoftReference(obj5);  
      
     
           
      Account obj3 = new Account(500);          
      
      Reference ref3 = new SoftReference(obj3);
      
          
      /*System.out.println("\nThe Weak ref object1 status is   " + ref1.get());
      System.out.println("The soft ref object2 status is   " + ref2.get());
      */
      
      System.out.println("\n\nThe first weak Ref object status is  "+ ref2.get());
      System.out.println("The First SOFT  Ref object status is  :  " + ref3.get());     
      System.out.println("The phantom  ref Object status is  " + ref4.get()); 
      
      /*Account weakAccount1 = (Account) ref2.get();
      Address oldAddress = weakAccount1.getAdress();  
      System.out.println("The first weak Ref object address is  "+ oldAddress.getCityName());      
      */
      
     // System.out.println("The second SOFT Ref temporay object status is  " + ref5.get());   
      
     // obj1 = null;
       
     //System.gc();
      
      //consumeMemory();   
           
            
      /*System.out.println("\nThe Weak ref object1 status after first blast is   " + ref1.get());
      System.out.println("The soft ref object2 status after first blast is   " + ref2.get());*/
       
      System.out.println("\nThe first Weak Ref object status after first blast is  "+ ref2.get());
      System.out.println("The second Soft Ref object status after first blast is  :  " + ref3.get());       
      System.out.println("The phantom ref Object status after first blast is   " + ref4.get()); 
      
      System.out.println("The phantomed Account object address after first blast is  "+ obj4.getAdress().getCityName());  
      
      
     /* Account weakAccount = (Account) ref2.get();
      Address newerAddress = weakAccount.getAdress();      
      System.out.println("The first weak Ref object address is  "+ newerAddress.getCityName());
      */
    //  System.out.println("The second SOFT Ref temporay object status after first blast is  " + ref5.get());  
      
      /*System.out.println("The second Weak Ref Account object status after first blast is  "+ obj4);
      System.out.println("The second Soft Ref Account object status after first blast is  :  " + obj5);       
      System.out.println("The phantom Ref Account Object status after first blast is  " + obj6);   
     */
      
      //System.out.println("The second Soft Ref Account object status is  :  " + obj5);    
      //ref5.clear();
      //clears current reference object.
      //Invoking this method will not cause this object to be enqueued.       
             
      
      //ref5.enqueue();
      
    /* int  REPEAT = args.length > 0 ? Integer.parseInt(args[0]) : 999999999;      
      for (int i = 0; i < REPEAT; i++)
        Integer ic = new Integer(i);*/
      
      consumeMemory();      
       
      
     /* System.out.println("\nThe Weak ref object1 status after second blast is   " + ref1.get());
      System.out.println("The soft ref object2 status after second blast is   " + ref2.get());
     */ 
      System.out.println("\nThe first Weak Ref object status after second  blast is  "+ ref2.get());
      System.out.println("The second Soft Ref object status after second blast is  :  " + ref3.get());
      System.out.println("The phantom Ref object status after second blast  is  :  " + ref4.get());
      
    
      
      /*System.out.println("\nThe second Weak Ref Account object status after second blast is  "+ obj4);
      System.out.println("The second Soft Ref Account object status after second blast is  :  " + obj5);       
      System.out.println("The phantom  Ref Account Object status after second blast is  " + obj6);   
     */          
      
      
      
      System.out.println("The phantomed Account object address after first blast is  "+ obj4.getAdress().getCityName());
      
     
    }
    catch(Exception e){
    	
    	// System.out.println("\n$$$$Now the phantomed Account object new address is  "+ obj4.getAdress().getCityName());  
    	 e.printStackTrace();
    	 }
    
    long count = 999999l;
    while(count > 0)
    {
    	String s1 = new String("Here is the String............................................................");
        count--;
           
    }
    
    System.out.println("The phantomed Account object address after first blast is  "+ globalObj.getAdress().getCityName());  
    
    
  }

   private static void consumeMemory()
   {
	     //Dummy code to increase memeory usage..
	 		int SIZE = 4000000;
	 	    String[]  s = new String[SIZE];;
	 	    java.util.Vector v = new Vector(SIZE);
	 	    
	 	    Double[] dArray = new Double[SIZE];

	 	    //Create some objects so that the garbage collector 
	 	    //has something to do
	 	    for (int i = 0; i < SIZE; i++)
	 	    {
	 	    	
	 	      double val = 99999999999999.99 + SIZE - i;
	 	      dArray[i] = val;
	 	      v.add(dArray[i]);           
	 	       
	 	    }
	 	   for (int j = 0; j < SIZE-9090; j++)
	 	    {
	          String str = "Helloo "+j;
	          s[j] = str;
	 	    }
	 	   
	 	   
   }
}
