import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.ArrayList;

/**
 * Created by angoh on 6/18/15.
 */
public class Main {
    public static void main(String[] args) {
        TicTacToeBoard board = new TicTacToeBoard();
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<Player> players = new ArrayList<>();
        players.add(new Player("Player 1", "X", board, System.out, reader));
        players.add(new Player("Player 2", "0", board, System.out, reader));
        TicTacToe game = new TicTacToe(board, System.out, players);
        game.start();
    }
}
