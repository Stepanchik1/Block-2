import java.util.Objects;

public class Car extends Transport {
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
    public double maxVelocity() {return getEngineVolume()*Volume_VelocityCouplingCoefficient;}
    public double theBestTime() {return 1.0*(CIRCLE_LENGTH/maxVelocity());}

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
}
