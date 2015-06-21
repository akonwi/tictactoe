import org.junit.Before;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.IOException;
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
    List<Player> players;

    @Before
    public void setUp() {
        reader = mock(BufferedReader.class);
        board = mock(TicTacToeBoard.class);
        when(board.getBoard()).thenReturn(" board ");
        printStream = mock(PrintStream.class);
        players = new ArrayList<Player>();
        game = new TicTacToe(board, printStream, reader, players);
    }

    @Test
    public void shouldPrintBoardOnStart() {
        when(board.isFull()).thenReturn(true);
        game.start();
        verify(printStream, atLeastOnce()).println(board.getBoard());
    }

    @Test
    public void shouldPromptUsersToTakeTurnsOnStart() throws IOException {
        when(reader.readLine()).thenReturn("1");
        when(board.isFull()).thenReturn(false, false, true);
        player1 = mock(Player.class);
        when(player1.playTurn(anyInt())).thenReturn(true);
        when(player1.name()).thenReturn("Player 1");
        player2 = mock(Player.class);
        when(player2.name()).thenReturn("Player 2");
        when(player2.playTurn(anyInt())).thenReturn(true);
        players.add(player1);
        players.add(player2);

        game.start();

        verify(player1).playTurn(anyInt());
        verify(player2).playTurn(anyInt());
    }

    @Test
    public void shouldPromptUserForInput() throws IOException {
        when(reader.readLine()).thenReturn("1");
        when(board.place(1, "X")).thenReturn(true);
        player1 = mock(Player.class);
        when(player1.playTurn(anyInt())).thenReturn(true);
        when(player1.name()).thenReturn("Player 1");
        players.add(player1);

        game.play();

        verify(printStream).println("Player 1: Enter a number between 1 and 9 to make a move");
    }

    @Test
    public void shouldContinuePromptingUserUntilSuccessfulMove() throws IOException {
        when(reader.readLine()).thenReturn("a").thenReturn("1");
        when(board.place(1, "X")).thenReturn(false);
        player1 = mock(Player.class);
        when(player1.name()).thenReturn("Player 1");
        when(player1.playTurn(anyInt())).thenReturn(false).thenReturn(true);
        players.add(player1);

        game.play();

        verify(printStream).println("That location cannot be played");
    }

    @Test
    public void shouldLetPlayersKnowWhenBoardIsFull() {
        when(board.isFull()).thenReturn(true);
        game.start();
        verify(printStream).println("Game is a draw");
    }

    @Test
    public void shouldStopGameWhenItIsWon() throws IOException {
        when(board.isWon()).thenReturn(true);
        game.start();
        verify(printStream).println(contains("won"));
    }
}
