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

package com.karateman2400.paintballx.game.data.events;

import com.karateman2400.paintballx.game.GameObject;
import com.karateman2400.paintballx.game.data.board.GameBoard;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;

public class ScoreboardUpdateEvent extends Event {

    private static final HandlerList HANDLERS = new HandlerList();

    private GameBoard board;
    private GameObject gameObject;

    public ScoreboardUpdateEvent(GameBoard board, GameObject gameObject) {
        this.board = board;
        this.gameObject = gameObject;
    }

    public GameBoard getGameBoard() {
        return board;
    }

    public GameObject getGameObject() {
        return gameObject;
    }

    @Override
    public HandlerList getHandlers() {
        return HANDLERS;
    }

    public static HandlerList getHandlerList() {
        return HANDLERS;
    }

}
