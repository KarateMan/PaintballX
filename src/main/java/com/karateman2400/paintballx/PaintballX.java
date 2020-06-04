package com.karateman2400.paintballx;

import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;

public class PaintballX extends JavaPlugin implements Listener {

    private static PaintballX instance;

    @Override
    public void onEnable() {
        instance = this;

    }

    public static PaintballX getInstance() {
        return instance;
    }

}
