interface drivable{

}    


abstract class Vehicle implements drivable{
    double speed;

    // Pass Vehicle as argument instead of a specific subclass like Car
    void move(Vehicle vehicle) {
        System.out.println("The " + vehicle.getClass().getSimpleName() + " is moving.");
    }

    void stop(Vehicle vehicle) {
        System.out.println("The " + vehicle.getClass().getSimpleName() + " has stopped.");
        this.speed = 0;
    }
}

class Car extends Vehicle {
    String model;
    String name;
    String color;
    int year;
    static int number_of_cars = 0;

    public Car(String model, String name, String color, int year) {
        this.model = model;
        this.name = name;
        this.color = color;
        this.year = year;
        ++number_of_cars;
    }
    @Override
    void move(Vehicle vehicle){
        super.speed = 100;
        System.out.println("The " + vehicle.getClass().getSimpleName() + " is moving.");
    }

    @Override
    public String toString() {
        return model + " " + name + " was produced in " + year + " with " + color + " colors";
    }
}

class Bicycle extends Vehicle {
    @Override
    public String toString() {
        return "Bicycle";
    }
}

class Garage {
    void park(Vehicle vehicle) {
        System.out.println("The " + vehicle.getClass().getSimpleName() + " is parked.");
    }
}

public class Main1 {
    public static void main(String[] args) {
        Car ferrari = new Car("Ferrari", "Laferrari", "red", 2016);
        Bicycle bike = new Bicycle();
        Garage garage = new Garage();

        // Pass any type of Vehicle (Car, Bicycle) to move and stop
        ferrari.move(ferrari);
        ferrari.stop(ferrari);

        bike.move(bike);
        bike.stop(bike);

        garage.park(ferrari);
        garage.park(bike);
        
        System.out.println("You have a total of " + Car.number_of_cars + " cars");
    }
}
