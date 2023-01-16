public class DriverD <S extends Transport > extends Driver {

    private static final String DRIVER_LICENSE = "D";

    public DriverD(String FIO, int experience) {
        super(FIO, experience);
    }

    public DriverD(String FIO, int experience, S transport) {
        super(FIO, experience);
        this.transport = transport;
    }

    public String toString() {
        if (transport instanceof Bus) {
            return "Водитель " + FIO +
                    " с категорией прав - D" +
                    " и стажем вождения - " + experience +
                    " лет. Использует "+ nameOfCategory(transport)+": " + transport;
        }
        else {
            return "Водитель " + FIO +
                    " с категорией прав - D" +
                    " и стажем вождения - " + experience +
                    " лет. Не использует автотранспорт";
        }}

    public void setTransport(S transport) {
        if (transport instanceof Bus||transport==null) {
            this.transport = transport;
        } else {
            System.out.println(nameOfCategory(transport)+" не установлен, так как не соотвествует категории прав водителя (D)");
        }
    }

    public String getDRIVER_LICENSE () {
        return DRIVER_LICENSE;
    }
}