package hexlet.code.games;

import java.util.Random;
import java.util.Scanner;

public class EvenGame {
    public static void startEvenGame(String userName) {
        Scanner scanner = new Scanner(System.in);
        Random randomizer = new Random();
        int correctAnswers = 0;

        System.out.println("Answer 'yes' if the number is even, otherwise answer 'no");
        while (correctAnswers < 3) {

            int quizNumber = randomizer.nextInt(2, 100);

            System.out.println("Question: " + quizNumber);

            String userAnswer = scanner.next();
            String correctAnswer = quizNumber % 2 == 0 ? "yes" : "no";

            if (userAnswer.equals(correctAnswer)) {
                correctAnswers += 1;
                System.out.println("Correct!");
            } else {
                String outputMessage = "'" + userAnswer + "' is wrong answer ;(. ";
                outputMessage += "Correct answer was '" + correctAnswer + "'";
                System.out.println(outputMessage);
                System.out.println("Let's try again!");
                return;
            }
        }

        System.out.println("Congratulations, " + userName);
        System.out.println("See you next time!");
    }
}
