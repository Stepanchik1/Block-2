import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Scanner;

public class Change {

    public static void ChangeTask () {
        int a = 0;
        int ID = 0;
        for (; ; ) {
            int id = Service.ID();
            if (Service.privateTaskMap.get(id) != null) {
                if (!Service.prove(Service.privateTaskMap.get(id))) {
                    return;
                }
            }
            System.out.println("Выберите действие:\n 0 - назад,\n 1 - изменить описание,\n 2 - изменить название,\n 3 - изменить повторяемость,\n 4 - изменить срок выполнения,\n 5 - поменять тип рабочая/личная");
            Scanner in = new Scanner(System.in);
            try {
                int chose = in.nextInt();
                if (chose >= 0 && chose <= 5) {
                    a = chose;
                    ID = id;
                    break;
                }
            } catch (NumberFormatException ignored) {
            }
        }
        if (ID == 0) {return;}
        Task task = Search.Searching(ID);
        if (task != null) {
            if (task instanceof WorkTask) {
                switch (a) {
                    case 0:
                        return;
                    case 1:
                        changeDescription(Service.workTaskMap.get(ID));
                        return;
                    case 2:
                        changeName(Service.workTaskMap.get(ID));
                        return;
                    case 3:
                        changePeriodicity(Service.workTaskMap.get(ID));
                        return;
                    case 4:
                        changeDeadline(Service.workTaskMap.get(ID));
                        return;
                    case 5:
                        changeType(Service.workTaskMap.get(ID));
                        return;
                }
            } if (task instanceof PrivateTask) {
                switch (a) {
                    case 0:
                        return;
                    case 1:
                        changeDescription(Service.privateTaskMap.get(ID));
                        return;
                    case 2:
                        changeName(Service.privateTaskMap.get(ID));
                        return;
                    case 3:
                        changePeriodicity(Service.privateTaskMap.get(ID));
                        return;
                    case 4:
                        changeDeadline(Service.privateTaskMap.get(ID));
                        return;
                    case 5:
                        changeType(Service.privateTaskMap.get(ID));
                        return;
                }
            }
        } else {
            System.out.println("Задача с таким ID не найдена, проверьте список завершенных задач");
        }
    }
    public static void changeName (Task task) {
        if (task == null) {
            System.out.println("Задача не существует"); return;}
        System.out.println("0 - отмена\nВведите новое имя:");
        Scanner changer = new Scanner(System.in);
        String name = changer.nextLine().trim();
        if (name.equals("0")) {return;}
        else {task.setName(name); System.out.println("Задача изменена:\n"+task); return;}
    }

    public static void changeDescription (Task task) {
        if (task == null) {
            System.out.println("Задача не существует"); return;}
        System.out.println("0 - отмена\nВведите новое описание:");
        Scanner changer = new Scanner(System.in);
        String desc = changer.nextLine().trim();
        if (desc.equals("0")) {return;}
        else {task.setDescrirtion(desc); System.out.println("Задача изменена:\n"+task); return;}
    }

    public static void changeDeadline (Task task) {
        if (task == null) {
            System.out.println("Задача не существует"); return;}
        boolean exit = false;
        int year =0;
        int month = 0;
        int day = 0;
        for (;exit == false;) {
            if (task.getPeriodicity() == Task.Periodicity.ONETIME) {
                System.out.println("0 - отмена\nВведите новую дату крайнего срока выполнения задачи:\nЕсли хотите сделать задачу бессрочной, введите -1");}
            else {
                System.out.println("0 - отмена\nВведите новую дату выполнения задачи:");
            }
            try {
                System.out.println("Введите год:");
                Scanner setYear = new Scanner(System.in);
                year = setYear.nextInt();
                if (year<1900||year>=2200) {
                    if ((year>0)&&(year<100)) {year=year+2000;}
                    if (year==0) {return;}
                    if (year==-1&&task.getPeriodicity()==Task.Periodicity.ONETIME) {task.setDeadline(null); return;}}
                    else {throw new NumberFormatException();}
                System.out.println("Введите месяц:");
                Scanner setMonth = new Scanner(System.in);
                month = setYear.nextInt();
                if (month>12||month<1) {throw new NumberFormatException();}
                System.out.println("Введите день:");
                Scanner setDay = new Scanner(System.in);
                day = setYear.nextInt();
                if (day<1||day>31) {throw new NumberFormatException();}
                if ((month==4||month==6||month==9||month==11)&&(day==31)) {throw new NumberFormatException();}
                if (month==2&&day>29) {throw new NumberFormatException();} exit = true; }
            catch (NumberFormatException n) {
                System.out.println("Неверно задан формат числа");
            }
        }
        Calendar c = new GregorianCalendar(year, month-1, day);
        task.setDeadline(c);
        System.out.println("Задача изменена:\n"+task);
    }

    public static void changePeriodicity (Task task) {
        if (task == null) {
            System.out.println("Задача не существует"); return;}
        for (; ; ) {
            System.out.println("0 - отмена\nВыберите новую повторяемость задачи:\n1 - разовая\n2 - каждый день\n3 - каждую неделю\n4 - каждый месяц\n5 - каждый год");
            Scanner per = new Scanner(System.in);
            String periodicity = per.nextLine();
            if (periodicity.equals("0")) {
                return;
            }
            if (periodicity.equals("1")) {
                task.setPeriodicity(Task.Periodicity.ONETIME);
                System.out.println("Задача изменена:\n"+task);return;
            }
            if (periodicity.equals("2")) {
                task.setPeriodicity(Task.Periodicity.EVERYDAY); System.out.println("Задача изменена:\n"+task);return;
            }
            if (periodicity.equals("3")) {
                task.setPeriodicity(Task.Periodicity.EVERYWEEK); System.out.println("Задача изменена:\n"+task);return;
            }
            if (periodicity.equals("4")) {
                task.setPeriodicity(Task.Periodicity.EVERYMONTH); System.out.println("Задача изменена:\n"+task);return;
            }
            if (periodicity.equals("5")) {
                task.setPeriodicity(Task.Periodicity.EVERYYEAR); System.out.println("Задача изменена:\n"+task);return;
            }
        }
    }

    public static void changeType (Task task) {
        if (task == null) {
            System.out.println("Задача не существует"); return;}
        for (; ;) {
            System.out.println("0 - отмена\nВыберите новый тип задачи: \n1 - рабочая\n2 - личная");
            Scanner tasktype = new Scanner(System.in);
            String type = tasktype.nextLine().trim();
            if (type.equals("0")) {
               return;
            }
            if (type.equals("1")) {
                if (task instanceof WorkTask) {
                    System.out.println("Задача итак рабочая");
                }
                else {
                WorkTask workTask = new WorkTask(task.getName(), task.getPeriodicity());
                workTask.setID(task.getID());
                workTask.setDeadline(task.getDeadline());
                workTask.setDescrirtion(task.getDescrirtion());
                workTask.setDateOfCreation(task.getDateOfCreation());
                Service.privateTaskMap.put(task.getID(), null);
                Service.workTaskMap.put(workTask.getID(), workTask);
                    System.out.println("Задача изменена:\n"+Service.workTaskMap.get(workTask.getID()));
                return;
                }
            }
            if (type.equals("2")) {
                if (task instanceof PrivateTask) {
                    System.out.println("Задача итак приватная");
                }
                else {
                    PrivateTask privateTask = new PrivateTask(task.getName(), task.getPeriodicity(), PrivateTask.choseKey());
                    privateTask.setID(task.getID());
                    privateTask.setDeadline(task.getDeadline());
                    privateTask.setDescrirtion(task.getDescrirtion());
                    privateTask.setDateOfCreation(task.getDateOfCreation());
                    Service.workTaskMap.put(task.getID(), null);
                    Service.privateTaskMap.put(privateTask.getID(), privateTask);
                   System.out.println("Задача изменена:\n"+Service.privateTaskMap.get(privateTask.getID()));
                    return;
                }
            }
        }
    }
}
