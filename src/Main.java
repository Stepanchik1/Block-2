import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.function.*;
import java.util.stream.Stream;

public class Main {

    public static void main(String[] args) {
        PlanetSistem.createPS();
        Stream<PlanetSistem> planetStream = PlanetSistem.planetSistemList.stream();
        Comparator comparator = new Compare(); // для тренеровки сделал через отдельный класс
        BiConsumer<PlanetSistem, PlanetSistem> planetsConsumer = (PS1, PS2) -> {
            System.out.println("минимальное значение - " + PS1.getCountOfPlanets() + " планетной системы " + PS1);
            System.out.println("максимальное значение - " + PS2.getCountOfPlanets() + " планетной системы " + PS2);
        };
        Operations minMax = new Operations(); //если делаю метод findMinMax статичным, то подчеркивает <Т>, поэтому пришлось сделать экземпляр класса
        minMax.findMinMax(planetStream, comparator, planetsConsumer);

        int[] array = {1, 2, 3, 4, 5, 6, 7, 8, 9, 0};
        ArrayList<Integer> numbers = new ArrayList<>();
        //numbers = (ArrayList<Integer>) Arrays.stream(array).collect(Collectors.toList()); не хотит работать, поэтому цикл
        for (int i = 0; i < array.length; i++) {
            numbers.add(array[i]);
        }
        Operations even = new Operations();
        System.out.println(numbers.toString());
        numbers = even.findEvenNumbers(numbers);
        System.out.println(numbers.toString());
    }
}