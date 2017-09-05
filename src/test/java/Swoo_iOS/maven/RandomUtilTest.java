package Swoo_iOS.maven;

import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * Created by dvyas on 14/06/17.
 */
public class RandomUtilTest {

    @Test
    public void testPhoneNumber() {
        String phoneNumber = RandomUtil.generateRandomPhoneNumber("8060", 6);
        System.out.println(phoneNumber);
        Assert.assertEquals(phoneNumber.substring(0, 4), "8060");
        Assert.assertEquals(phoneNumber.length(), 10);
    }

}
