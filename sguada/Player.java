public class Player extends Creature{
  
  private Item _sword;
  private Item _armor;

  public void setWeapon(Item sword){
    _sword = sword;
    System.out.println("setWeapon");
  }
    
  public void setArmor(Item armor){
    _armor = armor;
    System.out.println("setArmor");
  }
    
}
