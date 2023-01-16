public class Truck extends Transport {
    int weight;

    public Truck() {
        super();
        this.weight = 1000;
    }

    public Truck(String mark, String model, double engineVolume, int weight) {
        super(mark, model, engineVolume);
        this.weight = weight;
    }

    @Override
    public String toString() {
        return super.toString() + ", масса - " + getWeight() +" кг";
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public void pitstop() {
        System.out.println("Грузовик остановился");
    }
    public int maxVelocity() {return (int)getEngineVolume()*Volume_VelocityCouplingCoefficient/(int)(weight*Weight_Deceleration_Factor);}
    public double theBestTime() {return 1.0*(CIRCLE_LENGTH/maxVelocity());}
}
