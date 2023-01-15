import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Car extends Transport implements Diagnostic{
   private boolean trailer;

   String bodyType;

    public enum BodyType{ Body_Sedan("Седан"), Body_Hatchback("Хэтчбэк"), Body_Cupe("Купе"), Body_Universal("Универсал"), Body_OffRoad("Внедорожник"), Body_Crossover("Кроссовер"), Body_Picap("Пикап"), Body_Furgon("Фургон"), Body_Miniven("Минивен");

        String body;
        BodyType (String body) {
            this.body = body;
        }

        public String getBodyType () {return this.body;}

        public void setBody(String body) {
            this.body = body;
        }

        @Override
        public String toString() {
            return body;
        }
    }

    public Car() {
        super();
        this.trailer = false;
        this.bodyType = "Седан";
    }

    public Car(String mark, String model, double engineVolume, boolean trailer, String bodyType) {
        super(mark, model, engineVolume);
        this.trailer = trailer;
       this.bodyType = BodyType.valueOf(bodyType.trim()).body;
    }

    private String trailerToString (boolean trailer) {
        if (trailer == true) {return "с прицепом";}
        else {return "без прицепа";}
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Car car = (Car) o;
        return trailer == car.trailer && Objects.equals(bodyType, car.bodyType);
    }

    @Override
    public int hashCode() {
        return Objects.hash(trailer, bodyType);
    }

    @Override
    public String toString() {

        return super.toString() + ", " + trailerToString(getTrailer())+ ", с типом кузова: "+getBodyType();
    }

    public boolean getTrailer() {
        return trailer;
    }

    public void setTrailer(boolean trailer) {
        this.trailer = trailer;
    }

    public void pitstop() {
        System.out.println("Машина остановилась");
    }

    public String getBodyType() {
      return bodyType;

    }

    public void setBodyType(String bodyType) {
        BodyType body [] = new BodyType[BodyType.values().length];
        for (int i = 0; i < body.length; i++) {
            if (bodyType.equals(body[i])) {  this.bodyType = bodyType;}
            else {this.bodyType =  null;}
        }
    }

    public void printType () {
        System.out.println("Машина");
    }

    public void diagnostika() {
        System.out.println("Автомобиль "+toString()+" Проходит диагностику");
    }

    static List<Car> cars = new ArrayList<>();
    public static void list () {
        Car car1 = new Car ("Kia", "K5", 4.0, false, "Body_Crossover");
        Car car2 = new Car ("Nisan", "Tyida", 3.4, false, "Body_Sedan");
        Car car3 = new Car ("Lada", "Granta", 3.2, true, "Body_Picap");
        Car car4 = new Car ("Shcoda", "Yati", 3.6, false, "Body_Universal");
        cars.add(car1);
        cars.add(car2);
        cars.add(car3);
        cars.add(car4);
    }

    public static List<Car> getCars() {
        return cars;
    }

    public static void setCars(List<Car> cars) {
        Car.cars = cars;
    }
}
