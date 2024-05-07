package hexlet.code.utils;

import java.util.Random;

public class Randomizer {
    public static int getRandomIntegerInRange(int min, int max) {
        Random random = new Random();
        return random.nextInt(min, max);
    }
}
