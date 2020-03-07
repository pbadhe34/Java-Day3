
public class LoadAndDeadlock {

	private static class AllocThread extends Thread {
		public void run() {
			 System.out.println("AllocThread Running..");
			while (true) {
				System.out.println("AllocThread Yielding..");
				Thread.yield();
				try {
					sleep(30 * 1000);
				} catch (Exception e) {
				}

				for (int i = 0; i < 10000; i++) {
					char[] tmp = new char[1024 * 1024];
					tmp[1] = 'a';
				}
			}
		}
	}

	private static class LockerThread extends Thread {
		Object l1;
		Object l2;

		public void init(Object lock1, Object lock2) {
			l1 = lock1;
			l2 = lock2;
		}

		public void run() {
			while (true) {
				System.out.println("LockerThread Running..");
				synchronized (l1) {
					try {
						System.out.println("synchronized O1..");
						Thread.sleep(1000);
					} catch (InterruptedException e) {
					}
					synchronized (l2) {
						try {
							System.out.println("synchronized O2..");
							Thread.sleep(1000);
						} catch (InterruptedException e) {
						}
						System.out.println("Finally Got one!");

					}
				}
			}
		}

	}

	public static void main(String[] args) {
		AllocThread allocthread = new AllocThread();
		Object lock1 = new Object();
		Object lock2 = new Object();

		LockerThread first = new LockerThread();
		LockerThread second = new LockerThread();

		first.init(lock1, lock2);
		second.init(lock2, lock1);

		allocthread.start();
		first.start();
		second.start();

	}
}

/*1. Triggers rules are built on the MBeans | Triggers tab.

2. The CPU load attribute is under oracle.jrockit.management/Runtime#CPULoad.

3. CPU load is in fractions, in other words 0.4 is 40%.

4. You need to enable the rule after creating it.

5. Deadlock detection is in the Runtime | Threads tab, and is enabled by checking the appropriate box.

6. You can sort on deadlocked threads by clicking the appropriate column header.

7. Deadlocked threads also have a different icon.

8. You can enable more columns, such as the _Lock Owner Name_, by clicking the table settings.

*/
