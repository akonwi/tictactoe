import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintStream;
import java.nio.Buffer;

/**
 * Created by angoh on 6/18/15.
 */
public class TicTacToe {
    private String prompt;
    private TicTacToeBoard board;
    private PrintStream printStream;
    private BufferedReader reader;

    public TicTacToe(TicTacToeBoard board, PrintStream printStream, BufferedReader reader) {
        this.board = board;
        this.printStream = printStream;
        this.reader = reader;
        this.prompt = "Enter a number between 1 and 9 to make a move";
    }

    public void start() {
        printStream.println(board.getBoard());
        int move = promptPlayer1();
        player1Move(move);
        move = promptPlayer2();
        player2Move(move);
    }

    public int promptPlayer1() {
        printStream.println("Player 1: " + prompt);
        return getUserInput();
    }

    public int promptPlayer2() {
        printStream.println("Player 2: " + prompt);
        return getUserInput();
    }

    public void player1Move(int location) {
        board.placeX(location);
        printStream.println(board.getBoard());
    }

    public void player2Move(int location) {
        board.placeO(location);
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
