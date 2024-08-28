package strategies.validator;

import exception.NoBotPlayerFoundException;
import model.Game;
import model.PlayerType;

import java.util.stream.Collectors;

public class BotCountValidator implements  GameParamValidator
{
    @Override
    public void validate(Game.GameBuilder builder) throws Exception {
        // There should be at least 1  bot
        boolean isThereAnyBot = builder.getPlayers()
                .stream().anyMatch(player -> player.getPlayerType().equals(PlayerType.BOT));

        if(!isThereAnyBot){
            throw new NoBotPlayerFoundException("No bot player found.");
        }
    }
}
