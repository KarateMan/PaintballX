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

package com.karateman2400.paintballx.game.utils;

import com.karateman2400.paintballx.PaintballX;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.scoreboard.DisplaySlot;
import org.bukkit.scoreboard.Objective;
import org.bukkit.scoreboard.Scoreboard;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class ScoreboardUtil {

    private BukkitRunnable lobbyTimer;

    public void updateLobbyScoreboard(int currentPlayers, int minPlayers, int maxPlayers, String arenaName, int shortTimer, int longTimer, List<Player> players) {
        if(currentPlayers == 0) return;
        if(currentPlayers < minPlayers) {
            Scoreboard scoreboard = Bukkit.getScoreboardManager().getNewScoreboard();
            Objective scores = scoreboard.registerNewObjective("scores", "dummy", ChatColor.translateAlternateColorCodes('&', "&e&lPaintball&c&lX"));
            scores.setDisplaySlot(DisplaySlot.SIDEBAR);
            scores.getScore(ChatColor.translateAlternateColorCodes('&', "&6&lArena")).setScore(10);
            scores.getScore(arenaName).setScore(9);
            scores.getScore("").setScore(8);
            scores.getScore(ChatColor.translateAlternateColorCodes('&', "&a&lPlayers")).setScore(7);
            scores.getScore(currentPlayers + "/" + maxPlayers).setScore(6);
            scores.getScore(" ").setScore(5);
            scores.getScore(ChatColor.translateAlternateColorCodes('&', "&e&lStarting in")).setScore(4);
            scores.getScore("Waiting for players...").setScore(3);
            for(Player player : players) player.setScoreboard(scoreboard);
        } else {
            lobbyTimer = new BukkitRunnable() {
                int timer = currentPlayers == maxPlayers ? longTimer : shortTimer;
                @Override
                public void run() {
                    int temp = timer;
                    long minutes = TimeUnit.SECONDS
                            .toMinutes(timer);
                    temp -= TimeUnit.MINUTES.toSeconds(minutes);
                    Scoreboard scoreboard = Bukkit.getScoreboardManager().getNewScoreboard();
                    Objective scores = scoreboard.registerNewObjective("scores", "dummy", ChatColor.translateAlternateColorCodes('&', "&e&lPaintball&c&lX"));
                    scores.setDisplaySlot(DisplaySlot.SIDEBAR);
                    scores.getScore(ChatColor.translateAlternateColorCodes('&', "&6&lArena")).setScore(10);
                    scores.getScore(arenaName).setScore(9);
                    scores.getScore("").setScore(8);
                    scores.getScore(ChatColor.translateAlternateColorCodes('&', "&a&lPlayers")).setScore(7);
                    scores.getScore(currentPlayers + "/" + maxPlayers).setScore(6);
                    scores.getScore(" ").setScore(5);
                    scores.getScore(ChatColor.translateAlternateColorCodes('&', "&e&lStarting in")).setScore(4);
                    if(timer <= 0) {
                        scores.getScore("Starting...").setScore(3);
                    } else {
                        scores.getScore(minutes + ":" + (temp >= 10 ? temp : "0" + temp)).setScore(3);
                    }
                    timer--;
                    for(Player player : players) player.setScoreboard(scoreboard);
                }
            };
            lobbyTimer.runTaskTimer(PaintballX.getInstance(), 0, 20);
        }
    }

    public void cancelLobbyScoreboard() {
        lobbyTimer.cancel();
    }

    public void updateGameScoreboard() {

    }

    public void cancelGameScoreboard() {

    }
}
