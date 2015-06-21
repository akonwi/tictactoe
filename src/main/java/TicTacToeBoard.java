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
       return wonDiagonally() || wonHorizontally() || wonVertically();
    }

    private boolean wonDiagonally() {
        String topLeftMark = locations.get(0).trim();
        if (!topLeftMark.isEmpty()) {
            if (locations.get(4).trim().equals(locations.get(8).trim()) && topLeftMark.equals(locations.get(4).trim())) {
                return true;
            }
        }
        String topRightMark = locations.get(2);
        if (!topRightMark.isEmpty()) {
            if (locations.get(4).trim().equals(locations.get(6).trim()) && topRightMark.equals(locations.get(4).trim())) {
                return true;
            }
        }
        return false;
    }

    private boolean wonVertically() {
        for (int i = 0; i < 9; i++) {
            String lastMark = getFirstMark(i);
            if (lastMark == null) return false;
            for (int j = i; j < 9; j++) {
                if (i > 5) {
                    return false;
                }
                String currentMark = locations.get(j).trim();
                if (!currentMark.isEmpty()) {
                    if (currentMark.equals(lastMark)) {
                        if (nextTwoMatchVertically(j, lastMark)) {
                            return true;
                        }
                    }
                }
            }
        }
        return false;
    }

    private boolean wonHorizontally() {
        for (int i = 0; i < 9; i++) {
            String lastMark = getFirstMark(i);
            if (lastMark == null) return false;
            for (int j = i; j < 9; j++) {
                String currentMark = locations.get(j).trim();
                if (!currentMark.isEmpty()) {
                    if (currentMark.equals(lastMark)) {
                        if (nextTwoMatchHorizontally(j, lastMark)) {
                            return true;
                        }
                    }
                }
            }
        }
        return false;
    }

    private boolean nextTwoMatchVertically(int start, String lastMark) {
        boolean aChance = true;
        int next = start + 3;
        if (start < 3) {
            while (aChance && next < start + 7 && next < 9) {
                String nextMark = locations.get(next).trim();
                if (nextMark.isEmpty() || !nextMark.equals(lastMark)) {
                    aChance = false;
                }
                next += 3;
            }
        }
        else {
            aChance = false;
        }
        return aChance;
    }


    private boolean nextTwoMatchHorizontally(int start, String lastMark) {
        boolean aChance = true;
        int next = start + 1;
        if (start == 0 || start == 3 || start == 6) {
            while (aChance && next < start + 3 && next < 9) {
                String nextMark = locations.get(next).trim();
                if (nextMark.isEmpty() || !nextMark.equals(lastMark)) {
                    aChance = false;
                }
                next++;
            }
        }
        else {
            aChance = false;
        }
        return aChance;
    }

    private String getFirstMark(int start) {
        for (int i = start; i < 9; i ++) {
            if (!locations.get(i).trim().isEmpty()) {
                return locations.get(i);
            }
        }
        return null;
    }
}
