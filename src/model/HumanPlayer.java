package model;

public class HumanPlayer extends Player {

    public HumanPlayer(String id, String name, Character symbol){
        super(id, name, symbol, PlayerType.HUMAN);
    }
    @Override
    public void  makeAMove(Board board) {
        System.out.println(this.name + "'s move. Please make your move");
        //We are going to wait for player move
    }
}
