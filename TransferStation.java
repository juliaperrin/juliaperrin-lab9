import java.util.ArrayList;

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
      if (s.getNext() == null || !s.getNext().equals(this)) {
         s.setNext(this);
      }
   }
   
   public void addTransferStationNext(Station s) {
      afterTransfer.add(s);
      otherStations.add(s);
      if (s.getPrev() == null || !s.getPrev().equals(this)) {
         s.setPrev(this);
      }
      
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
      
      for (Station s : otherStations) {
         finalString += "\t" + s.toString() + "\n";
      }

      
      return finalString;
   } 
   
}            
 