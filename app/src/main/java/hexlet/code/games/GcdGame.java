package hexlet.code.games;

import hexlet.code.Engine;
import hexlet.code.utils.Randomizer;
import hexlet.code.utils.Validator;

public class GcdGame {
    public static void startGcdGame(String userName) {
        int correctAnswers = 0;

        System.out.println("Find the greatest common divisor of given numbers.");

        while (correctAnswers < Engine.getAnswersToWin()) {
            int quizFirstNumber = Randomizer.getRandomIntegerInRange(4, 100);
            int quizSecondNumber = Randomizer.getRandomIntegerInRange(4, 100);

            System.out.println("Question: "
                    +
                    quizFirstNumber
                    +
                    " "
                    +
                    quizSecondNumber);

            int correctAnswer = gcd(quizFirstNumber, quizSecondNumber);
            int userAnswer = Validator.numberValidator();

            if (Engine.checkUserAnswerIncorrectness(userAnswer, correctAnswer)) {
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
