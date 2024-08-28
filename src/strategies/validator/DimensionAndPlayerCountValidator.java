package strategies.validator;

import exception.InvalidPlayerAndDimensionCountException;
import exception.InvalidPlayerCountException;
import model.Game;

public class DimensionAndPlayerCountValidator implements GameParamValidator {
    @Override
    public void validate(Game.GameBuilder builder) throws Exception {
        if(builder.getPlayers().size() < 1){
            throw new InvalidPlayerCountException("Players are not efficient to start the game");
        }
        if(builder.getPlayers().size() >= builder.getDimension()){
            throw new InvalidPlayerAndDimensionCountException("Players are more than the board size");
        }
    }
}
