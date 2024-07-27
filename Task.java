package AstronautDailyScheduleOrganizer;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.SimpleFormatter;

public class Task {

    private final String Description;
    private final String PriorityLevel;

    private final Date StartTime;
    private final Date EndTime;
    private final int PriorityIndicator;

    Task(String Description, Date StartTime, Date EndTime, String PriorityLevel, int priorityIndicator){
        this.Description=Description;
        this.StartTime=StartTime;
        this.EndTime = EndTime;
        this.PriorityLevel = PriorityLevel;
        this.PriorityIndicator=priorityIndicator;
    }




    public String getDescription(){
        return Description;
    }
    public String getPriorityLevel(){
        return PriorityLevel;
    }
    public Date getStartTime(){
        return StartTime;
    }
    public Date getEndTime(){
        return EndTime;
    }
    public int getPriorityIndicator(){
        return PriorityIndicator;
    }

}
