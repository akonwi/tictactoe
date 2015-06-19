import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintStream;

/**
 * Created by angoh on 6/18/15.
 */
public class Player {
    private String name;
    private String move;
    private TicTacToeBoard board;
    private PrintStream printStream;
    private BufferedReader reader;

    public Player(String name, String move, TicTacToeBoard board, PrintStream printStream, BufferedReader reader) {
        this.name = name;
        this.move = move;
        this.board = board;
        this.printStream = printStream;
        this.reader = reader;
    }

    public boolean playTurn() {
        while (true) {
            int location = getUserInput();
            boolean success = board.place(location, move);
            if (success) {
                break;
            }
            printStream.println("That location cannot be played");
        }
        return true;
    }

    public int getUserInput() {
        printStream.println(name + ": Enter a number between 1 and 9 to make a move");
        try {
            return Integer.parseInt(reader.readLine());
        } catch (IOException e) {
            return -1;
        } catch (NumberFormatException e) {
            return -1;
        }
    }
}
