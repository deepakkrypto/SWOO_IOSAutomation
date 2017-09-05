package Swoo_iOS.maven;

import java.util.Random;

/**
 * Created by dvyas on 14/06/17.
 */
public class RandomUtil {

    public static String generateRandomPhoneNumber(String prefix, int digits) {
        Random rand = new Random();
        int num = (int) (rand.nextInt((int) (9 * Math.pow(10, digits-1))) + Math.pow(10, digits-1));
        return prefix + num;
    }

}
