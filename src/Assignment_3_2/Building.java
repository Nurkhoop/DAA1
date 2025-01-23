package Assignment_3_2;

public class Building {
    private String type;

    public void initialize(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }

    public static void main(String[] args) {
        Building building = new Building();
        building.initialize("Restaurant");
        building.initialize("Barbershop");

    }
}
