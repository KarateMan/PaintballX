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
