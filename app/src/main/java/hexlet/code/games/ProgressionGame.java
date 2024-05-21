package hexlet.code.games;

import hexlet.code.Engine;
import hexlet.code.utils.Randomizer;

public class ProgressionGame {
    public static final int MIN_PROGRESSION_LENGTH = 5;
    public static final int MAX_PROGRESSION_LENGTH = 11;
    public static final int MIN_STARTING = 1;
    public static final int MAX_STARTING = 100;
    public static final int MIN_PROGRESSION_STEP = 2;
    public static final int MAX_PROGRESSION_STEP = 10;

    public static void startProgressionGame() {
        String[][] gameData = new String[Engine.ANSWERS_TO_WIN][2];

        for (int i = 0; i < gameData.length; i++) {
            int progressionLength = Randomizer.nextInt(MIN_PROGRESSION_LENGTH, MAX_PROGRESSION_LENGTH);
            int progressionMissed = Randomizer.nextInt(0, progressionLength);
            int progressionStartingValue = Randomizer.nextInt(MIN_STARTING, MAX_STARTING);
            int progressionStep = Randomizer.nextInt(MIN_PROGRESSION_STEP, MAX_PROGRESSION_STEP);

            int[] progression = generateProgression(progressionLength, progressionStep, progressionStartingValue);

            gameData[i][0] = generateQuestion(progression, progressionMissed);
            gameData[i][1] = "" + progression[progressionMissed];
        }

        Engine.runGame("What number is missing in the progression?", gameData);
    }

    private static int[] generateProgression(int length, int step, int starting) {
        var progression = new int[length];

        for (int i = 0; i < length; i++) {
            progression[i] = starting + step * i;
        }

        return progression;
    }

    private static String generateQuestion(int[] progression, int missing) {
        var question = new StringBuilder();

        for (int i = 0; i < progression.length; i++) {
            if (i == missing) {
                question.append("..");
                question.append(" ");
                continue;
            }

            question.append(progression[i]);
            question.append(" ");
        }

        return question.toString();
    }
}
