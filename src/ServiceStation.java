import java.util.*;

public abstract class ServiceStation {
    String mechanist;
    static    Queue<Driver> driversInList = new LinkedList<>();

    public static void toLine (Driver driver) {
        getInLine (driver);
        System.out.println(driver.getFIO()+" встал в очередь на ремонт. Его номер - "+driversInList.size());
    }

public static void toLineAll (List <Driver> drivers) {
    for (int i = 0; i < drivers.size(); i++) {
        toLine(drivers.get(i));
    }
    }
public static void getInLine (Driver driver) {
    driversInList.add(driver);
}

private static boolean isRepaired = false;
public static void repair (Driver driver) {
    isRepaired = false;
        if (driver.getMechanist()!=null) {
    driver.getMechanist().repair(driver.getTransport());
    isRepaired = true;
        }
        else {
            System.out.println("Нельзя ремонтировать без механиков");
        }
}

public static void service () {
    for (int i = 0; driversInList.peek()!=null; i++) {
        Driver d = driversInList.poll();
repair(d);
if (isRepaired == true) {
        System.out.println(d.getFIO()+" отремонтирован и покидает очередь");}
else {
    System.out.println(d.getFIO()+" не отремонтирован и покидает очередь");
}
        if (driversInList.peek()!=null) {
            System.out.println("В очереди осталось "+driversInList.size()+" человек");
        System.out.println("Следующий в очереди на ремонт - "+driversInList.peek());}
        else {
            System.out.println("Очередь на ремонт пуста");
        }

    }
    isRepaired = false;
}

}
