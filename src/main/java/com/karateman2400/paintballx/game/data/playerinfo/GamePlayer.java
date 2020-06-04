package com.karateman2400.paintballx.game.data.playerinfo;

import org.bukkit.entity.Player;

public class GamePlayer {

    private Player player;

    private int kills = 0;
    private int deaths = 0;
    private int coins = 0;

    public GamePlayer(Player player) {
        this.player = player;
    }
}
