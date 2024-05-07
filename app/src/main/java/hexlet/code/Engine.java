package hexlet.code;

import hexlet.code.games.CalcGame;
import hexlet.code.games.EvenGame;
import hexlet.code.games.GcdGame;
import hexlet.code.games.PrimeGame;
import hexlet.code.games.ProgressionGame;
import hexlet.code.utils.Validator;

import java.util.Map;

public class Engine {
    private static final int ANSWERS_TO_WIN = 3;
    private static final Map<Integer, String> GAME_CODES;

    static {
        GAME_CODES = Map.of(0,
                "EXIT",
                1,
                "GREET",
                2,
                "EVEN",
                3,
                "CALC",
                4,
                "GCD",
                5,
                "PROGRESSION",
                6,
                "PRIME");
    }

    public static void run() {
        showGames();

        int gameCode = Validator.numberValidator();

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

    private static void startGames(int gameCode) {
        switch (GAME_CODES.get(gameCode)) {
            case "EXIT":
                System.out.println("See you next time!");
                break;
            case "GREET":
                Cli.askName();
                break;
            case "EVEN":
                EvenGame.startEvenGame(Cli.askName());
                break;
            case "CALC":
                CalcGame.startCalcGame(Cli.askName());
                break;
            case "GCD":
                GcdGame.startGcdGame(Cli.askName());
                break;
            case "PROGRESSION":
                ProgressionGame.startProgressionGame(Cli.askName());
                break;
            case "PRIME":
                PrimeGame.startPrimeGame(Cli.askName());
                break;
            default:
                System.out.println("Game doesn't exist. Bye");
                break;
        }
    }

    public static <T> boolean checkUserAnswerIncorrectness(T userAnswer, T correctAnswer, String userName) {
        if (!userAnswer.equals(correctAnswer)) {
            String outputMessage = "'" + userAnswer + "' is wrong answer ;(. ";
            outputMessage += "Correct answer was '" + correctAnswer + "'";
            System.out.println(outputMessage);
            System.out.println("Let's try again, " + userName + "!");
            return true;
        }

        System.out.println("Correct!");
        return false;
    }

    public static void congratulateUser(String userName) {
        System.out.println("Congratulations, " + userName + "!");
    }

    public static int getAnswersToWin() {
        return ANSWERS_TO_WIN;
    }
}
