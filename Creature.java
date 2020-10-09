public class Creature extends Displayable{
 
 public class Creature{
2
​
3
  public Creature(){
4
    System.out.println("Creature");
5
    }
6
    
7
    public void setHp(int h){
8
    System.out.println("setHp");
9
    }
10
    
11
    public void setHpMoves(int hpm){
12
    System.out.println("setHpMoves");
13
    }
14
    
15
    public void setDeathAction(CreatureAction da){
16
    System.out.println("setDeathAction");
17
    }
18
    
19
    public void setHitAction(CreatureAction ha){
20
    System.out.println("setHHitAction");
21
    }
22
    
23
 
 }
