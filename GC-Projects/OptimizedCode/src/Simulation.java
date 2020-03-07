import java.util.*;

public class Simulation {

   static ArrayList bodies = new ArrayList();
   static final int NUM_BODIES = 200;
   static final int TIME_STEPS = 100000;
   static Random rand = new Random();
   
   public static void main(String[] args) {
      for (int i = 0; i < NUM_BODIES; i++) {
         bodies.add(new Body());
      }
      Stopwatch timer = new Stopwatch().start();
      for (int i = 0; i < TIME_STEPS ; i++) { 
         doTimeStep(i);
      }
      timer.stop();
      System.out.println("The Time sepent here is "+timer.getElapsedTime()+"ms");
   }

   public static void doTimeStep(int timeStep) {
      Iterator iter = bodies.iterator();
      while (iter.hasNext()) {
         Body body = (Body)iter.next();
         body.move();
         Location loc = body.getLocation();
         log(body, loc, timeStep);  
      }
   }

   public static void log (Body body, Location loc, int time) {
      // log this info to somewhere
   }


}
