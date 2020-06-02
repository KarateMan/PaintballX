package com.karateman2400.paintballx.game.data;

import org.bukkit.Bukkit;
import org.bukkit.Location;

public class GameLocation {

    private String world;
    private int x;
    private int y;
    private int z;
    private long yaw;
    private long pitch;

    public GameLocation() {
        world = "";
        x = 1;
        y = 2;
        z = 3;
        yaw = 4;
        pitch = 5;
    }

    public String getWorld() {
        return world;
    }

    public void setWorld(String world) {
        this.world = world;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getZ() {
        return z;
    }

    public void setZ(int z) {
        this.z = z;
    }

    public long getYaw() {
        return yaw;
    }

    public void setYaw(long yaw) {
        this.yaw = yaw;
    }

    public long getPitch() {
        return pitch;
    }

    public void setPitch(long pitch) {
        this.pitch = pitch;
    }

    public Location getLocation() {
        return new Location(Bukkit.getWorld(world), x, y, z, yaw, pitch);
    }
}
