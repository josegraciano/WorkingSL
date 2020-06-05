package dev.josegraciano.workingsl;

import dev.josegraciano.workingsl.core.CoreSL;
import dev.josegraciano.workingsl.core.TimerSL;
import dev.josegraciano.workingsl.view.ViewSL;

import java.util.Timer;

public class WorkingSL {
    private static TimerSL time;

    public static void main(String[] args) {
        new Thread(ViewSL.threadView).start();
    }

    public static void StartTask(int delay) {
        time = new TimerSL();
        time.schedule(new CoreSL.ClockTask(), 0, delay);
    }

    public static void StopTask() {
        if(time != null) {
            if(time.hasRunStarted())
                time.cancel();
        }
    }
}
