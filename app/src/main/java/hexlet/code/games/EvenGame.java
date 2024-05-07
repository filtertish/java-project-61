package hexlet.code.games;

import hexlet.code.Engine;
import hexlet.code.utils.Randomizer;

import java.util.Scanner;

public class EvenGame {
    public static final int MIN_NUMBER = 2;
    public static final int MAX_NUMBER = 100;

    public static void startEvenGame(String userName) {

        Scanner scanner = new Scanner(System.in);
        int correctAnswers = 0;

        System.out.println("Answer 'yes' if the number is even, otherwise answer 'no'.");

        while (correctAnswers < Engine.getAnswersToWin()) {
            int quizNumber = Randomizer.getRandomIntegerInRange(MIN_NUMBER, MAX_NUMBER);

            System.out.println("Question: " + quizNumber);

            System.out.print("Your answer: ");
            String userAnswer = scanner.next();
            String correctAnswer = quizNumber % 2 == 0 ? "yes" : "no";

            if (Engine.checkUserAnswerIncorrectness(userAnswer, correctAnswer, userName)) {
                return;
            }

            correctAnswers += 1;
        }

        Engine.congratulateUser(userName);
    }
}
