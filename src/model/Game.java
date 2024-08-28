package model;

import strategies.validator.BotCountValidator;
import strategies.validator.DimensionAndPlayerCountValidator;
import strategies.validator.GameParamValidator;
import strategies.validator.UniqueSymbolValidator;
import strategies.winning.WinningStrategy;

import java.util.List;

public class Game {

    private Board board;
    private List<Player> players;
    private List<Move> moves;
    private int nextPlayerIndex;
    private Player winner;
    private GameState state;
    List<WinningStrategy> winningStrategies;

    private Game(int dimension, List<Player> players, List<WinningStrategy> winningStrategies) {
        this.players = players;
        this.winningStrategies = winningStrategies;
        this.board = new Board(dimension);
        this.state = GameState.IN_PROGRESS;
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

    public int getNextPlayerIndex() {
        return nextPlayerIndex;
    }

    public void setNextPlayerIndex(int nextPlayerIndex) {
        this.nextPlayerIndex = nextPlayerIndex;
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
        //check the next player
        //ask player to type the move
        //store the move
        //check winner

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
