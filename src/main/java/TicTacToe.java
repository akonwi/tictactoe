import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintStream;
import java.util.List;

/**
 * Created by angoh on 6/18/15.
 */
public class TicTacToe {
    private List<Player> players;
    private Player player1;
    private Player player2;
    private TicTacToeBoard board;
    private PrintStream printStream;
    private BufferedReader reader;
    private boolean notFull;

    public TicTacToe(TicTacToeBoard board, PrintStream printStream, List<Player> players) {
        this.board = board;
        this.printStream = printStream;
        this.players = players;
    }

    public void start() {
        printStream.println(board.getBoard());
        notFull = !board.isFull();
        while (notFull) {
            for (Player player : players) {
                player.playTurn();
                if (board.isFull()) break;
            }
            break;
        }
        printStream.println("Game is a draw");
    }

//    public int promptPlayer1() {
//        printStream.println("Player 1: " + prompt);
//        return getUserInput();
//    }
//
//    public int promptPlayer2() {
//        printStream.println("Player 2: " + prompt);
//        return getUserInput();
//    }

//    public boolean player1Move() {
//        int location = promptPlayer1();
//        while (location < 1) {
//            printStream.println("That location cannot be played");
//            location = promptPlayer1();
//        }
//        boolean failed = !board.placeX(location);
//        if (failed) {
//            printStream.println("That location cannot be played");
//        }
//        notFull = !board.isFull();
//        return failed;
//    }
//
//    public boolean player2Move() {
//        int location = promptPlayer2();
//        while (location < 1) {
//            printStream.println("That location cannot be played");
//            location = promptPlayer2();
//        }
//        boolean failed = !board.placeO(location);
//        if (failed) {
//            printStream.println("That location cannot be played");
//        }
//        notFull = !board.isFull();
//        return failed;
//    }

}
