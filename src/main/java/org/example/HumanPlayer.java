package org.example;
import java.util.Scanner;
import java.util.InputMismatchException;

public class HumanPlayer extends Player{
    private final Scanner in;

    public HumanPlayer(String name, Mark mark, Scanner in){
        super(name, mark);
        this.in = in;
    }

    @Override
    public int[] chooseMove(Board board) {
        while (true) {
            System.out.printf("%s (%s), enter move in format \"row(1-3) col(1-3)\": ", name, mark);
            int r = inputValidation(in) - 1;
            int c = inputValidation(in) - 1;
            if (board.isEmpty(r, c)) return new int[]{r, c};
            System.out.println("Invalid move, try again.");
        }
    }
    public static int inputValidation(Scanner scnr){
        int userInput;
        while(true){
            try{
                userInput = scnr.nextInt();
                if((userInput != 1) && (userInput != 2) && (userInput != 3)){
                    System.out.println("Invalid Number! Choose a number from 1-3");
                }
                else
                    break;
            }
            catch(InputMismatchException e){
                System.out.println("Invalid input! Choose a number from 1-3");
                scnr.nextLine();
            }
        }
        return userInput;
    }
}
