import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.BiConsumer;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Operations <T> {
    public void findMinMax(Stream<? extends T> stream, Comparator<? super T> order, BiConsumer<? super T, ? super T> minmax) {
        ArrayList<? extends T> list = (ArrayList<? extends T>) stream.sorted(order).collect(Collectors.toList());
        if (list.size() > 1) {
            minmax.accept(list.get(0), list.get(list.size() - 1));
        } else if (list.size() == 1) {
            System.out.println("Единственное значение - " + list.get(0));
        } else {
            System.out.println("Нет значений для сравнения");
        }
    }

    public ArrayList findEvenNumbers (ArrayList <Integer> arrayList){
    List <Integer> e = new ArrayList<>();
    e = arrayList.stream().filter(s -> s%2==0).collect(Collectors.toList());
    return (ArrayList <Integer>) e;
    }
}