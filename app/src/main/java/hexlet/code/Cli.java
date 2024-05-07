package hexlet.code;

import java.util.Scanner;

public class Cli {
    public static String askName(boolean exclamation) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("May I have your name? ");
        String userName = scanner.next();
        System.out.println("Hello, " + userName + (exclamation ? "!" : ""));

        return userName;
    }
}
