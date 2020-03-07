
public class Body {
   private int mass = 10;
   private MutableLocation loc = new MutableLocation();

   public int getMass() {
      return mass;
   }
   public void setMass(int mass) {
      this.mass = mass;
   }
   public Location getLocation() {
      return loc;
   }
   public void move() {
      // we're just moving at random here
      // in a real  we'd have forces  
      loc.x += 1;
      loc.y += 2;
      loc.z += 3;
   }
}
