package hexlet.code.games;

import hexlet.code.Engine;
import hexlet.code.utils.Randomizer;

public class PrimeGame {
    private static final int MIN_NUMBER = 2;
    private static final int MAX_NUMBER = 100;

    public static void startPrimeGame() {
        String gameRules = "Answer 'yes' if given number is prime. Otherwise answer 'no'.";
        String[] questions = new String[Engine.ANSWERS_TO_WIN];
        String[] answers = new String[Engine.ANSWERS_TO_WIN];

        for (int i = 0; i < questions.length; i++) {
            int question = Randomizer.getRandomIntegerInRange(MIN_NUMBER, MAX_NUMBER);
            questions[i] = "" + question;
            answers[i] = isPrime(question) ? "yes" : "no";
        }

        Engine.runGame(gameRules, questions, answers);
    }

    private static boolean isPrime(int number) {
        for (int i = 2; i < number / 2; i++) {
            if (number % i == 0) {
                return false;
            }
        }

        return true;
    }
}
