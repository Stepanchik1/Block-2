public class Truck extends Transport implements Diagnostic{
    String weight;
    double massDown;
    double massUp;

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
            return mass + "";
        }

    }

    public Truck() {
        super();
        this.massDown = 0;
        this.massUp = 3.5;
    }

    public Truck(String mark, String model, double engineVolume, String mass) {
        super(mark, model, engineVolume);
        this.massDown = Mass.valueOf(mass.trim()).dm;
        this.massUp = Mass.valueOf(mass.trim()).um;
        this.weight = Mass.valueOf(mass.trim()).mass;
    }

    @Override
    public String toString() {
        if (massUp>100000) {return super.toString() + ", "+weight+ ", c массой более " + getMassDown() +" кг";}
        return super.toString() + ", "+weight+ ", c массой от  " + getMassDown() +" до "+ getMassUp()+" кг";
    }

    public String getWeight() {
        return weight;
    }

    public void setWeight(String weight) {
        this.weight = weight;
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

    public void diagnostika() {
        System.out.println("Грузовик "+toString()+" Проходит диагностику");
    }
}
