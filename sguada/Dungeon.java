public class Dungeon{
    private Room _room;
    private Creature _creature;
    private Passage _passage;
    private Item _item;
    
    public static void getDungeon(String name, int width, int gameHeight){
        System.out.println("Get dungeon");
    }
    
    public void addRoom(Room room){
        _room = room;
        System.out.println("addRoom");
    }
    
    public void addCreature(Creature creature){
        _creature = creature;
        System.out.println("addCreature");
    }
    
    public void addPassage(Passage passage){
        _passage = passage;
        System.out.println("addPassage");
    }
    
    public void addItem(Item item){
        _tem = item;
        System.out.println("addItem");
    }
}
    
