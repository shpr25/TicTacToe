package strategies.validator;

import exception.InvalidPlayerAndDimensionCountException;
import exception.InvalidPlayerCountException;
import model.Game;

public interface GameParamValidator {
    public void validate(Game.GameBuilder builder) throws Exception;
}
