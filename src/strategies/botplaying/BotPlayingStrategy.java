package strategies.botplaying;

import model.Board;
import model.Cell;

public interface BotPlayingStrategy {
    public Cell makeMove(Board board);
}
