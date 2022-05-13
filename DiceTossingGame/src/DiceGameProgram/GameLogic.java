// 7, 11: win
//2,3,12: lose
//4,5,6,8,9,10: another chance
package DiceGameProgram;

import java.util.InputMismatchException;
import java.util.Scanner;

public class GameLogic {

    //instance variables
    private Dice dice1, dice2;
    private int totalValue; // total face values of 2 dices


    // declare constant variables/ string
    public static final String[] userStateList = {"Win", "Lose", "Draw"};
    //"Draw" is assumed for continuing playing and not yet play any round

    //constructor
    public GameLogic() {
        //instantiate the dice objects (have 2 dices in this game)
        dice1 = new Dice(1);
        dice2 = new Dice(2);
    }


    //behavior/ action methods
    public String currentUserState() {
        //calculate total face values of 2 dices
        System.out.println("\n" + dice1 + "\n" + dice2); //get value of each dice
        totalValue = dice1.getValue() + dice2.getValue(); // calculate total value

        //logic to find win or lose or continue the game
        if (totalValue == 7 || totalValue == 11) { // win game
            System.out.println("Your values: " + totalValue + "\n***You Win!***");
            return userStateList[0];
        }
        else if (totalValue == 2 || totalValue == 3 || totalValue == 12) { //lose game
            System.out.println("Your values: " + totalValue + "\nBOO! Loser");
            return userStateList[1];
        }
        else { //continue the game (or draw)
            System.out.println("Your values: " + totalValue + "\nPlease continue the game");
            return userStateList[2];
        }
    }
    public void go(Scanner input, GameLogic craps) {
        // variable to store user choice about game mode (automatic or running by themselves)
        int gameMode;
        //variable to store player's current state in their game
        String userState;

        //instruction for user to choose
        System.out.println("""
                Please choose 1 among 2 modes for playing games
                1_ Let the game roll the dices automatically until you win or lose
                2_ You will roll the dices by yourself
                0_ Exit the game""");

        //start looping for input and handling errors
        do {
            //place for inputting
            System.out.print("You choose for game mode (Press 3 if you do not remember instructions for game mode): ");
            try {
                gameMode = input.nextInt(); //user options as int
                //run the program base on the player's option
                switch (gameMode) {
                    case 1: //mode 1
                        //automatically tossing the dices until the user wins or loses
                        do {
                            userState = craps.currentUserState(); //run until winning or losing
                            if (!userState.equalsIgnoreCase(userStateList[2])) { //when the user wins or loses
                                //ask user to choose to play again or exit the game
                                startGame(input, userState);
                            }
                        } while (userState.equalsIgnoreCase(userStateList[2]));
                        break;

                    case 2: //mode 2
                        //the user tosses the dices by themselves until they win or lose
                        do {
                            //toss
                            userState = craps.currentUserState();
                            //ask user to continue to toss
                            startGame(input, userState);
                        } while (userState.equalsIgnoreCase(userStateList[2])); // until they win or lose
                        break;

                    case 3:
                        //print instruction again if they dont remember
                        System.out.println("""
                                Please choose 1 among 2 modes for playing games
                                1_ Let the game roll the dices automatically until you win or lose
                                2_ You will roll the dices by yourself
                                0_ Exit the game""");
                        break;

                    case 0: // exit game
                        System.out.println("Exit the program!");
                        System.exit(0); //exit after successfully running

                    default: //invalid value -> enter again
                        System.err.print("Invalid value! Please enter num btw 0-2: ");
                }
            }
            //ask user to enter again b/c they dont enter an integer
            catch(InputMismatchException e) {
                System.err.print("Invalid format! Please enter a number btw 0-2.");
            }
        } while (true);
    }

    //methods for supporting behavior methods
    private static void startGame(Scanner input, String userState) {
        int userInput; //declare variable  to store input while looping

        //print instruction for user to input basing on their current state
        if (userState.equalsIgnoreCase(userStateList[2])) //this is in case the user chooses to roll the dices by themselves
            System.out.println("To start rolling, press 1. To exit the game, press 0");
            //ask user if they want to play game again
        else if (userState.equalsIgnoreCase(userStateList[0]))
            System.out.println("If you want to start a new round - enter 1. Exit program - enter 0");
        else
            System.out.println("If you want to try again - enter 1. Exit program - enter 0");

        //place for user input
        System.out.print("You choose for start game: ");

        //loop to take input and handle errors
        do {
            try {
                userInput = input.nextInt(); //take user input as integer
                if (userInput == 1) //user choose to continue or start rolling
                    return; // exit this function

                    //exit option
                else if (userInput == 0) {
                    System.out.println("Exit the program!");
                    System.exit(0); // exit when the program is true
                }
                //invalid value input -> enter again
                else
                    System.err.print("Invalid value! The number must be either 1 or 0 only: ");
            }
            //invalid format input (string, character,... instead of an integer)
            catch(InputMismatchException e) {
                System.err.print("Invalid format! Please choose either 1 or 0 only: ");
            }
        } while (true);
    }


    public static void main(String[] args) {
        //declare and instantiate the object of this class
        GameLogic craps = new GameLogic();

        //declare input and use
        Scanner input = new Scanner(System.in);

        // run game
        craps.go(input, craps);

    }

}