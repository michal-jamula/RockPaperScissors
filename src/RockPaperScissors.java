/*
    Michal Jamula
    19/6/23
 */

import java.util.Random;
import java.util.Scanner;

public class RockPaperScissors {

    public static void main(String[] args) {

        //Run main menu on repeat
        while (true) {
            PrintMethods.printMainMenu();
            int userInput = getAndVerifyMenuInput();
            switch (userInput){
                case 1:
                    playMainGame();
                    break;
                case 2:
                    PrintMethods.explainRules();
                    break;
                case 3:
                    System.exit(1);
                    break;
            }
        }
    }

    //gets user's menu input and verifies
    static int getAndVerifyMenuInput () {
        Scanner scanner = new Scanner(System.in);
        String userOption = scanner.nextLine();
        return verifyUserInput(userOption);
    }

    //This verifies user's input is valid
    static int verifyUserInput(String userInput) {
        switch (userInput.trim()) {
            case "1":
                return 1;
            case "2":
                return 2;
            case "3":
                return 3;
            default:
                System.out.println("Invalid input, try again\n\n");
                return 0;
        }
    }


    static void playMainGame() {

        //Get user's pick
        Scanner scanner = new Scanner(System.in);
        System.out.print("Pick - rock paper or scissors: ");
        String userChoice = scanner.nextLine();

        //get computer's pick
        String[] pcOptions = new String[]{"rock", "paper", "scissors"};
        Random random = new Random();
        String pcChoice = pcOptions[random.nextInt(pcOptions.length)];

        //Calculate and print out the winner
        calculateAndPrintWinner(userChoice, pcChoice);

    }

    static void calculateAndPrintWinner (String userChoice, String pcChoice) {

        userChoice = userChoice.toLowerCase();
        if (userChoice.equals("paper") || userChoice.equals("scissors") || userChoice.equals("rock")) {

            //Print user and PC selections
            PrintMethods.printSelections(userChoice, pcChoice);

            //User winning scenarios
            if (userChoice.equals("paper") && pcChoice.equals("rock")
                    || userChoice.equals("scissors") && pcChoice.equals("paper")
                    || userChoice.equals("rock") && pcChoice.equals("scissors")) {
                System.out.println("---User Wins---");

                //user loosing scenarios
            } else if (userChoice.equals("paper") && pcChoice.equals("scissors")
                    || userChoice.equals("scissors") && pcChoice.equals("rock")
                    || userChoice.equals("rock") && pcChoice.equals("paper")) {
                System.out.println("---Computer Wins---");
                //Drawing scenarios
            } else {
                System.out.println("---Draw---");
            }

            PrintMethods.pressEnterToContinue();
            //Invalid input by user
        } else {
            System.out.println("Invalid input detected.");
            PrintMethods.pressEnterToContinue();
        }
    }


    //Static nested class to contain simple System.out.println methods
    static class PrintMethods {
        static void printSelections(String userChoice, String pcChoice) {
            System.out.println("");
            System.out.println("User selected: " + userChoice);
            System.out.println("Computer selected: " + pcChoice);
        }

        static void pressEnterToContinue() {
            System.out.println("Press Enter key to continue...");
            try {
                System.in.read();
            } catch (Exception e) {
            }
        }

        static void printMainMenu() {
            System.out.println("----Welcome to Rock Paper scissors----");
            System.out.println("");
            System.out.println("To play with Computer press 1 \nTo read the rules press 2 \nTo exit press 3");
        }


        static void explainRules() {
            System.out.println("");
            System.out.println("After starting the game you will be asked to pick from 3 options: Rock, Paper and Scissors");
            System.out.println("Then the computer will pick a random option");
            System.out.println("Rock beats scissors, scissors cut paper, paper covers rock, any other options are draw");
            PrintMethods.pressEnterToContinue();
        }

    }

}
