package pageObject;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class AddressPage {
	private WebDriver driver;
	
	public AddressPage(WebDriver driver){
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//input[@id='first-name']")
	WebElement Firstname;
	@FindBy(xpath = "//input[@id='last-name']")
	WebElement Lastname;
	@FindBy(xpath = "//input[@id='postal-code']")
	WebElement postalcode;
	@FindBy(xpath = "//input[@id='continue']")
	WebElement Continue;
	
	public void EnterSippingDetails(String firstname, String lastname, String zip) {
		Firstname.sendKeys(firstname);
		Lastname.sendKeys(lastname);
		postalcode.sendKeys(zip);
	}
	
	public CheckOutPage CheckOut () {
		Continue.click();
		return new CheckOutPage(driver);
		
	}
	
	
	
}
