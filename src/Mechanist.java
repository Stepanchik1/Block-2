import java.util.HashMap;
import java.util.Map;

public class Mechanist <T extends Transport> {
    String FIO;
    String company;

    public Mechanist(String FIO, String company) {
        this.FIO = FIO;
        this.company = company;
    }

    public String getFIO() {
        return FIO;
    }

    public void setFIO(String FIO) {
        this.FIO = FIO;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    @Override
    public String toString() {
        return "Механик " + FIO +
                ", работающий в компании " + company;
    }

    public void diagnostika(T automobile) {
        if (automobile instanceof Car || automobile instanceof Truck) {
            if (automobile instanceof Car) {
                System.out.println(this + "начинает диагностику автомобиля: ");
                ((Car) automobile).diagnostika();
            }
            if (automobile instanceof Truck) {
                System.out.println(this + "начинает диагностику грузового автомобиля: ");
                ((Truck) automobile).diagnostika();
            }
        } else {
            System.out.println("Диагностику данного вида транспорта проводить нельзя");
        }
    }

    public void diagnostika(Driver driver) {
        if ((driver instanceof Driver)&&(driver.getTransport() instanceof Car)) {
            System.out.println("начинает диагностику легкового автомобиля "+driver.toString().replace("Водитель ", "водителя "));
            ((Car) driver.getTransport()).diagnostika();}
        else if ((driver instanceof Driver)&&(driver.getTransport() instanceof Truck)) { System.out.println("начинает диагностику грузового автомобиля "+driver.toString().replace("Водитель ", "водителя "));
            ((Truck) driver.getTransport()).diagnostika();}
            else {
            System.out.println("Некорректно задан водитель");
        }
    }

    public void repair (T automobile) {
        if (automobile instanceof Car || automobile instanceof Truck) {
            System.out.println(this + " чинит: \n " + automobile);
        } else if (automobile instanceof Bus) {
            System.out.println("Автобусы не подлежат ремонту");
        } else {
            System.out.println("Данный вид транспорта чинить нельзя");
        }
    }

    public void repair (Driver driver) {
        if (driver instanceof Driver) {
            System.out.println(this + " чинит: \n " + driver.getTransport() + "\n принадлежащий" + driver.toString().replace("Водтель ", "водтелю "));
        }
    }
    // private static Map<Driver, Mechanist> MapOfMechanists = new HashMap<>();
    // public static Map<Driver, Mechanist> getMapOfMechanists() {
    //   return MapOfMechanists;}
    // public static void setMapOfMechanists(Map<Driver, Mechanist> mapOfMechanists) {
    //    MapOfMechanists = mapOfMechanists;}
public static void set () {
    Mechanist Vasya = new Mechanist("Василий Иванович", "РемонтТех");
    Mechanist Sema = new Mechanist("Семен Егорович", "Прайм");
    Mechanist Yulya = new Mechanist("Юлия Александровна", "РосРемонт");
}

}
