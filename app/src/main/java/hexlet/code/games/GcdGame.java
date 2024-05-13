package hexlet.code.games;

import hexlet.code.Engine;
import hexlet.code.utils.Randomizer;

public class GcdGame {
    public static final int MIN_NUMBER = 4;
    public static final int MAX_NUMBER = 100;

    public static void startGcdGame(String userName) {
        String gameRules = "Find the greatest common divisor of given numbers.";
        String[] questions = new String[3];
        String[] answers = new String[3];

        for (int i = 0; i < questions.length; i++) {
            int firstNumber = Randomizer.getRandomIntegerInRange(MIN_NUMBER, MAX_NUMBER);
            int secondNumber = Randomizer.getRandomIntegerInRange(MIN_NUMBER, MAX_NUMBER);

            questions[i] = firstNumber + " " + secondNumber;
            answers[i] = "" + gcd(firstNumber, secondNumber);
        }

        Engine.runGame(userName, gameRules, questions, answers);
    }

    private static int gcd(int firstNumber, int secondNumber) {
        if (secondNumber == 0) {
            return firstNumber;
        }
        return gcd(secondNumber, firstNumber % secondNumber);
    }
}
