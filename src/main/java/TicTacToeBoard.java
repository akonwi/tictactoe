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
            String mark = locations[i];
            if (mark == null || mark.isEmpty()) {
                board += "   ";
            }
            else {
                board += " " + mark + " ";
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

    public boolean isFull() {
        for(int i = 1; i < 10; i++) {
            String location = locations[i];
            if (location == null || location.isEmpty()) {
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
        for (int i = 1; i < 10; i++) {
            String currentMark = locations[i];
            if (currentMark != null && !currentMark.isEmpty()) {
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
        for (int i = 1; i < 10; i++) {
            String currentMove = locations[i];
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
            if (locations[next] == null || locations[next].isEmpty()) {
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
            if (locations[next] == null || locations[next].isEmpty()) {
                aChance = false;
            }
            next++;
        }
        return aChance;
    }

    private String getFirstMark() {
        for (int i = 1; i < 10; i ++) {
            if (locations[i] != null && !locations[i].isEmpty()) {
                return locations[i];
            }
        }
        return null;
    }
}
