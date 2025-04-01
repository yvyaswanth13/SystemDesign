2. Abstract Factory Pattern
Concept:
A factory of factories: Instead of a single factory, we have multiple factories for different related objects.

Provides an interface for creating families of related objects without specifying their concrete classes.

Used when we need to support multiple types of object creation families.

// Step 1: Create interfaces for product families
interface Car {
    void assemble();
}

interface Bike {
    void assemble();
}

// Step 2: Concrete classes for two different brands
class ToyotaCar implements Car {
    public void assemble() {
        System.out.println("Assembling a Toyota Car");
    }
}

class HondaCar implements Car {
    public void assemble() {
        System.out.println("Assembling a Honda Car");
    }
}

class ToyotaBike implements Bike {
    public void assemble() {
        System.out.println("Assembling a Toyota Bike");
    }
}

class HondaBike implements Bike {
    public void assemble() {
        System.out.println("Assembling a Honda Bike");
    }
}

// Step 3: Abstract Factory Interface
interface VehicleFactory {
    Car createCar();
    Bike createBike();
}

// Step 4: Concrete Factories
class ToyotaFactory implements VehicleFactory {
    public Car createCar() {
        return new ToyotaCar();
    }

    public Bike createBike() {
        return new ToyotaBike();
    }
}

class HondaFactory implements VehicleFactory {
    public Car createCar() {
        return new HondaCar();
    }

    public Bike createBike() {
        return new HondaBike();
    }
}

// Step 5: Client code
public class Main {
    public static void main(String[] args) {
        VehicleFactory factory = new ToyotaFactory();
        Car car = factory.createCar();
        car.assemble();  // Output: Assembling a Toyota Car

        Bike bike = factory.createBike();
        bike.assemble();  // Output: Assembling a Toyota Bike
    }
}
