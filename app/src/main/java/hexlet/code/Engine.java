package hexlet.code;

import java.util.Scanner;

public class Engine {
    public static final int ANSWERS_TO_WIN = 3;

    public static void runGame(String userName, String gameRules, String[] question, String[] rightAnswers) {
        Scanner scanner = new Scanner(System.in);

        System.out.println(gameRules);

        for (int i = 0; i < ANSWERS_TO_WIN; i++) {
            System.out.println("Question: " + question[i]);

            System.out.print("Your answer: ");
            String userAnswer = scanner.next();

            if (!userAnswer.equals(rightAnswers[i])) {
                String outputMessage = "'" + userAnswer + "' is wrong answer ;(. ";
                outputMessage += "Correct answer was '" + rightAnswers[i] + "'";
                System.out.println(outputMessage);
                System.out.println("Let's try again, " + userName + "!");
                return;
            }

            System.out.println("Correct!");
        }

        System.out.println("Congratulations, " + userName + "!");
    }
}
