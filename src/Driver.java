import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class Driver <S extends Transport > {
    private String FIO;
    private char category;
    private int experience;
    private S transport;

    private Mechanist mechanist;

    public Driver(String FIO, char category, int experience) {
        this.FIO = FIO;
        if (category == 'B' || category == 'C' || category == 'D') {
            this.category = category;
        } else {
            this.category = 0;
        }
        if (experience >= 0) {
            this.experience = experience;
        } else {
            this.experience = 0;
        }
    }

    public Driver (String FIO, char category, int experience, S transport) {
        this.FIO = FIO;
        if (category == 'B' || category == 'C' || category == 'D') {
            this.category = category;
        } else {
            this.category = 0;
        }
        if (experience >= 0) {
            this.experience = experience;
        } else {
            this.experience = 0;
        }
        if ((this.category == 'B' && transport instanceof Car) || (this.category == 'C' && transport instanceof Truck) || (this.category == 'D' && transport instanceof Bus)) {
            this.transport = transport;
        } else {
            System.out.println(nameOfCategory(transport)+" не установлен, так как не соотвествует категории прав водителя ("+category+")"); this.transport=null;}
    }

    private void stopTheCar() {
        System.out.println("Водитель " + FIO + " остановился ");
    }

    private void startDriving() {
        System.out.println("Водитель " + FIO + " начинает движение... ");
    }

    private void refuel() {
        System.out.println("Водитель " + FIO + " заправляет ");
    }

    public String getFIO() {
        if (FIO==null) {return "(ФИО не установлены)";}
        return FIO;
    }

    public void setFIO(String FIO) {
        this.FIO = FIO;
    }

    public char getCategory() {
        return category;
    }

    public void setCategory(char category) {
        this.category = category;
    }

    public int getExperience() {
        return experience;
    }

    public void setExperience(int experience) {
        this.experience = experience;
    }

    public S getTransport() {
        return transport;
    }

    public String nameOfCategory (S transport) {
        if (transport instanceof Car) {return "Легковой автомобиль";}
        if (transport instanceof Truck) {return "Грузовой автомобиль";}
        if (transport instanceof Bus) {return "Автобус";}
        else {return "Транспорт";}
    }

    public void setTransport(S transport) {
        if ((this.category == 'B' && transport instanceof Car) || (this.category == 'C' && transport instanceof Truck) || (this.category == 'D' && transport instanceof Bus)) {
            this.transport = transport;
        } else {
            System.out.println(nameOfCategory(transport)+" не установлен, так как не соотвествует категории прав водителя ("+category+")");
        }
    }

    @Override
    public String toString() {
        if (transport instanceof Car||transport instanceof Bus||transport instanceof Truck) {
            return "Водитель " + FIO +
                    " с категорией прав - " + category +
                    " и стажем вождения - " + experience +
                    " лет. Использует "+ nameOfCategory(transport)+": " + transport;
        }
        else {
        return "Водитель " + FIO +
                " с категорией прав - " + category +
                " и стажем вождения - " + experience +
                " лет. Не использует автотранспорт";
    }}

    public Mechanist getMechanist() {
        return mechanist;
    }

    public void setMechanist(Mechanist mechanist) {
        this.mechanist = mechanist;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Driver<?> driver = (Driver<?>) o;
        return category == driver.category && experience == driver.experience && Objects.equals(FIO, driver.FIO) && Objects.equals(transport, driver.transport) && Objects.equals(mechanist, driver.mechanist);
    }

    @Override
    public int hashCode() {
        return Objects.hash(FIO, category, experience, transport, mechanist);
    }

    static Set<Driver> driverSet = new HashSet<>();

    public static void set () {
        Driver Leha = new Driver<>("Алексей Иванович", 'B', 2, Car.cars.get(0));
        Driver Sasha = new Driver<> ("Александр Степанович", 'C', 5, Truck.trucks.get(1));
        Driver Petya = new Driver<>("Петр Семенович", 'D', 10, Bus.buses.get(3));
        Driver Fima = new Driver<>("Ефим Николаевич", 'C', 17, Truck.trucks.get(2));
        Driver Jenya = new Driver("Евгений Прокопьевич", 'B', 32, Car.cars.get(1));
        Driver Seva = new Driver("Савелий Игнатьевич", 'C', 6, Truck.trucks.get(0));
        Driver Pasha = new Driver("Павел Артемович", 'B', 0, Car.cars.get(2));

        driverSet.add(Leha);
        driverSet.add(Sasha);
        driverSet.add(Petya);
        driverSet.add(Fima);
        driverSet.add(Jenya);
        driverSet.add(Seva);
        driverSet.add(Pasha);
        driverSet.add(Seva); // проверка на повтор
        driverSet.add(Pasha); // проверка на повтор

    }
}