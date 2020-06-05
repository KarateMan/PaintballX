package com.karateman2400.paintballx.game.data.gameinfo;

import com.karateman2400.paintballx.PaintballX;
import com.karateman2400.paintballx.game.GameObject;
import com.karateman2400.paintballx.game.data.board.LobbyBoard;
import com.karateman2400.paintballx.game.data.events.ScoreboardUpdateEvent;
import org.bukkit.scheduler.BukkitRunnable;

public class GameTimer {

    public final int LONG_START = 180;
    public final int SHORT_START = 180;

    private BukkitRunnable currentTimer = null;

    private int timeToStart = 0;

    public void beginLongLobbyTimer(GameObject gameObject) {
        cancelTimer();
        timeToStart = LONG_START;

        new BukkitRunnable() {
            @Override
            public void run() {
                if(timeToStart != 0) --timeToStart;
                LobbyBoard board = new LobbyBoard(gameObject.getGameArena());
                PaintballX.getInstance().getServer().getPluginManager().callEvent(new ScoreboardUpdateEvent(board, gameObject));
            }
        }.runTaskTimer(PaintballX.getInstance(), 0, 20);
    }

    public void beginShortLobbyTimer(GameObject gameObject) {
        cancelTimer();
        timeToStart = SHORT_START;

        new BukkitRunnable() {
            @Override
            public void run() {
                if(timeToStart != 0) --timeToStart;
                // TODO: Send Scoreboard Update
            }
        }.runTaskTimer(PaintballX.getInstance(), 0, 20);
    }

    public void beginGameTimer(GameObject gameObject) {

    }

    public void cancelTimer() {
        if(currentTimer != null) currentTimer.cancel();
    }

    public int getTimeToStart() {
        return timeToStart;
    }

}
