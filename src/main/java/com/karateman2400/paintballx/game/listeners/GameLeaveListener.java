package com.karateman2400.paintballx.game.listeners;

import com.karateman2400.paintballx.game.GameObject;
import com.karateman2400.paintballx.game.data.events.GameLeaveEvent;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;

public class GameLeaveListener implements Listener {

    private GameObject gameObject;

    public GameLeaveListener(GameObject gameObject) {
        this.gameObject = gameObject;
    }

    @EventHandler
    public void onGameLeave(GameLeaveEvent event) {

        if(!event.getGameObject().equals(gameObject)) return;

        // TODO: Handle GameJoin logic
    }
}
