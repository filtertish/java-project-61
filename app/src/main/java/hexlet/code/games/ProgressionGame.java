package hexlet.code.games;

import hexlet.code.Engine;
import hexlet.code.utils.Randomizer;
import hexlet.code.utils.Validator;

public class ProgressionGame {
    public static final int MIN_PROGRESSION_LENGTH_VALUE = 5;
    public static final int MAX_PROGRESSION_LENGTH_VALUE = 11;
    public static final int MIN_STARTING_VALUE = 1;
    public static final int MAX_STARTING_VALUE = 100;
    public static final int MIN_PROGRESSION_STEP_VALUE = 2;
    public static final int MAX_PROGRESSION_STEP_VALUE = 10;

    public static void startProgressionGame(String userName) {
        int correctAnswers = 0;

        System.out.println("What number is missing in the progression?");

        while (correctAnswers < Engine.getAnswersToWin()) {
            int progressionLength = Randomizer
                    .getRandomIntegerInRange(MIN_PROGRESSION_LENGTH_VALUE, MAX_PROGRESSION_LENGTH_VALUE);
            int progressionStart = Randomizer
                    .getRandomIntegerInRange(MIN_STARTING_VALUE, MAX_STARTING_VALUE);
            int progressionStep = Randomizer
                    .getRandomIntegerInRange(MIN_PROGRESSION_STEP_VALUE, MAX_PROGRESSION_STEP_VALUE);
            int progressionMissedPosition = Randomizer
                    .getRandomIntegerInRange(MIN_STARTING_VALUE, progressionLength);
            int progressionMissed = 0;

            StringBuilder progression = new StringBuilder();

            for (int i = 1; i < progressionLength + 1; i++) {
                if (i == progressionMissedPosition) {
                    progressionMissed = progressionStart + progressionStep * i;
                    progression.append("..");
                    progression.append(" ");
                    continue;
                }

                progression.append(progressionStart + progressionStep * i);
                progression.append(" ");
            }

            System.out.println("Question: " + progression);

            System.out.print("Your answer: ");
            int userAnswer = Validator.numberValidator();

            if (Engine.checkUserAnswerIncorrectness(userAnswer, progressionMissed, userName)) {
                return;
            }

            correctAnswers += 1;
        }

        Engine.congratulateUser(userName);
    }
}
