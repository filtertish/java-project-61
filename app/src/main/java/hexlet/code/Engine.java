package hexlet.code;

import hexlet.code.games.CalcGame;
import hexlet.code.games.EvenGame;
import hexlet.code.utils.Validator;

public class Engine {
    public static void run() {
        showGames();

        int gameCode = Validator.numberValidator();

        switch (gameCode) {
            case 0:
                System.out.println("See you next time!");
                break;
            case 1:
                Cli.askName();
                break;
            case 2:
                EvenGame.startEvenGame(Cli.askName());
                break;
            case 3:
                CalcGame.startCalcGame(Cli.askName());
                break;
            default:
                System.out.println("Game doesn't exist. Bye");
                break;
        }
    }

    private static void showGames() {
        System.out.println("Please, enter the game number and press Enter.");
        System.out.println("1 - Greet");
        System.out.println("2- Even");
        System.out.println("3 - Calc");
        System.out.println("0 - Exit");
        System.out.print("Your choice: ");
    }

    public static <T> boolean checkUserAnswerIncorrectness(T userAnswer, T correctAnswer) {
        if (!userAnswer.equals(correctAnswer)) {
            String outputMessage = "'" + userAnswer + "' is wrong answer ;(. ";
            outputMessage += "Correct answer was '" + correctAnswer + "'";
            System.out.println(outputMessage);
            System.out.println("Let's try again!");
            return true;
        }

        System.out.println("Correct!");
        return false;
    }

    public static void congratulateUser(String userName) {
        System.out.println("Congratulations, " + userName);
        System.out.println("See you next time!");
    }
}
