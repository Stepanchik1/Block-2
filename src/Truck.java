public class Truck extends Transport {
    private String mass;
   private double massDown;
   private double massUp;

    private enum Mass {
        light("легкий", 0, 3.5),
        middle("средний", 3.5, 12.0),
        hard("тяжелый", 12.0, 999999999);
        String mass;
        double dm;
        double um;

        Mass(String mass, double dm, double um) {
            this.mass = mass;
            this.dm = dm;
            this.um = um;
        }

        @Override
        public String toString() {
            if (um>100000) {return mass + "(с массой выше "+um+" кг)";}
            return mass + " (с массой от "+dm+" до "+um+" кг)";
        }

    }

    public Truck(String mark, String model, double engineVolume, String mass) {
        super(mark, model, engineVolume);
        //this.massDown = Mass.valueOf(mass.trim()).dm;
        //this.massUp = Mass.valueOf(mass.trim()).um;
        this.mass = Mass.valueOf(mass.trim()).toString();
        this.massUp=Mass.valueOf(mass.trim()).um;
        this.massDown=Mass.valueOf(mass.trim()).dm;
    }

    @Override
    public String toString() {
        return "Грузовой автомобиль, "+mass+", "+super.toString();
    }

    public void pitstop() {
        System.out.println("Грузовик остановился");
    }
    public double maxVelocity() {
       double weigh = massUp;
        if (massUp>100000) {weigh=10000;}
        return getEngineVolume()*Volume_VelocityCouplingCoefficient/(weigh*Weight_Deceleration_Factor*1000);}
    public double theBestTime() {return (CIRCLE_LENGTH/maxVelocity());}

    public void printType () {
        System.out.println("Грузовик");
    }

    public String getMass() {
        return mass;
    }

    public void setMass(String mass) {
        this.mass = mass;
    }

    public double getMassDown() {
        return massDown;
    }

    public void setMassDown(double massDown) {
        this.massDown = massDown;
    }

    public double getMassUp() {
        return massUp;
    }

    public void setMassUp(double massUp) {
        this.massUp = massUp;
    }
}
