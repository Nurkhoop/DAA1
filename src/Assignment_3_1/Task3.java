package Assignment_3_1;

public class Task3 {
    public interface CanFly {
        void fly();
    }

    public interface CanRun {
        void run();
    }

    public interface CanSwim {
        void swim();
    }

    public static void main(String[] args) {
    }

    public class Human implements CanRun, CanSwim {
        @Override
        public void run() {
        }

        @Override
        public void swim() {
        }
    }

    public class Duck implements CanFly, CanRun, CanSwim {
        @Override
        public void fly() {
        }

        @Override
        public void run() {
        }

        @Override
        public void swim() {
        }
    }

    public class Penguin implements CanRun, CanSwim {
        @Override
        public void run() {
        }

        @Override
        public void swim() {

        }
    }

    public class Airplane implements CanFly {
        @Override
        public void fly() {
        }
    }
}
