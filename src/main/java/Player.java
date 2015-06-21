import java.io.PrintStream;

/**
 * Created by angoh on 6/18/15.
 */
public class Player {
    private String name;
    private String mark;
    private TicTacToeBoard board;

    public Player(String name, String move, TicTacToeBoard board) {
        this.name = name;
        this.mark = move;
        this.board = board;
    }

    public String name() {
        return name;
    }

    public boolean playTurn(int location) {
        return board.place(location, mark);
    }


}
