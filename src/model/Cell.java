package model;

public class Cell {
    private int rowIndex;
    private int colIndex;
    private CellState state;
    private Player player;

    public Cell(int i, int j) {
        this.rowIndex = i;
        this.colIndex = j;
        this.state = CellState.EMPTY;
    }

    public int getRowIndex() {
        return rowIndex;
    }

    public void setRowIndex(int rowIndex) {
        this.rowIndex = rowIndex;
    }

    public int getColIndex() {
        return colIndex;
    }

    public void setColIndex(int colIndex) {
        this.colIndex = colIndex;
    }

    public CellState getState() {
        return state;
    }

    public void setState(CellState state) {
        this.state = state;
    }

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public void display() {
        if(state.equals(CellState.EMPTY)){
            System.out.print("| _ |");
        }else{
            System.out.print("| "+ this.player.getSymbol() + " |");
        }
    }
}
