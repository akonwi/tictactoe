import org.junit.Before;
import org.junit.Test;

import java.io.PrintStream;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;
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

    @Before
    public void setUp() {
        printStream = mock(PrintStream.class);
        board = mock(TicTacToeBoard.class);
        playerX = new Player("Player 1", "X", board);
    }

    @Test
    public void shouldReturnTrueWhenItsTurnWasSuccessful() {
        when(board.place(1, "X")).thenReturn(true);
        assertThat(playerX.playTurn(1), is(true));
    }

    @Test
    public void shouldReturnFalseWhenItsTurnWasSuccessful() {
        when(board.place(1, "X")).thenReturn(false);
        assertThat(playerX.playTurn(1), is(false));
    }
}
