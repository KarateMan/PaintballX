package com.karateman2400.paintballx;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.karateman2400.paintballx.game.GameObject;
import com.karateman2400.paintballx.game.data.Arena;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.logging.Level;

public class PaintballX extends JavaPlugin implements Listener {

    private static PaintballX instance;

    @Override
    public void onEnable() {
        getServer().getPluginManager().registerEvents(this, this);
        instance = this;

        Arena a = new Arena("Test");
        a.setMaxPlayers(1);
        a.setMinPlayers(0);
        a.setBlueSpawn(new Location(Bukkit.getWorlds().get(0), 1, 1, 1));
        a.setRedSpawn(new Location(Bukkit.getWorlds().get(0), 1, 1, 1));
        a.setLobbySpawn(new Location(Bukkit.getWorlds().get(0), 1, 1, 1));
        a.setEndSpawn(new Location(Bukkit.getWorlds().get(0), 1, 1, 1));
        getLogger().log(Level.INFO, "tttt");
        testArena(a);
    }

    public static PaintballX getInstance() {
        return instance;
    }

    @EventHandler
    public void join(PlayerJoinEvent e) {

    }

    public void testArena(Arena arena) {
        try {
            File fd = new File(this.getDataFolder(), "arenas.json");
            FileWriter fw = new FileWriter(fd);
            Gson gson = new GsonBuilder().setPrettyPrinting().create();
            gson.toJson(arena, fw);
            fw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
