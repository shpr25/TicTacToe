package controller;

import model.Game;
import model.GameState;
import model.Player;
import model.PlayerType;
import strategies.winning.WinningStrategy;

import java.util.List;

public class GameController {
    public Game startGame(int dimension, List<Player> players, List<WinningStrategy> winningStrategies) throws Exception {
        return Game.builder()
                .setDimension(dimension)
                .setPlayers(players)
                .setWinningStrategies(winningStrategies)
                .build();
    }

    public void display(Game game) {
        game.displayBoard();
    }

    public boolean checkState(Game game, GameState gameState) {
        return game.getState().equals(gameState);
    }

    public void makeMove(Game game) {
        game.makeMove();
    }

    public Player getWinner(Game game) {
        return game.getWinner();
    }

    public void undo(Game game) throws Exception {
        game.undo();
    }

    public boolean checkNextPlayer(Game game, PlayerType playerType) {
        return game.getCurrentPlayer().getPlayerType().equals(playerType);
    }
}
