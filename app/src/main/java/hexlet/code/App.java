package hexlet.code;

import hexlet.code.games.CalcGame;
import hexlet.code.games.EvenGame;
import hexlet.code.games.GcdGame;
import hexlet.code.games.PrimeGame;
import hexlet.code.games.ProgressionGame;

import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        System.out.print("""
                Please enter the game number and press Enter.
                1 - Greet
                2 - Even
                3 - Calc
                4 - GCD
                5 - Progression
                6 - Prime
                0 - Exit
                Your choice:\s"""
        );

        Scanner scanner = new Scanner(System.in);
        String gameCode = scanner.next();

        System.out.println();
        System.out.println("Welcome to the Brain Games!");

        switch (gameCode) {
            case "0":
                System.out.println("See you next time!");
                break;
            case "1":
                askName();
                break;
            case "2":
                EvenGame.startEvenGame(askName());
                break;
            case "3":
                CalcGame.startCalcGame(askName());
                break;
            case "4":
                GcdGame.startGcdGame(askName());
                break;
            case "5":
                ProgressionGame.startProgressionGame(askName());
                break;
            case "6":
                PrimeGame.startPrimeGame(askName());
                break;
            default:
                System.out.println("Game doesn't exist. Bye");
                break;
        }
    }

    public static String askName() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("May I have your name? ");
        String userName = scanner.next();
        System.out.println("Hello, " + userName +  "!");

        return userName;
    }
}
