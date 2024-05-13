package hexlet.code.games;

import hexlet.code.Engine;
import hexlet.code.utils.Randomizer;

public class EvenGame {
    public static final int MIN_NUMBER = 2;
    public static final int MAX_NUMBER = 100;

    public static void startEvenGame(String userName) {
        String gameRules = "Answer 'yes' if the number is even, otherwise answer 'no'.";
        String[] questions = new String[Engine.getAnswersToWin()];
        String[] answers = new String[Engine.getAnswersToWin()];

        for (int i = 0; i < questions.length; i++) {
            int question = Randomizer.getRandomIntegerInRange(MIN_NUMBER, MAX_NUMBER);
            questions[i] = "" + question;
            answers[i] = question % 2 == 0 ? "yes" : "no";
        }

        Engine.runGame(userName, gameRules, questions, answers);
    }
}
