import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Map;

public class GameTest {

    private Player playerA;
    private Player playerB;
    private Board board;
    private Game game;

    @BeforeEach
    public void createNewGame() {
        playerA = new Player();
        playerB = new Player();
        board = new Board();
        game = new Game(playerA, playerB, board);
    }

    @Test
    public void playGame_winnerPlayerA() {
        int[] input = {3, 1, 5, 2, 3, 4, 1};
        game.play(input);
        Map stats = game.getStats();

        Assertions.assertEquals(Constants.FOUND_WINNER, stats.get(Constants.OUTCOME));
        Assertions.assertEquals(Constants.PLAYER_A, stats.get(Constants.WINNER));
    }

    @Test
    public void playGame_winnerPlayerB() {
        int[] input = {1, 1, 1, 6, 1, 6, 1, 6, 4, 1, 4, 6, 4, 3, 1, 2};
        game.play(input);
        Map stats = game.getStats();

        Assertions.assertEquals(Constants.FOUND_WINNER, stats.get(Constants.OUTCOME));
        Assertions.assertEquals(Constants.PLAYER_B, stats.get(Constants.WINNER));
    }

    @Test
    public void playGame_draw() {
        int[] input = {3, 1, 5, 1, 1, 5, 5, 5, 5, 1};
        game.play(input);
        Map stats = game.getStats();

        Assertions.assertEquals(Constants.DRAW, stats.get(Constants.OUTCOME));
    }

    @Test
    public void playGame_foulPenaltyPlayerA() {
        int[] input = {1, 1, 4, 1, 4, 6, 4, 3, 1, 2};
        game.play(input);

        Assertions.assertTrue(playerA.isHavingFoulPenalty());
    }

    @Test
    public void playGame_noStrikePenaltyPlayerB() {
        int[] input = {1, 3, 5, 1, 2, 6, 4, 6, 3, 6, 2};
        game.play(input);

        Assertions.assertTrue(playerB.isHavingNoStrikePenalty());
    }

    @Test
    public void playGame_invalidInput() {
        int[] input = {3, 1, 5, 1, 1, 5, 5, 5, 5};
        game.play(input);
        Map stats = game.getStats();

        Assertions.assertEquals(null, stats.get(Constants.OUTCOME));
    }

}