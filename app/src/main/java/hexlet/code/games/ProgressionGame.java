package hexlet.code.games;

import hexlet.code.Engine;
import hexlet.code.utils.Randomizer;
import hexlet.code.utils.Validator;

public class ProgressionGame {
    public static void startProgressionGame(String userName) {
        int correctAnswers = 0;

        System.out.println("What number is missing in the progression?");

        while (correctAnswers < Engine.getAnswersToWin()) {
            int progressionLength = Randomizer.getRandomIntegerInRange(5, 11);
            int progressionStart = Randomizer.getRandomIntegerInRange(1, 100);
            int progressionStep = Randomizer.getRandomIntegerInRange(2, 10);
            int progressionMissedPosition = Randomizer.getRandomIntegerInRange(1, progressionLength);
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

            int userAnswer = Validator.numberValidator();

            if (Engine.checkUserAnswerIncorrectness(userAnswer, progressionMissed)) {
                return;
            }

            correctAnswers += 1;
        }

        Engine.congratulateUser(userName);
    }
}
