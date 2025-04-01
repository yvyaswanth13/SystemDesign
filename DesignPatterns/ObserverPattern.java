Real-World Analogy:
Imagine you subscribe to a YouTube channel. Whenever the channel uploads a new video:

YouTube channel (Subject) → Notifies all subscribers.

Subscribers (Observers) → Get notified and can watch the new video.
Wether Temprature: When ever temp increases it shpuld update on all devices(Mobile, TV..etc)

interface Observer {
    void update(float temperature);
}


import java.util.ArrayList;
import java.util.List;

interface Subject {
    void registerObserver(Observer o);
    void removeObserver(Observer o);
    void notifyObservers();
}


Step 3: Create the Concrete Subject (WeatherStation)

class WeatherStation implements Subject {
    private List<Observer> observers;
    private float temperature;

    public WeatherStation() {
        this.observers = new ArrayList<>();
    }

    @Override
    public void registerObserver(Observer o) {
        observers.add(o);
    }

    @Override
    public void removeObserver(Observer o) {
        observers.remove(o);
    }

    @Override
    public void notifyObservers() {
        for (Observer o : observers) {
            o.update(temperature);
        }
    }

    // Method to update temperature and notify observers
    public void setTemperature(float temperature) {
        this.temperature = temperature;
        notifyObservers();
    }
}



Step 4: Create Concrete Observers

class PhoneDisplay implements Observer {
    private float temperature;

    @Override
    public void update(float temperature) {
        this.temperature = temperature;
        System.out.println("Phone Display updated: Temperature is " + temperature + "°C");
    }
}

class TVDisplay implements Observer {
    private float temperature;

    @Override
    public void update(float temperature) {
        this.temperature = temperature;
        System.out.println("TV Display updated: Temperature is " + temperature + "°C");
    }
}


Step 5: Test the Observer Pattern
public class Main {
    public static void main(String[] args) {
        WeatherStation weatherStation = new WeatherStation();
        
        Observer phoneDisplay = new PhoneDisplay();
        Observer tvDisplay = new TVDisplay();

        // Register observers
        weatherStation.registerObserver(phoneDisplay);
        weatherStation.registerObserver(tvDisplay);

        // Update temperature
        System.out.println("Setting temperature to 25°C...");
        weatherStation.setTemperature(25);

        System.out.println("Setting temperature to 30°C...");
        weatherStation.setTemperature(30);

        // Remove an observer
        weatherStation.removeObserver(phoneDisplay);
        System.out.println("Phone display unsubscribed.");

        // Update temperature again
        System.out.println("Setting temperature to 35°C...");
        weatherStation.setTemperature(35);
    }
}

O/p:
Setting temperature to 25°C...
Phone Display updated: Temperature is 25.0°C
TV Display updated: Temperature is 25.0°C

Setting temperature to 30°C...
Phone Display updated: Temperature is 30.0°C
TV Display updated: Temperature is 30.0°C

Phone display unsubscribed.
Setting temperature to 35°C...
TV Display updated: Temperature is 35.0°C
