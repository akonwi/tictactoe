import org.junit.Before;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

/**
 * Created by angoh on 6/18/15.
 */
public class TicTacToeTest {

    TicTacToeBoard board;
    PrintStream printStream;
    TicTacToe game;
    BufferedReader reader;

    @Before
    public void setUp() {
        reader = mock(BufferedReader.class);
        board = mock(TicTacToeBoard.class);
        when(board.getBoard()).thenReturn(" board ");
        printStream = mock(PrintStream.class);
        game = new TicTacToe(board, printStream, reader);
    }

    @Test
    public void shouldPrintBoardOnStart() {
        game.start();
        verify(printStream, atLeastOnce()).println(board.getBoard());
    }

    @Test
    public void shouldPromptPlayer1ToMakeAMove() {
        game.start();
        verify(printStream).println("Enter a number between 1 and 9 to make a move");
    }

    @Test
    public void shouldHandleInvalidUserInputAndPrintBoard() throws IOException {
        when(reader.readLine()).thenReturn("a");
        game.start();
        verify(printStream, times(2)).println(board.getBoard());
    }

    @Test
    public void shouldHandleValidUserInputAndTellBoard() throws IOException {
        when(reader.readLine()).thenReturn("1");
        game.start();
        verify(printStream, times(2)).println(board.getBoard());
        verify(board).placeX(1);
    }

}
