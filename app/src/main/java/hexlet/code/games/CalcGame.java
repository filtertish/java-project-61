package hexlet.code.games;

import hexlet.code.Engine;
import hexlet.code.utils.Randomizer;
import hexlet.code.utils.Validator;

public class CalcGame {
    public static final int MIN_OPERAND_NUMBER = 1;
    public static final int MAX_OPERAND_NUMBER = 50;
    public static final int MIN_MULTIPLY_OPERAND_NUMBER = 2;
    public static final int MAX_MULTIPLY_OPERAND_NUMBER = 10;
    public static final int OPERATOR_MIN_BOUND = 1;
    public static final int OPERATOR_MAX_BOUND = 4;

    public static void startCalcGame(String userName) {

        int correctAnswers = 0;

        System.out.println("What is the result of the expression?");

        while (correctAnswers < Engine.getAnswersToWin()) {
            int quizOperator = Randomizer
                    .getRandomIntegerInRange(OPERATOR_MIN_BOUND, OPERATOR_MAX_BOUND);

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

            System.out.print("Your answer: ");
            int userAnswer = Validator.numberValidator();
            int correctAnswer = calcResult(quizOperator, quizFirstOperand, quizSecondOperand);

            if (Engine.checkUserAnswerIncorrectness(userAnswer, correctAnswer, userName)) {
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
        return operator < OPERATOR_MAX_BOUND - 1
                ?
                Randomizer
                        .getRandomIntegerInRange(MIN_OPERAND_NUMBER, MAX_OPERAND_NUMBER)
                :
                Randomizer
                        .getRandomIntegerInRange(MIN_MULTIPLY_OPERAND_NUMBER, MAX_MULTIPLY_OPERAND_NUMBER);
    }

    private static int calcResult(int operator, int firstOperand, int secondOperand) {
        return switch (operator) {
            case 1 -> firstOperand + secondOperand;
            case 2 -> firstOperand - secondOperand;
            default -> firstOperand * secondOperand;
        };
    }
}
