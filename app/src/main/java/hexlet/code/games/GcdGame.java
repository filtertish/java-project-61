package hexlet.code.games;

import hexlet.code.Engine;
import hexlet.code.utils.Randomizer;

public class GcdGame {
    private static final int MIN_NUMBER = 4;
    private static final int MAX_NUMBER = 100;

    public static void startGcdGame() {
        String gameRules = "Find the greatest common divisor of given numbers.";
        String[][] gameData = new String[Engine.ANSWERS_TO_WIN][2];

        for (int i = 0; i < gameData.length; i++) {
            int firstNumber = Randomizer.nextInt(MIN_NUMBER, MAX_NUMBER);
            int secondNumber = Randomizer.nextInt(MIN_NUMBER, MAX_NUMBER);

            gameData[i][0] = firstNumber + " " + secondNumber;
            gameData[i][1] = "" + gcd(firstNumber, secondNumber);
        }

        Engine.runGame(gameRules, gameData);
    }

    private static int gcd(int firstNumber, int secondNumber) {
        if (secondNumber == 0) {
            return firstNumber;
        }
        return gcd(secondNumber, firstNumber % secondNumber);
    }
}
