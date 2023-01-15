public class Mechanist <T> {
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
            }}
        else if (automobile instanceof Driver) {
            System.out.println("начинает диагностику транспортного средства "+automobile.toString().replace("Водитель ", "водителя "));
            ((Driver<?>) automobile).diagnostika();
        }
        else {
            System.out.println("Диагностику данного вида транспорта проводить нельзя");
        }
    }

    public void repair (T automobile) {
        if (automobile instanceof Car || automobile instanceof Truck) {
            System.out.println(this + " чинит: \n " + automobile);
        } else if (automobile instanceof Driver) {
            System.out.println(this + " чинит: \n " + automobile + "\n принадлежащий" + automobile.toString().replace("Водтель ", "водтелю "));
        } else if (automobile instanceof Bus) {
            System.out.println("Автобусы не подлежат ремонту");
        } else {
            System.out.println("Данный вид транспорта чинить нельзя");
        }

    }
}
