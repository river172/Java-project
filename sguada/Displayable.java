public class Displayable{
  private int maximumHit;
  private int hp_moves;
  private int h_p;
  private char type;
  private int value;
  private int posX;
  private int posY;
  private int width;
  private int height;

  public Displayable(){
    System.out.println("Displayable");
  }

  public void setInvisible(){
    System.out.println("setInvisible");
  }
  
  public void setVisible(){
    System.out.println("setVisible");
  }
  
  public void setMaxHit(int maxHit){
    System.out.println("setMaxHit");
  }

  public int getMaxHit(){
    return this.maximumHit;
  }
  
  public void setHpMove(int hpMoves){
    System.out.println("setHpMove");
  }

  public int getHpMove(){
    return this.hp_moves;
  }
  
  public void setHp(int Hp){
    System.out.println("setHp");
  }

  public int getHp(){
    return this.h_p;
  }
  
  public void setType(char t){
    System.out.println("setType");
  }

  public char getType(){
    return this.type;
  }

  public void setValue(int v){
    System.out.println("setValue");
  }

  public int setValue(){
    return this.value;
  }
  
  public void setPosX(int x){
    posX = x;
  System.out.println("setPosX");
  }

  public int setPosX(){
    return this.posX;
  }
  
  public void setPosY(int y){
    posY = y;
  System.out.println("setPosY");
  }

  public int setPosY(){
    return this.posY;
  }
  
  public void setWidth(int x){
    width = x;
  System.out.println("setWidth");
  }

  public int setWidth(){
    return this.width;
  }
  
  public void setHeight(int y){
    height = y;
  System.out.println("setHeight");
  }

  public int setHeight(){
    return this.height;
  }
  
}
  
  
  
