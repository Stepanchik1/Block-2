import java.util.Calendar;
import java.util.Scanner;
public class PrivateTask extends Task {
    private int key;

    public PrivateTask(String name, Periodicity periodicity, int key) {
        super(name, periodicity);
        this.key = key;
        isPersonal = true;
    }

    public PrivateTask(String name, String descrirtion, Periodicity periodicity, Calendar deadline, int key, int ID) {
        super(name, descrirtion, periodicity, deadline);
        this.key = key;
        this.ID = ID;
        isPersonal = true;
    }

    public static int choseKey() {
        boolean exit = false;
        int toint = 0;
        for (; !exit; ) {
            System.out.println("Введите ключ доступа (не более 10 цифр):");
            Scanner key = new Scanner(System.in);
            String string = key.nextLine().trim();
            exit = true;
            try {
                if (string.trim().equals("0")) {
                    throw new NumberFormatException();
                }
                toint = Integer.parseInt(string);
            } catch (NumberFormatException n) {
                System.out.println("Неверно задан формат ключа");
                exit = false;
            }
        }
        return toint;
    }

    public int getKey() {
        return key;
    }

    public void setKey(int key) {
        this.key = key;
    }

    public String toStringPrivate () {
        return getName()+", ID - "+getID()+". Приватная задача";
    }
}
