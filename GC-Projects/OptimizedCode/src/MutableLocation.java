public class MutableLocation extends Location{

   public MutableLocation() { }
   public MutableLocation(int x, int y, int z) {
      super(x,y,z);
   }

   public final void setX(int x) { this.x=x; }
   public final void setY(int y) { this.y=y; }   
   public final void setZ(int z) { this.z=z; }
}

