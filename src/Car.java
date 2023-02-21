import java.util.Objects;

public class Car extends Transport {
   private boolean trailer;

   private BodyType bodyType;

    enum BodyType{ Body_Null ("Не указан"), Body_Sedan("Седан"), Body_Hatchback("Хэтчбэк"), Body_Cupe("Купе"), Body_Universal("Универсал"), Body_OffRoad("Внедорожник"), Body_Crossover("Кроссовер"), Body_Picap("Пикап"), Body_Furgon("Фургон"), Body_Miniven("Минивен");

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
        this.bodyType = BodyType.Body_Null;
    }

    public Car(String mark, String model, double engineVolume, boolean trailer, BodyType bodyType) {
        super(mark, model, engineVolume);
        this.trailer = trailer;
       this.bodyType = bodyType;
    }

    private String trailerToString (boolean trailer) {
        if (trailer == true) {return "с прицепом";}
        else {return "без прицепа";}
    }

    @Override
    public String toString() {

        return "Легковой автомобиль: "+super.toString() + ", " + trailerToString(getTrailer())+ ", с типом кузова: "+getBodyType();
    }

    public boolean getTrailer() {
        return trailer;
    }

    public void setTrailer(boolean trailer) {
        this.trailer = trailer;
    }

    public String getBodyType() {
      return bodyType.getBodyType();
    }

    public void setBodyType(String bodyType) {
       this.bodyType = BodyType.valueOf(bodyType);
    }
    public void printType () {
        System.out.println("Легковой автомобиль");
    }
}
