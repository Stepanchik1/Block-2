import java.util.Objects;

public class Automobile {
    String brand;
    String model;
    double engineVolume;
    String color;
    int year;
    String country;


    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
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

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Automobile that = (Automobile) o;
        return engineVolume == that.engineVolume && year == that.year && Objects.equals(brand, that.brand) && Objects.equals(model, that.model) && Objects.equals(color, that.color) && Objects.equals(country, that.country);
    }

    @Override
    public int hashCode() {
        return Objects.hash(brand, model, engineVolume, color, year, country);
    }

    @Override
    public String toString() {
        return
                "brand='" + brand + '\'' +
                        ", model='" + model + '\'' +
                        ", engineVolume=" + engineVolume +
                        ", color='" + color + '\'' +
                        ", year=" + year +
                        ", country='" + country + '\'' + "\n"
                ;
    }


    public Automobile() {
        this (null, null, 0, null, 0, null);
    }

    public Automobile(String brand, String model, double engineVolume, String color, int year, String country) {
        this.brand = brand;
        if (this.brand == null) {
            this.brand = "default";
        }
        this.model = model;
        if (this.model == null) {
            this.model = "default";
        }
        this.engineVolume = engineVolume;
        if (this.engineVolume <= 0) {
            this.engineVolume = 1.5;
        }
        this.color = color;
        if (this.color == null) {
            this.color = "белый";
        }
        this.year = year;
        if (this.year <= 0) {
            this.year = 2000;
        }
        this.country = country;
        if (this.country == null) {
            this.country = "default";
        }


    }
}