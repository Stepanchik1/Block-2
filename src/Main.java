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

        Mechanist Vasya = new Mechanist("Василий Иванович", "РемонтТех");
        Mechanist Sema = new Mechanist("Семен Егорович", "Прайм");
        Mechanist Yulya = new Mechanist("Юлия Александровна", "РосРемонт");

        Driver Leha = new Driver<>("Алексей Иванович", 'B', 2, Car.cars.get(0));
        Driver Sasha = new Driver<> ("Александр Степанович", 'C', 5, Truck.trucks.get(1));
        Driver Petya = new Driver<>("Петр Семенович", 'D', 10, Bus.buses.get(3));
        Driver Fima = new Driver<>("Ефим Николаевич", 'C', 17, Truck.trucks.get(2));
        Driver Jenya = new Driver("Евгений Прокопьевич", 'B', 32, Car.cars.get(1));
        Driver Seva = new Driver("Савелий Игнатьевич", 'C', 6, Truck.trucks.get(0));
        Driver Pasha = new Driver("Павел Артемович", 'B', 0, Car.cars.get(2));

Mechanist.getMapOfMechanists().put(Leha, Vasya);
Mechanist.getMapOfMechanists().put(Sasha, Sema);
Mechanist.getMapOfMechanists().put(Petya, Yulya);
Mechanist.getMapOfMechanists().put(Fima, Vasya);
Mechanist.getMapOfMechanists().put(Jenya, Yulya);
Mechanist.getMapOfMechanists().put(Seva, Sema);
Mechanist.getMapOfMechanists().put(Pasha, null);
        Mechanist.getMapOfMechanists().put(Leha, Vasya);
        Mechanist.getMapOfMechanists().put(Sasha, Sema);
        Mechanist.getMapOfMechanists().put(Seva, Sema);

        System.out.println(Mechanist.getMapOfMechanists().get(Leha));
        System.out.println(Mechanist.getMapOfMechanists().get(Sasha));
        System.out.println(Mechanist.getMapOfMechanists().get(Petya));
        System.out.println(Mechanist.getMapOfMechanists().get(Fima));
        System.out.println(Mechanist.getMapOfMechanists().get(Jenya));
        System.out.println(Mechanist.getMapOfMechanists().get(Seva));
        System.out.println(Mechanist.getMapOfMechanists().get(Pasha));
        sep();
        Leha.setMechanist(Mechanist.getMapOfMechanists().get(Leha));
        Sasha.setMechanist(Mechanist.getMapOfMechanists().get(Sasha));
        Petya.setMechanist(Mechanist.getMapOfMechanists().get(Petya));
        Fima.setMechanist(Mechanist.getMapOfMechanists().get(Fima));
        Jenya.setMechanist(Mechanist.getMapOfMechanists().get(Jenya));
        Seva.setMechanist(Mechanist.getMapOfMechanists().get(Seva));
        Pasha.setMechanist(Mechanist.getMapOfMechanists().get(Pasha));
        ////
        System.out.println(Leha);
        System.out.println(Sasha);
        System.out.println(Petya);
        System.out.println(Fima);
        System.out.println(Jenya);
        System.out.println(Seva);
        System.out.println(Pasha);
    }}
