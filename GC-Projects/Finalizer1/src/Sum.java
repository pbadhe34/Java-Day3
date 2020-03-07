public class Sum {
    
    
public static void main(String[] args)
    {
    System.out.println("Addition of two numbers!");
    int a = 11;//Integer.parseInt(args[0]);
    int b = 13;//Integer.parseInt(args[1]);
    
    System.out.println("Sum: " + add(a,b));
    
    Integer arr[] = new Integer[]{11,34,5678,234,5677,111,98,222,666,778899,222333,777777,9999};
    Integer  res = sum(arr);
    System.out.println("The second sum is  "+res);
    
    }

    private static int  add(int a, int b) {	 
	return a + b;
}

	public static Integer sum(Integer[] array) {
	Integer sum = 0;
	for (int i = 0 ; i<array.length ; i++) {
	    sum += array[i];
	}
	return sum;
}
}

