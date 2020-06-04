package com.karateman2400.paintballx.game.data.board;

import com.karateman2400.paintballx.game.GameObject;
import com.karateman2400.paintballx.game.data.gameinfo.GameArena;

public abstract class GameBoard {

    protected GameArena arena;

    public GameBoard(GameArena arena) {
        this.arena = arena;
    }

    public GameArena getArena() {
        return arena;
    }

    public abstract void updateBoard(GameObject gameObject);

}
