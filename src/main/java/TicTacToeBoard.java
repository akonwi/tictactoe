import java.util.Arrays;
import java.util.List;

import static java.lang.String.format;

/**
 * Created by angoh on 6/18/15.
 */
public class TicTacToeBoard {
    public List<String> locations;

    public TicTacToeBoard() {
        locations = Arrays.asList(
                " ", " ", " ",
                " ", " ", " ",
                " ", " ", " "
        );
    }

    public String getBoard() {
        String boardString =
                " %s | %s | %s \n" +
                "-----------\n" +
                " %s | %s | %s \n" +
                "-----------\n" +
                " %s | %s | %s ";
        boardString = format(boardString,
                locations.get(0), locations.get(1), locations.get(2),
                locations.get(3), locations.get(4), locations.get(5),
                locations.get(6), locations.get(7), locations.get(8)
                );
        return boardString;
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
        for (int i = 0; i < 9; i++) {
            String currentMark = locations.get(i).trim();
            if (!currentMark.isEmpty()) {
                if (currentMark.equals(lastMark)) {
                    return nextTwoMatchVertically(i, lastMark);
                }
            }
        }
        return false;
    }

    private boolean wonHorizontally() {
        String lastMove = getFirstMark();
        for (int i = 0; i < 9; i++) {
            String currentMove = locations.get(i);
            if (currentMove != null && !currentMove.isEmpty()) {
                if (currentMove.equals(lastMove)) {
                    return nextTwoMatchHorizontally(i, lastMove);
                }
            }
        }
        return false;
    }

    private boolean nextTwoMatchVertically(int start, String lastMark) {
        boolean aChance = true;
        int next = start + 3;
        while (aChance && next < start + 7) {
            String nextMark = locations.get(next).trim();
            if (nextMark.isEmpty() || !nextMark.equals(lastMark)) {
                aChance = false;
            }
            next += 3;
        }
        return aChance;
    }


    private boolean nextTwoMatchHorizontally(int start, String lastMark) {
        boolean aChance = true;
        int next = start + 1;
        while (aChance && next < start + 3) {
            String nextMark = locations.get(next).trim();
            if (nextMark.isEmpty() || !nextMark.equals(lastMark)) {
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
