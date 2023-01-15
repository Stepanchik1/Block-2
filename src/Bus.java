import java.util.ArrayList;
import java.util.List;

public class Bus extends Transport{
    private int seatPlacesDown;

    private int seatPlacesUp;

    private String seatPlaces;
    private String scale;

    private String capacity;

    private enum Scale {MICRO ("Микро", 0,10), SMALL ("Короткий", 0, 25), MIDDLE("Средний", 40,50), BIG("Большой",60,80), VERY_BIG("Огромный", 100, 120);

        int numberDown;
        int numberUp;
        String scale;

        Scale( String scale, int numberDown, int numberUp) {
            this.numberDown = numberDown;
            this.numberUp = numberUp;
            this.scale = scale;
        }
        public String toStringPlaces() {
            return "от " + numberDown +
                    " до " + numberUp;
        }

        public String toString () {
            return scale;
        }
    }

    public Bus() {
        super();
        this.seatPlaces = Scale.SMALL.toString();
        this.scale = Scale.SMALL.scale;
        this.seatPlacesDown = Scale.valueOf(this.scale.trim()).numberDown;
        this.seatPlacesUp = Scale.valueOf(this.scale.trim()).numberUp;
    }

    public Bus(String mark, String model, double engineVolume, String scale) {
        super(mark, model, engineVolume);
        this.scale = Scale.valueOf(scale.trim()).scale;
        this.seatPlacesDown = Scale.valueOf(scale.trim()).numberDown;
        this.seatPlacesUp = Scale.valueOf(scale.trim()).numberUp;
        this.seatPlaces = Scale.valueOf(scale.trim()).toStringPlaces();
    }

    @Override
    public String toString() {
        return super.toString () +
                ", количество сидячих мест - " + getSeatPlaces() +
                ", размер - " + getScale();
    }


    public String getScale() {
        if (scale==null) {return "короткий";}
        return scale;
    }

    public void setScale(String scale) {
        this.scale = scale;
    }

    double toScale (String scale) {
        if (scale.equals("Микро")) {return 1;}
        if (scale.equals("Короткий")) {return 1.5;}
        if (scale.equals("Маленький")) {return 2.0;}
        return 1;
    }

    public void pitstop() {
        System.out.println("Автобус остановился");
    }

    public String getSeatPlaces() {
        return seatPlaces;
    }

    public void printType () {
        System.out.println("Автобус");
    }
    static List<Bus> buses = new ArrayList<>();
    public static void list () {
        Bus bus1 = new Bus("WV", "Transporter", 4.0,  "MICRO");
        Bus bus2 = new Bus("Москвич", "А9", 1.3, "MICRO");
        Bus bus3 = new Bus("Mersedes", "Benz Tourismo", 12.0, "BIG");
        Bus bus4 = new Bus("Mitsubishi", "Fuso Rosa", 5.5, "SMALL");
        buses.add(bus1);
        buses.add(bus2);
        buses.add(bus3);
        buses.add(bus4);
    }

    public static List<Bus> getBuses() {
        return buses;
    }

    public static void setBuses(List<Bus> buses) {
        Bus.buses = buses;
    }
}
