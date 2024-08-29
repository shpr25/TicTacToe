package strategies.winning;

import model.Board;
import model.Move;

import java.util.HashMap;
import java.util.Map;

public class RowWiseWinningStrategy implements WinningStrategy {
    Map<Integer, Map<Character, Integer>> rowCountMap;

    public RowWiseWinningStrategy(){
        this.rowCountMap = new HashMap<>();
    }

    @Override
    public boolean checkWinner(Board board, Move move) {
        int row = move.getCell().getRowIndex();
        Character symbol = move.getPlayer().getSymbol();

        rowCountMap.putIfAbsent(row, new HashMap<>());
        Map<Character, Integer> countMap = rowCountMap.get(row);

        countMap.putIfAbsent(symbol, 0);
        countMap.put(symbol, countMap.get(symbol)+1);

        return countMap.get(symbol) == board.getSize();

    }
}
