package ticTacToe;

import static ticTacToe.Mark.*;

public class Board {
    private final Mark [][] gameBoard = {{E,E,E}, {E,E,E}, {E,E,E}};

    public void displayGameBoard(){
        for (int i = 0; i <3 ; i++) {
            System.out.print("| ");
            for (int j = 0; j <3 ; j++) {
                System.out.print(gameBoard[i][j]);
                System.out.print(" | ");
            }
            System.out.println();
            System.out.println(" __  __  __");
        }
    }
    public Mark[][] getGameBoard(){
        return gameBoard;
    }

    public boolean isWinner(){
        if (isWinnerRowZero())return true;
        if (isWinnerRowOne()) return true;
        if (isWinnerRowTwo()) return true;
        if (isWinnerColumnZero()) return true;
        if (isWinnerColumnOne()) return true;
        if (isWinnerColumnTwo()) return true;
        if (isWinnerDiagonalRight()) return true;
        return isWinnerDiagonalLeft();
    }


    private boolean isWinnerRowZero() {
        boolean isX = gameBoard[0][0] == X && gameBoard[0][1] == X && gameBoard[0][2] == X;
        boolean isO = gameBoard[0][0] == O && gameBoard[0][1] == O && gameBoard[0][2] == O;
        return isX || isO;
    }

    private boolean isWinnerRowOne(){
        boolean isX = gameBoard[1][0] == X && gameBoard[1][1] == X && gameBoard[1][2] == X;
        boolean isO = gameBoard[1][0] == O && gameBoard[1][1] == O && gameBoard[1][2] == O;
        return isX || isO;
    }

    private boolean isWinnerRowTwo(){
        boolean isX = gameBoard[2][0] == X && gameBoard[2][1] == X && gameBoard[2][2] == X;
        boolean isO = gameBoard[2][0] == O && gameBoard[2][1] == O && gameBoard[2][2] == O;
        return isX || isO;
    }

    private boolean isWinnerColumnZero(){
        boolean isX = gameBoard[0][0] == X && gameBoard[1][0] == X && gameBoard[2][0] == X;
        boolean isO = gameBoard[0][0] == O && gameBoard[1][0] == O && gameBoard[2][0] == O;
        return isX || isO;
    }

    private boolean isWinnerColumnOne(){
        boolean isX = gameBoard[0][1] == X && gameBoard[1][1] == X && gameBoard[2][1] == X;
        boolean isO = gameBoard[0][1] == O && gameBoard[1][1] == O && gameBoard[2][1] == O;
        return isX || isO;
    }

    private boolean isWinnerColumnTwo(){
        boolean isX = gameBoard[0][2] == X && gameBoard[1][2] == X && gameBoard[2][2] == X;
        boolean isO = gameBoard[0][2] == O && gameBoard[1][2] == O && gameBoard[2][2] == O;
        return isX || isO;
    }

    private boolean isWinnerDiagonalRight(){
        boolean isX = gameBoard[0][0] == X && gameBoard[1][1] == X && gameBoard[2][2] == X;
        boolean isO = gameBoard[0][0] == O && gameBoard[1][1] == O && gameBoard[2][2] == O;
        return isX || isO;
    }

    private boolean isWinnerDiagonalLeft(){
        boolean isX = gameBoard[0][2] == X && gameBoard[1][1] == X && gameBoard[2][0] == X;
        boolean isO = gameBoard[0][2] == O && gameBoard[1][1] == O && gameBoard[2][0] == O;
        return isX || isO;
    }


    public boolean isTied() {
        boolean isX = gameBoard[0][0] == X && gameBoard[0][1] == X && gameBoard[0][2] == X;
        boolean isO = gameBoard[1][0] == X && gameBoard[1][1] == X && gameBoard[1][2] == X;

        return true;
    }
}
