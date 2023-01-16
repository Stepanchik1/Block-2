public interface Competitors {

    int Volume_VelocityCouplingCoefficient = 52;
    int CIRCLE_LENGTH = 2000;

    double Weight_Deceleration_Factor = 0.0003;
    default void pitstop() {}
    default int maxVelocity() {return 0;}
    default double theBestTime() {return 0;}

}
