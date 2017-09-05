package Swoo_iOS.maven;

import io.appium.java_client.MobileElement;
import org.openqa.selenium.*;
import org.testng.Assert;
import org.testng.AssertJUnit;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.ResourceBundle;


/**
 * Unit test for simple App.
 */
public class AppTest
        extends Base {
    private static final WebDriver WebDriverRefrence = null;
    ResourceBundle rb;
    private boolean isAlertPresent() {
        try {
            dr.switchTo().alert();
            return true;
        } catch (Exception e) {
            return false;
        }
    }
    /**
     * Create the test case
     *
     * @throws InterruptedException
     */
    @BeforeMethod(alwaysRun = true)
    public void beforeClassMethod() throws InterruptedException, IOException {
        super.beforeClassMethod();
    }

    @AfterMethod(alwaysRun = true)
    public void AfterClassMethod(ITestResult result) throws InterruptedException, IOException {
        super.AfterClassMethod(result);
    }

    @Test
    public void GuestUserBroadcast() throws InterruptedException {
        UtilityiOS utility = new UtilityiOS(dr);

        if (dr.findElements(By.id(utility.rb.getString("Splash1"))).size() != 0) {
            Assert.assertTrue(dr.findElement(By.id(utility.rb.getString("Splash1"))).getText().contains("SKIP"));
            dr.findElement(By.id(utility.rb.getString("Splash1"))).click();
            Assert.assertTrue(dr.findElement(By.id(utility.rb.getString("LoginRegister"))).getText().contains("LOGIN / REGISTER"));
            Assert.assertTrue(dr.findElement(By.id(utility.rb.getString("Splash2"))).getText().contains("Login Later"));
            dr.findElement(By.id(utility.rb.getString("Splash2"))).click();
            Thread.sleep(3000);
            Assert.assertTrue(dr.findElement(By.id(utility.rb.getString("SwooHeaderTitle"))).isDisplayed());
            Assert.assertTrue(dr.findElement(By.id(utility.rb.getString("SwooBroadcastIcon"))).isDisplayed());
            dr.findElement(By.id(utility.rb.getString("SwooBroadcastIcon"))).click();
            //Thread.sleep(4000);
            String CreateProfileMessage = dr.findElement(By.id(utility.rb.getString("CreateProfileMessage"))).getText();
            CreateProfileMessage = CreateProfileMessage.replace("\n", "");
            System.out.println(CreateProfileMessage);
            Assert.assertTrue(CreateProfileMessage.contains("PLEASE CREATE YOUR PROFILE."));
            String CreateProfileButton = dr.findElement(By.id(utility.rb.getString("LoginSignUpButton"))).getText();
            System.out.println(CreateProfileButton);
            Assert.assertTrue(CreateProfileButton.contains("LOGIN/SIGN UP"));
            System.out.println("Splash");
        } else {
            Assert.assertTrue(dr.findElement(By.id(utility.rb.getString("SwooHeaderTitle"))).isDisplayed());
            Assert.assertTrue(dr.findElement(By.id(utility.rb.getString("SwooBroadcastIcon"))).isDisplayed());
            dr.findElement(By.id(utility.rb.getString("SwooBroadcastIcon"))).click();
            //Thread.sleep(4000);
            String CreateProfileMessage = dr.findElement(By.id(utility.rb.getString("CreateProfileMessage"))).getText();
            CreateProfileMessage = CreateProfileMessage.replace("\n", "");
            System.out.println(CreateProfileMessage);
            Assert.assertTrue(CreateProfileMessage.contains("PLEASE CREATE YOUR PROFILE."));
            String CreateProfileButton = dr.findElement(By.id(utility.rb.getString("LoginSignUpButton"))).getText();
            System.out.println(CreateProfileButton);
            Assert.assertTrue(CreateProfileButton.contains("LOGIN/SIGN UP"));
        }
    }


    @Test
    public void GuestUserFollow() throws InterruptedException {
        Dimension size;
        UtilityiOS utility = new UtilityiOS(dr);


        if (dr.findElements(By.id(utility.rb.getString("Splash1"))).size() != 0) {
            Assert.assertTrue(dr.findElement(By.id(utility.rb.getString("Splash1"))).getText().contains("SKIP"));
            dr.findElement(By.id(utility.rb.getString("Splash1"))).click();
            Assert.assertTrue(dr.findElement(By.id(utility.rb.getString("LoginRegister"))).getText().contains("LOGIN / REGISTER"));
            dr.findElement(By.id(utility.rb.getString("Splash2"))).click();
            Assert.assertTrue(dr.findElement(By.id(utility.rb.getString("SwooHeaderTitle"))).isDisplayed());


            List s = dr.findElements(By.id("com.speakerswire.home.broadcastview"));
            WebElement VideoPlay = (WebElement) s.get(0);
            VideoPlay.click();
            Thread.sleep(3000);
            //dr.findElement(By.id("com.speakerswire.home.broadcastview")).click();
//			Thread.sleep(3000);
//			JavascriptExecutor js = (JavascriptExecutor) dr;
//			HashMap<String, String> swipeObject = new HashMap<String, String>();
//			swipeObject.put("direction", "right");
//			// one can also set the particular element to swipe on
//			// otherwise it will be performed on the XCUIElementTypeApplication UI element
//			// swipeObject.put("element", el.getId());
//			js.executeScript("mobile: swipe", swipeObject);
//			Thread.sleep(5000);
            JavascriptExecutor js = (JavascriptExecutor) dr;
            HashMap<String, String> scrollObject = new HashMap<String, String>();
            scrollObject.put("direction", "left");
            js.executeScript("mobile: scroll", scrollObject);
            Thread.sleep(5000);
            String FollowButton = dr.findElement(By.id(utility.rb.getString("BroadcastDetailFollowButton"))).getText();
            Assert.assertTrue(FollowButton.contains("Follow"));

            Assert.assertTrue(FollowButton.contains("Follow"));
            dr.findElement(By.id(utility.rb.getString("BroadcastDetailFollowButton"))).click();
            String CreateProfileMessage = dr.findElement(By.id(utility.rb.getString("CreateProfileMessage"))).getText();
            CreateProfileMessage = CreateProfileMessage.replace("\n", "");
            System.out.println(CreateProfileMessage);
            Assert.assertTrue(CreateProfileMessage.contains("PLEASE CREATE YOUR PROFILE."));
            String CreateProfileButton = dr.findElement(By.id(utility.rb.getString("LoginSignUpButton"))).getText();
            System.out.println(CreateProfileButton);
            Assert.assertTrue(CreateProfileButton.contains("LOGIN/SIGN UP"));

            System.out.println("Splash");
        } else {
            List s = dr.findElements(By.id("com.speakerswire.home.broadcastview"));
            WebElement VideoPlay = (WebElement) s.get(0);
            VideoPlay.click();
            //dr.findElement(By.id("com.speakerswire.home.broadcastview")).click();
            Thread.sleep(3000);
            JavascriptExecutor js = (JavascriptExecutor) dr;
            HashMap<String, String> scrollObject = new HashMap<String, String>();
            scrollObject.put("direction", "left");
            js.executeScript("mobile: scroll", scrollObject);
            Thread.sleep(5000);
//			JavascriptExecutor js = (JavascriptExecutor) dr;
//			HashMap<String, String> swipeObject = new HashMap<String, String>();
//			swipeObject.put("direction", "right");
//			// one can also set the particular element to swipe on
//			// otherwise it will be performed on the XCUIElementTypeApplication UI element
//			// swipeObject.put("element", el.getId());
//			js.executeScript("mobile: swipe", swipeObject);
//			Thread.sleep(5000);
            String FollowButton = dr.findElement(By.id(utility.rb.getString("BroadcastDetailFollowButton"))).getText();
            Assert.assertTrue(FollowButton.contains("Follow"));

            Assert.assertTrue(FollowButton.contains("Follow"));
            dr.findElement(By.id(utility.rb.getString("BroadcastDetailFollowButton"))).click();
            String CreateProfileMessage = dr.findElement(By.id(utility.rb.getString("CreateProfileMessage"))).getText();
            CreateProfileMessage = CreateProfileMessage.replace("\n", "");
            System.out.println(CreateProfileMessage);
            Assert.assertTrue(CreateProfileMessage.contains("PLEASE CREATE YOUR PROFILE."));
            String CreateProfileButton = dr.findElement(By.id(utility.rb.getString("LoginSignUpButton"))).getText();
            System.out.println(CreateProfileButton);
            Assert.assertTrue(CreateProfileButton.contains("LOGIN/SIGN UP"));

            System.out.println("Splash");
        }

    }
 
/*
@Test
public void GuestUserLike() throws InterruptedException
{
	Dimension size;
	UtilityiOS utility = new UtilityiOS(dr);
	try
	  {
	    if(dr.findElement(By.xpath(utility.rb.getString("Splash1"))).isDisplayed() )
	    {
	    	dr.findElement(By.xpath(utility.rb.getString("Splash1"))).click();
	    	dr.findElement(By.xpath(utility.rb.getString("Splash2"))).click();

			System.out.println("Splash");
	    }
	  }
	  catch(Exception e)
	  {
		  Assert.assertTrue(dr.findElement(By.id(utility.rb.getString("SwooHeaderTitle"))).isDisplayed());
		  Assert.assertTrue(dr.findElement(By.id(utility.rb.getString("SwooBroadcastIcon"))).isDisplayed());
		  //dr.findElement(By.xpath("//android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.view.View[1]/android.support.v4.view.ViewPager[1]/android.view.View[1]/android.view.View[1]/android.support.v7.widget.RecyclerView[1]/android.widget.FrameLayout[1]/android.view.View[1]/android.view.View[1]")).click();

		  dr.findElement(By.xpath(utility.rb.getString("BroadcastHome"))).click();
		  Assert.assertTrue(dr.findElement(By.id(utility.rb.getString("BroadcastLike"))).isDisplayed());
		  dr.findElement(By.id(utility.rb.getString("BroadcastLike"))).click();
		  String CreateProfileMessage = dr.findElement(By.id(utility.rb.getString("CreateProfileMessage"))).getText();
		  CreateProfileMessage = CreateProfileMessage.replace("\n", "");
		  System.out.println(CreateProfileMessage);
		  Assert.assertTrue(CreateProfileMessage.contains("Please create your profile"));
		  String CreateProfileButton = dr.findElement(By.id(utility.rb.getString("LoginSignUpButton"))).getText();
		  System.out.println(CreateProfileButton);
		  Assert.assertTrue(CreateProfileButton.contains("LOGIN/SIGN UP with mobile number"));


	  }
}*/

    @Test
    public void GuestUserBroadcastHome() throws InterruptedException {
        UtilityiOS utility = new UtilityiOS(dr);

        if (dr.findElements(By.id(utility.rb.getString("Splash1"))).size() != 0) {
            Assert.assertTrue(dr.findElement(By.id(utility.rb.getString("Splash1"))).getText().contains("SKIP"));
            dr.findElement(By.id(utility.rb.getString("Splash1"))).click();
            Assert.assertTrue(dr.findElement(By.id(utility.rb.getString("LoginRegister"))).getText().contains("LOGIN / REGISTER"));
            dr.findElement(By.id(utility.rb.getString("Splash2"))).click();
            Thread.sleep(1000);
            Assert.assertTrue(dr.findElements(By.id(utility.rb.getString("SwooHeaderTitle"))).size()!=0);
            Assert.assertTrue(dr.findElements(By.id(utility.rb.getString("SwooBroadcastIcon"))).size()!=0);
            Assert.assertTrue(dr.findElements(By.id(utility.rb.getString("BroadcastHomeDuration"))).size()!=0);
            Assert.assertTrue(dr.findElements(By.id(utility.rb.getString("BroadcastHomeChannel"))).size()!=0);
            Assert.assertTrue(dr.findElements(By.id(utility.rb.getString("BroadcastHomeDescription"))).size()!=0);
            //Assert.assertTrue(dr.findElements(By.id(utility.rb.getString("BroadcastHomeName"))).size()!=0);
            Assert.assertTrue(dr.findElements(By.id(utility.rb.getString("BroadcastHomeHandle"))).size()!=0);
            Assert.assertTrue(dr.findElements(By.id(utility.rb.getString("BroadcastHomeViews"))).size()!=0);
            Assert.assertTrue(dr.findElements(By.id(utility.rb.getString("BroadcastHomeLikes"))).size()!=0);
            Assert.assertTrue(dr.findElements(By.id(utility.rb.getString("BroadcastHomeMore"))).size()!=0);


        } else {
            Assert.assertTrue(dr.findElement(By.id(utility.rb.getString("SwooHeaderTitle"))).isDisplayed());
            Assert.assertTrue(dr.findElement(By.id(utility.rb.getString("SwooBroadcastIcon"))).isDisplayed());
            Assert.assertTrue(dr.findElement(By.id(utility.rb.getString("BroadcastHomeDuration"))).isDisplayed());
            Assert.assertTrue(dr.findElement(By.id(utility.rb.getString("BroadcastHomeChannel"))).isDisplayed());
            Assert.assertTrue(dr.findElement(By.id(utility.rb.getString("BroadcastHomeDescription"))).isDisplayed());
            //Assert.assertTrue(dr.findElement(By.id(utility.rb.getString("BroadcastHomeName"))).isDisplayed());
            Assert.assertTrue(dr.findElement(By.id(utility.rb.getString("BroadcastHomeHandle"))).isDisplayed());
            Assert.assertTrue(dr.findElement(By.id(utility.rb.getString("BroadcastHomeViews"))).isDisplayed());
            Assert.assertTrue(dr.findElement(By.id(utility.rb.getString("BroadcastHomeLikes"))).isDisplayed());
            Assert.assertTrue(dr.findElement(By.id(utility.rb.getString("BroadcastHomeMore"))).isDisplayed());
        }

    }

    @Test
    public void GuestUserBroadcastDetails() throws InterruptedException {
        Dimension size;
        UtilityiOS utility = new UtilityiOS(dr);

        if (dr.findElements(By.id(utility.rb.getString("Splash1"))).size() != 0) {
            Assert.assertTrue(dr.findElement(By.id(utility.rb.getString("Splash1"))).getText().contains("SKIP"));
            dr.findElement(By.id(utility.rb.getString("Splash1"))).click();
            Assert.assertTrue(dr.findElement(By.id(utility.rb.getString("LoginRegister"))).getText().contains("LOGIN / REGISTER"));
            dr.findElement(By.id(utility.rb.getString("Splash2"))).click();
            Thread.sleep(4000);
            Assert.assertTrue(dr.findElement(By.id(utility.rb.getString("SwooHeaderTitle"))).isDisplayed());

            List s = dr.findElements(By.id("com.speakerswire.home.broadcastview"));
            WebElement VideoPlay = (WebElement) s.get(0);
            VideoPlay.click();
            Thread.sleep(3000);
            //dr.findElement(By.id("com.speakerswire.home.broadcastview")).click();
//			Thread.sleep(3000);
//			JavascriptExecutor js = (JavascriptExecutor) dr;
//			HashMap<String, String> swipeObject = new HashMap<String, String>();
//			swipeObject.put("direction", "right");
//			// one can also set the particular element to swipe on
//			// otherwise it will be performed on the XCUIElementTypeApplication UI element
//			// swipeObject.put("element", el.getId());
//			js.executeScript("mobile: swipe", swipeObject);
//			Thread.sleep(5000);

            JavascriptExecutor js = (JavascriptExecutor) dr;
            HashMap<String, String> scrollObject = new HashMap<String, String>();
            scrollObject.put("direction", "left");
            js.executeScript("mobile: scroll", scrollObject);
            Thread.sleep(5000);
            String FollowButton = dr.findElement(By.id(utility.rb.getString("BroadcastDetailFollowButton"))).getText();
            Assert.assertTrue(FollowButton.contains("Follow"));


            //Assert.assertTrue(dr.findElement(By.id(utility.rb.getString("BroadcastDate"))).isDisplayed());
            Assert.assertTrue(dr.findElement(By.id(utility.rb.getString("BroadcastDetailUsername"))).isDisplayed());
            //Assert.assertTrue(dr.findElement(By.id(utility.rb.getString("BroadcastDetailTitle"))).isDisplayed());
            Assert.assertTrue(dr.findElement(By.id(utility.rb.getString("BroadcastDetailUserHandle"))).isDisplayed());
            //Assert.assertTrue(dr.findElement(By.id(utility.rb.getString("BroadcastDetailLocation"))).isDisplayed());
            Assert.assertTrue(dr.findElement(By.id(utility.rb.getString("BroadcastDetailTime"))).isDisplayed());
            Assert.assertTrue(dr.findElement(By.id(utility.rb.getString("BroadcastDetailChannel"))).isDisplayed());
            //Assert.assertTrue(dr.findElement(By.id(utility.rb.getString("BroadcastDetailParticipants"))).isDisplayed());
            Assert.assertTrue(dr.findElement(By.id(utility.rb.getString("BroadcastDetailLike"))).isDisplayed());
            Assert.assertTrue(dr.findElement(By.id(utility.rb.getString("BroadcastDetailViewCount"))).isDisplayed());
            Assert.assertTrue(dr.findElement(By.id(utility.rb.getString("BroadcastDetailShareIcon"))).isDisplayed());

        } else {

Thread.sleep(3000);
            List s = dr.findElements(By.id("com.speakerswire.home.broadcastview"));
            WebElement VideoPlay = (WebElement) s.get(0);
            VideoPlay.click();
            Thread.sleep(3000);
            JavascriptExecutor js = (JavascriptExecutor) dr;
            HashMap<String, String> scrollObject = new HashMap<String, String>();
            scrollObject.put("direction", "left");
            js.executeScript("mobile: scroll", scrollObject);
            Thread.sleep(5000);
            String FollowButton = dr.findElement(By.id(utility.rb.getString("BroadcastDetailFollowButton"))).getText();
            Assert.assertTrue(FollowButton.contains("Follow"));


            //Assert.assertTrue(dr.findElement(By.id(utility.rb.getString("BroadcastDate"))).isDisplayed());
            Assert.assertTrue(dr.findElement(By.id(utility.rb.getString("BroadcastDetailUsername"))).isDisplayed());
            //Assert.assertTrue(dr.findElement(By.id(utility.rb.getString("BroadcastDetailTitle"))).isDisplayed());
            Assert.assertTrue(dr.findElement(By.id(utility.rb.getString("BroadcastDetailUserHandle"))).isDisplayed());
            //Assert.assertTrue(dr.findElement(By.id(utility.rb.getString("BroadcastDetailLocation"))).isDisplayed());
            Assert.assertTrue(dr.findElement(By.id(utility.rb.getString("BroadcastDetailTime"))).isDisplayed());
            Assert.assertTrue(dr.findElement(By.id(utility.rb.getString("BroadcastDetailChannel"))).isDisplayed());
            //Assert.assertTrue(dr.findElement(By.id(utility.rb.getString("BroadcastDetailParticipants"))).isDisplayed());
            Assert.assertTrue(dr.findElement(By.id(utility.rb.getString("BroadcastDetailLike"))).isDisplayed());
            Assert.assertTrue(dr.findElement(By.id(utility.rb.getString("BroadcastDetailViewCount"))).isDisplayed());
            Assert.assertTrue(dr.findElement(By.id(utility.rb.getString("BroadcastDetailShareIcon"))).isDisplayed());
        }
    }


    @Test
    public void GuestUserBroadcastNotification() throws InterruptedException {
        UtilityiOS utility = new UtilityiOS(dr);
        if (dr.findElements(By.id(utility.rb.getString("Splash1"))).size() != 0) {
            Assert.assertTrue(dr.findElement(By.id(utility.rb.getString("Splash1"))).getText().contains("SKIP"));
            dr.findElement(By.id(utility.rb.getString("Splash1"))).click();
            Assert.assertTrue(dr.findElement(By.id(utility.rb.getString("LoginRegister"))).getText().contains("LOGIN / REGISTER"));
            dr.findElement(By.id(utility.rb.getString("Splash2"))).click();

Thread.sleep(3000);
            dr.findElement(By.id(utility.rb.getString("Notification"))).click();

            Assert.assertTrue(dr.findElement(By.id(utility.rb.getString("NotificationTitle"))).getText().contains("Notifications"));
            String NoNotifications = dr.findElement(By.id(utility.rb.getString("NoNotificationText"))).getText();
            System.out.println(NoNotifications);
            Assert.assertTrue(NoNotifications.contains("NO NOTIFICATIONS"));
            Assert.assertTrue(dr.findElement(By.id(utility.rb.getString("NoNotificationDetailText"))).getText().contains("Please expand your community"));
            Assert.assertTrue(dr.findElement(By.id(utility.rb.getString("NotificationGoHome"))).getText().contains("Back"));
            dr.findElement(By.id(utility.rb.getString("NotificationGoHome"))).click();
            Assert.assertTrue(dr.findElement(By.id(utility.rb.getString("SwooHeaderTitle"))).isDisplayed());
        } else {
            dr.findElement(By.id(utility.rb.getString("Notification"))).click();

            Assert.assertTrue(dr.findElement(By.id(utility.rb.getString("NotificationTitle"))).getText().contains("Notifications"));
            String NoNotifications = dr.findElement(By.id(utility.rb.getString("NoNotificationText"))).getText();
            System.out.println(NoNotifications);
            Assert.assertTrue(NoNotifications.contains("NO NOTIFICATIONS"));
            Assert.assertTrue(dr.findElement(By.id(utility.rb.getString("NoNotificationDetailText"))).getText().contains("Please expand your community"));
            Assert.assertTrue(dr.findElement(By.id(utility.rb.getString("NotificationGoHome"))).getText().contains("Back"));
            dr.findElement(By.id(utility.rb.getString("NotificationGoHome"))).click();
            Assert.assertTrue(dr.findElement(By.id(utility.rb.getString("SwooHeaderTitle"))).isDisplayed());
        }


    }

    @Test
    public void GuestUserCommunity() throws InterruptedException {
        Dimension size;
        UtilityiOS utility = new UtilityiOS(dr);
        if (dr.findElements(By.id(utility.rb.getString("Splash1"))).size() != 0) {
            Assert.assertTrue(dr.findElement(By.id(utility.rb.getString("Splash1"))).getText().contains("SKIP"));
            dr.findElement(By.id(utility.rb.getString("Splash1"))).click();
            Assert.assertTrue(dr.findElement(By.id(utility.rb.getString("LoginRegister"))).getText().contains("LOGIN / REGISTER"));
            dr.findElement(By.id(utility.rb.getString("Splash2"))).click();

            Thread.sleep(3000);
            JavascriptExecutor js = (JavascriptExecutor) dr;
            HashMap<String, String> scrollObject = new HashMap<String, String>();
            scrollObject.put("direction", "right");
            js.executeScript("mobile: scroll", scrollObject);
            Thread.sleep(5000);

            String CommunityHeading = dr.findElement(By.id(utility.rb.getString("CommunityHeading"))).getText();
            String CommunityNetwork = dr.findElement(By.id(utility.rb.getString("CommunityNetwork"))).getText();
            String CommunityFollowing = dr.findElement(By.id(utility.rb.getString("CommunityFollowing"))).getText();
            String CommunityFollowers = dr.findElement(By.id(utility.rb.getString("CommunityFollowers"))).getText();
            Assert.assertTrue(CommunityHeading.contains("Community"));
            Assert.assertTrue(CommunityNetwork.contains("Network"));
            Assert.assertTrue(CommunityFollowing.contains("Following"));
            Assert.assertTrue(CommunityFollowers.contains("Followers"));
            Assert.assertTrue(dr.findElement(By.id(utility.rb.getString("CommunityProfileIcon"))).isDisplayed());
            dr.findElement(By.id(utility.rb.getString("CommunityProfileIcon"))).click();
            String CreateProfileMessage = dr.findElement(By.id(utility.rb.getString("CreateProfileMessage"))).getText();
            CreateProfileMessage = CreateProfileMessage.replace("\n", "");
            System.out.println(CreateProfileMessage);
            Assert.assertTrue(CreateProfileMessage.contains("PLEASE CREATE YOUR PROFILE."));
            String CreateProfileButton = dr.findElement(By.id(utility.rb.getString("LoginSignUpButton"))).getText();
            System.out.println(CreateProfileButton);
            Assert.assertTrue(CreateProfileButton.contains("LOGIN/SIGN UP"));
        } else {
            Thread.sleep(3000);
            JavascriptExecutor js = (JavascriptExecutor) dr;
            HashMap<String, String> scrollObject = new HashMap<String, String>();
            scrollObject.put("direction", "right");
            js.executeScript("mobile: scroll", scrollObject);
            Thread.sleep(5000);


            String CommunityHeading = dr.findElement(By.id(utility.rb.getString("CommunityHeading"))).getText();
            String CommunityNetwork = dr.findElement(By.id(utility.rb.getString("CommunityNetwork"))).getText();
            String CommunityFollowing = dr.findElement(By.id(utility.rb.getString("CommunityFollowing"))).getText();
            String CommunityFollowers = dr.findElement(By.id(utility.rb.getString("CommunityFollowers"))).getText();
            Assert.assertTrue(CommunityHeading.contains("Community"));
            Assert.assertTrue(CommunityNetwork.contains("Network"));
            Assert.assertTrue(CommunityFollowing.contains("Following"));
            Assert.assertTrue(CommunityFollowers.contains("Followers"));
            Assert.assertTrue(dr.findElement(By.id(utility.rb.getString("CommunityProfileIcon"))).isDisplayed());
            dr.findElement(By.id(utility.rb.getString("CommunityProfileIcon"))).click();
            String CreateProfileMessage = dr.findElement(By.id(utility.rb.getString("CreateProfileMessage"))).getText();
            CreateProfileMessage = CreateProfileMessage.replace("\n", "");
            System.out.println(CreateProfileMessage);
            Assert.assertTrue(CreateProfileMessage.contains("PLEASE CREATE YOUR PROFILE."));
            String CreateProfileButton = dr.findElement(By.id(utility.rb.getString("LoginSignUpButton"))).getText();
            System.out.println(CreateProfileButton);
            Assert.assertTrue(CreateProfileButton.contains("LOGIN/SIGN UP"));
        }

    }

    @Test
    public void GuestUserNetworkFollowingFollowers() throws InterruptedException {
        Dimension size;
        UtilityiOS utility = new UtilityiOS(dr);
        if (dr.findElements(By.id(utility.rb.getString("Splash1"))).size() != 0) {
            Assert.assertTrue(dr.findElement(By.id(utility.rb.getString("Splash1"))).getText().contains("SKIP"));
            dr.findElement(By.id(utility.rb.getString("Splash1"))).click();
            Assert.assertTrue(dr.findElement(By.id(utility.rb.getString("LoginRegister"))).getText().contains("LOGIN / REGISTER"));
            dr.findElement(By.id(utility.rb.getString("Splash2"))).click();


	/*JavascriptExecutor js = (JavascriptExecutor) dr;
    HashMap<String, String> swipeObject = new HashMap<String, String>();
    swipeObject.put("direction", "left");
// one can also set the particular element to swipe on
// otherwise it will be performed on the XCUIElementTypeApplication UI element
// swipeObject.put("element", el.getId());
    js.executeScript("mobile: swipe", swipeObject);*/
            Thread.sleep(3000);
            JavascriptExecutor js = (JavascriptExecutor) dr;
            HashMap<String, String> scrollObject = new HashMap<String, String>();
            scrollObject.put("direction", "right");
            js.executeScript("mobile: scroll", scrollObject);
            Thread.sleep(5000);


            dr.findElement(By.id(utility.rb.getString("CommunityNetwork"))).click();
            String CreateProfileMessage = dr.findElement(By.id(utility.rb.getString("CreateProfileMessage"))).getText();
            CreateProfileMessage = CreateProfileMessage.replace("\n", "");
            System.out.println(CreateProfileMessage);
            Assert.assertTrue(CreateProfileMessage.contains("PLEASE CREATE YOUR PROFILE."));
            String CreateProfileButton = dr.findElement(By.id(utility.rb.getString("LoginSignUpButton"))).getText();
            Assert.assertTrue(CreateProfileButton.contains("LOGIN/SIGN UP"));
            dr.findElement(By.id(utility.rb.getString("Close"))).click();
            dr.findElement(By.id(utility.rb.getString("CommunityFollowing"))).click();

            Assert.assertTrue(CreateProfileMessage.contains("PLEASE CREATE YOUR PROFILE."));
            Assert.assertTrue(CreateProfileButton.contains("LOGIN/SIGN UP"));
            dr.findElement(By.id(utility.rb.getString("Close"))).click();
            dr.findElement(By.id(utility.rb.getString("CommunityFollowers"))).click();
            Assert.assertTrue(CreateProfileMessage.contains("PLEASE CREATE YOUR PROFILE."));
            Assert.assertTrue(CreateProfileButton.contains("LOGIN/SIGN UP"));
        } else {

            Thread.sleep(3000);
            JavascriptExecutor js = (JavascriptExecutor) dr;
            HashMap<String, String> scrollObject = new HashMap<String, String>();
            scrollObject.put("direction", "right");
            js.executeScript("mobile: scroll", scrollObject);
            Thread.sleep(5000);


            dr.findElement(By.id(utility.rb.getString("CommunityNetwork"))).click();
            String CreateProfileMessage = dr.findElement(By.id(utility.rb.getString("CreateProfileMessage"))).getText();
            CreateProfileMessage = CreateProfileMessage.replace("\n", "");
            System.out.println(CreateProfileMessage);
            Assert.assertTrue(CreateProfileMessage.contains("PLEASE CREATE YOUR PROFILE."));
            String CreateProfileButton = dr.findElement(By.id(utility.rb.getString("LoginSignUpButton"))).getText();
            Assert.assertTrue(CreateProfileButton.contains("LOGIN/SIGN UP"));
            dr.findElement(By.id(utility.rb.getString("Close"))).click();
            dr.findElement(By.id(utility.rb.getString("CommunityFollowing"))).click();

            Assert.assertTrue(CreateProfileMessage.contains("PLEASE CREATE YOUR PROFILE."));
            Assert.assertTrue(CreateProfileButton.contains("LOGIN/SIGN UP"));
            dr.findElement(By.id(utility.rb.getString("Close"))).click();
            dr.findElement(By.id(utility.rb.getString("CommunityFollowers"))).click();
            Assert.assertTrue(CreateProfileMessage.contains("PLEASE CREATE YOUR PROFILE."));
            Assert.assertTrue(CreateProfileButton.contains("LOGIN/SIGN UP"));
        }
    }

    @Test
    public void GuestUserDiscover() throws InterruptedException {
        Dimension size;
        UtilityiOS utility = new UtilityiOS(dr);
        if (dr.findElements(By.id(utility.rb.getString("Splash1"))).size() != 0) {
            Assert.assertTrue(dr.findElement(By.id(utility.rb.getString("Splash1"))).getText().contains("SKIP"));
            dr.findElement(By.id(utility.rb.getString("Splash1"))).click();
            Assert.assertTrue(dr.findElement(By.id(utility.rb.getString("LoginRegister"))).getText().contains("LOGIN / REGISTER"));
            dr.findElement(By.id(utility.rb.getString("Splash2"))).click();
            Thread.sleep(3000);

            JavascriptExecutor js = (JavascriptExecutor) dr;
            HashMap<String, String> scrollObject = new HashMap<String, String>();
            scrollObject.put("direction", "left");
            js.executeScript("mobile: scroll", scrollObject);
            Thread.sleep(5000);
            String DiscoverHeading = dr.findElement(By.id(utility.rb.getString("DiscoverHeading"))).getText();
            String DiscoverWatchLater = dr.findElement(By.id(utility.rb.getString("DiscoverWatchLater"))).getText();
            String DiscoverFollowing = dr.findElement(By.id(utility.rb.getString("DiscoverFollowing"))).getText();
            String DiscoverMyBroadcast = dr.findElement(By.id(utility.rb.getString("DiscoverMyBroadcast"))).getText();

            System.out.print(DiscoverHeading + "**  " + DiscoverWatchLater + "**   " + DiscoverFollowing + " **  " + DiscoverMyBroadcast);
            Assert.assertTrue(DiscoverHeading.contains("Discover"));
            Assert.assertTrue(DiscoverWatchLater.contains("WATCH LATER"));
            Assert.assertTrue(DiscoverFollowing.contains("FOLLOWING"));
            Assert.assertTrue(DiscoverMyBroadcast.contains("MY BROADCASTS"));
            Assert.assertTrue(dr.findElement(By.id(utility.rb.getString("DiscoverSearchIcon"))).isDisplayed());
        } else {
            Thread.sleep(3000);

            JavascriptExecutor js = (JavascriptExecutor) dr;
            HashMap<String, String> scrollObject = new HashMap<String, String>();
            scrollObject.put("direction", "left");
            js.executeScript("mobile: scroll", scrollObject);
            Thread.sleep(5000);
            String DiscoverHeading = dr.findElement(By.id(utility.rb.getString("DiscoverHeading"))).getText();
            String DiscoverWatchLater = dr.findElement(By.id(utility.rb.getString("DiscoverWatchLater"))).getText();
            String DiscoverFollowing = dr.findElement(By.id(utility.rb.getString("DiscoverFollowing"))).getText();
            String DiscoverMyBroadcast = dr.findElement(By.id(utility.rb.getString("DiscoverMyBroadcast"))).getText();

            System.out.print(DiscoverHeading + "**  " + DiscoverWatchLater + "**   " + DiscoverFollowing + " **  " + DiscoverMyBroadcast);
            Assert.assertTrue(DiscoverHeading.contains("Discover"));
            Assert.assertTrue(DiscoverWatchLater.contains("WATCH LATER"));
            Assert.assertTrue(DiscoverFollowing.contains("FOLLOWING"));
            Assert.assertTrue(DiscoverMyBroadcast.contains("MY BROADCASTS"));
            Assert.assertTrue(dr.findElement(By.id(utility.rb.getString("DiscoverSearchIcon"))).isDisplayed());
        }
    }

    @Test
    public void GuestUserWatchLaterFollowingMyBroadcast() throws InterruptedException {
        Dimension size;
        UtilityiOS utility = new UtilityiOS(dr);
        if (dr.findElements(By.id(utility.rb.getString("Splash1"))).size() != 0) {
            Assert.assertTrue(dr.findElement(By.id(utility.rb.getString("Splash1"))).getText().contains("SKIP"));
            dr.findElement(By.id(utility.rb.getString("Splash1"))).click();
            Assert.assertTrue(dr.findElement(By.id(utility.rb.getString("LoginRegister"))).getText().contains("LOGIN / REGISTER"));
            dr.findElement(By.id(utility.rb.getString("Splash2"))).click();
            Thread.sleep(3000);
            Assert.assertTrue(dr.findElement(By.id(utility.rb.getString("SwooHeaderTitle"))).isDisplayed());
            Assert.assertTrue(dr.findElement(By.id(utility.rb.getString("SwooBroadcastIcon"))).isDisplayed());
            JavascriptExecutor js = (JavascriptExecutor) dr;
            HashMap<String, String> scrollObject = new HashMap<String, String>();
            scrollObject.put("direction", "left");
            js.executeScript("mobile: scroll", scrollObject);
            Thread.sleep(5000);
            dr.findElement(By.id(utility.rb.getString("DiscoverWatchLater"))).click();
            String CreateProfileMessage = dr.findElement(By.id(utility.rb.getString("CreateProfileMessage"))).getText();
            CreateProfileMessage = CreateProfileMessage.replace("\n", "");
            Assert.assertTrue(CreateProfileMessage.contains("PLEASE CREATE YOUR PROFILE."));
            String CreateProfileButton = dr.findElement(By.id(utility.rb.getString("LoginSignUpButton"))).getText();
            Assert.assertTrue(CreateProfileButton.contains("LOGIN/SIGN UP"));
            dr.findElement(By.id(utility.rb.getString("Close"))).click();
            Thread.sleep(2000);
            dr.findElement(By.id(utility.rb.getString("DiscoverFollowing"))).click();
            Assert.assertTrue(CreateProfileMessage.contains("PLEASE CREATE YOUR PROFILE."));
            Assert.assertTrue(CreateProfileButton.contains("LOGIN/SIGN UP"));
            dr.findElement(By.id(utility.rb.getString("Close"))).click();
            Thread.sleep(2000);
            dr.findElement(By.id(utility.rb.getString("DiscoverMyBroadcast"))).click();
            Assert.assertTrue(CreateProfileMessage.contains("PLEASE CREATE YOUR PROFILE."));
            Assert.assertTrue(CreateProfileButton.contains("LOGIN/SIGN UP"));
        } else {
            Thread.sleep(3000);

            JavascriptExecutor js = (JavascriptExecutor) dr;
            HashMap<String, String> scrollObject = new HashMap<String, String>();
            scrollObject.put("direction", "left");
            js.executeScript("mobile: scroll", scrollObject);
            Thread.sleep(5000);
            dr.findElement(By.id(utility.rb.getString("DiscoverWatchLater"))).click();
            String CreateProfileMessage = dr.findElement(By.id(utility.rb.getString("CreateProfileMessage"))).getText();
            CreateProfileMessage = CreateProfileMessage.replace("\n", "");
            Assert.assertTrue(CreateProfileMessage.contains("PLEASE CREATE YOUR PROFILE."));
            String CreateProfileButton = dr.findElement(By.id(utility.rb.getString("LoginSignUpButton"))).getText();
            Assert.assertTrue(CreateProfileButton.contains("LOGIN/SIGN UP"));
            dr.findElement(By.id(utility.rb.getString("Close"))).click();
            Thread.sleep(2000);
            dr.findElement(By.id(utility.rb.getString("DiscoverFollowing"))).click();
            Assert.assertTrue(CreateProfileMessage.contains("PLEASE CREATE YOUR PROFILE."));
            Assert.assertTrue(CreateProfileButton.contains("LOGIN/SIGN UP"));
            dr.findElement(By.id(utility.rb.getString("Close"))).click();
            Thread.sleep(2000);
            dr.findElement(By.id(utility.rb.getString("DiscoverMyBroadcast"))).click();
            Assert.assertTrue(CreateProfileMessage.contains("PLEASE CREATE YOUR PROFILE."));
            Assert.assertTrue(CreateProfileButton.contains("LOGIN/SIGN UP"));
        }
    }


    @Test
    public void GuestUserDiscoverSearch() throws InterruptedException {
        Dimension size;
        UtilityiOS utility = new UtilityiOS(dr);
        if (dr.findElements(By.id(utility.rb.getString("Splash1"))).size() != 0) {
            Assert.assertTrue(dr.findElement(By.id(utility.rb.getString("Splash1"))).getText().contains("SKIP"));
            dr.findElement(By.id(utility.rb.getString("Splash1"))).click();
            Assert.assertTrue(dr.findElement(By.id(utility.rb.getString("LoginRegister"))).getText().contains("LOGIN / REGISTER"));
            dr.findElement(By.id(utility.rb.getString("Splash2"))).click();
            Thread.sleep(3000);

            JavascriptExecutor js = (JavascriptExecutor) dr;
            HashMap<String, String> scrollObject = new HashMap<String, String>();
            scrollObject.put("direction", "left");
            js.executeScript("mobile: scroll", scrollObject);
            Thread.sleep(5000);
            dr.findElement(By.id(utility.rb.getString("DiscoverSearchIcon"))).click();
            Thread.sleep(3000);
            dr.findElement(By.className("XCUIElementTypeSearchField")).sendKeys("test");
            dr.hideKeyboard("Search");


            Thread.sleep(3000);
            Assert.assertTrue(dr.findElement(By.id("swLogo.png")).isDisplayed());
            List stuff = new ArrayList();
            stuff = dr.findElements(By.id(utility.rb.getString("BroadcastHome")));
            Assert.assertTrue(stuff.size() > 0);
        } else {
            Thread.sleep(3000);

            JavascriptExecutor js = (JavascriptExecutor) dr;
            HashMap<String, String> scrollObject = new HashMap<String, String>();
            scrollObject.put("direction", "left");
            js.executeScript("mobile: scroll", scrollObject);
            Thread.sleep(5000);
            dr.findElement(By.id(utility.rb.getString("DiscoverSearchIcon"))).click();
            Thread.sleep(3000);
            dr.findElement(By.className("XCUIElementTypeSearchField")).sendKeys("test");
            dr.hideKeyboard("Search");


            Thread.sleep(3000);
            Assert.assertTrue(dr.findElement(By.id("swLogo")).isDisplayed());
            List stuff = new ArrayList();
            stuff = dr.findElements(By.id(utility.rb.getString("BroadcastHome")));
            Assert.assertTrue(stuff.size() > 0);
        }
    }
    @Test
    public void LoginButtonFunctionality() throws InterruptedException {
        Dimension size;
        UtilityiOS utility = new UtilityiOS(dr);

        if (dr.findElements(By.id(utility.rb.getString("Splash1"))).size() != 0) {
            dr.findElement(By.id(utility.rb.getString("Splash1"))).click();
            dr.findElement(By.id(utility.rb.getString("LoginRegister"))).click();
            MobileElement PhoneNumberTextMessage = (MobileElement) dr.findElementByXPath("//XCUIElementTypeStaticText[@name=\"What’s your phone number ?\"]");
            String PhoneNumberUserMessage=PhoneNumberTextMessage.getText();
            String PhoneNumberTermsCondition = dr.findElement(By.id(utility.rb.getString("LoginRegisterTermsCondition"))).getText();
            System.out.print(PhoneNumberUserMessage + "and " + PhoneNumberTermsCondition);
            Thread.sleep(4000);
            Assert.assertTrue(dr.findElement(By.id(utility.rb.getString("LoginRegisterCountryCode"))).isDisplayed());
            Assert.assertTrue(PhoneNumberUserMessage.contains("What’s your phone number ?"));
            Assert.assertTrue(PhoneNumberTermsCondition.contains("by signing up you agree to our T&C and Privacy Policy"));
            dr.findElement(By.id(utility.rb.getString("LoginRegisterCountryCode"))).click();
            Thread.sleep(3000);
            dr.findElement(By.id(utility.rb.getString("LoginRegisterCountryCodeSearch"))).sendKeys("United Arab Emirates");
            dr.findElement(By.id(utility.rb.getString("LoginRegisterCountryName"))).click();
            String SelectedCountryName = dr.findElement(By.id(utility.rb.getString("LoginregisterCountryLabel"))).getText();
            System.out.print(SelectedCountryName);
            Assert.assertTrue(SelectedCountryName.contains("United Arab Emirates (+971)"));


            System.out.println("Splash");
        } else {
            dr.findElement(By.id(utility.rb.getString("SwooBroadcastIcon"))).click();
            //Thread.sleep(4000);
            String CreateProfileMessage = dr.findElement(By.id(utility.rb.getString("CreateProfileMessage"))).getText();
            CreateProfileMessage = CreateProfileMessage.replace("\n", "");
            System.out.println(CreateProfileMessage);
            Assert.assertTrue(CreateProfileMessage.contains("PLEASE CREATE YOUR PROFILE."));
            String CreateProfileButton = dr.findElement(By.id(utility.rb.getString("LoginSignUpButton"))).getText();
            System.out.println(CreateProfileButton);
            Assert.assertTrue(CreateProfileButton.contains("LOGIN/SIGN UP"));
            dr.findElement(By.id(utility.rb.getString("LoginSignUpButton"))).click();
            MobileElement PhoneNumberTextMessage = (MobileElement) dr.findElementByXPath("//XCUIElementTypeStaticText[@name=\"What’s your phone number ?\"]");
            String PhoneNumberUserMessage=PhoneNumberTextMessage.getText();
            String PhoneNumberTermsCondition = dr.findElement(By.id(utility.rb.getString("LoginRegisterTermsCondition"))).getText();
            System.out.print(PhoneNumberUserMessage + "and " + PhoneNumberTermsCondition);
            Thread.sleep(4000);
            Assert.assertTrue(dr.findElement(By.id(utility.rb.getString("LoginRegisterCountryCode"))).isDisplayed());
            Assert.assertTrue(PhoneNumberUserMessage.contains("What’s your phone number ?"));
            Assert.assertTrue(PhoneNumberTermsCondition.contains("by signing up you agree to our T&C and Privacy Policy"));
            dr.findElement(By.id(utility.rb.getString("LoginRegisterCountryCode"))).click();
            Thread.sleep(3000);
            dr.findElement(By.id(utility.rb.getString("LoginRegisterCountryCodeSearch"))).sendKeys("United Arab Emirates");
            dr.findElement(By.id(utility.rb.getString("LoginRegisterCountryName"))).click();
            String SelectedCountryName = dr.findElement(By.id(utility.rb.getString("LoginregisterCountryLabel"))).getText();
            System.out.print(SelectedCountryName);
            Assert.assertTrue(SelectedCountryName.contains("United Arab Emirates (+971)"));

        }
    }

    @Test
    public void LoginValidPhoneValidOTP() throws InterruptedException {
        Dimension size;
        UtilityiOS utility = new UtilityiOS(dr);

        if (dr.findElements(By.id(utility.rb.getString("Splash1"))).size() != 0) {
            dr.findElement(By.id(utility.rb.getString("Splash1"))).click();
            dr.findElement(By.id(utility.rb.getString("LoginRegister"))).click();
            Thread.sleep(2000);
            MobileElement PhoneNumberTextMessage = (MobileElement) dr.findElementByXPath("//XCUIElementTypeStaticText[@name=\"What’s your phone number ?\"]");
            dr.findElement(By.id(utility.rb.getString("LoginRegisterCountryCode"))).click();
            Thread.sleep(3000);
            dr.findElement(By.id(utility.rb.getString("LoginRegisterCountryCodeSearch"))).sendKeys("United Arab Emirates");
            dr.findElement(By.id(utility.rb.getString("LoginRegisterCountryName"))).click();
            dr.findElement(By.id(utility.rb.getString("LoginRegisterPhoneNumber"))).sendKeys("0000000000");
            MobileElement LoginConfirtmationCodeButton = (MobileElement) dr.findElementByXPath(utility.rb.getString("LoginSendConfirmationCode"));

            String ConfirmationCodeButton = LoginConfirtmationCodeButton.getText();
            LoginConfirtmationCodeButton.click();
            MobileElement el2 = (MobileElement) dr.findElementByXPath(utility.rb.getString("LoginInvalidPhoneNumberTextMessage"));
            String InvalidPhoneNumbertext = el2.getText();
            Assert.assertTrue(InvalidPhoneNumbertext.contains("*Please provide a valid phone number"));
            Assert.assertTrue(ConfirmationCodeButton.contains("Send Confirmation Code"));
            dr.findElement(By.id(utility.rb.getString("LoginRegisterPhoneNumber"))).clear();
            dr.findElement(By.id(utility.rb.getString("LoginRegisterPhoneNumber"))).sendKeys("565394693");
            LoginConfirtmationCodeButton.click();
            Thread.sleep(3000);
            MobileElement LoginRegisterEnterCodeText = (MobileElement)dr.findElementByXPath(utility.rb.getString("LoginRegisterEnterCodeText"));

                String EnterOTPCodeText = LoginRegisterEnterCodeText.getText();
            MobileElement LoginRegisterResendOTP = (MobileElement)dr.findElementByXPath(utility.rb.getString("LoginRegisterResendOTP"));
            MobileElement LoginRegisterOTPOnCall = (MobileElement)dr.findElementByXPath(utility.rb.getString("LoginRegisterOTPOnCall"));
                String ResendOTPButton = LoginRegisterResendOTP.getText();
                String OTPOnCallButton = LoginRegisterOTPOnCall.getText();
                Assert.assertTrue(EnterOTPCodeText.contains("Enter Code"));

                Assert.assertTrue(ResendOTPButton.contains("Resend"));
                Assert.assertTrue(OTPOnCallButton.contains("OTP on call"));
            MobileElement EnterOTPCodeTextField = (MobileElement)dr.findElementByXPath(utility.rb.getString("LoginRegisterEnterOTP"));
            EnterOTPCodeTextField.sendKeys("1111");
            MobileElement LoginRegisterInvalidOTP = (MobileElement)dr.findElementByXPath(utility.rb.getString("LoginRegisterInvalidOTP"));
                String InvalidOTPText = LoginRegisterInvalidOTP.getText();
                System.out.print(InvalidOTPText);
                Assert.assertTrue(InvalidOTPText.contains("*OTP invalid"));
                EnterOTPCodeTextField.sendKeys("6789");
                Thread.sleep(5000);
            if(isAlertPresent()) {
                dr.switchTo().alert().accept();
            }
            Assert.assertTrue(dr.findElement(By.id("swLogo.png")).isDisplayed());

        }
    }


    @Test
    public void MemberUserBroadcast() throws InterruptedException {
        Dimension size;
        UtilityiOS utility = new UtilityiOS(dr);

        if (dr.findElement(By.id(utility.rb.getString("Splash1"))).isDisplayed()) {
            dr.findElement(By.id(utility.rb.getString("Splash1"))).click();
            dr.findElement(By.id(utility.rb.getString("LoginRegister"))).click();
            Thread.sleep(3000);
            dr.findElement(By.id(utility.rb.getString("LoginRegisterCountryCode"))).click();
            Thread.sleep(3000);
            dr.findElement(By.id(utility.rb.getString("LoginRegisterCountryCodeSearch"))).sendKeys("India");
            MobileElement CountrySelect = (MobileElement) dr.findElementByXPath(utility.rb.getString("SelectCountryFromList"));
            CountrySelect.click();
            String Phonenumber = RandomUtil.generateRandomPhoneNumber("8060", 6);
            String Username = RandomUtil.generateRandomPhoneNumber("abcd", 6);
            dr.findElement(By.id(utility.rb.getString("LoginRegisterPhoneNumber"))).sendKeys(Phonenumber);
            Thread.sleep(3000);
            MobileElement LoginConfirtmationCodeButton = (MobileElement) dr.findElementByXPath(utility.rb.getString("LoginSendConfirmationCode"));
            LoginConfirtmationCodeButton.click();
            MobileElement EnterOTPCodeTextField = (MobileElement)dr.findElementByXPath(utility.rb.getString("LoginRegisterEnterOTP"));
            EnterOTPCodeTextField.sendKeys("1234");
            if (dr.findElements(By.id(utility.rb.getString("BroadcastContinueButton"))).size()!=0) {
                dr.findElement(By.id(utility.rb.getString("BroadcastContinueButton"))).click();
                dr.findElement(By.id(utility.rb.getString("BroadcastAllowButton"))).click();
                dr.findElement(By.id(utility.rb.getString("LoginRegisterEnterOTP"))).sendKeys("1234");
                dr.findElement(By.id(utility.rb.getString("BroadcastAllowButton"))).click();
                dr.findElement(By.id(utility.rb.getString("SwooBroadcastIcon"))).click();
                String EnterInviteCodeButton = dr.findElement(By.id(utility.rb.getString("BroadcastEnterinviteCode"))).getText();
                String AskForInviteCodeButton = dr.findElement(By.id(utility.rb.getString("BroadcastAskForInvite"))).getText();
                String InviteCodelabel = dr.findElement(By.id(utility.rb.getString("BroadcastInviteLabel"))).getText();

                System.out.print(EnterInviteCodeButton + "and" + AskForInviteCodeButton + "and" + InviteCodelabel);
                Assert.assertTrue(EnterInviteCodeButton.contains("enter invite code"));
                Assert.assertTrue(AskForInviteCodeButton.contains("Ask For Invite"));
                Assert.assertTrue(InviteCodelabel.contains("to start your first broadcast"));
            } else {
                //dr.findElement(By.id(utility.rb.getString("LoginRegisterEnterOTP"))).sendKeys("1234");
                dr.findElement(By.xpath(utility.rb.getString("LoginFullName"))).sendKeys(Username);
                dr.findElement(By.xpath(utility.rb.getString("LoginUserName"))).sendKeys(Username);
                Assert.assertTrue(dr.findElement(By.id(utility.rb.getString("LoginNewUserNextButton"))).getText().contains("Next"));
                dr.findElement(By.id(utility.rb.getString("LoginNewUserNextButton"))).click();
                dr.findElement(By.xpath(utility.rb.getString("SelectPreferencesChannelSelection"))).click();
                Assert.assertTrue(dr.findElement(By.id(utility.rb.getString("SelectPreferencesChannelDoneButton"))).getText().contains("DONE"));
                dr.findElement(By.id(utility.rb.getString("SelectPreferencesChannelDoneButton"))).click();
                Thread.sleep(3000);
                if(isAlertPresent()) {
                    dr.switchTo().alert().accept();
                }

                Assert.assertTrue(dr.findElement(By.id(utility.rb.getString("SwooHeaderTitle"))).isDisplayed());
                dr.findElement(By.id(utility.rb.getString("SwooBroadcastIcon"))).click();
                String EnterInviteCodeButton = dr.findElement(By.id(utility.rb.getString("BroadcastEnterinviteCode"))).getText();
                String AskForInviteCodeButton = dr.findElement(By.id(utility.rb.getString("BroadcastAskForInvite"))).getText();
                String InviteCodelabel = dr.findElement(By.id(utility.rb.getString("BroadcastInviteLabel"))).getText();

                System.out.print(EnterInviteCodeButton + "and" + AskForInviteCodeButton + "and" + InviteCodelabel);
                Assert.assertTrue(EnterInviteCodeButton.contains("ENTER CODE"));
                Assert.assertTrue(AskForInviteCodeButton.contains("ASK FOR INVITE"));
                Assert.assertTrue(InviteCodelabel.contains("TO START YOUR FIRST BROADCAST"));
                System.out.println("Splash");
            }
        } else {

        }
    }
/*
    @Test
    public void MemberUserBroadcastAskForIntviteFunctionality() throws InterruptedException {
        Dimension size;
        UtilityiOS utility = new UtilityiOS(dr);

        if (dr.findElement(By.id(utility.rb.getString("Splash1"))).isDisplayed()) {
            dr.findElement(By.id(utility.rb.getString("Splash1"))).click();
            dr.findElement(By.id(utility.rb.getString("LoginRegisterButtom"))).click();
            dr.findElement(By.id(utility.rb.getString("LoginRegisterCountryCode"))).click();
            dr.findElement(By.id(utility.rb.getString("LoginRegisterCountryCodeSearch"))).sendKeys("United Arab Emirates");
            dr.findElement(By.id(utility.rb.getString("LoginRegisterCountryName"))).click();
            dr.findElement(By.id(utility.rb.getString("LoginRegisterPhoneNumber"))).sendKeys("527856869");
            dr.findElement(By.id(utility.rb.getString("LoginRegisterSendConfirmationCodeButton"))).click();
            if (dr.findElement(By.id(utility.rb.getString("BroadcastContinueButton"))).isDisplayed()) {
                dr.findElement(By.id(utility.rb.getString("BroadcastContinueButton"))).click();
                dr.findElement(By.id(utility.rb.getString("BroadcastAllowButton"))).click();
                dr.findElement(By.id(utility.rb.getString("LoginRegisterEnterOTP"))).sendKeys("1234");
                dr.findElement(By.id(utility.rb.getString("BroadcastAllowButton"))).click();
                dr.findElement(By.id(utility.rb.getString("SwooBroadcastIcon"))).click();


                dr.findElement(By.id(utility.rb.getString("BroadcastAskForInvite"))).click();

                String BroadcastRequestHeader = dr.findElement(By.id(utility.rb.getString("BroadcastRequestHeader"))).getText();
                String BroadcastRequestMessage = dr.findElement(By.id(utility.rb.getString("BroadcastRequestMessage"))).getText();
                String BroadcastRequestYesButton = dr.findElement(By.id(utility.rb.getString("BroadcastRequestYesButton"))).getText();
                String BroadcastRequestLaterButton = dr.findElement(By.id(utility.rb.getString("BroadcastRequestLaterButton"))).getText();

                System.out.print(BroadcastRequestHeader + " **** " + BroadcastRequestMessage + " ***** " + BroadcastRequestYesButton + " *** " + BroadcastRequestLaterButton);
                Assert.assertTrue(BroadcastRequestHeader.contains("Broadcast request"));
                Assert.assertTrue(BroadcastRequestMessage.contains("You want to send request for broadcaster right"));
                Assert.assertTrue(BroadcastRequestYesButton.contains("Yes"));
                Assert.assertTrue(BroadcastRequestLaterButton.contains("Later"));
                dr.findElement(By.id(utility.rb.getString("BroadcastRequestLaterButton"))).click();
                String AskForInviteCodeButton = dr.findElement(By.id(utility.rb.getString("BroadcastAskForInvite"))).getText();
                Assert.assertTrue(AskForInviteCodeButton.contains("Ask For Invite"));
                dr.findElement(By.id(utility.rb.getString("BroadcastAskForInvite"))).click();
                dr.findElement(By.id(utility.rb.getString("BroadcastRequestYesButton"))).click();
                String AskForInviteCodeSent = dr.findElement(By.id(utility.rb.getString("BroadcastAskForInvite"))).getText();
                System.out.print(AskForInviteCodeSent);
                Assert.assertTrue(AskForInviteCodeSent.contains("Request Sent"));
            } else {
                dr.findElement(By.id(utility.rb.getString("LoginRegisterEnterOTP"))).sendKeys("1234");
                dr.findElement(By.id(utility.rb.getString("SwooBroadcastIcon"))).click();


                dr.findElement(By.id(utility.rb.getString("BroadcastAskForInvite"))).click();

                String BroadcastRequestHeader = dr.findElement(By.id(utility.rb.getString("BroadcastRequestHeader"))).getText();
                String BroadcastRequestMessage = dr.findElement(By.id(utility.rb.getString("BroadcastRequestMessage"))).getText();
                String BroadcastRequestYesButton = dr.findElement(By.id(utility.rb.getString("BroadcastRequestYesButton"))).getText();
                String BroadcastRequestLaterButton = dr.findElement(By.id(utility.rb.getString("BroadcastRequestLaterButton"))).getText();

                System.out.print(BroadcastRequestHeader + " **** " + BroadcastRequestMessage + " ***** " + BroadcastRequestYesButton + " *** " + BroadcastRequestLaterButton);
                Assert.assertTrue(BroadcastRequestHeader.contains("Broadcast request"));
                Assert.assertTrue(BroadcastRequestMessage.contains("You want to send request for broadcaster right"));
                Assert.assertTrue(BroadcastRequestYesButton.contains("Yes"));
                Assert.assertTrue(BroadcastRequestLaterButton.contains("Later"));
                dr.findElement(By.id(utility.rb.getString("BroadcastRequestLaterButton"))).click();
                String AskForInviteCodeButton = dr.findElement(By.id(utility.rb.getString("BroadcastAskForInvite"))).getText();
                Assert.assertTrue(AskForInviteCodeButton.contains("Ask For Invite"));
                dr.findElement(By.id(utility.rb.getString("BroadcastAskForInvite"))).click();
                dr.findElement(By.id(utility.rb.getString("BroadcastRequestYesButton"))).click();
                String AskForInviteCodeSent = dr.findElement(By.id(utility.rb.getString("BroadcastAskForInvite"))).getText();
                System.out.print(AskForInviteCodeSent);
                Assert.assertTrue(AskForInviteCodeSent.contains("Request Sent"));
            }

        } else {

        }
    }

    @Test
    public void MemberUserBroadcastVideoPlay() throws InterruptedException {
        Dimension size;
        UtilityiOS utility = new UtilityiOS(dr);
        if (dr.findElements(By.id(utility.rb.getString("Splash1"))).size() != 0) {
            dr.findElement(By.id(utility.rb.getString("Splash1"))).click();
            dr.findElement(By.id(utility.rb.getString("LoginRegisterButtom"))).click();
            dr.findElement(By.id(utility.rb.getString("LoginRegisterCountryCode"))).click();
            dr.findElement(By.id(utility.rb.getString("LoginRegisterCountryCodeSearch"))).sendKeys("United Arab Emirates");
            dr.findElement(By.id(utility.rb.getString("LoginRegisterCountryName"))).click();
            dr.findElement(By.id(utility.rb.getString("LoginRegisterPhoneNumber"))).sendKeys("527856869");
            dr.findElement(By.id(utility.rb.getString("LoginRegisterSendConfirmationCodeButton"))).click();
            if (dr.findElement(By.id(utility.rb.getString("BroadcastContinueButton"))).isDisplayed()) {
                dr.findElement(By.id(utility.rb.getString("BroadcastContinueButton"))).click();
                dr.findElement(By.id(utility.rb.getString("BroadcastAllowButton"))).click();

                dr.findElement(By.id(utility.rb.getString("LoginRegisterEnterOTP"))).sendKeys("1234");
                dr.findElement(By.id(utility.rb.getString("BroadcastAllowButton"))).click();
                dr.findElement(By.id(utility.rb.getString("BroadcastHome"))).click();
                Thread.sleep(3000);
                size = dr.manage().window().getSize();
                System.out.println(size);
                int endx = (int) (size.width * 0.90);
                int startx = (int) (size.width * 0.09);
                int starty = size.height / 2;
                dr.swipe(startx, starty, endx, starty, 500);
                Thread.sleep(5000);
                String FollowButton = dr.findElement(By.id(utility.rb.getString("FollowButton"))).getText();
                Assert.assertTrue(FollowButton.contains("Follow"));
            } else {
                dr.findElement(By.id(utility.rb.getString("LoginRegisterSendConfirmationCodeButton"))).click();
                dr.findElement(By.id(utility.rb.getString("LoginRegisterEnterOTP"))).sendKeys("1234");
                dr.findElement(By.id(utility.rb.getString("BroadcastHome"))).click();
                Thread.sleep(3000);
                size = dr.manage().window().getSize();
                System.out.println(size);
                int endx = (int) (size.width * 0.90);
                int startx = (int) (size.width * 0.09);
                int starty = size.height / 2;
                dr.swipe(startx, starty, endx, starty, 500);
                Thread.sleep(5000);
                String FollowButton = dr.findElement(By.id(utility.rb.getString("FollowButton"))).getText();
                Assert.assertTrue(FollowButton.contains("Follow"));
            }

        } else {

        }
    }

    @Test
    public void NewUserLogin() throws InterruptedException {
        Dimension size;
        UtilityiOS utility = new UtilityiOS(dr);

        if (dr.findElements(By.id(utility.rb.getString("Splash1"))).size() != 0) {


            dr.findElement(By.id(utility.rb.getString("Splash1"))).click();
            dr.findElement(By.id(utility.rb.getString("LoginRegisterButtom"))).click();

            dr.findElement(By.id(utility.rb.getString("LoginRegisterCountryCode"))).click();
            dr.findElement(By.id(utility.rb.getString("LoginRegisterCountryCodeSearch"))).sendKeys("India");
            List country = dr.findElements(By.id(utility.rb.getString("SelectCountryFromList")));
            WebElement selectcountry = (WebElement) country.get(1);
            selectcountry.click();
            String Phonenumber = RandomUtil.generateRandomPhoneNumber("8060", 6);
            String Username = RandomUtil.generateRandomPhoneNumber("abcd", 6);
            dr.findElement(By.id(utility.rb.getString("LoginRegisterPhoneNumber"))).sendKeys(Phonenumber);
            dr.findElement(By.id(utility.rb.getString("LoginRegisterSendConfirmationCodeButton"))).click();
            if (dr.findElements(By.id(utility.rb.getString("BroadcastContinueButton"))).size() != 0) {
                dr.findElement(By.id(utility.rb.getString("BroadcastContinueButton"))).click();
                dr.findElement(By.id(utility.rb.getString("BroadcastAllowButton"))).click();
                dr.findElement(By.id(utility.rb.getString("LoginRegisterEnterOTP"))).sendKeys("1234");
                Assert.assertTrue(dr.findElement(By.id(utility.rb.getString("LoginUsernameFullNameMaleprofile"))).isDisplayed());
                Assert.assertTrue(dr.findElement(By.id(utility.rb.getString("LoginUsernameFullNameFemaleprofile"))).isDisplayed());
                Assert.assertTrue(dr.findElement(By.id(utility.rb.getString("LoginUsernameFullNameScreenTextMessage"))).getText().contains("Select your display picture"));

                dr.findElement(By.id(utility.rb.getString("LoginFullName"))).sendKeys(Username);
                dr.findElement(By.id(utility.rb.getString("LoginUserName"))).sendKeys(Username);
                Assert.assertTrue(dr.findElement(By.id(utility.rb.getString("LoginNewUserNextButton"))).getText().contains("Next"));
                dr.findElement(By.id(utility.rb.getString("LoginNewUserNextButton"))).click();
                Assert.assertTrue(dr.findElement(By.id(utility.rb.getString("SelectPreferencesText"))).getText().contains("Select preferences"));
                dr.findElement(By.id(utility.rb.getString("SelectPreferencesChannelSelection"))).click();
                Assert.assertTrue(dr.findElement(By.id(utility.rb.getString("SelectPreferencesChannelDoneButton"))).getText().contains("Done"));
                dr.findElement(By.id(utility.rb.getString("SelectPreferencesChannelDoneButton"))).click();
                Thread.sleep(3000);
                if(dr.findElements(By.id(utility.rb.getString("BroadcastAllowButton"))).size()!=0)
                {
                    dr.findElement(By.id(utility.rb.getString("BroadcastAllowButton"))).click();
                    Assert.assertTrue(dr.findElement(By.id(utility.rb.getString("SwooHeaderTitle"))).isDisplayed());
                }
                else {
                    Assert.assertTrue(dr.findElement(By.id(utility.rb.getString("SwooHeaderTitle"))).isDisplayed());
                }
            } else {
                String EnterOTPCodeText = dr.findElement(By.id(utility.rb.getString("LoginRegisterEnterCodeText"))).getText();
                String DigitCodeTextMessage = dr.findElement(By.id(utility.rb.getString("LoginRegister4DigitTextMessage"))).getText();
                String ResendOTPButton = dr.findElement(By.id(utility.rb.getString("LoginRegisterResendOTP"))).getText();
                String OTPOnCallButton = dr.findElement(By.id(utility.rb.getString("LoginRegisterOTPOnCall"))).getText();
                Assert.assertTrue(EnterOTPCodeText.contains("Enter Code"));
                Assert.assertTrue(DigitCodeTextMessage.contains("We have sent you 4 digit code"));
                Assert.assertTrue(ResendOTPButton.contains("Resend OTP"));
                Assert.assertTrue(OTPOnCallButton.contains("OTP on call"));
                dr.findElement(By.id(utility.rb.getString("LoginRegisterEnterOTP"))).sendKeys("1234");
                Assert.assertTrue(dr.findElement(By.id(utility.rb.getString("LoginUsernameFullNameMaleprofile"))).isDisplayed());
                Assert.assertTrue(dr.findElement(By.id(utility.rb.getString("LoginUsernameFullNameFemaleprofile"))).isDisplayed());
                Assert.assertTrue(dr.findElement(By.id(utility.rb.getString("LoginUsernameFullNameScreenTextMessage"))).getText().contains("Select your display picture"));

                dr.findElement(By.id(utility.rb.getString("LoginFullName"))).sendKeys(Username);
                dr.findElement(By.id(utility.rb.getString("LoginUserName"))).sendKeys(Username);
                Assert.assertTrue(dr.findElement(By.id(utility.rb.getString("LoginNewUserNextButton"))).getText().contains("Next"));
                dr.findElement(By.id(utility.rb.getString("LoginNewUserNextButton"))).click();
                Assert.assertTrue(dr.findElement(By.id(utility.rb.getString("SelectPreferencesText"))).getText().contains("Select preferences"));
                dr.findElement(By.id(utility.rb.getString("SelectPreferencesChannelSelection"))).click();
                Assert.assertTrue(dr.findElement(By.id(utility.rb.getString("SelectPreferencesChannelDoneButton"))).getText().contains("Done"));
                dr.findElement(By.id(utility.rb.getString("SelectPreferencesChannelDoneButton"))).click();
                Thread.sleep(3000);
                if(dr.findElements(By.id(utility.rb.getString("BroadcastAllowButton"))).size()!=0)
                {
                    dr.findElement(By.id(utility.rb.getString("BroadcastAllowButton"))).click();
                    Assert.assertTrue(dr.findElement(By.id(utility.rb.getString("SwooHeaderTitle"))).isDisplayed());
                }
                else {
                    Assert.assertTrue(dr.findElement(By.id(utility.rb.getString("SwooHeaderTitle"))).isDisplayed());
                }
            }

            System.out.println("Splash");
        } else {

        }
    }*/

}

