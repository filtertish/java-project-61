package hexlet.code.games;

import hexlet.code.Engine;
import hexlet.code.utils.Randomizer;

public class PrimeGame {
    private static final int MIN_NUMBER = 2;
    private static final int MAX_NUMBER = 100;

    public static void startPrimeGame() {
        String[][] gameData = new String[Engine.ANSWERS_TO_WIN][2];

        for (int i = 0; i < gameData.length; i++) {
            int question = Randomizer.nextInt(MIN_NUMBER, MAX_NUMBER);
            gameData[i][0] = "" + question;
            gameData[i][1] = isPrime(question) ? "yes" : "no";
        }

        Engine.runGame("Answer 'yes' if given number is prime. Otherwise answer 'no'.", gameData);
    }

    private static boolean isPrime(int number) {
        if (number <= 1) {
            return false;
        }

        for (int i = 2; i <= Math.sqrt(number); i++) {
            if (number % i == 0) {
                return false;
            }
        }

        return true;
    }
}
