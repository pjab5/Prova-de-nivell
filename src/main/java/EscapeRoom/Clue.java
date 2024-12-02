package EscapeRoom;

public class Clue {
    private int id;
    private double price;
    private String name;
    private int time;
    private Theme theme;

    public Clue(int id, double price, String name, int time, Theme theme) {
        this.id = id;
        this.price = price;
        this.name = name;
        this.time = time;
        this.theme = theme;
    }

    public double getNetPrice(){
        return price*1.1;
    }

    public double getPrice() {
        return price;
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    public int getTime() {
        return time;
    }

    public Theme getTheme() {
        return theme;
    }
}
