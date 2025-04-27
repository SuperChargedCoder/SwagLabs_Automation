package runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.DataProvider;

@CucumberOptions(features = "src/test/java/featureFiles", // Path to your feature files 
		glue = { "stepDefinitions" }, // Package where step definitions are located
		plugin = { "pretty", // Prints pretty output
				"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"
		}, monochrome = true, // Makes console output more readable (False By Default)
		dryRun = false // If true, checks if steps are implemented without actually running tests
)
public class Runner_ExtentReporter extends AbstractTestNGCucumberTests {
	

}
