import java.util.Arrays;
import java.util.List;

import static java.lang.String.format;

/**
 * Created by angoh on 6/18/15.
 */
public class TicTacToeBoard {
    private String board;
    private List<String> locations;

    public TicTacToeBoard() {
        locations = Arrays.asList(
                " ", " ", " ",
                " ", " ", " ",
                " ", " ", " "
        );
        makeBoard();
    }

    public String makeBoard() {
        board = " %s | %s | %s \n" +
                "-----------\n" +
                " %s | %s | %s \n" +
                "-----------\n" +
                " %s | %s | %s ";
        board = format(board,
                locations.get(0), locations.get(1), locations.get(2),
                locations.get(3), locations.get(4), locations.get(5),
                locations.get(6), locations.get(7), locations.get(8)
                );
        return board;
    }

    public String getBoard() {
        return makeBoard();
    }

    public boolean place(int i, String move) {
        i = i - 1;
        if (i > -1) {
            if (locations.get(i).trim().isEmpty()) {
                locations.set(i, move);
                return true;
            }
        }
        return false;
    }

    public boolean isFull() {
        for(int i = 0; i < 9; i++) {
            String location = locations.get(i);
            if (location.trim().isEmpty()) {
                return false;
            }
        }
        return true;
    }

    public boolean isWon() {
       return wonHorizontally() || wonVertically();
    }

    private boolean wonVertically() {
        String lastMark = getFirstMark();
        int count = 0;
        for (int i = 0; i < 9; i++) {
            String currentMark = locations.get(i).trim();
            if (!currentMark.isEmpty()) {
                if (count == 3) return true;
                if (currentMark.equals(lastMark)) {
                    return nextTwoMatchVertically(i);
                }
            }
        }
        return false;
    }

    private boolean wonHorizontally() {
        String lastMove = getFirstMark();
        int count = 0;
        for (int i = 0; i < 9; i++) {
            String currentMove = locations.get(i);
            if (currentMove != null && !currentMove.isEmpty()) {
                if (count == 3) {
                    return true;
                }
                if (currentMove.equals(lastMove)) {
                    return nextTwoMatchHorizontally(i);
                }
            }
        }
        return false;
    }

    private boolean nextTwoMatchVertically(int start) {
        boolean aChance = true;
        int next = start + 3;
        while (aChance && next < start + 7) {
            if (locations.get(next) == null || locations.get(next).isEmpty()) {
                aChance = false;
            }
            next += 3;
        }
        return aChance;
    }


    private boolean nextTwoMatchHorizontally(int start) {
        boolean aChance = true;
        int next = start + 1;
        while (aChance && next < start + 3) {
            if (locations.get(next) == null || locations.get(next).isEmpty()) {
                aChance = false;
            }
            next++;
        }
        return aChance;
    }

    private String getFirstMark() {
        for (int i = 0; i < 9; i ++) {
            if (!locations.get(i).trim().isEmpty()) {
                return locations.get(i);
            }
        }
        return null;
    }
}
