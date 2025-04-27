package stepDefinitions;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import io.cucumber.java.en.*;
import pageObject.AddressPage;
import pageObject.CartPage;
import pageObject.CheckOutPage;
import pageObject.ConfirmationPage;
import pageObject.HomePage;
import testComponent.BaseTest;

public class StepDefinitionMapping extends BaseTest {

	private WebDriver driver;
	HomePage homepage;
	CartPage cartpage;
	AddressPage address;
	ConfirmationPage confirmation;

	@Given("user is on the Swag Labs login page")
	public void user_is_on_the_swag_labs_login_page() throws IOException {
		driver = InitiateDriver();
		LaunchLoginPage();
	}

	@When("user enters {string} and {string}")
	public void user_enters_and(String id, String passkey) {
		log.UserLogin(id, passkey);
	}

	@When("user clicks the login button")
	public void user_clicks_the_login_button() {
		homepage = log.clickLoginButton();
	}

	@Then("the error message {string} should be displayed")
	public void the_error_message_should_be_displayed(String string) {
		System.out.println(log.GetLoginError());
	}

	/******************************/

	@When("user applies the {string} filter on the product list")
	public void user_applies_the_filter_on_the_product_list(String string) {
		homepage.FilterLowToHigh();
	}

	@When("user identifies and adds the two most expensive products to the cart")
	public void user_identifies_and_adds_the_most_expensive_products_to_the_cart() {
		homepage.AddExpensives();
	}

	@When("user navigates to the cart page")
	public void user_navigates_to_the_cart_page() {
		cartpage = homepage.cartpage();
	}

	@Then("cart should contain exactly {int} items")
	public void cart_should_contain_exactly_items(Integer count) {
		Assert.assertEquals(cartpage.CartCount(), count);
	}

	@When("user proceeds to checkout")
	public void user_proceeds_to_checkout() {
		address = cartpage.CheckOut();
	}

	@When("user enters first name {string}, last name {string}, and postal code {string}")
	public void user_enters_first_name_last_name_and_postal_code(String string, String string2, String string3) {
		address.EnterSippingDetails(string, string2, string3);
	}

	@When("user completes the checkout process")
	public void user_completes_the_checkout_process() {
		CheckOutPage checkOut = address.CheckOut();
		confirmation = checkOut.Purchase();
	}

	@Then("the confirmation page should display the message {string}")
	public void the_confirmation_page_should_display_the_message(String message) {
		Assert.assertEquals(confirmation.GetConfirmatinoMessage(), message);
	}

}
