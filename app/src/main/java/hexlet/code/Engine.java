package hexlet.code;

import java.util.Scanner;

public class Engine {
    public static final int ANSWERS_TO_WIN = 3;

    public static void runGame(String gameRules, String[][] gameData) {
        String userName = askName();

        Scanner scanner = new Scanner(System.in);

        System.out.println(gameRules);

        for (int i = 0; i < ANSWERS_TO_WIN; i++) {
            System.out.println("Question: " + gameData[i][0]);

            System.out.print("Your answer: ");
            String userAnswer = scanner.next();

            if (!userAnswer.equals(gameData[i][1])) {
                System.out.printf("'%s' is wrong answer ;(. Correct answer was '%s'\n"
                        + "Let's try again, %s!%n", userAnswer, gameData[i][1], userName);
                return;
            }

            System.out.println("Correct!");
        }

        System.out.println("Congratulations, " + userName + "!");
    }

    private static String askName() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("May I have your name? ");
        String userName = scanner.next();
        System.out.println("Hello, " + userName + "!");

        return userName;
    }
}
