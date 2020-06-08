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

package com.karateman2400.paintballx.game.data.board;

import com.karateman2400.paintballx.game.GameObject;
import com.karateman2400.paintballx.game.data.gameinfo.GameArena;
import com.karateman2400.paintballx.game.data.playerinfo.GamePlayer;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.scoreboard.DisplaySlot;
import org.bukkit.scoreboard.Objective;
import org.bukkit.scoreboard.Scoreboard;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class LobbyBoard extends GameBoard {

    public LobbyBoard(GameArena arena) {
        super(arena);
    }

    @Override
    public void updateBoard(GameObject gameObject, int time) {
        List<GamePlayer> gamePlayerList = gameObject.getGamePlayerList();
        if(gamePlayerList.size() == 0) return;

        Scoreboard scoreboard = Bukkit.getScoreboardManager().getNewScoreboard();
        Objective scores = scoreboard.registerNewObjective("scores", "dummy", ChatColor.translateAlternateColorCodes('&', "&e&lPaintball&c&lX"));
        scores.setDisplaySlot(DisplaySlot.SIDEBAR);
        scores.getScore(ChatColor.translateAlternateColorCodes('&', "&6&lArena")).setScore(8);
        scores.getScore(arena.getArenaName()).setScore(7);
        scores.getScore("").setScore(6);
        scores.getScore(ChatColor.translateAlternateColorCodes('&', "&a&lPlayers")).setScore(5);
        scores.getScore(gamePlayerList.size() + "/" + arena.getMaxPlayers()).setScore(4);
        scores.getScore(" ").setScore(3);
        scores.getScore(ChatColor.translateAlternateColorCodes('&', "&e&lStarting in")).setScore(2);

        if(gamePlayerList.size() > arena.getMinPlayers()) {
            int temp = time;
            long minutes = TimeUnit.SECONDS.toMinutes(time);
            temp -= TimeUnit.MINUTES.toSeconds(minutes);
            scores.getScore(minutes + ":" + (temp >= 10 ? temp : "0" + temp)).setScore(1);
        } else {
            scores.getScore("Waiting for players...").setScore(1);
        }

        gamePlayerList.stream().forEach((gamePlayer) -> {
            gamePlayer.getPlayer().setScoreboard(scoreboard);
        });
    }
}
