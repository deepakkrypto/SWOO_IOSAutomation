package Swoo_iOS.maven;


import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.sql.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ResourceBundle;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

import com.github.genium_framework.appium.support.server.AppiumServer;
import com.github.genium_framework.server.ServerArguments;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.remote.AutomationName;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.service.local.AppiumServiceBuilder;



public class Base {
	
		public	IOSDriver dr;
		public File file_read;
		 
	private static AppiumServiceBuilder service;
		
		public ExtentReports report;
		public ExtentTest logger;


		private boolean isAlertPresent() {
			try {
				dr.switchTo().alert();
				return true;
			} catch (Exception e) {
				return false;
			}
		}

		public void beforeClassMethod() throws InterruptedException, IOException
		{
		   /*
			service =new AppiumServiceBuilder().usingDriverExecutable(new File("/usr/local/bin/node")).withAppiumJS(new File("/usr/local/node_modules/appium/build/lib/main.js"));
			ServerArguments server = new ServerArguments();
			server.setArgument("--address", "127.0.0.1");
			//server.setArgument("--chromedriver-port", 9516);
			server.setArgument("--port", 4723);
			server.setArgument("--no-reset", true);
			server.setArgument("--local-timezone", true);
			
			
				if(service.build().isRunning())
				{
					System.out.println("Server is already running");
				}
				else
				{
					service.build().start();
				}
				*/

				DesiredCapabilities capabilities = new DesiredCapabilities();
			//capabilities.setCapability("bundleId", "com.kryptolabs.ios.speakerswire");
			//capabilities.setCapability("appium-version", "1.6.4");
			capabilities.setCapability("platformName", "iOS");
			capabilities.setCapability("platformVersion", "10.3.2");
			capabilities.setCapability("deviceName", "krypto iPhone");
			capabilities.setCapability("automationName", AutomationName.IOS_XCUI_TEST);
			capabilities.setCapability("realDeviceLogger", "idevicesyslog");
			capabilities.setCapability("bundleId","com.kryptolabs.ios.speakerswire");
			capabilities.setCapability("udid", "fc7db8b99c65e6e314be90323ddef968d1f10ae7");
			capabilities.setCapability("bootstrapPath", "/usr/local/lib/node_modules/appium-xcuitest-driver/WebDriverAgent");
			capabilities.setCapability("agentPath", "/usr/local/lib/node_modules/appium-xcuitest-driver/WebDriverAgent/WebDriverAgent.xcodeproj");
			capabilities.setCapability("updatedWDABundleId", "com.apple.test.WebDriverAgentRunner-Runner");
			capabilities.setCapability("app", "/Users/dvyas/Library/Developer/Xcode/DerivedData/SWOO-ctunvlokouwewacprpfspekhwhgs/Build/Products/StagingDebug-iphoneos/SWOO.app");
			capabilities.setCapability("useNewWDA", "false");
				dr = new IOSDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
				dr.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
				if(isAlertPresent()) {
					dr.switchTo().alert().accept();
				}


				
		    Thread.sleep(5000);
		    Set<String> contextNames = dr.getContextHandles();
		    System.out.println("Context View   "  + contextNames.size());
		    
		          System.out.println(contextNames);
		    Thread.sleep(10000);
		    for (String contextName : contextNames)
		    {
		        if (!contextName.equals("NATIVE_APP"))
		        {
		            dr.context(contextName);
		                    break;
		        }
		    }
	        //testdata  = ResourceBundle.getBundle("testCases/TestData");
	 }
		
		public void AfterClassMethod(ITestResult result) throws InterruptedException, IOException
		{
			/*if (result.getStatus() == ITestResult.FAILURE) {
	            logger.log(LogStatus.FAIL, result.getThrowable());
	        } else if (result.getStatus() == ITestResult.SKIP) {
	            logger.log(LogStatus.SKIP, "Test skipped " + result.getThrowable());
	        } else {
	            logger.log(LogStatus.PASS, "Test passed");
	        }
	        
			report.endTest(logger);
			
			report.flush();
			*/
			dr.quit();
		}

		
	}

	


