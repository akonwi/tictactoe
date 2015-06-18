import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * Created by angoh on 6/18/15.
 */
public class Main {
    public static void main(String[] args) {
        TicTacToeBoard board = new TicTacToeBoard();
        TicTacToe game = new TicTacToe(board, System.out, new BufferedReader(new InputStreamReader(System.in)));
        game.start();
    }
}
