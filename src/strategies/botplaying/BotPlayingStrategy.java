package strategies.botplaying;

import model.Cell;
import model.Game;

public interface BotPlayingStrategy {
    public Cell makeMove(Game game);
}
