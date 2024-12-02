package EscapeRoom;

import java.util.ArrayList;

public class Room {
    private int id;
    private String name;
    private int difficultyLevel;
    private double totalPrice;
    private ArrayList<Object> objects;
    private ArrayList<Clue> clues;

    public Room(int id, String name, int difficultyLevel) {
        this.id = id;
        this.name = name;
        this.difficultyLevel = difficultyLevel;
        totalPrice = 0;
        objects = new ArrayList<>();
        clues = new ArrayList<>();
    }

    public void addObject(Object object){
        objects.add(object);
    }
    public void removeObject(Object object){
        objects.remove(object);
    }

    public void addClue(Clue clue){
        clues.add(clue);
    }

    public void removeClue(Clue clue){
        clues.remove(clue);
    }

    public double getTotalPrice(){
        for (Object o:objects) {
            totalPrice += o.getNetPrice();
        }
        for (Clue c:clues) {
            totalPrice += c.getNetPrice();
        }
        return totalPrice;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getDifficultyLevel() {
        return difficultyLevel;
    }

    @Override
    public String toString() {
        return "Room{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", difficultyLevel=" + difficultyLevel +
                '}';
    }

    public ArrayList<Object> getObjects() {
        return objects;
    }

    public ArrayList<Clue> getClues() {
        return clues;
    }
}
