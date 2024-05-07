package hexlet.code.games;

import hexlet.code.Engine;
import hexlet.code.utils.Randomizer;

import java.util.Scanner;

public class PrimeGame {
    public static final int MIN_NUMBER_VALUE = 2;
    public static final int MAX_NUMBER_VALUE = 100;

    public static void startPrimeGame(String userName) {
        Scanner scanner = new Scanner(System.in);
        int correctAnswers = 0;

        System.out.println("Answer 'yes' if given number is prime. Otherwise answer 'no'.");

        while (correctAnswers < Engine.getAnswersToWin()) {
            int quizNumber = Randomizer.getRandomIntegerInRange(MIN_NUMBER_VALUE, MAX_NUMBER_VALUE);

            System.out.println("Question: " + quizNumber);

            System.out.print("Your answer: ");
            String userAnswer = scanner.next();
            String correctAnswer = isEven(quizNumber) ? "yes" : "no";

            if (Engine.checkUserAnswerIncorrectness(userAnswer, correctAnswer, userName)) {
                return;
            }

            correctAnswers += 1;
        }

        Engine.congratulateUser(userName);
    }

    private static boolean isEven(int number) {
        for (int i = 2; i < number / 2; i++) {
            if (number % i == 0) {
                return false;
            }
        }

        return true;
    }
}
