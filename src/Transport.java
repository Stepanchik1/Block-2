import java.util.ArrayList;
import java.util.List;

public abstract class Transport {
 protected String mark;
 protected String model;
 protected double engineVolume;

public Transport() {
    this.mark = "марка не указана";
    this.model = "модель не указана";
    this.engineVolume = 0;
    }

    public Transport(String mark, String model, double engineVolume) {
    this.mark = mark;
    this.model = model;
    this.engineVolume = engineVolume;
    }

    @Override
    public String toString() {
    if (this == null) {return "Транспорт отсутствует";}
        return "марка - " + getMark() +
                ", модель - " + getModel() +
                ", объем двигателя - " + getEngineVolume() +
                " л";
    }

    public String getMark() {
    if (mark==null) {return "марка не указана";}
        return mark;
    }

    public void setMark(String mark) {
        this.mark = mark;
    }

    public String getModel() {
        if (model==null) {return "модель не указана";}
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public double getEngineVolume() {
        return engineVolume;
    }

    public void setEngineVolume(double engineVolume) {
        this.engineVolume = engineVolume;
    }

    public abstract void printType ();

static List<Mechanist> mechanists = new ArrayList<>();

public static void main (String[] args) {
    Mechanist Vasya = new Mechanist("Василий Иванович", "РемонтТех");
    Mechanist Sema = new Mechanist("Семен Егорович", "Прайм");
    Mechanist Yulya = new Mechanist("Юлия Александровна", "РосРемонт");
    mechanists.add(Vasya);
    mechanists.add(Sema);
    mechanists.add(Yulya);

}
}
