package stepDefinitions;

import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;


import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.BeforeStep;
import io.cucumber.java.Scenario;
import testComponent.BaseTest;

public class Hooks extends BaseTest{
	private WebDriver driver;
	
	@Before
    public void setUp() throws IOException {
        driver = InitiateDriver ();
    }
	
	@AfterStep
	public void Reporting (Scenario scenario) throws IOException, InterruptedException {
		if (scenario.isFailed()) {
			Thread.sleep(3000);
            String scenarioName = scenario.getName();
            String screenshotPath = TakeScreenShot(scenarioName, driver);
            final byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
            scenario.attach(screenshot, "image/png", scenarioName);
        }
	}
	
	@After
	public void tearDown() {
		closeDriver();
	}
}
