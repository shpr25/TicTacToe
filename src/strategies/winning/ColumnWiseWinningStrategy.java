package strategies.winning;

import model.Board;
import model.Move;

import java.util.HashMap;
import java.util.Map;

public class ColumnWiseWinningStrategy implements WinningStrategy {
    Map<Integer, Map<Character, Integer>> colCountMap;

    public ColumnWiseWinningStrategy(){
        this.colCountMap = new HashMap<>();
    }

    @Override
    public boolean checkWinner(Board board, Move move) {
       int col = move.getCell().getColIndex();
       Character symbol = move.getPlayer().getSymbol();

       this.colCountMap.putIfAbsent(col, new HashMap<>());
        Map<Character, Integer> countMap = this.colCountMap.get(col);

        countMap.putIfAbsent(symbol, 0);
        countMap.put(symbol, countMap.get(symbol)+1);

        return countMap.get(symbol) == board.getSize();
    }

    @Override
    public void handleUndo(Board board, Move move) {
        int col = move.getCell().getColIndex();
        Character symbol = move.getPlayer().getSymbol();

        Map<Character, Integer> countMap = this.colCountMap.get(col);
        countMap.put(symbol, countMap.get(symbol)-1);
    }
}
