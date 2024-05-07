package hexlet.code.games;

import hexlet.code.Engine;
import hexlet.code.utils.Randomizer;

import java.util.Scanner;

public class PrimeGame {
    public static void startPrimeGame(String userName) {
        Scanner scanner = new Scanner(System.in);
        int correctAnswers = 0;

        System.out.println("Answer 'yes' if given number is prime. Otherwise answer 'no'.");

        while (correctAnswers < Engine.getAnswersToWin()) {
            int quizNumber = Randomizer.getRandomIntegerInRange(2, 100);

            System.out.println("Question: " + quizNumber);

            String userAnswer = scanner.next();
            String correctAnswer = isEven(quizNumber) ? "yes" : "no";

            if (Engine.checkUserAnswerIncorrectness(userAnswer, correctAnswer)) {
                return;
            }

            correctAnswers += 1;
        }

        Engine.congratulateUser(userName);
    }

    private static boolean isEven(int number) {
        if (number == 1 || number == 2 || number == 3) {
            return true;
        }

        for (int i = 2; i < number / 2; i++) {
            if (number % i == 0) {
                return false;
            }
        }

        return true;
    }
}
