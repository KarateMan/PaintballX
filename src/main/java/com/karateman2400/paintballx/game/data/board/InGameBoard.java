package com.karateman2400.paintballx.game.data.board;

import com.karateman2400.paintballx.game.GameObject;
import com.karateman2400.paintballx.game.data.gameinfo.GameArena;
import com.karateman2400.paintballx.game.data.playerinfo.GamePlayer;

import java.util.List;

public class InGameBoard extends GameBoard {

    public InGameBoard(GameArena arena) {
        super(arena);
    }

    @Override
    public void updateBoard(GameObject gameObject, int time) {
        List<GamePlayer> gamePlayerList = gameObject.getGamePlayerList();
        // TODO: Send Board to PlayerList
    }

}
