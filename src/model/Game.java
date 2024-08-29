package model;

import strategies.validator.BotCountValidator;
import strategies.validator.DimensionAndPlayerCountValidator;
import strategies.validator.GameParamValidator;
import strategies.validator.UniqueSymbolValidator;
import strategies.winning.WinningStrategy;

import java.util.ArrayList;
import java.util.List;

public class Game {

    private Board board;
    private List<Player> players;
    private List<Move> moves;
    private int currentPlayerIndex;
    private Player winner;
    private GameState state;
    List<WinningStrategy> winningStrategies;

    private Game(int dimension, List<Player> players, List<WinningStrategy> winningStrategies) {
        this.players = players;
        this.winningStrategies = winningStrategies;
        this.board = new Board(dimension);
        this.state = GameState.IN_PROGRESS;
        this.moves = new ArrayList<>();
    }

    public Board getBoard() {
        return board;
    }

    public void setBoard(Board board) {
        this.board = board;
    }

    public List<Player> getPlayers() {
        return players;
    }

    public void setPlayers(List<Player> players) {
        this.players = players;
    }

    public List<Move> getMoves() {
        return moves;
    }

    public void setMoves(List<Move> moves) {
        this.moves = moves;
    }

    public int getCurrentPlayerIndex() {
        return currentPlayerIndex;
    }

    public void setCurrentPlayerIndex(int currentPlayerIndex) {
        this.currentPlayerIndex = currentPlayerIndex;
    }

    public Player getWinner() {
        return winner;
    }

    public void setWinner(Player winner) {
        this.winner = winner;
    }

    public GameState getState() {
        return state;
    }

    public void setState(GameState state) {
        this.state = state;
    }

    public List<WinningStrategy> getWinningStrategies() {
        return winningStrategies;
    }

    public void setWinningStrategies(List<WinningStrategy> winningStrategies) {
        this.winningStrategies = winningStrategies;
    }

    public void displayBoard() {
        this.board.display();
    }

    public void makeMove() {
        Player currentPlayer = this.players.get(currentPlayerIndex);
        Move move;

        do{
            move = currentPlayer.makeAMove(board);
        }while (!validateMove(move));

        //update the cell and move
        move.getCell().setState(CellState.FILLED);
        move.getCell().setPlayer(currentPlayer);

        //store the move
        moves.add(move);

        //check winner
        if(checkWinner(move)){
            this.setState(GameState.GAME_WON);
            setWinner(currentPlayer);
        }else if(moves.size() == board.getSize() * board.getSize()){
            setState(GameState.DRAW);
            setWinner(null);
        }

        //update the current player index
        currentPlayerIndex = ((currentPlayerIndex + 1) % players.size());

    }

    private boolean validateMove(Move move) {
        Cell cell = move.getCell();
        int r = cell.getRowIndex();
        int c = cell.getColIndex();

        if(r >= board.getSize() || r < 0 || c >= board.getSize() || c < 0 ){
            System.out.println("Invalid move! Please try again!!");
            return false;
        }
        Cell cellToUpdate = this.board.getGrid().get(r).get(c);
        move.setCell(cellToUpdate);

        if(!cell.getState().equals(CellState.EMPTY)){
            System.out.println("Invalid move! Please try again!!");
            return false;
        }

        return true;
    }

    private boolean checkWinner(Move move) {
        for(WinningStrategy strategy : winningStrategies){
            if(strategy.checkWinner(board, move)){
                return true;
            }
        }
        return false;
    }

    public static GameBuilder builder(){
         return new GameBuilder();
    }

     public static class GameBuilder {
        private List<Player> players;
        private int dimension;
        private List<WinningStrategy> winningStrategies;
        private List<GameParamValidator> validators;

        public GameBuilder(){
            this.validators = List.of(new DimensionAndPlayerCountValidator(),
                    new BotCountValidator(),
                    new UniqueSymbolValidator());
        }

         public List<Player> getPlayers() {
             return players;
         }

         public int getDimension() {
             return dimension;
         }

         public GameBuilder setPlayers(List<Player> players) {
            this.players = players;
            return this;
        }

        public GameBuilder setDimension(int dimension) {
            this.dimension = dimension;
            return this;
        }

        public GameBuilder setWinningStrategies(List<WinningStrategy> winningStrategies) {
            this.winningStrategies = winningStrategies;
            return this;
        }

        private void validateConfigureParams() throws Exception {
            for (GameParamValidator validator: validators) {
                validator.validate(this);
            }
        }
        public Game build() throws Exception {
            validateConfigureParams();
            return new Game(this.dimension, this.players, this.winningStrategies);
        }
    }
}
