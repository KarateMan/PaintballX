package com.karateman2400.paintballx.game.data.events;

import com.karateman2400.paintballx.game.GameObject;
import com.karateman2400.paintballx.game.data.board.GameBoard;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;

public class ScoreboardUpdateEvent extends Event {

    private static final HandlerList HANDLERS = new HandlerList();

    private GameBoard board;

    public ScoreboardUpdateEvent(GameBoard board) {
        this.board = board;
    }

    public GameBoard getGameBoard() {
        return board;
    }

    @Override
    public HandlerList getHandlers() {
        return HANDLERS;
    }

    public static HandlerList getHandlerList() {
        return HANDLERS;
    }

}
