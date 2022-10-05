package ticTacToe;
import exceptions.TicTacToeException;
import ticTacToe.Mark;
import static ticTacToe.Mark.*;

public class Player {
    private final Mark mark;
    public Player(Mark mark) {
        this.mark = mark;
    }

    public void playGame(int position, Board board){
        if (position < 1 || position > 9) throw new
                ArrayIndexOutOfBoundsException("You can only play on a position on the board");
        else {
            var gameBoard = board.getGameBoard();
            int row = 0;
            int col = position - 1;
            if (position > 3) {
                row = 1;
                col = position - 4;
            }
            if (position > 6) {
                row = 2;
                col = position -7;
            }
            if (gameBoard[row][col]  == E) {
                gameBoard[row][col] = mark;
            } else {
                throw new TicTacToeException("You can only Play to an empty position");
            }
        }
    }
}
