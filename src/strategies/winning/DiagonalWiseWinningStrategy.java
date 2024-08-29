package strategies.winning;

import model.Board;
import model.Move;

import java.util.HashMap;
import java.util.Map;

public class DiagonalWiseWinningStrategy implements WinningStrategy {
    Map<Character, Integer> primaryDiagonalCountMap;
    Map<Character, Integer> secondaryDiagonalCountMap;

    public DiagonalWiseWinningStrategy() {

        this.primaryDiagonalCountMap = new HashMap<>();
        this.secondaryDiagonalCountMap = new HashMap<>();
    }

    @Override
    public boolean checkWinner(Board board, Move move) {
        int row = move.getCell().getRowIndex();
        int col = move.getCell().getColIndex();
        Character symbol = move.getPlayer().getSymbol();

        if (row == col) {
            primaryDiagonalCountMap.put(symbol, primaryDiagonalCountMap.getOrDefault(symbol, 0) + 1);
            if(primaryDiagonalCountMap.get(symbol) == board.getSize()){
                return true;
            }
        }

        if (row + col == board.getSize() - 1) {
            secondaryDiagonalCountMap.put(symbol, secondaryDiagonalCountMap.getOrDefault(symbol, 0) + 1);
            if(secondaryDiagonalCountMap.get(symbol) == board.getSize()){
                return true;
            }
        }

        return false;
    }

}
