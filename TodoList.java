import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Date;
import java.time.LocalTime;

class Task {
    String name;
    private Date scheduledTime;

    public Task(String name, Date scheduledTime) {
        this.name = name;
        this.scheduledTime = scheduledTime;
    }

    public String getname() {
        return name;
    }

    public Date getScheduledTime() {
        return scheduledTime;
    }

    public String toString() {
        return "Task:" + name + "|Scheduled Time:" + scheduledTime;
    }

}

public class TodoList {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Task> tasks = new ArrayList<>();

        System.out.println("Enter the number of tasks you want to add:");
        int n = scanner.nextInt();
        scanner.nextLine();

        for (int i = 0; i < n; i++) {
            // String task = scanner.nextLine();
            System.out.println("Enter the tasks:");
            String task = scanner.nextLine();
            System.out.print("Enter the Scheduled hour:");
            int hour = scanner.nextInt();
            if (hour < 0 || hour > 23) {
                System.out.println("Please enter a valid hour (0-23).");
                i--;
                scanner.nextLine();
                continue;
            }
            System.out.print("Enter the Scheduled Minute:");
            int minute = scanner.nextInt();
            if (minute < 0 || minute > 59) {
                System.out.println("Please enter a valid minute (0-59).");
                i--;
                scanner.nextLine();
                continue;
            }

            tasks.add(new Task(task, CreateTime(hour, minute)));

        }
        for (int i = 0; i < tasks.size(); i++) {
            System.out.println(tasks.get(i));
        }
        scanner.close();
    }

    @SuppressWarnings("deprecation")
    public static Date CreateTime(int hour, int minute) {
        Date now = new Date();
        now.setHours(hour);
        now.setMinutes(minute);
        now.setSeconds(0);
        return now;
    }

}
