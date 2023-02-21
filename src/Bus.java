public class Bus extends Transport{
    private int seatPlacesDown;

    private int seatPlacesUp;
    private Scale scale;

    private String capacity;

    enum Scale {NULL ("не указан", 0, 0), MICRO ("микро", 0,10), SMALL ("короткий", 0, 25), MIDDLE("средний", 40,50), BIG("большой",60,80), VERY_BIG("огромный", 100, 120);

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

        public String getScale() {
            return scale;
        }
    }

    public Bus(String mark, String model, double engineVolume, Scale scale) {
        super(mark, model, engineVolume);
        this.scale = scale;
        this.seatPlacesDown = scale.numberDown;
        this.seatPlacesUp = scale.numberUp;
        this.capacity = scale.toString();
    }

    @Override
    public String toString() {
        if ((scale.getScale().trim()).equals("микро")) {return
                "Микроавтобус"+capacity.replace("микро", "") + ", "+ super.toString();}
        return
                "Автобус "+capacity + ", "+ super.toString();
    }


    public String getScale() {
        if (scale==null) {return Scale.NULL.getScale();}
        return scale.getScale();
    }

    public void setScale(String scale) {
        this.scale = Scale.valueOf(scale);
    }

    double toScale (String scale) {
        if (scale.equals("Микро")) {return 1;}
        if (scale.equals("Короткий")) {return 1.5;}
        if (scale.equals("Маленький")) {return 2.0;}
        return 0;
    }

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
