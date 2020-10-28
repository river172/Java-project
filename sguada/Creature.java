public class Creature extends Displayable{
  private CreatureAction creatureAction;
  private int hP;
  private int hPMoves;
  private CreatureAction deathAction;
  private CreatureAction hitAction;

  public Creature(){
    System.out.println("Creature");
  }
  
  public void setCreature(CreatureAction creature){
    System.out.println("Creature");
  }

  public CreatureAction getCreature(){
    return this.creatureAction;
  }

  public void setHp(int h){
    hp = h;
    System.out.println("setHp");
  }

  public int getHp(){
    return this.hP;
  }

  public void setHpMoves(int hpm){
    hpMoves = hpm;
    System.out.println("setHpMoves");
  }

  public int getHpMoves(){
    return this.hPMoves;
  }
  
  public void setDeathAction(CreatureAction da){
    deathAction = da;
    System.out.println("setDeathAction");
  }

  public CreatureAction getDeathAction(){
    return this.deathAction;
  }

  public void setHitAction(CreatureAction ha){
    hitAction = ha;
    System.out.println("setHHitAction");
  }
  
  public CreatureAction getHiAction(){
    return this.hitAction;
  }
}
