public abstract class Transport {
 private String mark;
 private String model;
 private final int yearOfIssue = 1900;
private final String country = "Немечщина";
private String color;
private int maxVelocity;

public Transport() {
        this.mark = "марка не указана";
        this.model = "модель не указана";
        this.color = "белый";
        this.maxVelocity = 100;
    }

    public Transport(String mark, String model, String color, int maxVelocity) {
        this.mark = mark;
        this.model = model;
        this.color = color;
        this.maxVelocity = maxVelocity;
    }

    @Override
    public String toString() {
        return "марка - " + getMark() +
                ", модель - " + getModel() +
                ", год выпуска - " + getYearOfIssue() +
                ", страна выпуска - " + getCountry()+
                ", цвет - " + getColor() +
                ", максимальная скорость - " + getMaxVelocity();
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

    public int getYearOfIssue() {
        return yearOfIssue;
    }

    public String getCountry() {
        return country;
    }

    public String getColor() {
        if (color==null) {return "белый";}
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getMaxVelocity() {
        if (maxVelocity==0) {return 100;}
        return maxVelocity;
    }

    public void setMaxVelocity(int maxVelocity) {
        this.maxVelocity = maxVelocity;
    }
}
