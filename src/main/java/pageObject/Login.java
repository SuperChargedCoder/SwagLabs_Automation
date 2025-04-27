package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Login {
	private WebDriver driver;
	
	public Login(WebDriver driver){
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//input[@id='user-name']")
	WebElement UserName;
	
	@FindBy(xpath = "//input[@id='password']")
	WebElement Password;
	
	@FindBy(xpath = "//input[@id='login-button']")
	WebElement Login;
	
	@FindBy(xpath = "//h3[@data-test='error']")
	WebElement LoginError;
	
	public void UserLogin(String username, String password) {
		UserName.sendKeys(username);
		Password.sendKeys(password);
	}
	
	public HomePage clickLoginButton() {
		Login.click();
		return new HomePage(driver);
	}
	
	public String GetLoginError() {
		return LoginError.getText();
	}

}
