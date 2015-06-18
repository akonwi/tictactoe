import org.junit.Test;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

/**
 * Created by angoh on 6/18/15.
 */
public class TicTacToeTest {
    @Test
    public void shouldPrintBoardOnStart() {
        TicTacToeBoard board = mock(TicTacToeBoard.class);
        TicTacToe game = new TicTacToe(board);
        game.start();
        verify(board).printBoard();
    }
}
