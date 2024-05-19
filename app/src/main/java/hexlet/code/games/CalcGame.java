package hexlet.code.games;

import hexlet.code.Engine;
import hexlet.code.utils.Randomizer;

public class CalcGame {
    private static final int MIN_OPERAND_NUMBER = 1;
    private static final int MAX_OPERAND_NUMBER = 50;
    private static final int MIN_MULTIPLY_OPERAND_NUMBER = 2;
    private static final int MAX_MULTIPLY_OPERAND_NUMBER = 10;
    private static final int OPERATOR_MIN_BOUND = 0;
    private static final int OPERATOR_MAX_BOUND = 3;

    private static final String[] OPERATORS = new String[]{"+", "-", "*"};

    public static void startCalcGame() {
        String gameRules = "What is the result of the expression?";
        String[][] gameData = new String[Engine.ANSWERS_TO_WIN][2];

        for (int i = 0; i < gameData.length; i++) {
            int operatorIndex = Randomizer.nextInt(OPERATOR_MIN_BOUND, OPERATOR_MAX_BOUND);
            int firstOperand = calcOperand(operatorIndex);
            int secondOperand = calcOperand(operatorIndex);

            gameData[i][0] = firstOperand + " " + OPERATORS[operatorIndex] + " " + secondOperand;
            gameData[i][1] = "" + calcResult(OPERATORS[operatorIndex], firstOperand, secondOperand);
        }

        Engine.runGame(gameRules, gameData);
    }

    private static int calcOperand(int operator) {
        return operator < OPERATOR_MAX_BOUND - 1
                ?
                Randomizer
                        .nextInt(MIN_OPERAND_NUMBER, MAX_OPERAND_NUMBER)
                :
                Randomizer
                        .nextInt(MIN_MULTIPLY_OPERAND_NUMBER, MAX_MULTIPLY_OPERAND_NUMBER);
    }

    private static int calcResult(String operator, int firstOperand, int secondOperand) {
        return switch (operator) {
            case "+" -> firstOperand + secondOperand;
            case "-" -> firstOperand - secondOperand;
            case "*" -> firstOperand * secondOperand;
            default -> throw new RuntimeException("Unknown operator");
        };
    }
}
