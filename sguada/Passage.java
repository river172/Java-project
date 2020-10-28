public class Passage extends Structure{
  private String name;
  private int room;
  private int _room2;

  public Passage(){
    System.out.println("Passage");
  }
    
  public void setName(String string){
    name = string;
    System.out.println("setName");
  }
    
  public void setID(int room1,int room2){
    room = room1;
    _room2 = room2;
    System.out.println("setId");
  }
  
  public String getName(){
    
    return name;
  }
 
    
 }
