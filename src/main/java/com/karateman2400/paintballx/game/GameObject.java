package com.karateman2400.paintballx.game;

import com.karateman2400.paintballx.PaintballX;
import com.karateman2400.paintballx.game.data.gameinfo.GameArena;
import com.karateman2400.paintballx.game.data.gameinfo.GameStatus;
import com.karateman2400.paintballx.game.data.playerinfo.GamePlayer;
import com.karateman2400.paintballx.game.listeners.GameJoinListener;
import com.karateman2400.paintballx.game.listeners.GameLeaveListener;
import org.bukkit.event.Listener;

import java.util.ArrayList;
import java.util.List;

public class GameObject implements Listener {

    private GameStatus gameStatus = new GameStatus();
    private List<GamePlayer> gamePlayerList = new ArrayList<>();
    private GameArena gameArena;

    public GameObject(GameArena gameArena) {
        this.gameArena = gameArena;

        PaintballX.getInstance().getServer().getPluginManager().registerEvents(new GameJoinListener(this), PaintballX.getInstance());
        PaintballX.getInstance().getServer().getPluginManager().registerEvents(new GameLeaveListener(this), PaintballX.getInstance());
    }

    public GameStatus getGameStatus() {
        return gameStatus;
    }

    public List<GamePlayer> getGamePlayerList() {
        return gamePlayerList;
    }

    public boolean isJoinable() {
        if(gameStatus.getGameState() == GameStatus.GameState.WAITING) return true;

        if(gameArena.getMaxPlayers() > gamePlayerList.size()) return true;

        return false;
    }

    public void forceEnd() {
        // TODO: Run Force End Processes
    }

}
