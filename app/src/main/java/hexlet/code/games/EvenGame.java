package hexlet.code.games;

import hexlet.code.Engine;
import hexlet.code.utils.Randomizer;

public class EvenGame {
    private static final int MIN_NUMBER = 2;
    private static final int MAX_NUMBER = 100;

    public static void startEvenGame() {
        String gameRules = "Answer 'yes' if the number is even, otherwise answer 'no'.";
        String[] questions = new String[Engine.ANSWERS_TO_WIN];
        String[] answers = new String[Engine.ANSWERS_TO_WIN];

        for (int i = 0; i < questions.length; i++) {
            int question = Randomizer.getRandomIntegerInRange(MIN_NUMBER, MAX_NUMBER);
            questions[i] = "" + question;
            answers[i] = isEven(question) ? "yes" : "no";
        }

        Engine.runGame(gameRules, questions, answers);
    }

    private static boolean isEven(int number) {
        return number % 2 == 0;
    }
}
