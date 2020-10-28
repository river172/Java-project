public class Item extends Displayable{
  private Creature creature_owner;
  private ItemAction item_action;
  
  public void setOwner(Creature owner){
    System.out.println("setOwner");
  }

  public Creature getOwner(){
    return this.creature_owner;
  }

  public void setItemAction(ItemAction itemAction){
    System.out.println("setOwner");
  }

  public ItemAction getItemAction(){
    return this.item_action;
  }
  
  // itemAction or setItemAction
}
