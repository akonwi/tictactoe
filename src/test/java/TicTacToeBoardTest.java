import org.junit.Before;
import org.junit.Test;

import static junit.framework.TestCase.assertFalse;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

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
        board.placeX(1);
        String boardString = " X |   |   \n-----------\n   |   |   \n-----------\n   |   |   ";
        assertEquals(boardString, board.getBoard());
    }

    @Test
    public void shouldPlaceXInBox7() {
        board.placeX(7);
        String boardString = "   |   |   \n-----------\n   |   |   \n-----------\n X |   |   ";
        assertEquals(boardString, board.getBoard());
    }

    @Test
    public void shouldPlaceOInBox1() {
        board.placeO(1);
        String boardString = " O |   |   \n-----------\n   |   |   \n-----------\n   |   |   ";
        assertEquals(boardString, board.getBoard());
    }

    @Test
    public void shouldNotAllowPlayingInAnOccupiedBox() {
        assertTrue(board.placeX(1));
        String boardString = " X |   |   \n-----------\n   |   |   \n-----------\n   |   |   ";
        assertFalse(board.placeO(1));
        assertEquals(boardString, board.getBoard());
    }

    @Test
    public void shouldKnowWhenBoardIsFull() {
        for(int i = 1; i < 10; i++) {
            board.placeX(i);
        }
        assertTrue(board.isFull());
    }
}
