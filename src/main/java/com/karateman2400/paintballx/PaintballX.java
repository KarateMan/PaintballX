package com.karateman2400.paintballx;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.karateman2400.paintballx.game.GameObject;
import com.karateman2400.paintballx.game.data.Arena;
import com.karateman2400.paintballx.game.data.GameLocation;
import com.karateman2400.paintballx.game.data.TestArena;
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

        TestArena a = new TestArena("Test");
        a.setBlueSpawn(new GameLocation());
        a.setRedSpawn(new GameLocation());
        a.setLobbySpawn(new GameLocation());
        a.setEndSpawn(new GameLocation());
        a.setMaxPlayers(1);
        a.setMinPlayers(0);
        getLogger().log(Level.INFO, "tttt");
        testArena(a);
    }

    public static PaintballX getInstance() {
        return instance;
    }

    @EventHandler
    public void join(PlayerJoinEvent e) {

    }

    public void testArena(TestArena arena) {
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
