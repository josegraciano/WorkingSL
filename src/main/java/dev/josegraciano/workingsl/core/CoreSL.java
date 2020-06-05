package dev.josegraciano.workingsl.core;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.util.TimerTask;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;

public class CoreSL {
    private static final Logger LOGGER = Logger.getLogger( CoreSL.class.getName() );

    public static class ClockTask extends TimerTask {
        @Override
        public void run() {
            EventQueue.invokeLater(threadCore);
        }
    }

    private static final Runnable threadCore = new Runnable() {
        public void run() {
            execCore();
        }
    };

    private static void execCore() {
        try {
            Toolkit tk = Toolkit.getDefaultToolkit();
            tk.setLockingKeyState(KeyEvent.VK_SCROLL_LOCK, true);
            TimeUnit.MILLISECONDS.sleep(200);
            tk.setLockingKeyState(KeyEvent.VK_SCROLL_LOCK, false);
        } catch (InterruptedException e) {
            LOGGER.log(Level.SEVERE, e.toString(), e.getStackTrace());
        }
    }
}
