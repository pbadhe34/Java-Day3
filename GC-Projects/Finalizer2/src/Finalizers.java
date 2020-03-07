
/*Finalizers are expensive. Are there many around?
How can we easily get rid of them?
		*/
public class Finalizers {
	public static void main(String[] args) {
		while (true) {
			for (int i = 0; i < 10; i++) {
				@SuppressWarnings("unused")
				DataBearerHierarchic db = new DataBearerHierarchic(0, 50,
						"DataBearer" + i, "");
			}
		}
	}
}


/*1. In JRA, go to Memory | GC.
2. Sort on Longest Pause.
3. Go to the Pause Time tab in details and sort it on time. The handling of Finalizers seem to take a long time.
4. Select References and Finalizers in the combo box next to the graph.
5. There are a lot of finalizers around to handle each gc...
6. Fix by removing the finalize method in DataBearerHierarchic, it does nothing to help anyway.
*/