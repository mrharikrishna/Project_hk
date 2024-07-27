package AstronautDailyScheduleOrganizer;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.PriorityQueue;

public class Actions {

    private final PriorityQueue<Task> TaskSchedule = new PriorityQueue<>(
            (a, b) -> {
                int startTimeComparison = a.getStartTime().compareTo(b.getStartTime());
                if (startTimeComparison != 0) {
                    return startTimeComparison;
                }
                return Integer.compare(b.getPriorityIndicator(), a.getPriorityIndicator());
            }
    );


    public void ViewTasks() {
        SimpleDateFormat timeFormat = new SimpleDateFormat("HH:mm");

        if (!TaskSchedule.isEmpty()) {
            for (Task task : TaskSchedule) {
                String startTimeStr = timeFormat.format(task.getStartTime());
                String endTimeStr = timeFormat.format(task.getEndTime());
                System.out.println(startTimeStr + " - " + endTimeStr + ": " + task.getDescription() + " [" + task.getPriorityLevel() + "]");
            }
        } else {
            System.out.println("No tasks scheduled for the day");
        }
    }
    public void AddTask(Task task){
        StringBuilder description = new StringBuilder();

        if(ValidateOverlap(task, description)) {
            TaskSchedule.add(task);
            System.out.println("Task added successfully. No conflicts.");
        }
        else{
            System.out.println("Error: Task conflicts with existing task " +"(" +description +")");
        }
    }

    public void RemoveTask(String description){
        Task TaskToRemove =TaskContain(description);

        if(TaskToRemove!=null){
            TaskSchedule.remove(TaskToRemove);
            System.out.println("Task removed successfully");
        }
        else{
            System.out.println("Error: Task not found");
        }


    }



    public Task TaskContain(String description){
        for(Task t: TaskSchedule){
            if(t.getDescription().equalsIgnoreCase(description)){
                return t;

            }
        }
        return null;
    }



    public boolean ValidateOverlap(Task task, StringBuilder description){
        Date StartTime = task.getStartTime();
        Date EndTime = task.getEndTime();

        for(Task t: TaskSchedule){
            Date st=t.getStartTime();
            Date et=t.getEndTime();

            // Check if the task's start time or end time overlaps with any scheduled task
            if ((StartTime.before(et) && StartTime.after(st)) ||
                (EndTime.before(et) && EndTime.after(st))) {
                description.append(t.getDescription());
                return false;
            }
        }
        return true;

    }



    public static Date ConvertStringToDate(String TimeString) {
        String TimeFormat = "HH:mm";
        SimpleDateFormat formatter = new SimpleDateFormat(TimeFormat);
        formatter.setLenient(false);

        try {
            Date date=formatter.parse(TimeString);
            if (date.getHours() >= 24) {
                return null;
            }
            return date ;
        } catch (ParseException e) {
            return null;
        }
    }
}
