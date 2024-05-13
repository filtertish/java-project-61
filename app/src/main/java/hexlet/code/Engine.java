package hexlet.code;

import java.util.Scanner;

public class Engine {
    private static final int ANSWERS_TO_WIN = 3;

    public static void runGame(String userName, String gameRules, String[] question, String[] rightAnswers) {
        Scanner scanner = new Scanner(System.in);

        System.out.println(gameRules);

        for (int i = 0; i < ANSWERS_TO_WIN; i++) {
            System.out.println("Question: " + question[i]);

            System.out.print("Your answer: ");
            String userAnswer = scanner.next();

            if (Engine.checkUserAnswerIncorrectness(userAnswer, rightAnswers[i], userName)) {
                return;
            }
        }

        congratulateUser(userName);
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
