import java.util.Comparator;

public class Compare implements Comparator <PlanetSistem>
{
    @Override
    public int compare (PlanetSistem o1, PlanetSistem o2) {
        if (o1.getCountOfPlanets() > o2.getCountOfPlanets()) {
            return 1;
        } else if (o1.getCountOfPlanets() < o2.getCountOfPlanets()) {
            return -1;
        }
        return 0;
    }
}
