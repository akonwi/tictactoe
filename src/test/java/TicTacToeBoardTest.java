import org.junit.Test;

/**
 * Created by angoh on 6/18/15.
 */
public class TicTacToeBoardTest {
    @Test
    public void shouldDrawA3By3Grid() {
        TicTacToeBoard board = new TicTacToeBoard();
        String boardString = "   |   |   \n---------\n   |   |   \n---------\n   |   |   ";
        assertEqual(board.getBoard(), boardString);
    }
}
