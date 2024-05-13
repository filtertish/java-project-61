package hexlet.code;

import hexlet.code.games.CalcGame;
import hexlet.code.games.EvenGame;
import hexlet.code.games.GcdGame;
import hexlet.code.games.PrimeGame;
import hexlet.code.games.ProgressionGame;

import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        showGames();

        Scanner scanner = new Scanner(System.in);
        String gameCode = scanner.next();

        System.out.println();
        System.out.println("Welcome to the Brain Games!");

        startGames(gameCode);
    }

    private static void showGames() {
        System.out.println("Please enter the game number and press Enter.");
        System.out.println("1 - Greet");
        System.out.println("2- Even");
        System.out.println("3 - Calc");
        System.out.println("4 - GCD");
        System.out.println("5 - Progression");
        System.out.println("6 - Prime");
        System.out.println("0 - Exit");
        System.out.print("Your choice: ");
    }

    private static void startGames(String gameCode) {
        switch (gameCode) {
            case "0":
                System.out.println("See you next time!");
                break;
            case "1":
                Cli.askName();
                break;
            case "2":
                EvenGame.startEvenGame(Cli.askName());
                break;
            case "3":
                CalcGame.startCalcGame(Cli.askName());
                break;
            case "4":
                GcdGame.startGcdGame(Cli.askName());
                break;
            case "5":
                ProgressionGame.startProgressionGame(Cli.askName());
                break;
            case "6":
                PrimeGame.startPrimeGame(Cli.askName());
                break;
            default:
                System.out.println("Game doesn't exist. Bye");
                break;
        }
    }
}
