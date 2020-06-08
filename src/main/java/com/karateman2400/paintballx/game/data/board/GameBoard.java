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

package com.karateman2400.paintballx.game.data.board;

import com.karateman2400.paintballx.game.GameObject;
import com.karateman2400.paintballx.game.data.gameinfo.GameArena;

public abstract class GameBoard {

    protected GameArena arena;

    public GameBoard(GameArena arena) {
        this.arena = arena;
    }

    public abstract void updateBoard(GameObject gameObject, int time);

}
