package com.karateman2400.paintballx.game;

import com.karateman2400.paintballx.PaintballX;
import com.karateman2400.paintballx.game.data.Arena;
import com.karateman2400.paintballx.game.data.GameState;
import com.karateman2400.paintballx.game.utils.ScoreboardUtil;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

import java.util.ArrayList;
import java.util.List;

public class GameObject {

    private final int LONG_TIMER = 180;
    private final int SHORT_TIMER = 30;

    private List<Player> players = new ArrayList<>();
    private GameState state = GameState.INACTIVE;
    private Arena arena;

    private BukkitRunnable timer;

    public GameObject(Arena arena) {
        this.arena = arena;
    }

    public int currentPlayers() {
        return players.size();
    }

    public void addPlayer(Player player) {
        if(currentPlayers() == 0) state = GameState.WAITING;

        players.add(player);
        if(currentPlayers() >= arena.getMinPlayers()) {
            startTimer();
        }
        player.teleport(arena.getLobbySpawn());
        players.stream().forEach((p) -> p.sendMessage(ChatColor.translateAlternateColorCodes('&',
                "&e" + player.getName() + " Has joined the game. [" + currentPlayers() + "/" + arena.getMaxPlayers() + "]")));

        new ScoreboardUtil().updateLobbyScoreboard(currentPlayers(), arena.getMinPlayers(), arena.getMaxPlayers(), arena.getName(), SHORT_TIMER, LONG_TIMER, players);
    }

    public void removePlayer(Player player) {
        if(currentPlayers() == 1) state = GameState.INACTIVE;

        players.remove(player);
        if(currentPlayers() < arena.getMinPlayers()) {
            stopTimer();
        }
        player.teleport(arena.getEndSpawn());
        players.stream().forEach((p) -> p.sendMessage(ChatColor.translateAlternateColorCodes('&',
                "&e" + player.getName() + " Has left the game. [" + currentPlayers() + "/" + arena.getMaxPlayers() + "]")));

        new ScoreboardUtil().updateLobbyScoreboard(currentPlayers(), arena.getMinPlayers(), arena.getMaxPlayers(), arena.getName(), SHORT_TIMER, LONG_TIMER, players);
    }

    public void startTimer() {
        final int[] time = new int[1];
        time[0] = LONG_TIMER;

        timer = new BukkitRunnable() {

            @Override
            public void run() {
                if(time[0] == 0) {
                    //TODO: Run game start functions
                    this.cancel();
                }

                if(currentPlayers() == arena.getMaxPlayers() && time[0] > SHORT_TIMER) time[0] = SHORT_TIMER;

                new ScoreboardUtil().updateLobbyScoreboard(currentPlayers(), arena.getMinPlayers(), arena.getMaxPlayers(), arena.getName(), SHORT_TIMER, LONG_TIMER, players);
                time[0]--;
            }

        };

        timer.runTaskTimer(PaintballX.getInstance(), 0, 20);
    }

    public void stopTimer() {
        timer.cancel();
    }

    public void reset() {
        state = GameState.INACTIVE;
        players.clear();
    }

}
