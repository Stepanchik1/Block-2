public class Main {

    public static void main(String[] args) {

        Car car1 = new Car("Kia", "K5", 4.0, false, Car.BodyType.Body_Crossover);
        Car car2 = new Car("Nisan", "Tyida", 3.4, false, Car.BodyType.Body_Sedan);
        Car car3 = new Car("Lada", "Granta", 3.2, true, Car.BodyType.Body_Picap);
        Car car4 = new Car("Shcoda", "Yati", 3.6, false, Car.BodyType.Body_Universal);

        Bus bus1 = new Bus("WV", "Transporter", 4.0, Bus.Scale.SMALL);
        Bus bus2 = new Bus("Москвич", "А9", 1.3, Bus.Scale.MICRO);
        Bus bus3 = new Bus("Mersedes", "Benz Tourismo", 12.0, Bus.Scale.BIG);
        Bus bus4 = new Bus("Mitsubishi", "Fuso Rosa", 5.5, Bus.Scale.SMALL);

        Truck truck1 = new Truck("Hyundai", "HD35", 2.5, "light");
        Truck truck2 = new Truck("Hyundai", "Mighty", 2.9, "middle");
        Truck truck3 = new Truck("Hyundai", "Universe", 12.7, "hard");
        Truck truck4 = new Truck("КамАЗ", "4311", 10.85, "hard");

        System.out.println(car1);
        System.out.println(bus1);
        System.out.println(truck1);


    }}