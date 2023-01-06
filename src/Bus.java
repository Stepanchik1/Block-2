public class Bus extends Transport{
    private static int counter = 0;
    private int seatPlaces;
    private int allPlaces;
    private String scale;
    private final boolean secondFloor = false;

    public Bus() {
        super();
        this.seatPlaces = 50;
        this.allPlaces = 100;
        this.scale = "маленький";
        counter++;
    }

    public Bus(String mark, String model, int year, String color, int maxVelocity, int seatPlaces, int allPlaces, String scale) {
        super(mark, model, year, color, maxVelocity);
        this.seatPlaces = seatPlaces;
        this.allPlaces = allPlaces;
        this.scale = scale;
        counter++;
    }

    @Override
    public String toString() {
        return "Автобус" + getCounter() + ": "+super.toString () +
                ", количество сидячих мест - " + getSeatPlaces() +
                ", всего мест - " + getAllPlaces() +
                ", размер - " + getScale() +
                ", одноэтажный";
    }

    public static int getCounter() {
        return counter;
    }

    public int getSeatPlaces() {
        if (seatPlaces==0) {return 100;}
        return seatPlaces;
    }

    public void setSeatPlaces(int seatPlaces) {
        this.seatPlaces = seatPlaces;
    }

    public int getAllPlaces() {
        if (allPlaces==0) {return 200;}
        return allPlaces;
    }

    public void setAllPlaces(int allPlaces) {
        this.allPlaces = allPlaces;
    }

    public String getScale() {
        if (scale==null) {return "короткий";}
        return scale;
    }

    public void setScale(String scale) {
        this.scale = scale;
    }

    public boolean isSecondFloor() {
        return secondFloor;
    }
}
