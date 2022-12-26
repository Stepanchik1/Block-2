public class Main {

    public static void main(String[] args) {

        Car car1 = new Car();
        System.out.println(car1);

Car car2 = new Car("Форд", "Эксплорер", "бирюзовый", 200, "полная", 7, true);
        System.out.println(car2);

        Bus bus1 = new Bus();
        System.out.println(bus1);
        Bus bus2 = new Bus("Ford", "bus", "желтый", 150, 20, 30, "микро");
        System.out.println(bus2);
        Bus bus3 = new Bus();
        bus3.setMark("BMW");
        bus3.setModel("какой-то крутой бмвэшный автобус");
        bus3.setColor("цвет морской волны");
        bus3.setSeatPlaces(200);
        bus3.setAllPlaces(300);
        bus3.setScale("огромный");
        bus3.setMaxVelocity(350);
        System.out.println(bus3);
    }
}