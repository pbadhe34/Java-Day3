import com.oracle.jrockit.jfr.EventToken;
import com.oracle.jrockit.jfr.Producer;

/**
 * Demonstrates how to create custom events. 
This example features a logger that is shared between a bunch of worker threads.
Do a one minute recording. If you want to, enable the custom event producer.

1. The idea with the worker threads is to get work done in parallel. How many 
   threads are actually running in parallel? Why?
   
2. Can you change the application by simply removing a key word to change this?

3. Think of another way to change the application to do this?


1. Do a recording and go to the Events | Graph tab. Green is good - the thread is running.
  Red is bad, the thread is waiting on entering a Java monitor.

2. As can be seen, only one thread at a time is getting to run. 
  The application is doing work in a sequential fashion, one thread at a time.

3. The blocking events all seem to be due to calls to the Log method. 
    See CPU/Threads | Contention tab.

4. Removing the synchronization call, 
  or making sure each thread has it's own logger will fix the problem.

5. New recording after the fix will show lot's of green in parallel. All red is gone.
 * 
 */
public class CustomEventLatencies {
	static EventToken LOG_EVENT_TOKEN;
	static EventToken WORK_EVENT_TOKEN;
	static Producer PRODUCER;
	private final static String PRODUCER_URI = "http://www.example.com/logdemo/";
	static {
		registerProducer();
		// Uncomment next line to register a recording with our events enabled by default.
		// enableAll();
	}

	/**
	 * Registers our producers, and our different events.
	 */
	private static void registerProducer() {
		try {
			PRODUCER = new Producer("Log Producer (Demo)",
					"A demo event producer for the demo logger.", PRODUCER_URI);
			LOG_EVENT_TOKEN = PRODUCER.addEvent(LogEvent.class);
			WORK_EVENT_TOKEN = PRODUCER.addEvent(WorkEvent.class);
			PRODUCER.register();
		} catch (Exception e) {
			// Add proper exception handling.
			e.printStackTrace();
		}
	}

	/**
	 * An example on how to creates a continuous recording and enable all the
	 * events for our producer. This can be safely skipped, and the events
	 * enabled in our template instead.
	 */
	/*
	private static void enableAll() {
		try {
			FlightRecorderClient fr = new FlightRecorderClient();
			FlightRecordingClient rec = fr.createRecordingObject("tmp");
			for (CompositeData pd : fr.getProducers()) {
				if (!PRODUCER_URI.equals(pd.get("uri")))
					continue;
				CompositeData events[] = (CompositeData[]) pd.get("events");
				// Go through all registered events and enable them
				for (CompositeData d : events) {
					int id = (Integer) d.get("id");
					rec.setEventEnabled(id, true);
					rec.setStackTraceEnabled(id, true);
					rec.setThreshold(id, 200);
					rec.setPeriod(id, 5);
					System.out.println("Enabled event " + d.get("name"));
				}
			}
		} catch (Exception e) {
			// Add proper exception handling.
			e.printStackTrace();
		}
	}
	*/
	
	/**
	 * Main program entry.
	 */
	public static void main(String[] args) throws InterruptedException {
		Thread.sleep(2000);
		Thread[] threads;
		threads = new Thread[20];
		for (int i = 0; i < threads.length; i++) {
			threads[i] = new WorkerThread(10000000);
			threads[i].start();
		}
	}
}
