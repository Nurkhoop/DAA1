package Assignment_3_1;

public class Task11 {
    public static void main(String[] args) {
    }

    public interface Movable {
        void move();
    }

    public interface Edible {
        void beEaten();
    }

    public interface Eat {
        void eat();
    }

    public class Dog implements Movable, Eat {
        @Override
        public void move() {
        }

        @Override
        public void eat() {
        }
    }

    public class Cat implements Movable, Eat, Edible {
        @Override
        public void move() {
        }

        @Override
        public void eat() {
        }

        @Override
        public void beEaten() {
        }
    }

    public class Mouse implements Movable, Edible {
        @Override
        public void move() {
        }

        @Override
        public void beEaten() {
        }
    }
}
