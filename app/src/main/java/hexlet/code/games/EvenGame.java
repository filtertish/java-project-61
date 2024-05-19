package hexlet.code.games;

import hexlet.code.Engine;
import hexlet.code.utils.Randomizer;

public class EvenGame {
    private static final int MIN_NUMBER = 2;
    private static final int MAX_NUMBER = 100;

    public static void startEvenGame() {
        String gameRules = "Answer 'yes' if the number is even, otherwise answer 'no'.";
        String[][] gameData = new String[Engine.ANSWERS_TO_WIN][2];

        for (int i = 0; i < gameData.length; i++) {
            int question = Randomizer.nextInt(MIN_NUMBER, MAX_NUMBER);
            gameData[i][0] = "" + question;
            gameData[i][1] = isEven(question) ? "yes" : "no";
        }

        Engine.runGame(gameRules, gameData);
    }

    private static boolean isEven(int number) {
        return number % 2 == 0;
    }
}
