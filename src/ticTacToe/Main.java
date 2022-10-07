package ticTacToe;

import java.util.InputMismatchException;
import java.util.Scanner;

import static java.lang.System.exit;
import static ticTacToe.Mark.*;

public class Main {
    private static final Board board = new Board();
    private static final Player player1 = new Player(X);
    private static final Player player2 = new Player(O);
    private static final Scanner input = new Scanner(System.in);

    public static void main(String[] args) {

        startTicTacToe();
    }

    private static void startTicTacToe(){
        displayBoard();
        prompt("""
                Select an option:
                1. Play with human
                2. Play with Computer
                3. Quit               
                """);
        try {
            int option = input.nextInt();
            switch (option){
                case 1 -> playWithHuman();
                case 2 -> playWIthComputer();
                case 3 -> exit(3);
                default -> {prompt("Invalid input select (1, 2 or 3)");
                    startTicTacToe();
                }
            }

        } catch ( InputMismatchException e) {
            prompt("Option must be a number");
            input.nextLine();
            startTicTacToe();
        };
    }

    private static void playWithHuman() {
    }

    private static void playWIthComputer() {
    }

    private static void prompt(String message){
        System.out.println(message);
    }

    private static void displayBoard(){
        board.displayGameBoard();

    }
}