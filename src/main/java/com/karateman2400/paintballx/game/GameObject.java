/*
 *     PaintballX is designed as a Minecraft minigame plugin using the Spigot API.
 *     Copyright (C) 2020  Justin "KarateMan" Hasbrouck
 *
 *     This program is free software: you can redistribute it and/or modify
 *     it under the terms of the GNU General Public License as published by
 *     the Free Software Foundation, either version 3 of the License, or any later version.
 *
 *     This program is distributed in the hope that it will be useful,
 *     but WITHOUT ANY WARRANTY; without even the implied warranty of
 *     MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *     GNU General Public License for more details.
 *
 *     You should have received a copy of the GNU General Public License
 *     along with this program.  If not, see <https://www.gnu.org/licenses/>.
 */

package com.karateman2400.paintballx.game;

import com.karateman2400.paintballx.PaintballX;
import com.karateman2400.paintballx.game.data.gameinfo.GameArena;
import com.karateman2400.paintballx.game.data.gameinfo.GameStatus;
import com.karateman2400.paintballx.game.data.playerinfo.GamePlayer;
import com.karateman2400.paintballx.game.listeners.GameJoinListener;
import com.karateman2400.paintballx.game.listeners.GameLeaveListener;
import com.karateman2400.paintballx.game.listeners.ScoreboardUpdateListener;
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
        PaintballX.getInstance().getServer().getPluginManager().registerEvents(new ScoreboardUpdateListener(this), PaintballX.getInstance());
    }

    public void addPlayer(GamePlayer player) {
        gamePlayerList.add(player);
    }

    public void removePlayer(GamePlayer player) {
        gamePlayerList.remove(player);
    }

    public boolean isJoinable() {
        if(gameStatus.getGameState() == GameStatus.GameState.WAITING) return true;

        if(gameArena.getMaxPlayers() > gamePlayerList.size()) return true;

        return false;
    }

    public void forceEnd() {
        // TODO: Run Force End Processes
    }

    public GameStatus getGameStatus() {
        return gameStatus;
    }

    public List<GamePlayer> getGamePlayerList() {
        return gamePlayerList;
    }

    public GameArena getGameArena() {
        return gameArena;
    }

}
