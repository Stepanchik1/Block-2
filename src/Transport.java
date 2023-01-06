public abstract class Transport {
 private String mark;
 private String model;
 private final int yearOfIssue;
private final String country = "Немечщина";
private String color;
private int maxVelocity;

public Transport() {
    this.yearOfIssue = 2000;
    this.mark = "марка не указана";
        this.model = "модель не указана";
        this.color = "белый";
        this.maxVelocity = 100;
    }

    public Transport(String mark, String model, int year, String color, int maxVelocity) {
    this.yearOfIssue = year;
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
    if (yearOfIssue == 0) {return 2000;}
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
