public class Bus extends Transport{
    private int seatPlacesDown;

    private int seatPlacesUp;
    private String scale;

    private String capacity;

    private enum Scale {MICRO ("микро", 0,10), SMALL ("короткий", 0, 25), MIDDLE("средний", 40,50), BIG("большой",60,80), VERY_BIG("огромный", 100, 120);

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
            return scale+" (с числом мест "+toStringPlaces()+")";
        }
    }

    public Bus() {
        super();
        this.scale = Scale.SMALL.scale;
        this.seatPlacesDown = Scale.SMALL.numberDown;
        this.seatPlacesUp = Scale.SMALL.numberUp;
        this.capacity = Scale.SMALL.toString();
    }

    public Bus(String mark, String model, double engineVolume, String scale) {
        super(mark, model, engineVolume);
        this.scale = Scale.valueOf(scale.trim()).scale;
        this.seatPlacesDown = Scale.valueOf(scale.trim()).numberDown;
        this.seatPlacesUp = Scale.valueOf(scale.trim()).numberUp;
        this.capacity = Scale.valueOf(scale.trim()).toString();
    }

    @Override
    public String toString() {
        if ((scale.trim()).equals("микро")) {return
                "Микроавтобус"+capacity.replace("микро", "") + ", "+ super.toString();}
        return
                "Автобус "+capacity + ", "+ super.toString();
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

    public void printType () {
        System.out.println("Автобус");
    }

    public int getSeatPlacesDown() {
        return seatPlacesDown;
    }

    public void setSeatPlacesDown(int seatPlacesDown) {
        this.seatPlacesDown = seatPlacesDown;
    }

    public int getSeatPlacesUp() {
        return seatPlacesUp;
    }

    public void setSeatPlacesUp(int seatPlacesUp) {
        this.seatPlacesUp = seatPlacesUp;
    }

    public String getCapacity() {
        return capacity;
    }

    public void setCapacity(String capacity) {
        this.capacity = capacity;
    }

}
