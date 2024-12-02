package EscapeRoom;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Inventory {

    private final ArrayList<Room> rooms;

    private HashMap<Clue, Integer> clues;
    private HashMap<Object,Integer> objects;

    public Inventory() {
        rooms = new ArrayList<>();
        clues = new HashMap<>();
        objects = new HashMap<>();
    }

    public void CreateRoom(int id, String name, int difficultyLevel) throws DuplicatedRoomException{
        for(Room r: rooms){
            if(id==r.getId()){
                throw new DuplicatedRoomException("This room already exists");
            }
        }
        Room room = new Room(id, name, difficultyLevel);
        rooms.add(room);
    }

    public Clue CreateClue(int id, double price, String name, int time, Theme theme) throws DuplicatedClueException{
        for (Clue c : clues.keySet()) {
            if (c.getId()==id) {
                throw new DuplicatedClueException("This clue already exists");
            }
        }
        Clue clue = new Clue(id, price, name, time, theme);
        clues.put(clue,1);
        return clue;
    }

    public Clue FindClue(int id) throws ClueNotFoundException{
        for (Clue c : clues.keySet()) {
            if (c.getId()==id) {
                return c;
            }
        }
        throw new ClueNotFoundException("This clue doesn't exist");
    }

    public Object CreateObject(int id, double price, String description, Material material) throws DuplicatedObjectException{
        for (Object o : objects.keySet()) {
            if (o.getId()==id) {
                throw new DuplicatedObjectException("This object already exists");
            }
        }
        Object object = new Object(id, price, description, material);
        objects.put(object,1);
        return object;
    }

    public Object FindObject(int id) throws ObjectNotFoundException{
        for (Object o : objects.keySet()) {
            if (o.getId()==id) {
                return o;
            }
        }
        throw new ObjectNotFoundException("This object doesn't exist");
    }



    public void addCluetoRoom(Clue clue,int id) throws RoomNotFoundException{
        for (Room r:rooms){
            if(r.getId()==id){
                r.addClue(clue);
                return;
            }
        }
        throw new RoomNotFoundException("Room not found!");
    }

    public void addObjecttoRoom(Object object,int id) throws RoomNotFoundException{
        for (Room r:rooms){
            if(r.getId()==id){
                r.addObject(object);
                return;
            }
        }
        throw new RoomNotFoundException("Room not found!");
    }

    public ArrayList<Room> getRooms() {
        return rooms;
    }

    public HashMap<Clue, Integer> getClues() {
        return clues;
    }

    public HashMap<Object, Integer> getObjects() {
        return objects;
    }

    public void getRoomsInfo(){
        System.out.println("List of rooms:\n");
        for(Room r: rooms){
            System.out.println(r.toString());
        }
    }
    public void getCluesInfo(){
        if(clues.isEmpty()){
            return;
        }
        System.out.println("List of clues:\n");
        clues.forEach(
                (key,value)
                -> System.out.println("The clue " + key.getId() + " with name "+ key.getName() + " has " + value + " instances in stock and its total price after VAT is " + key.getNetPrice()*value)
        );
    }

    public void getObjectsInfo(){
        if(objects.isEmpty()){
            return;
        }
        System.out.println("List of objects:\n");
        clues.forEach(
                (key,value)
                        -> System.out.println("The object " + key.getId()+ " with name "+ key.getName()  + " has " + value + " instances in stock and its total price after VAT is " + key.getNetPrice()*value)
        );
    }
     public void removeObject(Object object){
        for (Room r:rooms){
            for(Object o:r.getObjects()){
                if(object.getId()==o.getId()){
                    r.removeObject(o);
                }
            }
        }
         objects.remove(object);
     }

    public void removeClue(Clue clue){
        for (Room r:rooms){
            for(Clue c:r.getClues()){
                if(clue.getId()==c.getId()){
                    r.removeClue(c);
                }
            }
        }
        clues.remove(clue);
    }
}
