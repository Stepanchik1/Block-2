import java.util.ArrayList;
import java.util.List;

public class Truck extends Transport implements Diagnostic{
    String weight;
    double massDown;
    double massUp;

    private enum Mass {
        light("легкий", 0, 3.5),
        middle("средний", 3.5, 12.0),
        hard("тяжелый", 12.0, 999999999);
        String mass;
        double dm;
        double um;

        Mass(String mass, double dm, double um) {
            this.mass = mass;
            this.dm = dm;
            this.um = um;
        }

        @Override
        public String toString() {
            return mass + "";
        }

    }

    public Truck() {
        super();
        this.massDown = 0;
        this.massUp = 3.5;
    }

    public Truck(String mark, String model, double engineVolume, String mass) {
        super(mark, model, engineVolume);
        this.massDown = Mass.valueOf(mass.trim()).dm;
        this.massUp = Mass.valueOf(mass.trim()).um;
        this.weight = Mass.valueOf(mass.trim()).mass;
    }

    @Override
    public String toString() {
        if (massUp > 100000) {
            return "Грузовой автомобиль: " + super.toString() + ", " + weight + ", c массой более " + getMassDown() + " кг";
        }
        return "Грузовой автомобиль: " + super.toString() + ", " + weight + ", c массой от  " + getMassDown() + " до " + getMassUp() + " кг";
    }

    public String getWeight() {
        return weight;
    }

    public void setWeight(String weight) {
        this.weight = weight;
    }

    public double getMassDown() {
        return massDown;
    }

    public void setMassDown(double massDown) {
        this.massDown = massDown;
    }

    public double getMassUp() {
        return massUp;
    }

    public void setMassUp(double massUp) {
        this.massUp = massUp;
    }

    public void pitstop() {
        System.out.println("Грузовик остановился");
    }

    public void printType () {
        System.out.println("Грузовик");
    }

    public void diagnostika() {
        System.out.println("Грузовик "+toString()+" Проходит диагностику");
    }

    static List<Truck> trucks = new ArrayList<>();
    public static void list () {
        Truck truck1 = new Truck("Hyundai", "HD35", 2.5, "light" );
        Truck truck2 = new Truck("Hyundai", "Mighty", 2.9, "middle" );
        Truck truck3 = new Truck("Hyundai", "Universe", 12.7, "hard" );
        Truck truck4 = new Truck("КамАЗ", "4311", 10.85,  "hard");
        trucks.add(truck1);
        trucks.add(truck2);
        trucks.add(truck3);
        trucks.add(truck4);
    }

    public static List<Truck> getTrucks() {
        return trucks;
    }

    public static void setTrucks(List<Truck> trucks) {
        Truck.trucks = trucks;
    }
}
