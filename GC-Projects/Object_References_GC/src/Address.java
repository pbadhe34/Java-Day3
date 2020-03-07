import java.util.Vector;


public class Address {
	private String cityName;
	
	public void setCityName(String cityName) {
		this.cityName = cityName;
	}

	public String getCityName() {
		return cityName;
	}

	public Address()
	{
		
	}
	
	public Address(String city)
	{
		//Dummy code to increase memeory usage..
		/*int SIZE = 4000;
	   // String[]  s = new String[SIZE];;
	    java.util.Vector v = new Vector(SIZE);
	    
	    Double[] dArray = new Double[SIZE];

	    //Create some objects so that the garbage collector 
	    //has something to do
	    for (int i = 0; i < SIZE; i++)
	    {
	      String str = "Hello data value this data "+i;
	      s[i] = str;
	      double val = 1000000000 + SIZE - i;
	      dArray[i] = val;
	      v.add(dArray[i]);           
	       
	    }*/
		cityName = city;
	}

}
