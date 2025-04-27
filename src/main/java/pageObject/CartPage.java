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

public class CartPage {
	private WebDriver driver;
	
	public CartPage(WebDriver driver){
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//button[@id='checkout']")
	WebElement CheckOut;
	
	@FindBy(className = "cart_item")
	List<WebElement> CartItems;
	
	public int CartCount() {
		return CartItems.size();
	}
	
	public AddressPage CheckOut() {
		CheckOut.click();
		return new AddressPage(driver);
	}
	
}
