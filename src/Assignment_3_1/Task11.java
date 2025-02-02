package Assignment_3_1;

public class Task11 {
    public static void main(String[] args) {
        Cat cat = new Cat();
        Dog dog = new Dog();
        Mouse mouse = new Mouse();
        System.out.println(cat.beEaten());

    }

    public interface Movable {
        void move();
    }

    public interface Edible {
        char beEaten();

    }

    public interface Eat {
        void eat();
    }

    public static class Dog implements Movable, Eat {
        @Override
        public void move() {
            System.out.println("Dog is moving");
        }

        @Override
        public void eat() {
            System.out.println("Dog is eating");
        }
    }

    public static class Cat implements Movable, Eat, Edible {
        @Override
        public void move() {
            System.out.println("Cat is moving");
        }

        @Override
        public void eat() {
            System.out.println("Cat is eating");
        }

        @Override
        public char beEaten() {
            System.out.println("Cat is eaten by dog ");
            return 0;
        }
    }

    public static class Mouse implements Movable, Edible {
        @Override
        public void move() {
            System.out.println("Mouse is moving");
        }

        @Override
        public char beEaten() {
            System.out.println("Mouse is eaten by cat and dog");
            return 0;
        }
    }
}
