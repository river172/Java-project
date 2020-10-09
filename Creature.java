public class Creature extends Displayable{

  public Creature(){

    System.out.println("Creature");

    }

    

    public void setHp(int h){

    System.out.println("setHp");

    }

    

    public void setHpMoves(int hpm){

    System.out.println("setHpMoves");

    }

    
    public void setDeathAction(CreatureAction da){

    System.out.println("setDeathAction");

    }
    

    public void setHitAction(CreatureAction ha){

    System.out.println("setHHitAction");

    }
 
 }
