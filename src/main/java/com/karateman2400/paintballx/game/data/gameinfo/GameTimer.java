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

import com.karateman2400.paintballx.PaintballX;
import com.karateman2400.paintballx.game.GameObject;
import com.karateman2400.paintballx.game.data.board.LobbyBoard;
import com.karateman2400.paintballx.game.data.events.ScoreboardUpdateEvent;
import org.bukkit.scheduler.BukkitRunnable;

public class GameTimer {

    public final int LONG_START = 180;
    public final int SHORT_START = 180;

    private BukkitRunnable currentTimer = null;

    private int timeToStart = 0;

    public void beginLongLobbyTimer(GameObject gameObject) {
        cancelTimer();
        timeToStart = LONG_START;

        new BukkitRunnable() {
            @Override
            public void run() {
                if(timeToStart != 0) --timeToStart;
                LobbyBoard board = new LobbyBoard(gameObject.getGameArena());
                PaintballX.getInstance().getServer().getPluginManager().callEvent(new ScoreboardUpdateEvent(board, gameObject));
            }
        }.runTaskTimer(PaintballX.getInstance(), 0, 20);
    }

    public void beginShortLobbyTimer(GameObject gameObject) {
        cancelTimer();
        timeToStart = SHORT_START;

        new BukkitRunnable() {
            @Override
            public void run() {
                if(timeToStart != 0) --timeToStart;
                // TODO: Send Scoreboard Update
            }
        }.runTaskTimer(PaintballX.getInstance(), 0, 20);
    }

    public void beginGameTimer(GameObject gameObject) {

    }

    public void cancelTimer() {
        if(currentTimer != null) currentTimer.cancel();
    }

    public int getTimeToStart() {
        return timeToStart;
    }

}
