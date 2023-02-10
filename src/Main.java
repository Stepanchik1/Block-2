import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Main {

    public static void sep() {
        System.out.println("*****");
    }

    public static void main(String[] args) {

        Car.list();
        Bus.list();
        Truck.list();
        Driver.set();
        Mechanist.set();


        Iterator<Driver> drivers = Driver.driverSet.iterator();

        while (drivers.hasNext()) {
            System.out.println(drivers.next());
        }

        }
    }