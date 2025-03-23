public class EndStation extends Station {
   public EndStation(String color, String name) {
      super(color, name);
   }
   
   @Override
   public String toString() {
      return super.toString().replaceFirst("STATION", "ENDSTATION");
   }
   
   public void makeEnd() {
      if (this.next != null) {
         this.prev = this.next;
         this.next.prev = this;
      } else if (this.prev != null) {
         this.next = this.prev;
         this.prev.next = this;
      }
   }
}