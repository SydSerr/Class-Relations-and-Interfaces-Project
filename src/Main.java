import javafx.scene.layout.Priority;
import java.util.*;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {


    public static void main(String[] args) {
        //List for different tasks
        ArrayList task = new ArrayList();
        Tasks t1 = new Tasks("Do physics hw",5,4);
        task.add(t1);
        Tasks t2 = new Tasks("Tidy room", 3,2);
        task.add(t2);
        Tasks t3 = new Tasks("Practice instrument",4,3);
        task.add(t3);
        // Print unsorted tasks
        System.out.println("Unsorted:");
        for (int i = 0; i < task.size(); i++) {
            System.out.println(task.get(i));
        }
        // Print sorted tasks
        System.out.println( "\nSorted by Priority (5 being highest priority):");
        Collections.sort(task);
        for (int i = 0; i < task.size(); i++) {
            System.out.println(task.get(i));
        }
    }
}
//Create Tasks class
class Tasks implements priority, Complexity, Comparable<Tasks> {
    String task;
    private int priorityLvl;
    private int complexityLvl;
    //constructors
    public Tasks(String task, int priorityLvl, int complexityLvl) {
        this.task = task;
        this.priorityLvl = priorityLvl;
        this.complexityLvl = complexityLvl;
    }
    public Tasks() {

    }
    //setters and getters for priority and complexity
    public void setPriority(int priority) {
        priorityLvl = priority;
    }
    public int getPriority() {
        return priorityLvl;
    }
    public void setComplexity(int complexity) {
        complexityLvl = complexity;
    }
    public int getComplexity() {
        return complexityLvl;
    }
    //toString to print out tasks with corresponding priority lvl and complexity lvl
    public String toString() {
        return task + ", Priority: " + priorityLvl + ", Complexity: " + complexityLvl;
    }
    //compares tasks
    public int compareTo(Tasks t) {
        int result = 0;

        if (this.priorityLvl > t.getPriority()) {
            result = -1;
        } else if (this.priorityLvl < t.getPriority()) {
            result = 1;
        } else if (this.priorityLvl == t.getPriority()) {
            if (this.complexityLvl < t.getComplexity()) {
                result = -1;
            } else if (this.complexityLvl > t.getComplexity()) {
                result = 1;
            } else {
                result = 0;
            }
        }
        return result;
    }
}
//Complexity interface
interface Complexity {
    public void setComplexity(int complexity);
    public int getComplexity();
}
//priority interface
interface priority {
    public void setPriority(int priority);

    public int getPriority();
}