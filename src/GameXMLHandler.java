import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class GameXMLHandler extends DefaultHandler {
    private static final int DEBUG = 1;
    private static final String CLASSID = "GameXMLHandler";
    private StringBuilder data = null;
    private Stack<Displayable> displayableStack;
    private Stack<Action> actionsStack;
    private Displayable displayableBeingParsed = null;
    private ItemAction actionBeingParsed = null;

    // The bX fields here indicate that at corresponding field is
    // having a value defined in the XML file.  In particular, a
    // line in the xml file might be:
    // <instructor>Brook Parke</instructor> 
    // The startElement method (below) is called when <instructor>
    // is seen, and there we would set bInstructor.  The endElement
    // method (below) is called when </instructor> is found, and
    // in that code we check if bInstructor is set.  If it is,
    // we can extract a string representing the instructor name 
    // from the data variable above.
    private boolean bVisible = false;
    private boolean bPosX = false;
    private boolean bPosY = false;
    private boolean bWidth = false;
    private boolean bHeight = false;
    private boolean bType = false;
  
    private boolean bActionMessage = false;
    private boolean bActionIntValue = false;
    private boolean bActionCharValue = false;
    private boolean bHp = false;
    private boolean bHpMoves = false;
    private boolean bMaxHit = false;
    private boolean bItemIntValue = false;

    // Used by code outside the class to get the list of Student objects
    // that have been constructed.
    public Student[] getDisplayable() {
        return displayableStack;
    }

    public Student[] getAction() {
        return actionsList;
    }

    // A constructor for this class.  It makes an implicit call to the
    // DefaultHandler zero arg constructor, which does the real work
    // DefaultHandler is defined in org.xml.sax.helpers.DefaultHandler;
    // imported above, and we don't need to write it.  We get its 
    // functionality by deriving from it!
    public GameXMLHandler() {

    }

    // startElement is called when a <some element> is called as part of 
    // <some element> ... </some element> start and end tags.
    // Rather than explain everything, look at the xml file in one screen
    // and the code below in another, and see how the different xml elements
    // are handled.

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {

        if (DEBUG > 1) {
            System.out.println(CLASSID + ".startElement qName: " + qName);
        }

        if (qName.equalsIgnoreCase("Dungeon")) {
            String name = attributes.getValue("name");
            int width = Integer.parseInt(attributes.getValue("width"));  
            int topHeight = Integer.parseInt(attributes.getValue("topHeight")); 
            int gameHeight = Integer.parseInt(attributes.getValue("gameHeight"));
            int bottomHeight = Integer.parseInt(attributes.getValue("bottomHeight")); 
            dungeon = new Dungeon();
            dungeonGet = dungeon.getDungeon(name, width, gameHeight);
          
        } else if (qName.equalsIgnoreCase("Rooms")) {
            
        } else if (qName.equalsIgnoreCase("Room")) {
            String name = attributes.getValue("room");  
            room = new Room(name);
            push.displayableStack(room);
            
        } else if (qName.equalsIgnoreCase("visible")) {
            bVisible = true;
        } else if (qName.equalsIgnoreCase("posX")) {
            bPosX = true;
        } else if (qName.equalsIgnoreCase("posY")) {
            bPosY = true;
        } else if (qName.equalsIgnoreCase("width")) {
            bWidth = true;
        } else if (qName.equalsIgnoreCase("height")) {
            bHeight = true;
        } else if (qName.equalsIgnoreCase("type")) {
            bType = true;
        } else if (qName.equalsIgnoreCase("Scroll")) {
            String name = attributes.getValue("name");
            String room = attributes.getValue("room");
            String serial = attributes.getValue("serial");
            scroll = new Scroll(name);
            scroll.setID(room, serial);
            push.displayableStack(scroll);
            
        } else if (qName.equalsIgnoreCase("ItemAction")) {
            String name = attributes.getValue("name");
            String type = attributes.getValue("type");
            switch (name) {
                case "BlessArmor":
                    activity = new BlessArmor(type);     // what type? what input
                    push.actionsStack(activity);
                    break;
                case "Hallucinate":
                    activity = new Hallucinate(type);
                    push.actionsStack(activity);

                    break;
                case "BlessCurseOwner":
                    activity = new BlessCurseOwner(type);
                    push.actionsStack(activity);

                    break;
                default:
                    System.out.println("Unknown activity: " + type);
                    break;
            }
        } else if (qName.equalsIgnoreCase("actionMessage")) {
            bActionMessage = true;
            
        }else if (qName.equalsIgnoreCase("actionIntValue")) {
            bActionIntValue = true;
          
        } else if (qName.equalsIgnoreCase("actionCharValue")) {
            bActionCharValue = true;

        } else if (qName.equalsIgnoreCase("Player")) {
            String name = attributes.getValue("name");
            int room = Integer.parseInt(attributes.getValue("room"));  
            int serial = Integer.parseInt(attributes.getValue("serial"));  
          
            player = new Player();                // what input ?
            push.displayableStack(activity);


        } else if (qName.equalsIgnoreCase("hp")) {
            bHp = true;
        } else if (qName.equalsIgnoreCase("hpMoves")) {
            bHpMoves = true;
        } else if (qName.equalsIgnoreCase("maxhit")) {
            bMaxHit = true;
        
        } else if (qName.equalsIgnoreCase("CreatureAction")) {
            String name = attributes.getValue("name");
            String type = attributes.getValue("type");
            switch (name) {
                case "Teleport":
                    activity = new Teleport(name,type);     // what type? what input
                    push.actionsStack(activity);

                    break;
                case "Remove":
                    activity = new Remove(name,type);
                    push.actionsStack(activity);

                    break;
                case "ChangedDisplayedType":
                    activity = new ChangedDisplayedType(name,type);
                    push.actionsStack(activity);        

                    break;
                case "DropPack":
                    activity = new DropPack(name,type);     // what type? what input
                    push.actionsStack(activity);
                    break;
                case "YouWin":
                    activity = new YouWin(name,type);
                    push.actionsStack(activity);
                    break;
                case "EndGame":
                    activity = new EndGame(name,type);
                    push.actionsStack(activity);
                    break;
                case "UpdateDisplay":
                    activity = new UpdateDisplay(name,type);
                    push.actionsStack(activity);
                    break;
                default:
                    System.out.println("Unknown activity: " + type);
                    break;
            }
        
        } else if (qName.equalsIgnoreCase("Sword")) {
            String name = attributes.getValue("name");
            int room = Integer.parseInt(attributes.getValue("room"));  
            int serial = Integer.parseInt(attributes.getValue("serial"));
            sword = new Sword(name);
            push.displayableStack(sword);
            
            sword.setID(room,serial);
        
        } else if (qName.equalsIgnoreCase("Monster")) {
            String name = attributes.getValue("name");
            int room = Integer.parseInt(attributes.getValue("room"));  
            int serial = Integer.parseInt(attributes.getValue("serial"));
            monster = new Monster();
            push.displayableStack(monster);

            monster.setName(name);
            monster.setID(room,serial);
        
        } else if (qName.equalsIgnoreCase("ItemIntValue")) {
            bItemIntValue = true;
          
        } else if (qName.equalsIgnoreCase("Armor")) {
            String name = attributes.getValue("name");
            int room = Integer.parseInt(attributes.getValue("room"));  
            int serial = Integer.parseInt(attributes.getValue("serial"));
            armor = new Armor(name);
            armor.setName(name);
            armor.setID(room, serial);
            push.displayableStack(armor);

          
        } else if (qName.equalsIgnoreCase("Passage")) {
            int room1 = Integer.parseInt(attributes.getValue("room1"));  
            int room2 = Integer.parseInt(attributes.getValue("room2"));
            passage = new Passage(name);
            passage.setName(name);
            passage.setID(room1, room2);
            push.displayableStack(passage);
          
        } else {
            System.out.println("Unknown qname: " + qName);
        }
        data = new StringBuilder();
    }


    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        if (bVisible) {
            displayableStack.peek().setVisible(Integer.parseInt(data.toString()));
            bVisible = false;
        } else if (bPosX) {
            displayableStack.peek().setPosX(Integer.parseInt(data.toString()));
            bPosX = false;
        } else if (bPosY) {
            displayableStack.peek().setPosY(Integer.parseInt(data.toString()));
            bPosY = false;
        } else if (bWidth) {
            displayableStack.peek().setWidth(Integer.parseInt(data.toString()));
            bWidth = false;
        } else if (bHeight) {
            displayableStack.peek().setHeight(Integer.parseInt(data.toString()));
            bHeight = false;
        } else if (bType) {
            displayableStack.peek().setType(Integer.parseInt(data.toString()));
            bType = false;
        } else if (bActionMessage) {
            displayableStack.peek().setActionMessage(Integer.parseInt(data.toString()));
            bActionMessage = false;
        }else if (bActionIntValue) {
            displayableStack.peek().setActionIntValue(Integer.parseInt(data.toString()));
            bActionIntValue = false;
        } else if (bActionCharValue) {
            displayableStack.peek().setActionCharValue(Integer.parseInt(data.toString()));
            bActionCharValue = false;
        } else if (bHp) {
            displayableStack.peek().setHp(Integer.parseInt(data.toString()));
            bHp = false;
        } else if (bHpMoves) {
            displayableStack.peek().setHpMoves(Integer.parseInt(data.toString()));
            bHpMoves = false;
        } else if (bMaxHit) {
            displayableStack.peek().setMaxHit(Integer.parseInt(data.toString()));
            bMaxHit = false;
        } else {
            displayableStack.peek().setIntValue(Integer.parseInt(data.toString()));
            bItemIntValue = false;
        }
    }

    @Override
    public void characters(char ch[], int start, int length) throws SAXException {
        data.append(new String(ch, start, length));
        if (DEBUG > 1) {
            System.out.println(CLASSID + ".characters: " + new String(ch, start, length));
            System.out.flush();
        }
    }

    @Override
    public String toString() {
        String str = "StudentsXMLHandler\n";
        str += "   maxStudents: " + maxStudents + "\n";
        str += "   studentCount: " + studentCount + "\n";
        str += "   studentBeingParsed: " + studentBeingParsed.toString() + "\n";
        str += "   activityBeingParsed: " + activityBeingParsed.toString() + "\n";
        str += "   bInstructor: " + bInstructor + "\n";
        str += "   bCredit: " + bInstructor + "\n";
        str += "   bName: " + bInstructor + "\n";
        str += "   bNumber: " + bInstructor + "\n";
        str += "   bLocation: " + bInstructor + "\n";
        str += "   bMeetingTime: " + bInstructor + "\n";
        str += "   bMeetingDay: " + bInstructor + "\n";
        return str;
    }
}

