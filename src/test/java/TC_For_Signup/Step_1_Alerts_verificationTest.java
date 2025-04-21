package TC_For_Signup;

import java.io.InputStream;
import java.time.Duration;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import utilities.Reuseable;

public class Step_1_Alerts_verificationTest extends Reuseable {
	WebDriver driver;

	@Test(priority = 1)
	public void Setup() {

		Reuseable Reuseable = new Reuseable();
		driver = Reuseable.Reuseable();
		logger = LogManager.getLogger(this.getClass());

	}

	@Test(priority = 2)
	void verify_role_field_alerts() throws InterruptedException {
		logger.info("*****Opening Browser*****");

		logger.info("*****Started the Step_1_Alerts_verificationTest*****");

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.findElement(By.xpath("//button[normalize-space()='Get Started Free']")).click();
		logger.info("*****Clicked on Get Started Free button*****");
		driver.findElement(By.xpath("//button[normalize-space()='Next']")).click();
		logger.info("*****Clicked on next button without Entering data*****");

		WebElement roleSelect = driver.findElement(By.xpath(
				"/html[1]/body[1]/div[1]/div[1]/div[1]/div[1]/div[1]/form[1]/div[2]/div[1]/div[1]/div[1]/select[1]"));
		logger.info("*****Locate the role field*****");

// Fetch validation message from the select element
		JavascriptExecutor js = (JavascriptExecutor) driver;
		String validationMessage = (String) js.executeScript("return arguments[0].validationMessage;", roleSelect);

		System.out.println("Role field Validation Message:Expected Result: Please select an item in the list.  "
				+ "Actual Result: " + validationMessage);
		logger.info("*****Verify the actual result and expected result*****");

		SoftAssert softAssert = new SoftAssert();
		softAssert.assertEquals(validationMessage, "Please select an item in the list.");
		softAssert.assertAll();
		logger.info("*****Test Case Completed*****");

		logger.info("*****Finished Step_1_Alerts_verificationTest*****");
	}
}
