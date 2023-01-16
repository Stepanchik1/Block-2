public class Car extends Transport {
   private boolean trailer;

    public Car() {
        super();
        this.trailer = false;
    }

    public Car(String mark, String model, double engineVolume, boolean trailer) {
        super(mark, model, engineVolume);
        this.trailer = trailer;
    }

    private String trailerToString (boolean trailer) {
        if (trailer == true) {return "с прицепом";}
        else {return "без прицепа";}
    }

    @Override
    public String toString() {

        return super.toString() + ", " + trailerToString(getTrailer());
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
    public int maxVelocity() {return (int)getEngineVolume()*Volume_VelocityCouplingCoefficient;}
    public double theBestTime() {return 1.0*(CIRCLE_LENGTH/maxVelocity());}
}
