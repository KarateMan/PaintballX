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

package com.karateman2400.paintballx.game.listeners;

import com.karateman2400.paintballx.PaintballX;
import com.karateman2400.paintballx.game.GameObject;
import com.karateman2400.paintballx.game.data.board.LobbyBoard;
import com.karateman2400.paintballx.game.data.events.GameJoinEvent;
import com.karateman2400.paintballx.game.data.events.ScoreboardUpdateEvent;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;

public class GameJoinListener implements Listener {

    private GameObject gameObject;

    public GameJoinListener(GameObject gameObject) {
        this.gameObject = gameObject;
    }

    @EventHandler
    public void onGameJoin(GameJoinEvent event) {
        if(event.isCancelled()) return;

        if(!event.getGameObject().equals(gameObject)) {
            event.setCancelled(true);
            return;
        }

        gameObject.addPlayer(event.getGamePlayer());
        PaintballX.getInstance().getServer().getPluginManager().callEvent(new ScoreboardUpdateEvent(new LobbyBoard(gameObject.getGameArena()), gameObject));
        event.getGamePlayer().getPlayer().teleport(gameObject.getGameArena().getLobbySpawn().toLocation());
    }
}
