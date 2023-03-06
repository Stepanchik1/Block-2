import java.util.Calendar;

public class WorkTask extends Task{
    public WorkTask(String name, Periodicity periodicity ) {
        super(name, periodicity);
    }

    public WorkTask(String name, String descrirtion, Periodicity periodicity, Calendar deadline, int ID) {
        super(name, descrirtion, periodicity, deadline);
        this.setID(ID);
    }
}
