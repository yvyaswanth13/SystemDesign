1. Factory Pattern (Simple Factory)
Concept:
Creates objects without exposing the instantiation logic to the client.

Returns an instance of a specific class based on input.

Used when there is only one factory class responsible for creating related objects.


// Step 1: Create an interface
interface Vehicle {
    void drive();
}

// Step 2: Concrete implementations
class Car implements Vehicle {
    public void drive() {
        System.out.println("Driving a Car");
    }
}

class Bike implements Vehicle {
    public void drive() {
        System.out.println("Riding a Bike");
    }
}

// Step 3: Factory class that returns objects
class VehicleFactory {
    public static Vehicle getVehicle(String type) {
        if (type.equalsIgnoreCase("car")) {
            return new Car();
        } else if (type.equalsIgnoreCase("bike")) {
            return new Bike();
        }
        return null;
    }
}

// Step 4: Client code
public class Main {
    public static void main(String[] args) {
        Vehicle myVehicle = VehicleFactory.getVehicle("car");
        myVehicle.drive();  // Output: Driving a Car
    }
}
