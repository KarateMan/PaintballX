package com.karateman2400.paintballx.game.listeners;

import com.karateman2400.paintballx.game.GameObject;
import com.karateman2400.paintballx.game.data.events.ScoreboardUpdateEvent;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;

public class ScoreboardUpdateListener implements Listener {

    private GameObject gameObject;

    public ScoreboardUpdateListener(GameObject gameObject) {
        this.gameObject = gameObject;
    }

    @EventHandler
    public void onScoreboardUpdate(ScoreboardUpdateEvent event) {
        event.getGameBoard().updateBoard(gameObject);
    }
}
