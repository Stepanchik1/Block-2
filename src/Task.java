import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public abstract class Task {
    boolean isPersonal;
    private String name;
    private String descrirtion;
private Periodicity periodicity;
    private Calendar dateOfCreation;

    private Calendar deadline;
    protected int ID;

    private Status status;

    private Calendar deleted;

    enum Periodicity {ONETIME("разовая"), EVERYDAY("ежедневная"), EVERYWEEK("еженедельная"), EVERYMONTH("ежемесячная"), EVERYYEAR("ежегодная");
        String type;
        Periodicity (String type) {
            this.type = type;
        }

        @Override
        public String toString() {
            return type;
        }
    }

    enum Status {FINISHED("выполнена"), NOACTUALLY ("больше не нужна"), ENDTIME ("истекло время выполнения");
    String status;
        Status (String status) {this.status=status;}

        @Override
        public String toString() {
            return status;
        }
    }

    public void setDateOfCreation(Calendar dateOfCreation) {
        this.dateOfCreation = dateOfCreation;
    }

    public Task(String name, Periodicity periodicity) {
        this.name = name;
        this.periodicity = periodicity;
        Date date = new Date();
        Calendar c = new GregorianCalendar();
        this.dateOfCreation = c;
        this.deadline = c;
    }

    public Task(String name, String descrirtion, Periodicity periodicity, Calendar deadline) {
        this.name = name;
        this.descrirtion = descrirtion;
        this.periodicity = periodicity;
        this.deadline = deadline;
        this.dateOfCreation = new GregorianCalendar();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescrirtion() {
        return descrirtion;
    }

    public void setDescrirtion(String descrirtion) {
        this.descrirtion = descrirtion;
    }

    public Periodicity getPeriodicity() {
        return periodicity;
    }

    public void setPeriodicity(Periodicity periodicity) {
        this.periodicity = periodicity;
    }

    public Calendar getDeadline() {
        return deadline;
    }

    public void setDeadline(Calendar deadline) {
        this.deadline = deadline;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public boolean getPersonality () {
       return isPersonal;
    }

    public Calendar getDateOfCreation() {
        return dateOfCreation;
    }

    public String getDateOfCreationToString() {
        SimpleDateFormat df = new SimpleDateFormat("dd.MM.yyyy" );
        return df.format(dateOfCreation.getTime());
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }
    public String getDeadlineToString () {
        SimpleDateFormat df = new SimpleDateFormat("dd.MM.yyyy" );
        return (df.format(this.deadline.getTime()));
    }

    @Override
    public String toString() {
        SimpleDateFormat df = new SimpleDateFormat("dd.MM.yyyy" );
        if (this.getStatus()!=null) {return this.toStringFirst()+"\nЗавершена, статус - "+this.status+", дата удаления - "+df.format(this.getDeleted().getTime());} else {return toStringFirst();}
    }

    public String toStringFirst () {SimpleDateFormat df = new SimpleDateFormat("dd.MM.yyyy" );
        df.format(dateOfCreation.getTime());
        if (this.periodicity == Periodicity.ONETIME) {
            if (this.deadline!=null) {
                return name + ", тип: "+periodicity +
                        ", дата создания: " + getDateOfCreationToString() +
                        ", сделать до: " + getDeadlineToString() +
                        ", дней до выполнения: " + Service.getCountOfDays(this) +
                        ", ID - " + ID+"\nОписание: "+descrirtion;}
            else {return name + ", тип: "+periodicity +
                    ", дата создания: " + getDateOfCreationToString() +
                    ", бессрочная, ID - " + ID+"\nОписание:\n"+descrirtion;}}
        else  {return name + ", тип: "+periodicity +
                ", дата создания: " + getDateOfCreationToString() +
                ", дата близжайшего выполнения: " + getDeadlineToString() +
                ", дней до выполнения: " + Service.getCountOfDays(this) +
                ", ID - " + ID+"\nОписание:\n"+descrirtion;
        }}
    public Calendar getDeleted() {
        return deleted;
    }

    public void setDeleted(Calendar deleted) {
        this.deleted = deleted;
    }
}
