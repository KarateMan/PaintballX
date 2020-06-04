package com.karateman2400.paintballx.game.data.events;

import com.karateman2400.paintballx.game.GameObject;
import com.karateman2400.paintballx.game.data.playerinfo.GamePlayer;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;

public class GameLeaveEvent extends Event {

    private static final HandlerList HANDLERS = new HandlerList();

    private GamePlayer gamePlayer;
    private GameObject gameObject;

    public GameLeaveEvent(GameObject gameObject, GamePlayer gamePlayer) {
        this.gamePlayer = gamePlayer;
        this.gameObject = gameObject;
    }

    public GamePlayer getGamePlayer() {
        return gamePlayer;
    }

    public GameObject getGameObject() {
        return gameObject;
    }

    @Override
    public HandlerList getHandlers() {
        return HANDLERS;
    }

    public static HandlerList getHandlerList() {
        return HANDLERS;
    }

}
