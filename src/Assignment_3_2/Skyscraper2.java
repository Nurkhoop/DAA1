package Assignment_3_2;

public class Skyscraper2 {
    private int floorsCount;
    private String developer;

    // Constructor without parameters
    public Skyscraper2() {
        this.floorsCount = 5;
        this.developer = "JavaRushDevelopment";
    }

    // Constructor with parameters
    public Skyscraper2(int floorsCount, String developer) {
        this.floorsCount = floorsCount;
        this.developer = developer;
    }

    public static void main(String[] args) {
        Skyscraper2 skyscraper = new Skyscraper2();
        Skyscraper2 skyscraperUnknown = new Skyscraper2(50, "Unknown");

        // Optional: Test output for verification
        System.out.println("First building: " + skyscraper.floorsCount + " floors, developed by " + skyscraper.developer);
        System.out.println("Second building: " + skyscraperUnknown.floorsCount + " floors, developed by " + skyscraperUnknown.developer);
    }
}
