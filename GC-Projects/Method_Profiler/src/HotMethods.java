
public class HotMethods {
	 
	
	/*This example illustrates the hot methods tab in JRA and JFR. 

	1. Make a recording and check where most of the time is spent. 
	2. Can you make the application run faster?*/
	public static void main(String[] args) {		
		long start;
		long stop;
		int counter = 0;
		long totaltime = 0;

		while (true) {
			start = System.currentTimeMillis();
			Initiator i1 = new Initiator();
			Initiator i2 = new Initiator();
			i1.initiate(3);
			i2.initiate(5);
			int similars = i1.countSimilars(i2);
			System.out.println("Similars: " + similars);
			stop = System.currentTimeMillis();
			totaltime += (stop - start);
			counter++;
			System.out.println("Times - this round: " + (stop - start) + " ms. Average time: " + (totaltime/counter));
		}
	}

}

/*Tip 1: You can actually make the program run a lot faster by simply changing one line.

Tip 2: We spend a lot of time in the LinkedList.contains(Object) method.

Tip 3: Contains in a linked list is proportional to the number of entries.

Tip 4: A HashSet will on average do the trick in constant time.

Tip 5: Change line 7 in Initiator.java to read: list = new HashSet<Integer>(); Run and compare.
*/
