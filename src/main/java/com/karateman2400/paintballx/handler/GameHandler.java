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

package com.karateman2400.paintballx.handler;

import com.karateman2400.paintballx.PaintballX;
import com.karateman2400.paintballx.game.GameObject;
import com.karateman2400.paintballx.game.data.gameinfo.GameArena;
import com.karateman2400.paintballx.game.data.playerinfo.GamePlayer;
import com.karateman2400.paintballx.game.data.events.GameJoinEvent;
import org.bukkit.entity.Player;

import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class GameHandler {

    private List<GameObject> gameObjectList = new ArrayList<>();

    public void createNewGame() {
        // TODO: Choose Random Arena
        //gameObjectList.add(new GameObject(new GameArena()));
    }

    public void clearAllGames() {
        gameObjectList.stream().forEach((gameObject) -> {
            gameObject.forceEnd();
        });
        gameObjectList.clear();
    }

    public void addPlayerToFirstGame(Player player) {
        GameObject gameObject = gameObjectList.stream().filter(gameObjectFilter -> gameObjectFilter.isJoinable()).collect(Collectors.toList()).get(0);

        PaintballX.getInstance().getServer().getPluginManager().callEvent(new GameJoinEvent(gameObject, new GamePlayer(player)));
    }

    public void addPlayerToRandomGame(Player player) {
        List<GameObject> gameObjects = gameObjectList.stream().filter(gameObjectFilter -> gameObjectFilter.isJoinable()).collect(Collectors.toList());
        GameObject gameObject = gameObjects.get(new SecureRandom().nextInt(gameObjects.size()));

        PaintballX.getInstance().getServer().getPluginManager().callEvent(new GameJoinEvent(gameObject, new GamePlayer(player)));
    }

    public void addPlayerToGame(Player player, GameObject gameObject) {
        if(!gameObject.isJoinable()) return;

        PaintballX.getInstance().getServer().getPluginManager().callEvent(new GameJoinEvent(gameObject, new GamePlayer(player)));
    }

    public void removeGame(GameObject gameObject) {
        gameObjectList.remove(gameObject);
    }
}
