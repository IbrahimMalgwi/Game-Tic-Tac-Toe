package ticTacToe;

import exceptions.TicTacToeException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static ticTacToe.Mark.*;

class PlayerTest {
    private Player player1;
    private Player player2;
    private Board board;

    @BeforeEach
    void setUp() {
        player1 = new Player(X);
        player2 = new Player(O);
        board = new Board();
    }

    @Test
    void testThatPlayersExist(){
        assertNotNull(player1);
        assertNotNull(player2);
    }

    @Test
    void testThatGameBoardCanBeDisplay(){
        board.displayGameBoard();
    }

    @Test
    void testGameBoardShowXForPlayer1Play(){
        player1.playGame(9, board);
        var gameBoard = board.getGameBoard();
        assertEquals(X, gameBoard[2][2]);
        board.displayGameBoard();
    }

    @Test
    void testGameBoardShowOForPlayer2Play(){
        player2.playGame(9, board);
        var gameBoard = board.getGameBoard();
        assertEquals(O, gameBoard[2][2]);
        board.displayGameBoard();
    }

    @Test
    void testGameBoardShowXWherePlayer1PlaysToAndOWherePlayer2PlaysTo(){
        player1.playGame(3, board);
        player2.playGame(7, board);
        var gameBoard = board.getGameBoard();
        assertEquals(X, gameBoard[0][2]);
        assertEquals(O, gameBoard[2][0]);
        board.displayGameBoard();
    }

    @Test
    void testPlayCanOnlyPlayToAPositionThatIsEmpty(){
        var gameBoard = board.getGameBoard();
        player1.playGame(5, board);
        assertThrows(TicTacToeException.class, () -> player2.playGame(5, board));
        assertEquals(X, gameBoard[1][1]);
        board.displayGameBoard();
    }

    @Test
    void testPlayerCanOnlyToAPositionThatIsOnTheBoardAndExceptionIsThrownIfOtherWise(){
        var gameBoard = board.getGameBoard();
        assertThrows(ArrayIndexOutOfBoundsException.class, ()-> player1.playGame(10, board));
        board.displayGameBoard();
    }

    @Test
    void testPlayer1IsWinnerInRowZero(){
        player1.playGame(1, board);
        player2.playGame(4, board);
        player1.playGame(2, board);
        player2.playGame(9, board);
        player1.playGame(3, board);
        player2.playGame(5, board);
        assertTrue(board.isWinner());
//        board.displayGameBoard();
    }

    @Test
    void testPlayer2IsWinnerInRowZero(){
        player1.playGame(4, board);
        player2.playGame(1, board);
        player1.playGame(9, board);
        player2.playGame(2, board);
        player1.playGame(5, board);
        player2.playGame(3, board);
        assertTrue(board.isWinner());
//        board.displayGameBoard();
    }

    @Test
    void testPlayer1IsWinnerInRowOne(){
        player1.playGame(4, board);
        player2.playGame(2, board);
        player1.playGame(5, board);
        player2.playGame(9, board);
        player1.playGame(6, board);
        player2.playGame(1, board);
        assertTrue(board.isWinner());
    }

    @Test
    void testPlayer2IsWinnerInRowOne(){
        player1.playGame(2, board);
        player2.playGame(4, board);
        player1.playGame(3, board);
        player2.playGame(5, board);
        player1.playGame(9, board);
        player2.playGame(6, board);
        assertTrue(board.isWinner());
    }

    @Test
    void testPlayer1IsWinnerInRowTwo(){
        player1.playGame(7, board);
        player2.playGame(1, board);
        player1.playGame(8, board);
        player2.playGame(4, board);
        player1.playGame(9, board);
        player2.playGame(3, board);
        assertTrue(board.isWinner());
    }

    @Test
    void testPlayer2IsWinnerInRowTwo(){
        player1.playGame(1, board);
        player2.playGame(7, board);
        player1.playGame(5, board);
        player2.playGame(8, board);
        player1.playGame(3, board);
        player2.playGame(9, board);
        assertTrue(board.isWinner());
    }

    @Test
    void testPlayer1IsWinnerInColumnZero(){
        player1.playGame(1, board);
        player2.playGame(2, board);
        player1.playGame(4, board);
        player2.playGame(3, board);
        player1.playGame(7, board);
        player2.playGame(8, board);
        assertTrue(board.isWinner());
    }

    @Test
    void testPlayer2IsWinnerInColumnZero(){
        player1.playGame(3, board);
        player2.playGame(1, board);
        player1.playGame(5, board);
        player2.playGame(4, board);
        player1.playGame(6, board);
        player2.playGame(7, board);
        assertTrue(board.isWinner());
    }

    @Test
    void testPlayer1isWinnerInColumnOne(){
        player1.playGame(2, board);
        player2.playGame(1, board);
        player1.playGame(5, board);
        player2.playGame(3, board);
        player1.playGame(8, board);
        player2.playGame(4, board);
        assertTrue(board.isWinner());
    }

    @Test
    void testPlayer2IsWinnerInColumnOne(){
        player1.playGame(1, board);
        player2.playGame(2, board);
        player1.playGame(9, board);
        player2.playGame(5, board);
        player1.playGame(7, board);
        player2.playGame(8, board);
        assertTrue(board.isWinner());
    }

    @Test
    void testPlayer1IsWinnerInColumnTwo(){
        player1.playGame(3, board);
        player2.playGame(1, board);
        player1.playGame(6, board);
        player2.playGame(2, board);
        player1.playGame(9, board);
        player2.playGame(4, board);
        assertTrue(board.isWinner());
    }

    @Test
    void testPlayer2IsWinnerInColumnTwo(){
        player1.playGame(4, board);
        player2.playGame(3, board);
        player1.playGame(5, board);
        player2.playGame(6, board);
        player1.playGame(1, board);
        player2.playGame(9, board);
        assertTrue(board.isWinner());
    }

    @Test
    void testPlayer1IsWinnerInRightDiagonal(){
        player1.playGame(1, board);
        player2.playGame(2, board);
        player1.playGame(5, board);
        player2.playGame(3, board);
        player1.playGame(9, board);
        player2.playGame(4, board);
        assertTrue(board.isWinner());
    }

    @Test
    void testPlayer2IsWinnerInRightDiagonal(){
        player1.playGame(3, board);
        player2.playGame(1, board);
        player1.playGame(2, board);
        player2.playGame(5, board);
        player1.playGame(7, board);
        player2.playGame(9, board);
        assertTrue(board.isWinner());
    }

    @Test
    void testPlayer1IsWinnerInLeftDiagonal(){
        player1.playGame(3, board);
        player2.playGame(1, board);
        player1.playGame(5, board);
        player2.playGame(2, board);
        player1.playGame(7, board);
        player2.playGame(9, board);
        assertTrue(board.isWinner());
    }

    @Test
    void testPlayer2IsWinnerInLeftDiagonal(){
        player1.playGame(1, board);
        player2.playGame(3, board);
        player1.playGame(9, board);
        player2.playGame(5, board);
        player1.playGame(2, board);
        player2.playGame(7, board);
        assertTrue(board.isWinner());
    }

    @Test
    void testGameCanBeATieInRows(){
        player1.playGame(1, board);
        player2.playGame(4, board);
        player1.playGame(2, board);
        player2.playGame(5, board);
        player1.playGame(3, board);
        player2.playGame(6, board);
        assertTrue(board.isTied());


    }

    @Test
    void testGameCanBeATieInColumn(){
        player1.playGame(1, board);
        player2.playGame(3, board);
        player1.playGame(4, board);
        player2.playGame(6, board);
        player1.playGame(7, board);
        player2.playGame(9, board);


    }

}