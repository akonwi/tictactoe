import org.junit.Before;
import org.junit.Test;

import static junit.framework.TestCase.assertFalse;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;
import static org.mockito.Matchers.anyInt;
import static org.mockito.Mockito.when;

/**
 * Created by angoh on 6/18/15.
 */
public class TicTacToeBoardTest {

    private TicTacToeBoard board;

    @Before
    public void setUp() {
        board = new TicTacToeBoard();
    }

    @Test
    public void shouldBeA3By3Grid() {
        String boardString = "   |   |   \n-----------\n   |   |   \n-----------\n   |   |   ";
        assertEquals(boardString, board.getBoard());
    }

    @Test
    public void shouldPlaceXInBox1() {
        board.place(1, "X");
        String boardString = " X |   |   \n-----------\n   |   |   \n-----------\n   |   |   ";
        assertEquals(boardString, board.getBoard());
    }

    @Test
    public void shouldPlaceXInBox7() {
        board.place(7, "X");
        String boardString = "   |   |   \n-----------\n   |   |   \n-----------\n X |   |   ";
        assertEquals(boardString, board.getBoard());
    }

    @Test
    public void shouldPlaceOInBox1() {
        board.place(1, "O");
        String boardString = " O |   |   \n-----------\n   |   |   \n-----------\n   |   |   ";
        assertEquals(boardString, board.getBoard());
    }

    @Test
    public void shouldNotAllowPlayingInAnOccupiedBox() {
        assertTrue(board.place(1, "X"));
        String boardString = " X |   |   \n-----------\n   |   |   \n-----------\n   |   |   ";
        assertFalse(board.place(1, "O"));
        assertEquals(boardString, board.getBoard());
    }

    @Test
    public void shouldKnowWhenBoardIsFull() {
        for(int i = 1; i < 10; i++) {
            board.place(i, "X");
        }
        assertTrue(board.isFull());
    }

    @Test
    public void shouldKnowWhenAPlayerHasWonWithThreeHorizontally() {
        for (int i = 1; i < 4; i++) {
            board.place(i, "X");
        }
        assertThat(board.isWon(), is(true));
    }

    @Test
    public void shouldKnowWhenAPlayerHasWonWithThreeVertically() {
        for (int i = 0; i < 9; i += 3) {
            board.place(i, "X");
        }
        assertThat(board.isWon(), is(true));
    }
}
