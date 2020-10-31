import java.util.ArrayList;
public class Dungeon{
   
    private ArrayList<Room> Rooms = new ArrayList<Room>();
    private ArrayList<Creature> creatures = new ArrayList<Creature>();
    private ArrayList<Passage> passages = new ArrayList<Passage>();
    private ArrayList<Item> items = new ArrayList<Itemm>();
    public static void getDungeon(String name, int width, int gameHeight){
        System.out.println("Get dungeon");
    }
    
    public void addRoom(Room room){
        Rooms.add(Room);
        System.out.println("addRoom");
    }
    
    public void addCreature(Creature creature){
        creatures.add(creature);
        System.out.println("addCreature");
    }
    
    public void addPassage(Passage passage){
        passages.add(passage);
        System.out.println("addPassage");
    }
    
    public void addItem(Item item){
        items.add(item);
        System.out.println("addItem");
    }
}
    
 
