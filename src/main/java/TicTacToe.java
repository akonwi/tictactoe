/**
 * Created by angoh on 6/18/15.
 */
public class TicTacToe {
    private TicTacToeBoard board;

    public TicTacToe(TicTacToeBoard board) {
        this.board = board;
    }

    public void start() {
        board.printBoard();
    }
}
