import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Scanner;

public class Search {
    public static void searchTask() {
        int chose =0;
        for (;;){
            System.out.println("0 - назад\nПо какому параметру искать?\n1 - по имени\n2 - по ID\n3 - по сроку выполнения\n4 - по периодичности\n5 - показать весь архив задач");
            try { chose = new Scanner(System.in).nextInt();
                if (chose!=0&&chose!=1&&chose!=2&&chose!=3&&chose!=4&&chose!=5) {throw new NumberFormatException();}
                if (chose==0) {return;} if (chose==1||chose==2||chose==3||chose==4||chose==5) {break;}
            } catch (NumberFormatException ignored) {}
        }
        switch (chose) {
            case 1: searchByName(); return;
            case 2: searchByID(); return;
            case 3: searchByDeadline(); return;
            case 4: searchByPeriodicity(); return;
            case 5: lookMap(); return;
        }
    }

    public static Task Searching(Integer ID) {
        if (Service.workTaskMap.get(ID) != null) {
            return Service.workTaskMap.get(ID);
        }
        if (Service.privateTaskMap.get(ID) != null) {
            return Service.privateTaskMap.get(ID);
        }
        return null;
    }

    public static Task SearchingDeleted(int ID) {
        if (Service.MapOfEndedTasks.get(ID) != null) {
            return Service.MapOfEndedTasks.get(ID);
        } else {
            return null;
        }
    }

    public static void searchByName() {
        String name = Service.createName().toLowerCase();
        if (name.equals("0")) {
            return;
        }
        int count = 0;
        for (int i = 1; i < 999999999; i++) {
            try {
                if (Service.workTaskMap.get(i).getName().toLowerCase().contains(name)) {
                    count++;
                    System.out.println(Service.workTaskMap.get(i));
                }
            } catch (NullPointerException ignored) {
            }
        }
        for (int i = 1; i < 99999999; i++) {
            try {
                if (Service.privateTaskMap.get(i).getName().toLowerCase().contains(name)) {
                    count++;
                    System.out.println(Service.privateTaskMap.get(i).toStringPrivate());
                }
            } catch (NullPointerException ignored) {
            }
        }
        if (count == 0) {
            System.out.println("Задачи не найдены");
        }
    }

    public static void searchByID() {
        int ID = Service.ID();
        if (ID==0) {return;}
        if (Searching(ID) != null) {
            if (Searching(ID) instanceof PrivateTask) {
                if (Service.prove(Searching(ID))) {
                System.out.println(Searching(ID));}
            } else {
                System.out.println(Searching(ID));
            }
        } else if (SearchingDeleted(ID) != null) {
            if (Searching(ID) instanceof PrivateTask) {
                if (Service.prove(Searching(ID))) {
                    System.out.println(((PrivateTask) Searching(ID)));}
            } else {
                System.out.println(SearchingDeleted(ID));
            }
        } else {
            System.out.println("Задачи с таким ID не найдены");
        }
    }

    public static void searchForDeadlineless() {
        int count = 0;
        for (int i = 1; i < 99999999; i++) {
            try {
                if (Service.workTaskMap.get(i).getDeadline() == null) {
                    System.out.println(Service.workTaskMap.get(i));
                    count++;
                }
            } catch (NullPointerException ignored) {
            }
        }
        for (int j = 1; j < 99999999; j++) {
            try {
                if (Service.privateTaskMap.get(j).getDeadline() == null) {
                    System.out.println(Service.privateTaskMap.get(j).toStringPrivate());
                    count++;
                }
            } catch (NullPointerException ignored) {
            }
        }
        if (count == 0) {
            System.out.println("Задачи не найдены");
        }
    }

    public static void searchByDeadline() {
        System.out.println("-1 - бессрочная задача");
        Calendar c = Service.getSomeDate();
        Date date = new Date(0);
        int count = 0;
        if (c == null) {
            return;
        }
        if (c.getTime().before(date)) {
            searchForDeadlineless();
            return;
        }
        for (int i = 1; i < 99999999; i++) {
            try {
                if (Service.workTaskMap.get(i).getDeadline().getTime().getTime() == c.getTime().getTime()) {
                    System.out.println(Service.workTaskMap.get(i));
                    count++;
                }
            } catch (NullPointerException ignored) {
            }
        }
        for (int j = 1; j < 99999999; j++) {
            try {
                if (Service.privateTaskMap.get(j).getDeadline().getTime().getTime() == c.getTime().getTime()) {
                    System.out.println(Service.privateTaskMap.get(j).toStringPrivate());
                    count++;
                }
            } catch (NullPointerException ignored) {
            }
        }
        if (count == 0) {
            System.out.println("Задачи не найдены");
        }

    }

    public static void searchByPeriodicity() {
        Task.Periodicity p = Service.createPeriodicity();
        if (p==null) {return;}
        int count = 0;
        for (int i = 1; i < 99999999; i++) {
            try {
                if (Service.workTaskMap.get(i).getPeriodicity() == p) {
                    System.out.println(Service.workTaskMap.get(i));
                    count++;
                }
            } catch (NullPointerException ignored) {
            }
        }
        for (int j = 1; j < 99999999; j++) {
            try {
                if (Service.privateTaskMap.get(j).getPeriodicity() == p) {
                    System.out.println(Service.privateTaskMap.get(j).toStringPrivate());
                    count++;
                }
            } catch (NullPointerException ignored) {
            }
        }
        if (count == 0) {
            System.out.println("Задачи не найдены");
        }

    }

    public static void setMap(HashMap hashMap) {
        int count = 0;
        for (int i = 0; i < 99999999; i++) {
            if (hashMap.get(i) != null) {
                if (hashMap.get(i) instanceof PrivateTask) {
                    System.out.println(((PrivateTask) hashMap.get(i)).toStringPrivate());
                } else {
                    System.out.println(hashMap.get(i));
                }
                count++;
            }
        }
        if (count == 0) {
            System.out.println("архив пуст");
        }
    }

    public static void lookMap() {
        for (;;) {
            int chose = 0;
            for (; ; ) {
                System.out.println("Список каких задач показать:\n 1 - рабочих,\n 2 - личных,\n 3 - завершенных,\n 0 - назад");
                Scanner in = new Scanner(System.in);
                try {
                    chose = in.nextInt();
                } catch (NumberFormatException ignored) {
                }
                if (chose >= 0 && chose <= 3) {
                    break;
                }
            }
            switch (chose) {
                case 0:
                    return;
                case 1:
                    setMap(Service.workTaskMap);
                    break;
                case 2:
                    setMap(Service.privateTaskMap);
                    break;
                case 3:
                    setMap(Service.MapOfEndedTasks);
                    break;
            }

        }
    }


}


