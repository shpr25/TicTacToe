package factory;

import model.BotDifficultyLevel;
import strategies.botplaying.BotPlayingStrategy;
import strategies.botplaying.EasyBotPlayingStrategy;
import strategies.botplaying.HardBotPlayingStrategy;
import strategies.botplaying.MediumBotPlayingStrategy;

public class BotPlayingStrategyFactory {

    public static BotPlayingStrategy getPlayingStrategy(BotDifficultyLevel botDifficultyLevel) {
        if(botDifficultyLevel.equals(BotDifficultyLevel.EASY)){
            return new EasyBotPlayingStrategy();
        }
        else if(botDifficultyLevel.equals(BotDifficultyLevel.MEDIUM)){
            return new MediumBotPlayingStrategy();
        }
        return new HardBotPlayingStrategy();
    }
}
