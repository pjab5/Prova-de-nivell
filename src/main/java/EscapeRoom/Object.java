package EscapeRoom;

public class Object {
    private int id;
    private double price;
    private String description;
    private Material material;
    public Object(int id, double price, String description, Material material) {
        this.id = id;
        this.price = price;
        this.description = description;
        this.material = material;
    }

    public double getNetPrice(){
        return price*1.21;
    }

    public double getPrice() {
        return price;
    }

    public int getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }

    public Material getMaterial() {
        return material;
    }

}
