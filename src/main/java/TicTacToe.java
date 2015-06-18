import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintStream;
import java.nio.Buffer;

/**
 * Created by angoh on 6/18/15.
 */
public class TicTacToe {
    private TicTacToeBoard board;
    private PrintStream printStream;
    private BufferedReader reader;

    public TicTacToe(TicTacToeBoard board, PrintStream printStream, BufferedReader reader) {
        this.board = board;
        this.printStream = printStream;
        this.reader = reader;
    }

    public void start() {
        printStream.println(board.getBoard());
        printStream.println("Enter a number between 1 and 9 to make a move");
        player1Move(getUserInput());
    }

    private void player1Move(int location) {
        board.placeX(location);
        printStream.println(board.getBoard());
    }

    public int getUserInput() {
        try {
            return Integer.parseInt(reader.readLine());
        } catch (IOException e) {
            return -1;
        } catch (NumberFormatException e) {
            return -1;
        }
    }
}
