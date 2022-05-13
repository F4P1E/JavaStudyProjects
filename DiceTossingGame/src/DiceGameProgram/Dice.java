package DiceGameProgram;
import java.util.Random;
public class Dice {
    //instance variables
    private int diceNo; // the name of the dice
    private int value; // the face value of the dice
    private Random rand; // store rand value

    //constant variables
//    public final int MAX_FACE_VALUE = 6;
//    public final int MIN_FACE_VALUE = 1;
    public final int SIDES = 6;


    //constructor
    Dice(int diceNo) {
        this.diceNo = diceNo;
        rand = new Random();
        value = 1; // assume the first face value is 1
    }

    //accessing method
    int getValue() { return value; }

    //action method
    public int roll() {
        //value = (int)(Math.random() *(MAX_FACE_VALUE - MIN_FACE_VALUE)) + MIN_FACE_VALUE;
        value = rand.nextInt(SIDES) + 1; //random from 1 to SIDES (can also use Math.random but prefer this one)
        return value;
    }

    //toString method for output
    public String toString() {
        return "Dice No." + diceNo + ": " + roll();
    }

    public static void main(String[] args) {

    }
}