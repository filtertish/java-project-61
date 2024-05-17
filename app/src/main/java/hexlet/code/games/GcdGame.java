package hexlet.code.games;

import hexlet.code.Engine;
import hexlet.code.utils.Randomizer;

public class GcdGame {
    private static final int MIN_NUMBER = 4;
    private static final int MAX_NUMBER = 100;

    public static void startGcdGame() {
        String gameRules = "Find the greatest common divisor of given numbers.";
        String[] questions = new String[Engine.ANSWERS_TO_WIN];
        String[] answers = new String[Engine.ANSWERS_TO_WIN];

        for (int i = 0; i < questions.length; i++) {
            int firstNumber = Randomizer.getRandomIntegerInRange(MIN_NUMBER, MAX_NUMBER);
            int secondNumber = Randomizer.getRandomIntegerInRange(MIN_NUMBER, MAX_NUMBER);

            questions[i] = firstNumber + " " + secondNumber;
            answers[i] = "" + gcd(firstNumber, secondNumber);
        }

        Engine.runGame(gameRules, questions, answers);
    }

    private static int gcd(int firstNumber, int secondNumber) {
        if (secondNumber == 0) {
            return firstNumber;
        }
        return gcd(secondNumber, firstNumber % secondNumber);
    }
}
