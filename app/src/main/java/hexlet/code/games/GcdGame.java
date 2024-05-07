package hexlet.code.games;

import hexlet.code.Engine;
import hexlet.code.utils.Randomizer;
import hexlet.code.utils.Validator;

public class GcdGame {
    public static final int MIN_NUMBER_VALUE = 4;
    public static final int MAX_NUMBER_VALUE = 100;

    public static void startGcdGame(String userName) {
        int correctAnswers = 0;

        System.out.println("Find the greatest common divisor of given numbers.");

        while (correctAnswers < Engine.getAnswersToWin()) {
            int quizFirstNumber = Randomizer.getRandomIntegerInRange(MIN_NUMBER_VALUE, MAX_NUMBER_VALUE);
            int quizSecondNumber = Randomizer.getRandomIntegerInRange(MIN_NUMBER_VALUE, MAX_NUMBER_VALUE);

            System.out.println("Question: "
                    +
                    quizFirstNumber
                    +
                    " "
                    +
                    quizSecondNumber);

            int correctAnswer = gcd(quizFirstNumber, quizSecondNumber);

            System.out.print("Your answer: ");
            int userAnswer = Validator.numberValidator();

            if (Engine.checkUserAnswerIncorrectness(userAnswer, correctAnswer, userName)) {
                return;
            }

            correctAnswers += 1;
        }

        Engine.congratulateUser(userName);
    }

    private static int gcd(int firstNumber, int secondNumber) {
        if (secondNumber == 0) {
            return firstNumber;
        }
        return gcd(secondNumber, firstNumber % secondNumber);
    }
}
