package TC_For_Signup;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import java.io.IOException;
import java.io.InputStream;
import java.time.Duration;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import net.datafaker.Faker;
import utilities.Reuseable;

public class Carrier_Step_1_Alerts_verificationTest extends Reuseable {
	WebDriver driver;
	Faker testdata = new Faker();
	String firstName = testdata.name().firstName();
	String lastName = testdata.name().lastName();
	String email = firstName.toLowerCase() + "@yopmail.com";
	String password = firstName.toLowerCase() + "A51%%";

	@Test(priority = 1)
	public void Setup() {

		Reuseable Reuseable = new Reuseable();
		driver = Reuseable.Reuseable1();
		logger = LogManager.getLogger(this.getClass());

	}

	@Test(priority = 2)
	void Role__field_alert() throws InterruptedException {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		logger.info("*Opening Browser*");

		logger.info("*Started the Carrier_Step_1_Alerts_verificationTest*");

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.findElement(By.xpath("//button[normalize-space()='Get Started Free']")).click();
		logger.info("*Clicked on Get Started Free button*");
		driver.findElement(By.xpath("//button[normalize-space()='Next']")).click();
		logger.info("*Clicked on next button without Entering data*");

		WebElement roleSelect = driver.findElement(By.xpath(
				"/html[1]/body[1]/div[1]/div[1]/div[1]/div[1]/div[1]/form[1]/div[2]/div[1]/div[1]/div[1]/select[1]"));
		logger.info("*Locate the role field*");

// Fetch validation message from the select element
		JavascriptExecutor js = (JavascriptExecutor) driver;
		String validationMessage = (String) js.executeScript("return arguments[0].validationMessage;", roleSelect);

		logger.info("Role field Validation Message:Expected Result: Please select an item in the list.  "
				+ "Actual Result: " + validationMessage);
		logger.info("*Verify the actual result and expected result*");

		SoftAssert softAssert = new SoftAssert();
		AssertJUnit.assertEquals(validationMessage, "Please select an item in the list.");
		softAssert.assertAll();
		WebElement drop = driver.findElement(By.xpath(
				"/html[1]/body[1]/div[1]/div[1]/div[1]/div[1]/div[1]/form[1]/div[2]/div[1]/div[1]/div[1]/select[1]"));
		Thread.sleep(1000);
		Select sel = new Select(drop);
		sel.selectByIndex(1);
	}

	@Test(priority = 3)
	void firstname_field_alert() throws InterruptedException {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		driver.findElement(By.xpath("//button[normalize-space()='Next']")).click();
		Thread.sleep(1000);
		logger.info("*firstname_field_alerts test case started*");

		WebElement roleSelect = driver.findElement(By.xpath("//input[@placeholder='First Name *']"));

		JavascriptExecutor js = (JavascriptExecutor) driver;
		String validationMessage = (String) js.executeScript("return arguments[0].validationMessage;", roleSelect);

		logger.info("firstname field Validation Message:Expected Result: Please fill in this field.  "
				+ "Actual Result: " + validationMessage);
		logger.info("*Verify the actual result and expected result*");

		SoftAssert softAssert = new SoftAssert();
		AssertJUnit.assertEquals(validationMessage, "Please fill in this field.");
		softAssert.assertAll();
		Thread.sleep(1000);
		logger.info("*Verified firstname_field_alert*");

		driver.findElement(By.xpath("//input[@placeholder='First Name *']")).sendKeys(firstName);

	}

	@Test(priority = 4)
	void email_field_alert() throws InterruptedException {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		Thread.sleep(1000);

		driver.findElement(By.xpath("//button[normalize-space()='Next']")).click();
		logger.info("*email_field_alert test case started*");

		WebElement roleSelect = driver.findElement(By.xpath("//input[@placeholder='Email address *']"));

		JavascriptExecutor js = (JavascriptExecutor) driver;
		String validationMessage = (String) js.executeScript("return arguments[0].validationMessage;", roleSelect);

		logger.info("email field Validation Message:Expected Result: Please fill in this field.  "
				+ "Actual Result: " + validationMessage);
		SoftAssert softAssert = new SoftAssert();
		AssertJUnit.assertEquals(validationMessage, "Please fill in this field.");
		softAssert.assertAll();
		Thread.sleep(1000);
		logger.info("*Verified email_field_alert*");

		driver.findElement(By.xpath("//input[@placeholder='Email address *']")).sendKeys(email);

	}

	@Test(priority = 5)
	void option_field_alert() throws InterruptedException {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		Thread.sleep(1000);

		driver.findElement(By.xpath("//button[normalize-space()='Next']")).click();
		logger.info("*option_field_alert test case started*");
		WebElement roleSelect = driver.findElement(By.xpath(
				"/html[1]/body[1]/div[1]/div[1]/div[1]/div[1]/div[1]/form[1]/div[2]/div[5]/div[1]/div[1]/select[1]"));

		JavascriptExecutor js = (JavascriptExecutor) driver;
		String validationMessage = (String) js.executeScript("return arguments[0].validationMessage;", roleSelect);

		logger.info("option field Validation Message:Expected Result: Please select an item in the list.  "
				+ "Actual Result: " + validationMessage);
		SoftAssert softAssert = new SoftAssert();
		AssertJUnit.assertEquals(validationMessage, "Please select an item in the list.");
		softAssert.assertAll();
		logger.info("*Verified option_field_alert*");

		WebElement drop1 = driver.findElement(By.xpath(
				"/html[1]/body[1]/div[1]/div[1]/div[1]/div[1]/div[1]/form[1]/div[2]/div[5]/div[1]/div[1]/select[1]"));
		// drop.click();
		Thread.sleep(1000);
		Select sel1 = new Select(drop1);
		sel1.selectByIndex(2);

	}

	@Test(priority = 6)
	void Password_field_alert() throws InterruptedException {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		Thread.sleep(1000);

		driver.findElement(By.xpath("//button[normalize-space()='Next']")).click();
		logger.info("*Password_field_alert test case started*");

		WebElement roleSelect = driver.findElement(By.xpath("//input[@placeholder='Password *']"));

		JavascriptExecutor js = (JavascriptExecutor) driver;
		String validationMessage = (String) js.executeScript("return arguments[0].validationMessage;", roleSelect);

		logger.info("password field Validation Message:Expected Result: Please fill in this field.  "
				+ "Actual Result: " + validationMessage);
		SoftAssert softAssert = new SoftAssert();
		AssertJUnit.assertEquals(validationMessage, "Please fill in this field.");
		softAssert.assertAll();
		Thread.sleep(1000);
		logger.info("*Verified Password_field_alert*");

		driver.findElement(By.xpath("//input[@placeholder='Password *']")).sendKeys(password);

	}

	@Test(priority = 7)
	void confirm_passowrd_field_alert() throws InterruptedException {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		Thread.sleep(1000);

		driver.findElement(By.xpath("//button[normalize-space()='Next']")).click();

		WebElement roleSelect = driver.findElement(By.xpath("//input[@placeholder='Confirm Password *']"));

		JavascriptExecutor js = (JavascriptExecutor) driver;
		String validationMessage = (String) js.executeScript("return arguments[0].validationMessage;", roleSelect);

		logger.info("Confirmpassword field Validation Message:Expected Result: Please fill in this field.  "
				+ "Actual Result: " + validationMessage);
		SoftAssert softAssert = new SoftAssert();
		AssertJUnit.assertEquals(validationMessage, "Please fill in this field.");
		softAssert.assertAll();
		Thread.sleep(1000);
		logger.info("*Verified confirm_passowrd_field_alert*");

		driver.findElement(By.xpath("//input[@placeholder='Confirm Password *']")).sendKeys(password);
	}

	@Test(priority = 8)
	void password_validation_alert() throws InterruptedException {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		Thread.sleep(1000);
		logger.info("*Checking the password_validation_alert*");
		driver.findElement(By.xpath("//input[@placeholder='Confirm Password *']")).clear();
		driver.findElement(By.xpath("//input[@placeholder='Confirm Password *']")).sendKeys("Admine51%%");
		driver.findElement(By.xpath("//button[normalize-space()='Next']")).click();

		WebElement pwsd = driver
				.findElement(By.xpath("(//div[contains(@class,'invalid-feedback block star text-[12px]')])[1]"));
		logger.info("If Password and confirm password is not matched : "+pwsd.getText());
		Thread.sleep(1000);

		driver.findElement(By.xpath("//input[@placeholder='Password *']")).clear();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//input[@placeholder='Password *']")).sendKeys("123456789");

		WebElement cpwsd = driver.findElement(
				By.xpath("/html[1]/body[1]/div[1]/div[1]/div[1]/div[1]/div[1]/form[1]/div[2]/div[6]/div[2]"));
		logger.info("If password is not valid : "+cpwsd.getText());
		Thread.sleep(1000);

		driver.findElement(By.xpath("//input[@placeholder='Password *']")).sendKeys("11");
		Thread.sleep(1000);

		driver.findElement(By.xpath("//button[normalize-space()='Next']")).click();

		Thread.sleep(1000);
		WebElement roleSelect = driver.findElement(By.xpath("//input[@placeholder='Password *']"));

		JavascriptExecutor js = (JavascriptExecutor) driver;
		String validationMessage = (String) js.executeScript("return arguments[0].validationMessage;", roleSelect);

		logger.info(
				"password field Validation Message:Expected Result: Please lengthen this text to 8 characters or more (you are currently using 2 characters  "
						+ "Actual Result: " + validationMessage);
		logger.info("*Validated the password_validation_alert*");
		driver.findElement(By.xpath("//button[normalize-space()='Next']")).click();
		logger.info("*Finished Carrier_Step_1_Alerts_verificationTest*");

	}

	@Test(priority = 9)
	public void QuitBrowser() throws IOException, InterruptedException {
		Thread.sleep(3000);
		if (driver != null) {
			driver.quit();
		}
	}
}
