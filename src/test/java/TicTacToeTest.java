import org.junit.Before;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.*;

/**
 * Created by angoh on 6/18/15.
 */
public class TicTacToeTest {

    TicTacToeBoard board;
    PrintStream printStream;
    TicTacToe game;
    BufferedReader reader;
    Player player1;
    Player player2;

    @Before
    public void setUp() {
        reader = mock(BufferedReader.class);
        board = mock(TicTacToeBoard.class);
        when(board.getBoard()).thenReturn(" board ");
        printStream = mock(PrintStream.class);
        player1 = mock(Player.class);
        when(player1.playTurn()).thenReturn(true);
        player2 = mock(Player.class);
        when(player2.playTurn()).thenReturn(true);
        List<Player> players = new ArrayList<Player>();
        players.add(player1);
        players.add(player2);
        game = new TicTacToe(board, printStream, players);
    }

    @Test
    public void shouldPrintBoardOnStart() {
        when(board.isFull()).thenReturn(true);
        game.start();
        verify(printStream).println(board.getBoard());
    }

    @Test
    public void shouldPromptUsersToTakeTurnsOnStart() {
        when(board.isFull()).thenReturn(false, false, true);
        game.start();

        verify(player1).playTurn();
        verify(player2).playTurn();
    }

    @Test
    public void shouldLetPlayersKnowWhenBoardIsFull() {
        when(board.isFull()).thenReturn(true);
        game.start();
        verify(printStream).println("Game is a draw");
    }
}
