import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by angoh on 6/18/15.
 */
public class TicTacToeBoardTest {
    @Test
    public void shouldBeA3By3Grid() {
        TicTacToeBoard board = new TicTacToeBoard();
        String boardString = "   |   |   \n-----------\n   |   |   \n-----------\n   |   |   ";
        assertEquals(boardString, board.getBoard());
    }

    @Test
    public void shouldPlaceXInBox1() {
        TicTacToeBoard board = new TicTacToeBoard();
        board.placeX(1);
        String boardString = " X |   |   \n-----------\n   |   |   \n-----------\n   |   |   ";
        assertEquals(boardString, board.getBoard());
    }

    @Test
    public void shouldPlaceXInBox7() {
        TicTacToeBoard board = new TicTacToeBoard();
        board.placeX(7);
        String boardString = "   |   |   \n-----------\n   |   |   \n-----------\n X |   |   ";
        assertEquals(boardString, board.getBoard());
    }

    @Test
    public void shouldPlaceOInBox1() {
        TicTacToeBoard board = new TicTacToeBoard();
        board.placeO(1);
        String boardString = " O |   |   \n-----------\n   |   |   \n-----------\n   |   |   ";
        assertEquals(boardString, board.getBoard());
    }
}
