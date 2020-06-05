package dev.josegraciano.workingsl.core;

import java.util.Timer;
import java.util.TimerTask;

public class TimerSL extends Timer {
    private boolean hasStarted = false;

    public boolean hasRunStarted() {
        System.out.println(hasStarted);
        return this.hasStarted;
    }

    @Override
    public void schedule(TimerTask task, long delay, long period) {
        this.hasStarted = true;
        super.schedule(task, delay, period);
    }

    @Override
    public void cancel() {
        this.hasStarted = false;
        super.cancel();
    }
}