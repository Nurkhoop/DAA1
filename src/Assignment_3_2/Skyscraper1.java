package Assignment_3_2;

public class Skyscraper1 {
    public static final String SKYSCRAPER_WAS_BUILD = "Skyscraper2 is built.";
    public static final String SKYSCRAPER_WAS_BUILD_FLOORS_COUNT =
            "Skyscraper2 is built. The number of floors - ";
    public static final String SKYSCRAPER_WAS_BUILD_DEVELOPER =
            "Skyscraper2 is built. Developer - ";

    public Skyscraper1(){
        System.out.println(SKYSCRAPER_WAS_BUILD);
    }
    public Skyscraper1(int floor){
        System.out.println(SKYSCRAPER_WAS_BUILD_FLOORS_COUNT + floor);
    }
    public Skyscraper1(String developer){
        System.out.println(SKYSCRAPER_WAS_BUILD_DEVELOPER + developer);
    }

    public static void main(String[] args) {
        Skyscraper1 skyscraper = new Skyscraper1();
        Skyscraper1 skyscraperTower = new Skyscraper1(50);
        Skyscraper1 skyscraperSkyline = new Skyscraper1("JavaRushDevelopment");
    }
}
