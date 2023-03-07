import java.util.*;
import java.util.function.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        Service.trying();
        int chose = 0;
        for (; ; ) {
            for (; ; ) {
                System.out.println("Выберите дейсвтвие?\n1 - создать новую задачу\n2 - изменить задачу\n3 - искать задачу\n4 - удалить задачу\n0 - выйти");
                try {
                    chose = new Scanner(System.in).nextInt();
                    break;
                } catch (NumberFormatException ignored) {
                }
            }
            switch (chose) {
                case 0:
                    System.out.println("До свидания");
                    return;
                case 1:
                    Service.createTask();
                    break;
                case 2:
                    Change.ChangeTask();
                    break;
                case 3:
                    Search.searchTask();
                    break;
                case 4:
                    Service.deleteTask();
                    break;
            }
        }
    }
}












