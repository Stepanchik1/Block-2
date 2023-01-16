public class Main {

    public static void main(String[] args) {

Car car1 = new Car ("Kia", "K5", 4.0, false, "Body_Crossover");
Car car2 = new Car ("Nisan", "Tyida", 3.4, false, "Body_Sedan");
Car car3 = new Car ("Lada", "Granta", 3.2, true, "Body_Picap");
Car car4 = new Car ("Shcoda", "Yati", 3.6, false, "Body_Universal");

Bus bus1 = new Bus("WV", "Transporter", 4.0,  "MICRO");
Bus bus2 = new Bus("Москвич", "А9", 1.3, "MICRO");
Bus bus3 = new Bus("Mersedes", "Benz Tourismo", 12.0, "BIG");
Bus bus4 = new Bus("Mitsubishi", "Fuso Rosa", 5.5, "SMALL");

Truck truck1 = new Truck("Hyundai", "HD35", 2.5, "light" );
Truck truck2 = new Truck("Hyundai", "Mighty", 2.9, "middle" );
Truck truck3 = new Truck("Hyundai", "Universe", 12.7, "hard" );
Truck truck4 = new Truck("КамАЗ", "4311", 10.85,  "hard");

        Driver Leha = new Driver<>("Алексей Иванович", 'B', 2);
        Leha.setTransport(car1);
        System.out.println(Leha);
        Driver Sasha = new Driver<> ("Александр Степанович", 'C', 5, truck2);
        System.out.println(Sasha);
            car1.printType();
            truck1.printType();
            bus1.printType();
            Truck trucktor = new Truck("Белаз", "Витязь", 30.0, " light ");
            System.out.println(trucktor);
        System.out.println(car1);
        System.out.println(bus1);
        System.out.println(bus3);
        System.out.println(bus4);
    }}
