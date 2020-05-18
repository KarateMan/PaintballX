package com.karateman2400.paintballx;

import com.karateman2400.paintballx.game.GameObject;
import com.karateman2400.paintballx.game.data.Arena;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.plugin.java.JavaPlugin;

public class PaintballX extends JavaPlugin implements Listener {

    private static PaintballX instance;

    @Override
    public void onEnable() {
        getServer().getPluginManager().registerEvents(this, this);
        instance = this;
    }

    public static PaintballX getInstance() {
        return instance;
    }

    @EventHandler
    public void join(PlayerJoinEvent e) {
        Arena a = new Arena();
        a.setMaxPlayers(1);
        a.setMinPlayers(0);
        a.setName("Test Name");
        GameObject o = new GameObject(a);
        o.addPlayer(e.getPlayer());
    }

}
