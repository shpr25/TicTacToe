package model;

import factory.BotPlayingStrategyFactory;
import strategies.botplaying.BotPlayingStrategy;

public class BotPlayer extends Player {
    private BotDifficultyLevel difficultyLevel;
    private BotPlayingStrategy botPlayingStrategy;

    public BotPlayer(String id, String name, Character symbol, BotDifficultyLevel botDifficultyLevel){
        super(id, name, symbol, PlayerType.BOT);
        this.difficultyLevel = botDifficultyLevel;
        this.botPlayingStrategy = BotPlayingStrategyFactory.getPlayingStrategy(botDifficultyLevel);
    }

    @Override
    public Move makeAMove(Board board) {
        System.out.println(this.name + "'s move. Bot player move is calculating.");
        Cell cell = botPlayingStrategy.makeMove(board);
        return new Move(cell, this);
    }
}
