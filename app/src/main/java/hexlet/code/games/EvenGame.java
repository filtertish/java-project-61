package hexlet.code.games;

import hexlet.code.Engine;
import hexlet.code.utils.Randomizer;

import java.util.Scanner;

public class EvenGame {
    public static void startEvenGame(String userName) {
        Scanner scanner = new Scanner(System.in);
        int correctAnswers = 0;

        System.out.println("Answer 'yes' if the number is even, otherwise answer 'no");

        while (correctAnswers < Engine.getAnswersToWin()) {
            int quizNumber = Randomizer.getRandomIntegerInRange(2, 100);

            System.out.println("Question: " + quizNumber);

            String userAnswer = scanner.next();
            String correctAnswer = quizNumber % 2 == 0 ? "yes" : "no";

            if (Engine.checkUserAnswerIncorrectness(userAnswer, correctAnswer)) {
                return;
            }

            correctAnswers += 1;
        }

        Engine.congratulateUser(userName);
    }
}
