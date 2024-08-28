package strategies.validator;

import exception.DuplicateSymbolFoundException;
import model.Game;
import model.Player;

import java.util.stream.Collectors;

public class UniqueSymbolValidator implements GameParamValidator{
    @Override
    public void validate(Game.GameBuilder builder) throws Exception {
        boolean allAreUniqueSymbol = builder.getPlayers()
                .stream()
                .map(Player::getSymbol)
                .collect(Collectors.toSet())
                .size() == builder.getPlayers().size();

        if(!allAreUniqueSymbol){
            throw new DuplicateSymbolFoundException("There are players with same symbols.");
        }
    }
}
