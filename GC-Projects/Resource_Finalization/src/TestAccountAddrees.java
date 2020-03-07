import java.util.Vector;


public class TestAccountAddrees {

	/**
	 * @param args
	 * @throws InterruptedException 
	 */
	static Address adr  = null;
	public static void main(String[] args) 
	{	
	try {
			Account ac = new Account();
			ac.deposit();
			
		    adr  = new Address();
		    adr.setCityName("Mumbai");
			ac.setAdress(adr);			
           

            Runtime.getRuntime().runFinalization();
            
		//Dummy code to increase memeory usage..
 		int SIZE = 400;
 	    String[]  s = new String[SIZE];;
 	    Vector v = new Vector(SIZE);
 	    
 	    Double[] dArray = new Double[SIZE];

 	    //Create some objects so that the garbage collector 
 	    //has something to do
 	    for (int i = 0; i < SIZE; i++)
 	    {
 	    	
 	      double val = 999 + SIZE - i;
 	      dArray[i] = val;
 	      v.add(dArray[i]);           
 	       
 	    }
 	   for (int j = 0; j < SIZE-9090; j++)
 	    {
          String str = "Helloo "+j;
          s[j] = str;
 	    }
 	       ac = null;
		} 
		catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 
	    long count = 999999l;
	    while(count > 0)
	    {
	    	String s1 = new String("Here is the String............................................................");
	        count--;
	           
	    }
	    
	    while(true)
	    {
	    	String s1 = new String("Here is the String............................................................");
	         
	           
	    }


	}
 	   
 	   

		
		
		
	 

}
