public class Driver <S extends Transport > implements Diagnostic{
    private String FIO;
    private char category;
    private int experience;
    private S transport;

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

    public void diagnostika() {
        System.out.println("Начинается диагностика транспортного средства водителя...");
        try {
            if ((this.category == 'B' || this.category == 'C')&&this.transport!=null) {System.out.println(toString()+"\nУспешно прошел диагностику!");}
            else {
                if (this.category == 0) {
                    System.out.println("Не указана категория водителя");
                    throw new IllegalArgumentException("Не указана категория водителя");
                }
                if (this.category == 'D') {
                    System.out.println("Водители автобусов не могут проходить диагностику");
                    throw new IllegalArgumentException("Водители автобусов не могут проходить диагностику");
                }
                if (this.transport == null) {
                    throw new NullPointerException("Автотранспорт отсутствует");}
                System.out.println("Неверно указана категория водителя");
                throw new IllegalArgumentException("Неверно указана категория водителя");}
            }
        catch (IllegalArgumentException I) {
            if (this.transport==null) {System.out.println("Также у водителя отсутствует автотранспорт, чтобы пройти диагностику");}
            System.out.println(toString()+"\n "+"Диагностику не прошел!!!");
        }
        catch (NullPointerException N) {
            System.out.println(toString());
            System.out.println("У водителя отсутствует автотранспорт, чтобы пройти диагностику");
            System.out.println("Диагностика не может быть пройдена!");
        }
        finally {
            System.out.println("Закончилась диагностика транспортного средства.");
        }
    }
}