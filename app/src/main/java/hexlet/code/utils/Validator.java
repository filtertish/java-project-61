package hexlet.code.utils;

import java.util.Scanner;

public class Validator {
    public static int numberValidator() {
        Scanner scanner = new Scanner(System.in);
        Integer value = null;

        do {
            String answer = scanner.next();

            try {
                value = Integer.parseInt(answer);
            } catch (NumberFormatException error) {
                System.out.println("Incorrect input, try another one");
            }
        }
        while (value == null);

        return value;
    }
}
