package strategies.botplaying;

import model.Board;
import model.Cell;
import model.CellState;

import java.util.List;

public class EasyBotPlayingStrategy implements BotPlayingStrategy {
    //First available space
    @Override
    public Cell makeMove(Board board) {
        for(List<Cell> row: board.getGrid()) {
            for(Cell cell: row){
                if(cell.getState().equals(CellState.EMPTY)){
                    return cell;
                }
            }
        }
        return null;
    }
}
