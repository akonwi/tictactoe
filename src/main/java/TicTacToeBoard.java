import java.io.PrintStream;

/**
 * Created by angoh on 6/18/15.
 */
public class TicTacToeBoard {
    private String board;
    private String[] locations;

    public TicTacToeBoard() {
        locations = new String[10];
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

    public boolean place(int i, String move) {
        if (i > 0) {
            if (locations[i] == null || locations[i].isEmpty()) {
                locations[i] = move;
                return true;
            }
        }
        return false;
    }

    public boolean placeX(int location) {
        return place(location, "X");
    }

    public boolean placeO(int location) {
        return place(location, "O");
    }

    public boolean isFull() {
        for(int i = 1; i < 10; i++) {
            String location = locations[i];
            if (location == null || location.isEmpty()) {
                return false;
            }
        }
        return true;
    }
}
