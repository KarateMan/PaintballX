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

package com.karateman2400.paintballx.game.data.gameinfo;

import org.bukkit.Bukkit;
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
