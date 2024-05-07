package hexlet.code.games;

import hexlet.code.Engine;
import hexlet.code.utils.Randomizer;
import hexlet.code.utils.Validator;

public class CalcGame {
    public static void startCalcGame(String userName) {
        int correctAnswers = 0;

        System.out.println("What is the result of the expression?");
        while (correctAnswers < 3) {
            int quizOperator = Randomizer.getRandomIntegerInRange(1, 4);

            int quizFirstOperand = calcOperand(quizOperator);
            int quizSecondOperand = calcOperand(quizOperator);

            System.out.println("Question: "
                    +
                    quizFirstOperand
                    +
                    operatorToString(quizOperator)
                    +
                    quizSecondOperand
            );

            int userAnswer = Validator.numberValidator();
            int quizResult = calcResult(quizOperator, quizFirstOperand, quizSecondOperand);

            if (Engine.checkUserAnswerIncorrectness(userAnswer, quizResult)) {
                return;
            }

            correctAnswers += 1;
        }

        Engine.congratulateUser(userName);
    }

    private static String operatorToString(int operator) {
        return switch (operator) {
            case 1 -> " + ";
            case 2 -> " - ";
            default -> " * ";
        };
    }

    private static int calcOperand(int operator) {
        return operator < 3
                ?
                Randomizer.getRandomIntegerInRange(1, 50)
                :
                Randomizer.getRandomIntegerInRange(2, 10);
    }

    private static int calcResult(int operator, int firstOperand, int secondOperand) {
        return switch (operator) {
            case 1 -> firstOperand + secondOperand;
            case 2 -> firstOperand - secondOperand;
            default -> firstOperand * secondOperand;
        };
    }
}
