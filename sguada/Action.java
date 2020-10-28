public class Action {
    private int intValue;
    private char charValue;
    private String message;
    private CreatureAction creature;

    public void setMessage(String msg){
        message = msg;
    }

    public String getMessage(){
        return this.message;
    }

    public void setCreature(CreatureAction _creature){
        creature = _creature;
    }

    public CreatureAction getCreature(){
        return this.creature;
    }

    public void setIntValue(int v){
        intValue = v;
    }

    public int getIntValue(){
        return this.intValue;
    }

    public void setCharValue(char c){
        charValue = c;
    }

    public int getCharValue(){
        return this.charValue;
    }
}
