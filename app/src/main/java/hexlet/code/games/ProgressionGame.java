package hexlet.code.games;

import hexlet.code.Engine;
import hexlet.code.utils.Randomizer;

public class ProgressionGame {
    public static final int MIN_PROGRESSION_LENGTH_VALUE = 5;
    public static final int MAX_PROGRESSION_LENGTH_VALUE = 11;
    public static final int MIN_STARTING_VALUE = 1;
    public static final int MAX_STARTING_VALUE = 100;
    public static final int MIN_PROGRESSION_STEP_VALUE = 2;
    public static final int MAX_PROGRESSION_STEP_VALUE = 10;

    public static void startProgressionGame(String userName) {
        String gameRules = "What number is missing in the progression?";
        String[] questions = new String[Engine.getAnswersToWin()];
        String[] answers = new String[Engine.getAnswersToWin()];

        for (int i = 0; i < questions.length; i++) {
            int progressionLength = Randomizer.getRandomIntegerInRange(
                    MIN_PROGRESSION_LENGTH_VALUE,
                    MAX_PROGRESSION_LENGTH_VALUE
            );

            int progressionMissed = Randomizer.getRandomIntegerInRange(
                    0,
                    progressionLength
            );

            int progressionStartingValue = Randomizer.getRandomIntegerInRange(
                    MIN_STARTING_VALUE,
                    MAX_STARTING_VALUE
            );

            int progressionStep = Randomizer.getRandomIntegerInRange(
                    MIN_PROGRESSION_STEP_VALUE,
                    MAX_PROGRESSION_STEP_VALUE
            );

            questions[i] = generateProgression(
                    progressionLength,
                    progressionStep,
                    progressionStartingValue,
                    progressionMissed
            );

            answers[i] = (progressionStartingValue + progressionStep * (progressionMissed)) + "";
        }

        Engine.runGame(userName, gameRules, questions, answers);
    }

    private static String generateProgression(int length, int step, int starting, int missing) {
        var progression = new StringBuilder();

        for (int i = 0; i < length; i++) {
            if (i == missing) {
                progression.append("..");
                progression.append(" ");
                continue;
            }

            progression.append(starting + step * i);
            progression.append(" ");
        }

        return progression.toString();
    }
}
