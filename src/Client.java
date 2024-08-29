import controller.GameController;
import controller.PlayerController;
import model.BotDifficultyLevel;
import model.BotPlayer;
import model.Game;
import model.GameState;
import model.HumanPlayer;
import model.PlayerType;
import strategies.winning.ColumnWiseWinningStrategy;
import strategies.winning.DiagonalWiseWinningStrategy;
import strategies.winning.RowWiseWinningStrategy;

import java.util.List;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) {
        PlayerController playerController = new PlayerController();
        HumanPlayer humanPlayer = playerController.createHumanPlayer("1", "okele", 'O');
        BotPlayer botPlayer = playerController.createBotPlayer("2", "bele", 'X', BotDifficultyLevel.EASY);

        RowWiseWinningStrategy rowWiseWinningStrategy = new RowWiseWinningStrategy();
        ColumnWiseWinningStrategy columnWiseWinningStrategy = new ColumnWiseWinningStrategy();
        DiagonalWiseWinningStrategy diagonalWiseWinningStrategy = new DiagonalWiseWinningStrategy();

        GameController gameController = new GameController();
        Scanner sc = new Scanner(System.in);

        try {
            Game game = gameController.startGame(3,
                    List.of(humanPlayer, botPlayer),
                    List.of(rowWiseWinningStrategy, columnWiseWinningStrategy, diagonalWiseWinningStrategy)
            );

            while (gameController.checkState(game, GameState.IN_PROGRESS)) {
                gameController.display(game);
                gameController.makeMove(game);


                if(gameController.checkNextPlayer(game, PlayerType.HUMAN)){
                    gameController.display(game);

                    System.out.println("Do you want to undo? Press 1 to configure or press 2 to continue.");
                    int undoOption = sc.nextInt();
                    if(undoOption == 1) {
                        gameController.undo(game);
                        continue;
                    }
                }



                if (gameController.checkState(game, GameState.GAME_WON)) {
                    System.out.println(gameController.getWinner(game).getName() + " wins the game.");
                    break;
                } else if (gameController.checkState(game, GameState.DRAW)) {
                    System.out.println("Game is draw!");
                    break;
                }
            }
        } catch (Exception e) {
            System.out.println("Error while starting game: " + e.getMessage());
        }
    }
}
