package hexlet.code.games;

import hexlet.code.Engine;
import hexlet.code.utils.Randomizer;

public class PrimeGame {
    private static final int MIN_NUMBER = 2;
    private static final int MAX_NUMBER = 100;

    public static void startPrimeGame() {
        String gameRules = "Answer 'yes' if given number is prime. Otherwise answer 'no'.";
        String[][] gameData = new String[Engine.ANSWERS_TO_WIN][2];

        for (int i = 0; i < gameData.length; i++) {
            int question = Randomizer.nextInt(MIN_NUMBER, MAX_NUMBER);
            gameData[i][0] = "" + question;
            gameData[i][1] = isPrime(question) ? "yes" : "no";
        }

        Engine.runGame(gameRules, gameData);
    }

    private static boolean isPrime(int number) {
        if (number <= 1) {
            return false;
        }

        if (number == 2 || number == 3) {
            return true;
        }

        if (number % 2 == 0 || number % 3 == 0) {
            return false;
        }

        for (int i = 5; i <= Math.sqrt(number); i += 6) {
            if (number % i == 0 || number % (i + 2) == 0) {
                return false;
            }
        }

        return true;
    }
}
