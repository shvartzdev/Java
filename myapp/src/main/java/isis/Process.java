package isis;

import lombok.Data;

import java.util.ArrayList;

@Data
public class Process {
    private String name; //название
    private int time; //время появления в очереди
    private int priority; //приоритет
    private int duration; //cpu burst
    public  ArrayList<String> steps = new ArrayList<String>();

    Process(String name, int time, int priority, int duration) {
        this.name = name;
        this.time = time;
        this.priority = priority;
        this.duration = duration;
    }

    @Override
    public String toString() {
        return name + "    " + time + "c        " + priority + "        " + duration;
    }

    public void execute() {
        this.duration--;
    }

    public void addStep(String step) {
        this.steps.add(step);
    }

    public int waitingTime() {
        int result = 0;
        for(int i = 0; i < steps.size(); i++)
            if (steps.get(i) == "Г")
                result++;
            return result;
    }

    public int executingTime() {
        int result = 0;
        for(int i = 0; i < steps.size(); i++)
            if (steps.get(i) == "-")
                result++;
        return result;
    }
}
