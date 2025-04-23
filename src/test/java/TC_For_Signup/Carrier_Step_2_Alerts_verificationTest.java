package TC_For_Signup;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import org.testng.internal.invokers.TestMethodWithDataProviderMethodWorker;

import net.datafaker.Faker;

import java.io.IOException;
import java.time.Duration;
import java.util.HashMap;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import utilities.Reuseable;

public class Carrier_Step_2_Alerts_verificationTest {
	WebDriver driver;
	Reuseable testdata;
	Logger logger;

	@Test(priority = 1)
	public void Setup() {
		testdata = new Reuseable(); // Create instance of Reuseable
		driver = testdata.Reuseable1(); // Initialize driver from Reuseable class

		logger = LogManager.getLogger(this.getClass());
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		logger.info("*Started Carrier_Step_2_Alerts_verificationTest *");
		logger.info("*Browser Opened*");

	}

	@Test(priority = 2)
	public void SignUpFirstPage() throws IOException, InterruptedException {
		driver.findElement(By.xpath("//button[normalize-space()='Get Started Free']")).click();
		WebElement drop = driver.findElement(By.xpath(
				"/html[1]/body[1]/div[1]/div[1]/div[1]/div[1]/div[1]/form[1]/div[2]/div[1]/div[1]/div[1]/select[1]"));
		Select sel = new Select(drop);
		sel.selectByIndex(1);
		driver.findElement(By.xpath("//input[@placeholder='First Name *']")).sendKeys(testdata.FirstName());
		driver.findElement(By.xpath("//input[@placeholder='Last Name (Optional)']")).sendKeys(testdata.LastName());
		driver.findElement(By.xpath("//input[@placeholder='Email address *']")).sendKeys(testdata.Email());
		WebElement drop1 = driver.findElement(By.xpath(
				"/html[1]/body[1]/div[1]/div[1]/div[1]/div[1]/div[1]/form[1]/div[2]/div[5]/div[1]/div[1]/select[1]"));
		Select sel1 = new Select(drop1);
		sel1.selectByIndex(2);
		driver.findElement(By.xpath("//input[@placeholder='Password *']")).sendKeys("Admine51%%");
		driver.findElement(By.xpath("//input[@placeholder='Confirm Password *']")).sendKeys("Admine51%%");
		driver.findElement(By.xpath("(//button[normalize-space()='Next'])[1]")).click();

		logger.info("✅ Test passed: Sign Up First Page Form filled and progressed successfully.");

	}

	@Test(priority = 3)
	public void State_field_alert() throws IOException, InterruptedException {
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//button[normalize-space()='Next'])[1]")).click();
		logger.info("*Verify State field alert*");

		WebElement roleSelect = driver.findElement(By.xpath("//input[@placeholder='State *']"));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		String validationMessage = (String) js.executeScript("return arguments[0].validationMessage;", roleSelect);
		logger.info("State field Validation alert: Expected Result: Please fill in this field.  " + "Actual Result: "
				+ validationMessage);
		SoftAssert softAssert = new SoftAssert();
		AssertJUnit.assertEquals(validationMessage, "Please fill in this field.");
		softAssert.assertAll();
		driver.findElement(By.xpath("//input[@placeholder='State *']")).sendKeys("Punjab");
		logger.info("*Verified State field alert*");

	}

	@Test(priority = 4)
	public void City_field_alert() throws IOException, InterruptedException {
		driver.findElement(By.xpath("(//button[normalize-space()='Next'])[1]")).click();
		logger.info("*Verify City field alert*");
		WebElement roleSelect = driver.findElement(By.xpath("//input[@placeholder='City *']"));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		String validationMessage = (String) js.executeScript("return arguments[0].validationMessage;", roleSelect);
		logger.info("City field Validation alert: Expected Result: Please fill in this field.  " + "Actual Result: "
				+ validationMessage);
		SoftAssert softAssert = new SoftAssert();
		AssertJUnit.assertEquals(validationMessage, "Please fill in this field.");
		softAssert.assertAll();
		logger.info("*Verified City field alert*");
		driver.findElement(By.xpath("//input[@placeholder='City *']")).sendKeys("Sahibzada");

	}

	@Test(priority = 5)
	public void Zipcode_field_alert() throws IOException, InterruptedException {
		driver.findElement(By.xpath("(//button[normalize-space()='Next'])[1]")).click();
		logger.info("**Verify Zipcode field alert*");
		WebElement roleSelect = driver.findElement(By.xpath("(//input[@placeholder='Zipcode *'])[1]"));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		String validationMessage = (String) js.executeScript("return arguments[0].validationMessage;", roleSelect);
		logger.info("Zipcode field Validation alert: Expected Result: Please fill in this field.  " + "Actual Result: "
				+ validationMessage);
		SoftAssert softAssert = new SoftAssert();
		AssertJUnit.assertEquals(validationMessage, "Please fill in this field.");
		softAssert.assertAll();
		logger.info("**Verified Zipcode field alert*");
		driver.findElement(By.xpath("(//input[@placeholder='Zipcode *'])[1]")).sendKeys("324324");

	}

	@Test(priority = 6)
	public void Country_field_alert() throws IOException, InterruptedException {
		driver.findElement(By.xpath("(//button[normalize-space()='Next'])[1]")).click();
		logger.info("**Verify Country field alert*");
		WebElement roleSelect = driver.findElement(By.xpath("(//input[@placeholder='Country *'])[1]"));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		String validationMessage = (String) js.executeScript("return arguments[0].validationMessage;", roleSelect);
		logger.info("Country field Validation alert: Expected Result: Please fill in this field.  " + "Actual Result: "
				+ validationMessage);
		SoftAssert softAssert = new SoftAssert();
		AssertJUnit.assertEquals(validationMessage, "Please fill in this field.");
		softAssert.assertAll();
		logger.info("**Verified Country field alert*");
		driver.findElement(By.xpath("(//input[@placeholder='Country *'])[1]")).sendKeys("India");

	}

	@Test(priority = 7)
	public void Location_field_alert() throws IOException, InterruptedException {
		driver.findElement(By.xpath("(//button[normalize-space()='Next'])[1]")).click();
		logger.info("**Verify Location field alert*");
		WebElement roleSelect = driver.findElement(By.xpath(
				"/html[1]/body[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/form[1]/div[2]/div[1]/div[1]/div[1]/span[1]"));
		String ms = roleSelect.getText();
		logger.info("When location is not selected" + ms);
		logger.info("Location field Validation Message: Expected Result: Please select a location from the suggestions."
				+ "Actual Result: " + ms);
		SoftAssert softAssert = new SoftAssert();
		AssertJUnit.assertEquals(ms, "Please select a location from the suggestions.");
		softAssert.assertAll();
		logger.info("**Verified Location field alert*");

	}

	@Test(priority = 8)
	public void QuitBrowser() throws IOException, InterruptedException {
		if (driver != null) {
			driver.quit();
			logger.info("*Finished Carrier_Step_2_Alerts_verificationTest *");

		}
	}
}
