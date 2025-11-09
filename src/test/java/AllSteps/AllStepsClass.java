package AllSteps;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;
import java.time.Duration;
import java.util.Arrays;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.Sequence;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.*;
import pages.LoginClass;

public class AllStepsClass extends ParentClass {
	
	@Before
	public void setUp() throws MalformedURLException, InterruptedException {
		
		DesiredCapabilities c=new DesiredCapabilities();
		c.setCapability("platformName", "Android");
		c.setCapability("appium:automationName", "UiAutomator2");
		c.setCapability("appium:deviceName", "Android");
		c.setCapability("appium:app", "C:\\Users\\rams9\\OneDrive\\Desktop\\New folder\\Cielo365-v1.0.0-20250418-production-debug 2.apk");
		c.setCapability("appium:newCommandTimeout",60);  
		//  c.setCapability("platformVersion", "14.0");
		//c.setCapability("browserName", "Chrome");
		//c.setCapability("chromedriverExecutable", "C:\\Users\\rams9\\eclipse-workspace\\AppiumMobileTestingProject\\drivers\\chromedriver-win64\\chromedriver.exe");
		c.setCapability("appPackage", "com.armatura.cielo365");
		c.setCapability("appActivity","com.armatura.cielo365.MainActivity");
		URL url=URI.create("http://127.0.0.1:4723/").toURL();
	    driver=new AndroidDriver(url,c);
	    login=new LoginClass(driver);
		Thread.sleep(5000);
		System.out.println("Device started");
		driver.findElement(login.getClick_On_Skip()).click();	
	}
	@Given("Click on Signin button")
	public void click_on_signin_button() throws InterruptedException {
		Thread.sleep(5000);
	    driver.findElement(login.getClick_On_SignIn_Btn()).click();
		
	}
	@Given("Select the company")
	public void select_the_company() throws InterruptedException {
		Thread.sleep(5000);
	    driver.findElement(login.getClick_On_Company()).click();
	    Dimension size = driver.manage().window().getSize();
	    int startX = size.width / 2;
	    int startY = (int) (size.height * 0.3);
	    int endY = (int) (size.height * 0.8);
        Thread.sleep(5000);
	    PointerInput finger = new PointerInput(PointerInput.Kind.TOUCH, "finger");
	    Sequence swipe = new Sequence(finger, 1);
	    swipe.addAction(finger.createPointerMove(Duration.ZERO, PointerInput.Origin.viewport(), startX, startY));
	    swipe.addAction(finger.createPointerDown(PointerInput.MouseButton.LEFT.asArg()));
	    swipe.addAction(finger.createPointerMove(Duration.ofMillis(800), PointerInput.Origin.viewport(), startX, endY));
	    swipe.addAction(finger.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));
	    driver.perform(Arrays.asList(swipe));	
	}
	@Then("User should be able to view the dashboard page")
	public void user_should_be_able_to_view_the_dashboard_page() throws InterruptedException {
		Thread.sleep(5000);
		driver.findElement(login.getClick_On_Enter_Btn()).click();
	    System.out.println("No company");
	    driver.navigate().back();
	}
	@Given("Click on forgot password")
	public void click_on_forgot_password() {
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.elementToBeClickable(login.getClick_On_Forgot_password())).click();	
	}
	@Given("Enter registered email in email text field")
	public void enter_registered_email_in_email_text_field() throws InterruptedException {
		Thread.sleep(4000);
	    driver.findElement(login.getEnterRegisterdEmail()).sendKeys("rams94000@gmail.com");   
	}
	@Given("Click on send button")
	public void click_on_send_button() throws InterruptedException {
		Thread.sleep(4000);
	    driver.findElement(login.getClickOnSendButton()).click();
	}
	@Then("User should be able to receive email")
	public void user_should_be_able_to_receive_email() throws InterruptedException {
		Thread.sleep(7000);
		WebElement success=driver.findElement(login.getPrintSuccessmsg());
		String print=success.getText();
		System.out.println(print);	
	}
	@After
	public void tearDown() {
		driver.quit();
	}

}
