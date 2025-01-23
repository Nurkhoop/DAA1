package Assignment_3_1;

public class Task9 {
    public interface CanMove {
        Double speed();
    }

    public interface CanFly extends CanMove {
        Double speed(CanFly obj);
    }

    public static void main(String[] args) {

    }
}

