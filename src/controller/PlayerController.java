package controller;

import model.BotDifficultyLevel;
import model.BotPlayer;
import model.HumanPlayer;

public class PlayerController {
    public HumanPlayer createHumanPlayer(String id, String name, char symbol) {
        return new HumanPlayer(id, name, symbol);
    }

    public BotPlayer createBotPlayer(String id, String name, char symbol, BotDifficultyLevel difficultyLevel) {
        return new BotPlayer(id, name, symbol, difficultyLevel);
    }
}
