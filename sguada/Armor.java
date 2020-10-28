public class Armor extends Item{
  private String armorName;
  private int idRoom;
  private int idSerial;

  public Armor(String Name){
    System.out.println("Armor");
  }

  public void setName(String name){
    armorName = name;
  }

  public int getName(){
    return this.armorName;
  }

  public void setID(int room,int serial){
    idRoom = room;
    idSerial = serial;
  }

  public int getIDRoom(){
    return idRoom;
  }
  
  public int getIDSerial(){
    return idSerial;
  }
 }
