import org.junit.Before;
import org.junit.Test;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.stubbing.Answer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintStream;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

/**
 * Created by angoh on 6/18/15.
 */
public class PlayerTest {

    private PrintStream printStream;
    private TicTacToeBoard board;
    private Player playerX;
    private BufferedReader reader;

    @Before
    public void setUp() {
        printStream = mock(PrintStream.class);
        board = mock(TicTacToeBoard.class);
        reader = mock(BufferedReader.class);
        playerX = new Player("Player 1", "X", board, printStream, reader);
    }

    @Test
    public void shouldHandleInvalidUserInput() throws IOException {
        when(reader.readLine()).thenReturn("a");
        assertEquals(-1, playerX.getUserInput());
    }

    @Test
    public void shouldHandleValidUserInput() throws IOException {
        when(reader.readLine()).thenReturn("1");
        assertEquals(1, playerX.getUserInput());
    }

    @Test
    public void shouldPromptUserForInput() throws IOException {
        when(reader.readLine()).thenReturn("1");
        when(board.place(1, "X")).thenReturn(true);
        playerX.playTurn();
        verify(printStream).println("Player 1: Enter a number between 1 and 9 to make a move");
    }

    @Test
    public void shouldContinuePromptingUserUntilSuccessfulMove() throws IOException {
        when(reader.readLine()).thenAnswer(new Answer() {
            private int count = 0;

            @Override
            public String answer(InvocationOnMock invocationOnMock) throws Throwable {
                count++;
                if (count == 1) {
                    return "a";
                }
                else {
                    return "1";
                }
            }
        });
        when(board.place(1, "X")).thenReturn(true);
        boolean played = playerX.playTurn();
        assertTrue(played);
        verify(printStream).println("That location cannot be played");
    }
}
