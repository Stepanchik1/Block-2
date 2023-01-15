import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void sep() {
        System.out.println("*****");
    }

    public static void main(String[] args) {

Car.list();
Bus.list();
Truck.list();
Transport.main(args);
Driver.list();

        Driver.drivers.get(0).setMechanist(Transport.mechanists.get(0));
        System.out.println(Driver.drivers.get(0));
        sep();
        Driver.drivers.get(1).setMechanist(Transport.mechanists.get(1));
        System.out.println(Driver.drivers.get(1));
        sep();
        Driver.drivers.get(2).setMechanist(Transport.mechanists.get(2));
        System.out.println(Driver.drivers.get(2));
        sep();
        Driver.drivers.get(3).setMechanist(Transport.mechanists.get(0));
        System.out.println(Driver.drivers.get(3));
        sep();
        Driver.drivers.get(4).setMechanist(Transport.mechanists.get(1));
        System.out.println(Driver.drivers.get(4));
        sep();
        Driver.drivers.get(5).setMechanist(Transport.mechanists.get(2));
        System.out.println(Driver.drivers.get(5));
        sep();
        // Driver.drivers.get(6).setMechanist(Transport.mechanists.get(0));
        System.out.println(Driver.drivers.get(6));
        sep();

        ServiceStation.toLineAll(Driver.getDrivers());
        ServiceStation.service();

    }}
