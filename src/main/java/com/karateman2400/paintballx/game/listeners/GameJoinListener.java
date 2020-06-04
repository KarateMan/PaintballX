package com.karateman2400.paintballx.game.listeners;

import com.karateman2400.paintballx.game.GameObject;
import com.karateman2400.paintballx.game.data.events.GameJoinEvent;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;

public class GameJoinListener implements Listener {

    private GameObject gameObject;

    public GameJoinListener(GameObject gameObject) {
        this.gameObject = gameObject;
    }

    @EventHandler
    public void onGameJoin(GameJoinEvent event) {
        if(event.isCancelled()) return;

        if(!event.getGameObject().equals(gameObject)) {
            event.setCancelled(true);
            return;
        }

        // TODO: Handle GameJoin logic
    }
}
