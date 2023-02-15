import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class Main {

    public static void main(String[] args) {
        Predicate<Number> predicate = num -> {
            if (num.getNumber() > 0) {
                return true;
            }
            return false;
        };

        Consumer <Person> consumer = person -> System.out.println("Привет, я "+person.getName());

        Function <Double, Long> function = o -> {
            long l = (long) o.getD();
            Long aLong = new Long();
            aLong.setL(l);
            return aLong;
        };

        Supplier <Number> supplier = () -> {
            Number num = new Number();
            num.setNumber((int) (Math.random()*100));
            return num;
        };
    }
}