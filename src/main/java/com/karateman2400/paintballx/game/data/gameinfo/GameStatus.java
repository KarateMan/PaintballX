package com.karateman2400.paintballx.game.data.gameinfo;

public class GameStatus {

    private GameState gameState = GameState.INACTIVE;
    private GameTimer gameTimer = new GameTimer();

    public void setGameState(GameState gameState) {
        this.gameState = gameState;
    }

    public GameState getGameState() {
        return gameState;
    }

    public GameTimer getGameTimer() {
        return gameTimer;
    }

    public enum GameState {
        INACTIVE,
        WAITING,
        STARTING,
        ONGOING,
        ENDING
    }

}
