public abstract class Driver <S extends Transport > {
   protected String FIO;
   protected int experience;
   protected S transport;

    public Driver(String FIO, int experience) {
        this.FIO = FIO;
        if (experience >= 0) {
            this.experience = experience;
        } else {
            this.experience = 0;
        }
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
}