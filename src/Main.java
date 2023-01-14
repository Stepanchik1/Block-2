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
        Driver Leha = new Driver<>("Алексей Иванович", 'B', 2, car1);
        Driver Sasha = new Driver<> ("Александр Степанович", 'C', 5, bus3);
        Driver Petya = new Driver<>("Петр Семенович", 'D', 10);
        Driver Fima = new Driver<>("Ефим Николаевич", 'C', 17, truck3);
        Petya.setTransport(bus4);
        Driver Jenya = new Driver("Евгений Прокопьевич", 'D', 32);

        System.out.println("*****");
            Fima.diagnostika();
        System.out.println("*****");
            Leha.diagnostika();
        System.out.println("*****");
            Petya.diagnostika();
        System.out.println("*****");
            Sasha.diagnostika();
        System.out.println("*****");
            Jenya.diagnostika();


    }}
