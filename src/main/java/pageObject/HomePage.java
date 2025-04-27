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

public class HomePage {
	private WebDriver driver;
	
	public HomePage(WebDriver driver){
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//select[@class='product_sort_container']")
	WebElement Filter;
	
	@FindBy(xpath = "//button[contains(@data-test,'add-to-cart')]")
	List<WebElement> addToCartButtons;
	
	@FindBy(className = "inventory_item_price")
	List<WebElement> priceElements;
	
	@FindBy(xpath = "//a[@class='shopping_cart_link']")
	WebElement cartbutton;
	
	public void FilterLowToHigh() {
		Select s = new Select(Filter);
		s.selectByVisibleText("Price (low to high)");
	}
	
	public CartPage cartpage() {
		cartbutton.click();
		return new CartPage(driver);
	}
	
	public void AddExpensives() {
	    
	    Map<Double, WebElement> priceToButtonMap = new HashMap<>();

	    for (int i = 0; i < priceElements.size(); i++) {
	        String priceText = priceElements.get(i).getText().replace("$", "").trim();
	        double price = Double.parseDouble(priceText);
	        priceToButtonMap.put(price, addToCartButtons.get(i));
	    }

	    List<Double> sortedPrices = new ArrayList<>(priceToButtonMap.keySet());
	    sortedPrices.sort(Collections.reverseOrder());

	    for (int i = 0; i < 2; i++) {
	        priceToButtonMap.get(sortedPrices.get(i)).click();
	    }
	}
	
}
