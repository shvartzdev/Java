package isis;

import java.util.ArrayList;

public class Processing {

    public static void CreateProcesses() {
        ArrayList<Process> processes = creation();

        printProcessList(processes);
        processing(processes);
        printSteps(processes);
        counting(processes);
    }

    public static ArrayList<Process> creation( ) {
        ArrayList<Process> processes = new ArrayList<Process>();
        processes.add(new Process("p0", 0,10,7));
        processes.add(new Process("p1", 2, 9, 1));
        processes.add(new Process("p2", 4, 8, 3));
        processes.add(new Process("p3", 6, 7, 5));
        processes.add(new Process("p4", 8, 6, 9));
        processes.add(new Process("p5", 8, 5, 10));
        processes.add(new Process("p6", 6, 4, 8));
        processes.add(new Process("p7", 4, 3, 6));
        processes.add(new Process("p8", 2, 2, 4));
        processes.add(new Process("p9", 0, 1, 2));

        return processes;
    }

    public static void printProcessList(ArrayList<Process> processes) {
        System.out.println("name" + " " + "time" + " " + "priority" + " " + "duration");
        for (Process process: processes
             ) {
            System.out.println(process);
        }
    }

    public static void processing(ArrayList<Process> processes) {
        int step = 1;
        do {
            Process priorityProcess = new Process("p",0, Integer.MAX_VALUE, Integer.MAX_VALUE);
            for (Process process: processes) {
                if (process.getDuration() > 0 &&
                        process.getTime() <= step &&
                        process.getPriority() <= priorityProcess.getPriority()) {

                    priorityProcess = process;
                    if (process.getDuration() < priorityProcess.getDuration())
                        priorityProcess = process;
                }
            }

            for (Process process: processes) {
                if (process.getTime() <= step &&
                    process.getDuration() > 0) {
                    if (process != priorityProcess)
                        process.addStep("Г");
                    else {
                        process.addStep("И");
                        process.execute();
                    }
                } else process.addStep("-");
            }
            step++;
        } while (step <= 100);
    }

    public static void printSteps(ArrayList<Process> processes) {
        for (Process process:processes) {
            System.out.print(process.getName());
            System.out.print(process.getSteps());
            System.out.println();
        }
    }

    public static void counting(ArrayList<Process> processes) {
        double averageWaitingTime = 0;
        double averageExecutingTime = 0;

        for (Process proc : processes) {
            averageWaitingTime += proc.waitingTime();
            averageExecutingTime += proc.executingTime();
        }

        System.out.println("Среднее время ожидания = " + averageWaitingTime / processes.size());
        System.out.println("Среднее время выполнения = " + averageExecutingTime / processes.size());

    }
}
