import org.junit.Test;

import java.io.PrintStream;

import static org.mockito.Mockito.*;

/**
 * Created by angoh on 6/18/15.
 */
public class TicTacToeBoardTest {
    @Test
    public void shouldPrintA3By3Grid() {
        PrintStream printStream = mock(PrintStream.class);
        TicTacToeBoard board = new TicTacToeBoard(printStream);
        String boardString = "   |   |   \n-----------\n   |   |   \n-----------\n   |   |   ";
        board.printBoard();
        verify(printStream).println(boardString);
    }
}
