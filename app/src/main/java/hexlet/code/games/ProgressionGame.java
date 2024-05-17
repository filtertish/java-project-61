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

    public static void startProgressionGame() {
        String gameRules = "What number is missing in the progression?";
        String[] questions = new String[Engine.ANSWERS_TO_WIN];
        String[] answers = new String[Engine.ANSWERS_TO_WIN];

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

            int[] progression = generateProgression(
                    progressionLength,
                    progressionStep,
                    progressionStartingValue
            );

            questions[i] = generateQuestion(progression, progressionMissed);
            answers[i] = "" + progression[progressionMissed];
        }

        Engine.runGame(gameRules, questions, answers);
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
