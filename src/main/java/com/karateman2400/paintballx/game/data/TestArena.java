package com.karateman2400.paintballx.game.data;

public class TestArena {

    private String name;

    private GameLocation lobbySpawn;
    private GameLocation redSpawn;
    private GameLocation blueSpawn;
    private GameLocation endSpawn;

    private int maxPlayers;
    private int minPlayers;

    public TestArena() {

    }

    public TestArena(String name) {
        this.name = name;
    }

    public TestArena(String name, int maxPlayers, int minPlayers) {
        this.name = name;
        this.maxPlayers = maxPlayers;
        this.minPlayers = minPlayers;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getMaxPlayers() {
        return maxPlayers;
    }

    public void setMaxPlayers(int maxPlayers) {
        this.maxPlayers = maxPlayers;
    }

    public int getMinPlayers() {
        return minPlayers;
    }

    public void setMinPlayers(int minPlayers) {
        this.minPlayers = minPlayers;
    }

    public GameLocation getLobbySpawn() {
        return lobbySpawn;
    }

    public void setLobbySpawn(GameLocation lobbySpawn) {
        this.lobbySpawn = lobbySpawn;
    }

    public GameLocation getRedSpawn() {
        return redSpawn;
    }

    public void setRedSpawn(GameLocation redSpawn) {
        this.redSpawn = redSpawn;
    }

    public GameLocation getBlueSpawn() {
        return blueSpawn;
    }

    public void setBlueSpawn(GameLocation blueSpawn) {
        this.blueSpawn = blueSpawn;
    }

    public GameLocation getEndSpawn() {
        return endSpawn;
    }

    public void setEndSpawn(GameLocation endSpawn) {
        this.endSpawn = endSpawn;
    }

}
