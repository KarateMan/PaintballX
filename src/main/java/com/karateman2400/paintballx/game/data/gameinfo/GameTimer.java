package com.karateman2400.paintballx.game.data.gameinfo;

import com.karateman2400.paintballx.PaintballX;
import org.bukkit.scheduler.BukkitRunnable;

public class GameTimer {

    public final int LONG_START = 180;
    public final int SHORT_START = 180;

    private BukkitRunnable currentTimer = null;

    private int timeToStart = 0;

    public void beginLongTimer() {
        cancelTimer();
        timeToStart = LONG_START;

        new BukkitRunnable() {
            @Override
            public void run() {
                if(timeToStart != 0) --timeToStart;
                // TODO: Send Scoreboard Update
            }
        }.runTaskTimerAsynchronously(PaintballX.getInstance(), 0, 20);
    }

    public void beginShortTimer() {
        cancelTimer();
        timeToStart = SHORT_START;

        new BukkitRunnable() {
            @Override
            public void run() {
                if(timeToStart != 0) --timeToStart;
                // TODO: Send Scoreboard Update
            }
        }.runTaskTimerAsynchronously(PaintballX.getInstance(), 0, 20);
    }

    public void cancelTimer() {
        if(currentTimer != null) currentTimer.cancel();
    }

    public int getTimeToStart() {
        return timeToStart;
    }

}
