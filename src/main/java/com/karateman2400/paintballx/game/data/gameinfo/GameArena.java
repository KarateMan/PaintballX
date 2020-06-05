package com.karateman2400.paintballx.game.data.gameinfo;

import org.bukkit.Location;

import java.util.UUID;

public class GameArena {

    private UUID arenaId;
    private String arenaName;

    private GameLocation lobbySpawn;
    private GameLocation endSpawn;
    private GameLocation teamOneSpawn;
    private GameLocation teamTwoSpawn;

    private int maxPlayers;
    private int minPlayers;

    public GameArena(String arenaName, Location lobbySpawn, Location endSpawn, Location teamOneSpawn, Location teamTwoSpawn, int maxPlayers, int minPlayers) {
        this.arenaId = UUID.randomUUID();
        this.arenaName = arenaName;
        this.lobbySpawn = new GameLocation(lobbySpawn);
        this.endSpawn = new GameLocation(endSpawn);
        this.teamOneSpawn = new GameLocation(teamOneSpawn);
        this.teamTwoSpawn = new GameLocation(teamTwoSpawn);
        this.maxPlayers = maxPlayers;
        this.minPlayers = minPlayers;
    }

    public GameArena(UUID arenaUUID, String arenaName, Location lobbySpawn, Location endSpawn, Location teamOneSpawn, Location teamTwoSpawn, int maxPlayers, int minPlayers) {
        this.arenaId = arenaUUID;
        this.arenaName = arenaName;
        this.lobbySpawn = new GameLocation(lobbySpawn);
        this.endSpawn = new GameLocation(endSpawn);
        this.teamOneSpawn = new GameLocation(teamOneSpawn);
        this.teamTwoSpawn = new GameLocation(teamTwoSpawn);
        this.maxPlayers = maxPlayers;
        this.minPlayers = minPlayers;
    }

    public UUID getArenaId() {
        return arenaId;
    }

    public String getArenaName() {
        return arenaName;
    }

    public GameLocation getLobbySpawn() {
        return lobbySpawn;
    }

    public GameLocation getEndSpawn() {
        return endSpawn;
    }

    public GameLocation getTeamOneSpawn() {
        return teamOneSpawn;
    }

    public GameLocation getTeamTwoSpawn() {
        return teamTwoSpawn;
    }

    public int getMaxPlayers() {
        return maxPlayers;
    }

    public int getMinPlayers() {
        return minPlayers;
    }

}

class GameLocation {

    private String world;
    private double x;
    private double y;
    private double z;
    private float yaw;
    private float pitch;

    public GameLocation(Location location) {
        this.x = location.getX();
        this.y = location.getY();
        this.z = location.getZ();
        this.yaw = location.getYaw();
        this.pitch = location.getPitch();
    }

}
