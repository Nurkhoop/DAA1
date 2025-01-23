package Assignment_3_1;

public class Task2 {
    public static void main(String[] args) {
        Dog dog = new Dog();
        dog.move();
        dog.eat();

        Car car = new Car();
        car.move();

        Airplane airplane = new Airplane();
        airplane.move();
        airplane.fly();

        Duck duck = new Duck();
        duck.move();
        duck.fly();
        duck.eat();
    }
}

