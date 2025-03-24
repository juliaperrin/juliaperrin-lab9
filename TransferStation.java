public class TransferStation extends Station {
   private ArrayList<Station> beforeTransfer;
   private ArrayList<Station> afterTransfer;
   
   public TransferStation(String color, String name) {
      super(color, name);
      beforeTransfer = new ArrayList<>();
      afterTransfer = new ArrayList<>();
   }
   
   public void addTransferStationPrev(Station s) {
      beforeTransfer.add(s);
      s.addNext(this);
   }
   
   public void addTransferStationNext(Station s) {
      afterTransfer.add(s);
      s.addPrev(this);
   }
   
   @Override
   public String toString() {
      String prevName = "none";
      String nextName = "none";
      
      if (prev != null) {
         prev = prev.getName();
      } 
      if (next != null) {
         next = next.getName();
      }
      
      String finalString = "TRANSFERSTATION " + name + ": " + lineColor + " line, in service: " + inService + ", previous station: " + prevName + ", next station: " + nextName + "\n\tTransfers: \n"; 
      
      for (int i = 0; i < beforeTransfer.size(); i++) {
         Station s = beforeTransfer.get(i);
         finalString += "\t" + s.toString() + "\n";
      }
      
      for (int i = 0; i < afterTransfer.size(); i++) {
         Station s = afterTransfer.get(i);
         finalString += "\t" + s.toString() + "\n";
      }
      
      finalString += "\tTransfers: \n";
      return finalString;
   } 
   
   public int tripLength(Station destination) {
      return tripLengthAid(destination, new ArrayList<>());
   }
   
   private int tripLengthAid(Station destination, ArrayList<Station> wentThere) {
      if (this.equals(destination)) {
         return 0;
      }
      
      if (wentThere.contains(this)) {
         return -1;
      }
      
      wentThere.add(this);
      if (next != null) {
         int numStopsLeft = next.tripLengthAid(destination, wentThere);
         if (numStopsLeft != -1) {
            return 1 + numStopsLeft;
 