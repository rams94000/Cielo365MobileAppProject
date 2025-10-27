package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.android.AndroidDriver;

public class LoginClass {

	AndroidDriver driverG;
	
	public LoginClass(AndroidDriver driverl) {
		driverG=driverl;
		PageFactory.initElements(driverl,this);
	}
	
	private By Click_On_Skip=By.xpath("//androidx.compose.ui.platform.ComposeView/android.view.View/android.view.View/android.view.View[1]/android.widget.Button");
    private By EnterUsername=By.xpath("//android.widget.EditText[@text=\"pruthvi@zktecodev.com\"]");
    private By Enterpassword=By.xpath("//android.widget.EditText[@text=\"Zkteco@123\"]");
    private By Click_On_SignIn_Btn=By.xpath("//androidx.compose.ui.platform.ComposeView/android.view.View/android.view.View/android.view.View[2]/android.widget.Button");
    private By Click_On_Company=By.xpath("//android.widget.EditText");
    private By Click_On_Enter_Btn=By.xpath("//android.widget.Button");
    
    
	public By getClick_On_Enter_Btn() {
		return Click_On_Enter_Btn;
	}
	public By getClick_On_Company() {
		return Click_On_Company;
	}
	public By getClick_On_SignIn_Btn() {
		return Click_On_SignIn_Btn;
	}
	public By getEnterpassword() {
		return Enterpassword;
	}
	public By getEnterUsername() {
		return EnterUsername;
	}
	public By getClick_On_Skip() {
		return Click_On_Skip;
	}
	
	
}
