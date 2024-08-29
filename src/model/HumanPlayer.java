package model;

import java.util.Scanner;

public class HumanPlayer extends Player {
    Scanner sc = new Scanner(System.in);
    public HumanPlayer(String id, String name, Character symbol){
        super(id, name, symbol, PlayerType.HUMAN);
    }
    @Override
    public Move makeAMove(Board board) {
        System.out.println(this.name + "'s move. Please make your move");

        //Getting input from player
        System.out.println("Enter row");
        int row = sc.nextInt();
        System.out.println("Enter column");
        int col = sc.nextInt();

        Cell cell = new Cell(row, col);
        return new Move(cell, this);
    }
}
