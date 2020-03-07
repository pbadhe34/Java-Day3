
public class Location {
   protected int x;
   protected int y;
   protected int z;

   public Location() { }
   public Location(int x, int y, int z) {
      this.x = x;
      this.y = y;
      this.z = z;
   }

   public final int getX() { return x; }
   public final int getY() { return y; }
   public final int getZ() { return z; }

}

