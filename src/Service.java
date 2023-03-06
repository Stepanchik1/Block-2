import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class Service {

    private static int counter;
   // private static int counterPrivate;
    private static int counterDeleted;

   // public static LinkedList <WorkTask> listOfWorktasks = new LinkedList<>();
   // public static LinkedList <PrivateTask> listOfPrivatetasks = new LinkedList<>();


    public static HashMap <Integer, WorkTask> workTaskMap = new HashMap<>();
    public static HashMap <Integer, PrivateTask> privateTaskMap = new HashMap<>();
    public static HashMap <Integer, Task> MapOfEndedTasks = new HashMap<>();


    public static String createName() {
        System.out.println("0 - отмена\nВведите название задачи:");
        Scanner taskname = new Scanner(System.in);
        String name = taskname.nextLine().trim();
        return name;
    }

    public static Task createTasktype(String name) {
        for (; ; ) {
            System.out.println("0 - отмена\nВыберите тип задачи: \n1 - рабочая\n2 - личная");
            Scanner tasktype = new Scanner(System.in);
            String type = tasktype.nextLine().trim();
            if (type.equals("0")) {
                return null;
            }
            if (type.equals("1")) {
                WorkTask workTask = new WorkTask(name, null);
                return workTask;
            }
            if (type.equals("2")) {
                PrivateTask privateTask = new PrivateTask(name, null, PrivateTask.choseKey());
                return privateTask;
            }
        }
    }

    public static String createDescription() {
        System.out.println("0 - отмена\nВведите суть задачи:");
        Scanner descripe = new Scanner(System.in);
        String description = descripe.nextLine();
        return description;
    }

    public static Task.Periodicity createPeriodicity () {
        for (; ; ) {
            System.out.println("0 - отмена\nВыберите повторяемость задачи:\n1 - разовая\n2 - каждый день\n3 - каждую неделю\n4 - каждый месяц\n5 - каждый год");
            Scanner per = new Scanner(System.in);
            String periodicity = per.nextLine();
            if (periodicity.equals("0")) {
                return null;
            }
            if (periodicity.equals("1")) {
                return Task.Periodicity.ONETIME;
            }
            if (periodicity.equals("2")) {
                return Task.Periodicity.EVERYDAY;
            }
            if (periodicity.equals("3")) {
                return Task.Periodicity.EVERYWEEK;
            }
            if (periodicity.equals("4")) {
                return Task.Periodicity.EVERYMONTH;
            }
            if (periodicity.equals("5")) {
                return Task.Periodicity.EVERYYEAR;
            }
        }
    }

    public static Calendar createDeadline (Task t) {
        int year =0;
        int month = 0;
        int day = 0;
        for (; ;) {
        if (t.getPeriodicity() == Task.Periodicity.ONETIME) {
            System.out.println("Введите дату крайнего срока выполнения задачи:\nЕсли он не нужен, введите 0");}
        else {
            System.out.println("Введите дату выполнения задачи:");
        }
        try {
            System.out.println("Введите год:");
            Scanner setYear = new Scanner(System.in);
            year = setYear.nextInt();
            if (year>1900&&year<=2200) {} else
            if ((year>0)&&(year<100)) {year=year+2000;} else
            if (year==0) {return null;}
            else {throw new NumberFormatException();}
            System.out.println("Введите месяц:");
            Scanner setMonth = new Scanner(System.in);
            month = setMonth.nextInt();
            if (month>12||month<1) {throw new NumberFormatException();}
            System.out.println("Введите день:");
            Scanner setDay = new Scanner(System.in);
            day = setDay.nextInt();
            if (day<1||day>31) {throw new NumberFormatException();}
            if ((month==4||month==6||month==9||month==11)&&(day==31)) {throw new NumberFormatException();}
        if (month==2&&day>29) {throw new NumberFormatException();} break; }
catch (NumberFormatException n) {
    System.out.println("Неверно задан формат числа");
}
    }
    Calendar c = new GregorianCalendar(year, month-1, day);
        return c;
    }

    public static Calendar getSomeDate () {
        System.out.println(" 0 - отмена");
        int year =0;
        int month = 0;
        int day = 0;
        for (; ;) {
            try {
                System.out.println("Введите год:");
                Scanner setYear = new Scanner(System.in);
                year = setYear.nextInt();
                if (year>1900&&year<=2200) {}
                else     if ((year>0)&&(year<100)) {year=year+2000;}
                else     if (year==0) {return null;}
                else     if (year==-1) {Calendar signal = new GregorianCalendar(1,1,1); signal.set(Calendar.ERA, GregorianCalendar.BC); return signal;}
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
                if (month==2&&day>29) {throw new NumberFormatException();} break; }
            catch (NumberFormatException n) {
                System.out.println("Неверно задан формат числа");
            }
        }
        Calendar c = new GregorianCalendar(year, month-1, day);
        return c;}

    public static int getCountOfDays (Calendar c2) {
        Calendar с1 = new GregorianCalendar();
        Long c3 = c2.getTimeInMillis()-с1.getTimeInMillis();
        long diff = TimeUnit.DAYS.convert(c3, TimeUnit.MILLISECONDS);
        return (int)diff;
    }

    public static int getCountOfDays (Task task) {
        Calendar с1 = new GregorianCalendar();
        Long c3 = task.getDeadline().getTimeInMillis()-с1.getTimeInMillis();
        long diff = TimeUnit.DAYS.convert(c3, TimeUnit.MILLISECONDS);
        return (int)diff+1;
    }

    public static void createTask() {
        for (; ; ) {
            String name = createName();
            if (name.equals("0")) {
                return;
            }
            Task newtask = createTasktype(name);
                if (newtask == null) {
                    return;
                }
            String description = createDescription();
            if (description.equals("0")) {return;
            }
            newtask.setDescrirtion(description);
            Task.Periodicity periodicity = createPeriodicity();
            if (periodicity == null) {return;}
            newtask.setPeriodicity(periodicity);
            Calendar c = new GregorianCalendar();
            newtask.setDateOfCreation(c);
           newtask.setDeadline(createDeadline(newtask));
            if (newtask instanceof WorkTask) { counter++; int id = counter; newtask.setID(id); workTaskMap.put(id, (WorkTask) newtask); System.out.println("Создана задача: \n" +newtask); return;}
            else if (newtask instanceof PrivateTask) { counter++; int id = counter; newtask.setID(id); privateTaskMap.put(id, (PrivateTask) newtask); System.out.println("Создана задача: \n" +newtask+"\nключ доступа: "+((PrivateTask) newtask).getKey()+". Не забудьте его!"); return;}
            else {
                System.out.println("Не удалось создать задачу");
            }
        }
    }

    public static boolean prove (Task task) {
        if (task instanceof PrivateTask) {
            for (;;){
            System.out.println("0 - назад");
            int key = PrivateTask.choseKey();
            if (((PrivateTask) task).getKey() == key) {
                 return true;
            }
            if (key==0) {return false;}
            }
        }
        return true;
    }

    public static int ID () {
        int ID = 0;
        for (;;) {
            System.out.println("Введите ID задачи:");
            Scanner in = new Scanner(System.in);
            try {
                ID = in.nextInt();
                break;
            } catch (NumberFormatException n) {
                System.out.println("Некорректно введен ID");
            }
        }
        return ID;
    }

    public static int getCounter() {
        return counter;
    }

    public static void deleteTask () {
        Task task = Search.Searching(Service.ID());
        Task.Status status = Task.Status.FINISHED;
        if (task!=null) {
            if (Service.prove(task)) {
            System.out.println("Выбрана задача:\n"+task);
            for (;;){
                System.out.println("Вы уверены, что хотите завершить задачу?\n0 - нет\n1 - да");
                try {int chose = new Scanner(System.in).nextInt();
                if (chose!=0&&chose!=1) {throw new NumberFormatException();}
                if (chose==0) {return;} if (chose==1) {break;}
                } catch (NumberFormatException ignored) {}
            }} else {return;}
            for (;;){
                System.out.println("Причина завершения задачи?\n0 - отмена\n1 - сделана\n2 - больше нет необходимости");
                try {int chose = new Scanner(System.in).nextInt();
                    if (chose!=0&&chose!=1&&chose!=2) {throw new NumberFormatException();}
                    if (chose==0) {return;} if (chose==1) {break;} if (chose==2) {status = Task.Status.NOACTUALLY; break;}
                } catch (NumberFormatException ignored) {}
            }

            if (task instanceof WorkTask) {
        Service.workTaskMap.put(task.getID(), null); task.setStatus(status); task.setDeleted(new GregorianCalendar()); Service.MapOfEndedTasks.put(task.getID(), task);
                System.out.println("Задача \n"+task.getName()+", ID - "+task.getID()+"\nзавершена");
                SimpleDateFormat df = new SimpleDateFormat("dd.MM.yyyy" );
                System.out.println("Дата завершения - "+df.format(Service.MapOfEndedTasks.get(task.getID()).getDeleted().getTime()));
                System.out.println("Статус - "+Service.MapOfEndedTasks.get(task.getID()).getStatus().toString());}
            if (task instanceof PrivateTask) {
                Service.privateTaskMap.put(task.getID(), null); task.setStatus(status); task.setDeleted(new GregorianCalendar()); Service.MapOfEndedTasks.put(task.getID(), task);
                System.out.println("Задача \n"+task.getName()+", ID - "+task.getID()+"\nзавершена");
                SimpleDateFormat df = new SimpleDateFormat("dd.MM.yyyy" );
                System.out.println("Дата завершения - "+df.format(Service.MapOfEndedTasks.get(task.getID()).getDeleted().getTime()));
                System.out.println("Статус - "+Service.MapOfEndedTasks.get(task.getID()).getStatus().toString());
            }
        }
        else {
            System.out.println("Задача не найдена");
        }
    }

    public static void trying() {
        Calendar c1 = new GregorianCalendar(2023,3,11);
        Calendar c2 = new GregorianCalendar(2024,4,15);
        Calendar c3 = new GregorianCalendar(2023,3,19);
        Calendar c4 = new GregorianCalendar(2023,5,22);
        Calendar c5 = new GregorianCalendar(2024,8,29);
        Calendar c6 = new GregorianCalendar(2024,1,28);
        PrivateTask privateTask1 = new PrivateTask("Сходить к соседке", "", Task.Periodicity.ONETIME, null, 123, 1);
        PrivateTask privateTask2 = new PrivateTask("Заплатить налоги", "", Task.Periodicity.EVERYYEAR, c2, 1234, 2);
        PrivateTask privateTask3 = new PrivateTask("Приготовить ланч", "", Task.Periodicity.EVERYDAY, c3, 12345, 3);
        WorkTask workTask1 = new WorkTask("Починить мотор", "", Task.Periodicity.ONETIME, c4, 4);
        WorkTask workTask2 = new WorkTask("Посетить курс повышения квалификации", "", Task.Periodicity.EVERYWEEK, c5, 5);
        WorkTask workTask3 = new WorkTask("Сдать месячный отчет", "", Task.Periodicity.EVERYMONTH, c6, 6);
        Service.privateTaskMap.put(privateTask1.getID(), privateTask1 );
        Service.privateTaskMap.put(privateTask2.getID(), privateTask2 );
        Service.privateTaskMap.put(privateTask3.getID(), privateTask3 );
        Service.workTaskMap.put(workTask1.getID(), workTask1);
        Service.workTaskMap.put(workTask2.getID(), workTask2);
        Service.workTaskMap.put(workTask3.getID(), workTask3);
        counter = 6;
    }
}