/*
    Michal Jamula
    18/6/23
 */

import java.util.Random;
import java.util.Scanner;

public class RockPaperScissors {

    public static void main(String[] args) {

        while (true) {
            printMainMenu();
            int userInput = getAndVerifyMenuInput();
            switch (userInput){
                case 1:
                    playGame();
                    break;
                case 2:
                    explainRules();
                    break;
                case 3:
                    System.exit(1);
                    break;
            }
        }

    }

    static int getAndVerifyMenuInput () {
        Scanner scanner = new Scanner(System.in);
        String userOption = scanner.nextLine();
        return verifyUserInput(userOption);
    }

    static int verifyUserInput(String userInput) {
        switch (userInput.trim()) {
            case "1":
                return 1;
            case "2":
                return 2;
            case "3":
                return 3;
            default:
                System.out.println("Invalid input, terminating program");
                return 3;
        }
    }


    static void printMainMenu() {
        System.out.println("----Welcome to Rock Paper scissors----\n");
        System.out.println("To play with Computer press 1 \nTo read the rules press 2 \nTo exit press 3");
    }


    static void explainRules() {
        System.out.println("\nAfter starting the game you will be asked to pick from 3 options: Rock, Paper and Scissors");
        System.out.println("Then the computer will pick a random option");
        System.out.println("Rock beats scissors, scissors cut paper, paper covers rock, any other options are draw");
        pressEnterToContinue();
    }

    static void playGame() {

        //Get user's pick
        Scanner scanner = new Scanner(System.in);
        System.out.print("Pick - rock paper or scissors: ");
        String userChoice = scanner.nextLine();

        //get computer's pick
        String[] pcOptions = new String[]{"rock", "paper", "scissors"};
        Random random = new Random();
        String pcChoice = pcOptions[random.nextInt(pcOptions.length)];

        System.out.flush();

        //Calculate winner
        userChoice = userChoice.toLowerCase();
        if (userChoice.equals("paper") || userChoice.equals("scissors") || userChoice.equals("rock")) {

            printSelections(userChoice, pcChoice);

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
            } else {
                System.out.println("---Draw---");
            }
            pressEnterToContinue();


            //Invalid input
        } else {
            System.out.println("Invalid input detected.");
            pressEnterToContinue();
        }
    }

    static void pressEnterToContinue()
    {
        System.out.println("Press Enter key to continue...");
        try
        {
            System.in.read();
        }
        catch(Exception e)
        {}
    }


    static void printSelections (String userChoice, String pcChoice) {
        System.out.println("User selected: " + userChoice);
        System.out.println("Computer selected: " + pcChoice);
    }






}
