package hexlet.code;

import hexlet.code.games.EvenGame;

public class App {
    public static void main(String[] args) {
        gamesIntroduction();

        int gameCode = Validator.numberValidator();

        switch (gameCode) {
            case 0:
                System.out.println("See you next time!");
                break;
            case 1:
                Cli.askName();
                break;
            case 2:
                String userName = Cli.askName();
                EvenGame.startEvenGame(userName);
                break;
            default:
                System.out.println("Game doesn't exist. Bye");
                break;
        }
    }

    public static void gamesIntroduction() {
        System.out.println("Please, enter the game number and press Enter.");
        System.out.println("1 - Greet");
        System.out.println("2- Even");
        System.out.println("0 - Exit");
        System.out.print("Your choice: ");
    }
}
