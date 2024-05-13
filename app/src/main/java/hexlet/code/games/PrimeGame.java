package hexlet.code.games;

import hexlet.code.Engine;
import hexlet.code.utils.Randomizer;

public class PrimeGame {
    public static final int MIN_NUMBER = 2;
    public static final int MAX_NUMBER = 100;

    public static void startPrimeGame(String userName) {
        String gameRules = "Answer 'yes' if given number is prime. Otherwise answer 'no'.";
        String[] questions = new String[3];
        String[] answers = new String[3];

        for (int i = 0; i < questions.length; i++) {
            int question = Randomizer.getRandomIntegerInRange(MIN_NUMBER, MAX_NUMBER);
            questions[i] = "" + question;
            answers[i] = isEven(question) ? "yes" : "no";
        }

        Engine.runGame(userName, gameRules, questions, answers);
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
