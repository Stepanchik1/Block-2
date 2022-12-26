public class Car extends Transport {
    private static int counter = 0;
   private String complectation;
   private int seatPlaces;
   private boolean trailer;
   private final String type = "В";

    public Car() {
        super();
        this.complectation = "базовая";
        this.seatPlaces = 5;
        this.trailer = false;
        counter++;
    }

    public Car(String mark, String model, String color, int maxVelocity, String complectation, int seatPlaces, boolean trailer) {
        super(mark, model, color, maxVelocity);
        this.complectation = complectation;
        this.seatPlaces = seatPlaces;
        this.trailer = trailer;
        counter++;
    }

    private String trailerToString (boolean trailer) {
        if (trailer == true) {return "с прицепом";}
        else {return "без прицепа";}
    }

    @Override
    public String toString() {
        return "Car" + getCounter() + ": " + super.toString() +
                ", Комплектация - " + getComplectation() +
                ", мест для сидения - " + getSeatPlaces() +
                ", " + trailerToString(getTrailer()) +
                ", категория " + getType() + ".";
    }

    public String getComplectation() {
        if (complectation==null) {return "базовая";}
        return complectation;
    }

    public void setComplectation(String complectation) {
        this.complectation = complectation;
    }

    public int getSeatPlaces() {
        if (seatPlaces==0) {return 5;}
        return seatPlaces;
    }

    public void setSeatPlaces(int seatPlaces) {
        this.seatPlaces = seatPlaces;
    }

    public boolean getTrailer() {
        return trailer;
    }

    public void setTrailer(boolean trailer) {
        this.trailer = trailer;
    }

    public static int getCounter() {
        return counter;
    }

    public String getType() {
        return type;
    }



}
