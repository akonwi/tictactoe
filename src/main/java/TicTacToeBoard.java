import java.io.PrintStream;

/**
 * Created by angoh on 6/18/15.
 */
public class TicTacToeBoard {
    private String board;
    private PrintStream printStream;

    public TicTacToeBoard(PrintStream printStream) {
        this.printStream = printStream;
        board = "   |   |   \n-----------\n   |   |   \n-----------\n   |   |   ";
    }

    public void printBoard() {
        printStream.println(board);
    }
}
