package AstronautDailyScheduleOrganizer;

import java.util.Date;
import java.util.Scanner;

public class Run {
    public void run() {

        boolean loop=true;
        Scanner sc = new Scanner(System.in);
        Actions actions = new Actions();



        while (loop){

            System.out.println("1. AddTask\n2. RemoveTask\n3. ViewTasks\n4. Exit");
            System.out.println("Enter your choice: ");
            int choice =sc.nextInt();

            switch (choice){

                case 1 ->{
                    System.out.println("Enter description of the task: ");
                    String description = sc.next();
                    System.out.println("StartTime-(HH:MM): ");
                    String starttime = sc.next();
                    System.out.println("EndTime-(HH:MM): ");
                    String endtime = sc.next();
                    System.out.println("Enter priorityLevel of your task: ");
                    String prioritylevel = sc.next();

                    Date StartTime=Actions.ConvertStringToDate(starttime);
                    Date EndTime = Actions.ConvertStringToDate(endtime);

                    if(StartTime==null || EndTime==null){
                        System.out.println("Invalid Time Format !!!");
                        return;
                    }
                    int indicator=0;
                    String PriorityLevel = prioritylevel.toUpperCase();
                    indicator = switch (PriorityLevel) {
                        case "HIGH" -> 3;
                        case "MEDIUM" -> 2;
                        case "LOW" -> 1;
                        default -> indicator;
                    };

                    if(indicator==0){
                        System.out.println("Put a Valid priorityLevel!!!");
                        return;
                    }
                    Task task = new Task(description, StartTime, EndTime, PriorityLevel, indicator);
                    actions.AddTask(task);

                }
                case 2 ->{
                    System.out.println("Enter the task to remove: ");
                    String description = sc.next();
                    actions.RemoveTask(description);

                }
                case 3 ->{
                    actions.ViewTasks();
                }
                case 4 ->{
                    loop=false;
                }

            }

        }
    }
}
