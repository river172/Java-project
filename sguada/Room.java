public class Room extends Structure{
  private String roomN;
  private int ID;
  private Creature mons;
  public Room(String string){
    roomN = string;
    System.out.println("Room");
  }
    
  public void setId(int room){
    ID = room;
    System.out.println("setId");
  }
    
  public void setCreature(Creature Monster){
    mons = monster;
    System.out.println("setCreature");
  }
  
  public int getID(){
    return ID;
  }
}
    
