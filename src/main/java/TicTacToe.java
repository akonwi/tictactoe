import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintStream;
import java.util.List;

/**
 * Created by angoh on 6/18/15.
 */
public class TicTacToe {
    private BufferedReader reader;
    private List<Player> players;
    private TicTacToeBoard board;
    private PrintStream printStream;
    private boolean notFull;
    private boolean notWon;

    public TicTacToe(TicTacToeBoard board, PrintStream printStream, BufferedReader reader, List<Player> players) {
        this.board = board;
        this.printStream = printStream;
        this.reader = reader;
        this.players = players;
        notFull = !board.isFull();
        notWon = !board.isWon();
    }

    public void start() {
        printStream.println(board.getBoard());
        while (notFull && notWon) {
            play();
            notFull = !board.isFull();
            notWon = !board.isWon();
        }
        if (!notFull) {
            printStream.println("Game is a draw");
        }
        else {
            printStream.println("Someone won!");
        }
        printStream.println(board.getBoard());
    }

    public void play() {
        for (Player player : players) {
            while (true) {
                boolean success = player.playTurn(getUserInput(player.name()));
                if (success) {
                    break;
                }
                else {
                    printStream.println("That location cannot be played");
                    printStream.println(board.getBoard());
                }
            }
            notWon = !board.isWon();
            notFull = !board.isFull();
            printStream.println(board.getBoard());
        }
    }

    public int getUserInput(String playerName) {
        printStream.println(playerName + ": Enter a number between 1 and 9 to make a move");
        try {
            return Integer.parseInt(reader.readLine());
        } catch (IOException e) {
            return -1;
        } catch (NumberFormatException e) {
            return -1;
        }
    }

}
