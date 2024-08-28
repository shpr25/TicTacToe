import controller.GameController;
import controller.PlayerController;
import model.BotDifficultyLevel;
import model.BotPlayer;
import model.Game;
import model.HumanPlayer;
import strategies.winning.ColumnWiseWinningStrategy;
import strategies.winning.RowWiseWinningStrategy;

import java.util.List;

public class Client {
    public static void main(String[] args) {
        PlayerController playerController = new PlayerController();
        HumanPlayer humanPlayer = playerController.createHumanPlayer("1", "okele", 'O');
        BotPlayer botPlayer = playerController.createBotPlayer("2", "bele", 'X', BotDifficultyLevel.EASY);

        RowWiseWinningStrategy rowWiseWinningStrategy = new RowWiseWinningStrategy();
        ColumnWiseWinningStrategy columnWiseWinningStrategy = new ColumnWiseWinningStrategy();

        GameController gameController = new GameController();
        Game game = null;
        try {
            game = gameController.startGame(3,
                    List.of(humanPlayer, botPlayer),
                    List.of(rowWiseWinningStrategy, columnWiseWinningStrategy)
            );

            gameController.display(game);

//        while(gameController.checkState(game, GameState.IN_PROGRESS)){
//            gameController.display(game);
//            gameController.makeMove(game);
//
//            if(gameController.checkState(game, GameState.GAME_WON)){
//                System.out.println(gameController.getWinner(game).getName() + " wins the game.");
//                break;
//            }else if(gameController.checkState(game, GameState.DRAW)){
//                System.out.println("Game is draw!");
//                break;
//            }
//        }
        } catch (Exception e) {
            System.out.println("Error while starting game: " + e.getMessage());
        }
    }
}
