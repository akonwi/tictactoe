import java.io.PrintStream;

/**
 * Created by angoh on 6/18/15.
 */
public class TicTacToeBoard {
    private String board;
    private PrintStream printStream;
    private String[] locations;

    public TicTacToeBoard() {
        locations = new String[10];
//        board = "   |   |   \n-----------\n   |   |   \n-----------\n   |   |   ";
        makeBoard();
    }

    public String makeBoard() {
        board = "";
        for (int i = 1; i < 10; i++) {
            String move = locations[i];
            if (move == null || move.isEmpty()) {
                board += "   ";
            }
            else {
                board += " " + move + " ";
            }
            if (i == 0 || i % 3 != 0) {
                board += "|";
            }
            else if (i % 3 == 0 && i < 9) {
                board += "\n-----------\n";
            }
        }
        return board;
    }

    public String getBoard() {
        return makeBoard();
    }

    public void placeX(int i) {
        if (i > 0) {
            locations[i] = "X";
        }
    }

    public void placeO(int i) {
        if (i > 0) {
            locations[i] = "O";
        }
    }
}
