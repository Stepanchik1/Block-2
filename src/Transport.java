public abstract class Transport implements Competitors {
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

}
