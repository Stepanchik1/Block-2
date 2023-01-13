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
    public double maxVelocity() {
        double engineVolume = super.getEngineVolume();
        double scale = toScale(getScale());
        return (int)engineVolume*Volume_VelocityCouplingCoefficient/(int)(scale);}
    public double theBestTime() {return 1.0*(CIRCLE_LENGTH/maxVelocity());}

    public String getSeatPlaces() {
        return seatPlaces;
    }

    public void printType () {
        System.out.println("Автобус");
    }
}
