package hexlet.code.games;

import hexlet.code.Engine;
import hexlet.code.utils.Randomizer;

public class CalcGame {
    public static final int MIN_OPERAND_NUMBER = 1;
    public static final int MAX_OPERAND_NUMBER = 50;
    public static final int MIN_MULTIPLY_OPERAND_NUMBER = 2;
    public static final int MAX_MULTIPLY_OPERAND_NUMBER = 10;
    public static final int OPERATOR_MIN_BOUND = 1;
    public static final int OPERATOR_MAX_BOUND = 4;

    public static void startCalcGame(String userName) {
        String gameRules = "What is the result of the expression?";
        String[] questions = new String[Engine.getAnswersToWin()];
        String[] answers = new String[Engine.getAnswersToWin()];

        for (int i = 0; i < questions.length; i++) {
            int operator = Randomizer.getRandomIntegerInRange(OPERATOR_MIN_BOUND, OPERATOR_MAX_BOUND);
            int firstOperand = calcOperand(operator);
            int secondOperand = calcOperand(operator);

            questions[i] = firstOperand + operatorToString(operator) + secondOperand;
            answers[i] = "" + calcResult(operator, firstOperand, secondOperand);
        }

        Engine.runGame(userName, gameRules, questions, answers);
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
