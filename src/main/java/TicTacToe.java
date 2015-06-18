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
        while (!board.isFull()) {
            int move = promptPlayer1();
            player1Move(move);
            move = promptPlayer2();
            player2Move(move);
            printStream.println("Game is a draw");
        }
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
        boolean failed = !board.placeX(location);
        while (failed) {
           printStream.println("That location cannot be played");
            failed = !board.placeX(promptPlayer1());
        }
        printStream.println(board.getBoard());
    }

    public void player2Move(int location) {
        boolean failed = !board.placeO(location);
        while (failed) {
            printStream.println("That location cannot be played");
            failed = !board.placeO(promptPlayer2());
        }
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
