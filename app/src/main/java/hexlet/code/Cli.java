package hexlet.code;

import java.util.Scanner;

public class Cli {
    public static String askName() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Tell me your name: ");
        String userName = scanner.next();
        System.out.println("Nice to meet you, " + userName);

        return userName;
    }
}
