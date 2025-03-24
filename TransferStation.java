public class TransferStation extends Station {
   private ArrayList<Station> beforeTransfer;
   private ArrayList<Station> afterTransfer;
   public ArrayList<Station> otherStations;
   
   public TransferStation(String color, String name) {
      super(color, name);
      beforeTransfer = new ArrayList<>();
      afterTransfer = new ArrayList<>();
      otherStations = new ArrayList<>();
   }
   
   public void addTransferStationPrev(Station s) {
      beforeTransfer.add(s);
      otherStations.add(s);
      s.addNext(this);
   }
   
   public void addAfterTransfer(Station s) {
      afterTransfer.add(s);
      otherStation.add(s);
      s.addPrev(this);
   }
   
   public ArrayList<Station> getAfterTransfer() {
      return afterTransfer;
   }
   
   
   @Override
   public String toString() {
      String prevName = "none";
      String nextName = "none";
      
      if (prev != null) {
         prevName = prev.getName();
      } 
      if (next != null) {
         nextName = next.getName();
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
   
}            
 