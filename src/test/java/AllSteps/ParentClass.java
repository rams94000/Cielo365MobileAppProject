package AllSteps;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import pages.LoginClass;

import org.apache.commons.lang.RandomStringUtils;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.BeforeTest;

import java.net.URL;

public class ParentClass {
 
	AndroidDriver driver;
	 LoginClass login;
	 
	 public String enterEmail() {
		 return RandomStringUtils.randomAlphanumeric(4);
	 }
	 
    
}

