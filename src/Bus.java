public class Bus extends Transport{
    private int seatPlaces;
    private String scale;

    public Bus() {
        super();
        this.seatPlaces = 50;
        this.scale = "маленький";
    }

    public Bus(String mark, String model, double engineVolume, int seatPlaces, String scale) {
        super(mark, model, engineVolume);
        this.seatPlaces = seatPlaces;
        this.scale = scale;;
    }

    @Override
    public String toString() {
        return super.toString () +
                ", количество сидячих мест - " + getSeatPlaces() +
                ", размер - " + getScale();
    }

    public int getSeatPlaces() {
        if (seatPlaces==0) {return 100;}
        return seatPlaces;
    }

    public void setSeatPlaces(int seatPlaces) {
        this.seatPlaces = seatPlaces;
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
    public int maxVelocity() {
        double engineVolume = super.getEngineVolume();
        double scale = toScale(getScale());
        return (int)engineVolume*Volume_VelocityCouplingCoefficient/(int)(scale);}
    public double theBestTime() {return 1.0*(CIRCLE_LENGTH/maxVelocity());}

}
