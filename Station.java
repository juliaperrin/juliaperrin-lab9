public class Station {
   protected String lineColor;
   protected String name;
   protected boolean inService;
   protected Station next;
   protected Station prev;
   
   public Station(String color, String name) {
      this.lineColor = color;
      this.name = name;
      this.inService = true;
      this.next = null;
      this.prev = null;
   }
   
   public void addNext(Station s) {
      this.next = s;
   }
   
   public void addPrev(Station s) {
      this.prev = s;
   }
   
   public boolean isAvailable() {
      return inService;
   }
   
   public void switchAvailable() {
      if (this.inService == true) {
         this.inService = false;
      } else {
         this.inService = true;
      }
   }
   
   public void connect(Station s) {
      this.addNext(s);
      s.addPrev(this);
   } 
   
   public Station getNext() {
      return next;
   } 
   
   public Station getPrev() {
      return prev;
   }
   
   public String getName() {
      return name;
   } 
   
   public String getColor() {
      return lineColor;
   }
   
   @Override
   public String toString() {
      String prevName = "none";
      String nextName = "none";
      if (prev != null) {
         String prevName = prev.getName();
      } 
      
      if (next != null) {
         String nextName = next.getName();
      }

      return "STATION " + name + ": " + lineColor + " line, in service: " + inService + ", previous station: " + prevName + ", next station: " + nextName;
   }
   
   @Override
   public boolean equals(Object st) {
      if (st instanceof Station s) {
         return this.name.equals(s.getName()) && this.lineColor.equals(s.getColor());
      } 
      return false;
      
   }
}