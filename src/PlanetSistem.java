import java.awt.*;
import java.util.ArrayList;

public class PlanetSistem {
    private int countOfPlanets;
    static ArrayList <PlanetSistem> planetSistemList = new ArrayList<PlanetSistem>();
    public PlanetSistem(int countOfPlanets) {
        this.countOfPlanets = countOfPlanets;
    }

    public static void createPS()
    {
        PlanetSistem ps1 = new PlanetSistem(0);
        PlanetSistem ps2 = new PlanetSistem(2);
        PlanetSistem ps3 = new PlanetSistem(7);
        PlanetSistem ps4 = new PlanetSistem(4);
        PlanetSistem ps5 = new PlanetSistem(8);
        PlanetSistem ps6 = new PlanetSistem(6);
        planetSistemList.add(ps1);
        planetSistemList.add(ps2);
        planetSistemList.add(ps3);
        planetSistemList.add(ps4);
        planetSistemList.add(ps5);
        planetSistemList.add(ps6);
    }

    public int getCountOfPlanets() {
        return countOfPlanets;
    }
}
