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
    public void shouldPromptPlayer1ToMakeAMove() throws IOException {
        game.promptPlayer1();
        verify(printStream).println("Player 1: Enter a number between 1 and 9 to make a move");
    }

    @Test
    public void shouldHandleInvalidUserInputAndPrintBoard() throws IOException {
        when(reader.readLine()).thenReturn("a");
        game.player1Move(game.getUserInput());
        verify(printStream, atLeastOnce()).println(board.getBoard());
    }

    @Test
    public void shouldHandleValidUserInputAndTellBoard() throws IOException {
        when(reader.readLine()).thenReturn("1");
        game.start();
        verify(printStream, atLeastOnce()).println(board.getBoard());
        verify(board).placeX(1);
    }

    @Test
    public void shouldPromptPlayer2ToMakeAMoveAfterPlayer1() throws IOException {
        when(reader.readLine()).thenReturn("1");
        when(board.placeO(anyInt())).thenReturn(true);
        game.start();
        verify(printStream).println("Player 2: Enter a number between 1 and 9 to make a move");
    }

    @Test
    public void shouldLetUserKnowABoxCantBePlayed() throws IOException {
        game.player1Move(1);
        game.player2Move(1);
        verify(printStream, atLeastOnce()).println("That location cannot be played");
    }

    @Test
    public void shouldLetPlayersKnowWhenBoardIsFull() {
        when(board.isFull()).thenReturn(true);
        game.start();
        verify(printStream).println("Game is a draw");
    }
}
