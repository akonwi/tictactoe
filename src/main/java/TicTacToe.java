import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintStream;
import java.util.List;

/**
 * Created by angoh on 6/18/15.
 */
public class TicTacToe {
    private List<Player> players;
    private TicTacToeBoard board;
    private PrintStream printStream;
    private boolean notFull;

    public TicTacToe(TicTacToeBoard board, PrintStream printStream, List<Player> players) {
        this.board = board;
        this.printStream = printStream;
        this.players = players;
    }

    public void start() {
        printStream.println(board.getBoard());
        notFull = !board.isFull();
        while (notFull) {
            for (Player player : players) {
                player.playTurn();
                printStream.println(board.getBoard());
                if (board.isFull()) break;
            }
            notFull = !board.isFull();
        }
        printStream.println("Game is a draw");
    }

}
