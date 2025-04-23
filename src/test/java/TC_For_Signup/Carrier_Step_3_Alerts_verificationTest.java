package TC_For_Signup;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.io.IOException;
import java.time.Duration;
import java.util.HashMap;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import utilities.Reuseable;

public class Carrier_Step_3_Alerts_verificationTest {
	WebDriver driver;
	Reuseable testdata;
	Logger logger;

	@Test(priority = 1)
	public void Setup() {
		testdata = new Reuseable(); // Create instance of Reuseable
		driver = testdata.Reuseable1(); // Initialize driver from Reuseable class

		logger = LogManager.getLogger(this.getClass());
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		logger.info("*Started Carrier_Step_3_Alerts_verificationTest *");
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
	public void SignUpSecondPage() throws IOException, InterruptedException {
		WebElement locationInput = driver.findElement(By.xpath("//input[@placeholder='Location']"));
		locationInput.sendKeys("Mohali");
		Thread.sleep(1000);
		locationInput.sendKeys(Keys.DOWN);
		Thread.sleep(1000);
		locationInput.sendKeys(Keys.ENTER);
		Thread.sleep(1000);
		driver.findElement(By.xpath("//input[@placeholder='Zipcode *']")).sendKeys("324324");
		driver.findElement(By.xpath("//button[normalize-space()='Next']")).click();
		logger.info("✅ Test passed: Sign Up Second Page Form filled and progressed successfully.");
	}

	@Test(priority = 4)
	public void Company_field_alert() throws IOException, InterruptedException {
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//button[normalize-space()='Next'])[1]")).click();
		logger.info("*Verify Company field alert*");

		WebElement roleSelect = driver.findElement(By.xpath("//input[@placeholder=' Company Name *']"));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		String validationMessage = (String) js.executeScript("return arguments[0].validationMessage;", roleSelect);
		logger.info("Company field Validation alert: Expected Result: Please fill in this field.  " + "Actual Result: "
				+ validationMessage);
		SoftAssert softAssert = new SoftAssert();
		AssertJUnit.assertEquals(validationMessage, "Please fill in this field.");
		softAssert.assertAll();
		driver.findElement(By.xpath("//input[@placeholder=' Company Name *']")).sendKeys("Dummyname");
		logger.info("*Verified Company field alert*");

	}

	@Test(priority = 5)
	public void tax_field_alert() throws IOException, InterruptedException {
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//button[normalize-space()='Next'])[1]")).click();
		logger.info("*Verify Tax field alert*");

		WebElement roleSelect = driver.findElement(By.xpath("//input[@placeholder='Tax Number *']"));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		String validationMessage = (String) js.executeScript("return arguments[0].validationMessage;", roleSelect);
		logger.info("Tax field Validation alert: Expected Result: Please fill in this field.  " + "Actual Result: "
				+ validationMessage);
		SoftAssert softAssert = new SoftAssert();
		AssertJUnit.assertEquals(validationMessage, "Please fill in this field.");
		softAssert.assertAll();
		driver.findElement(By.xpath("//input[@placeholder='Tax Number *']")).sendKeys("4545");
		logger.info("*Verified Tax field alert*");

	}

	@Test(priority = 6)
	public void MC_field_alert() throws IOException, InterruptedException {
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//button[normalize-space()='Next'])[1]")).click();
		logger.info("*Verify MC field alert*");

		WebElement roleSelect = driver.findElement(By.xpath("//input[@placeholder='MC # *']"));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		String validationMessage = (String) js.executeScript("return arguments[0].validationMessage;", roleSelect);
		logger.info("MC field Validation alert: Expected Result: Please fill in this field.  " + "Actual Result: "
				+ validationMessage);
		SoftAssert softAssert = new SoftAssert();
		AssertJUnit.assertEquals(validationMessage, "Please fill in this field.");
		softAssert.assertAll();
		driver.findElement(By.xpath("//input[@placeholder='MC # *']")).sendKeys("23");
		logger.info("*Verified MC field alert*");

	}

	@Test(priority = 7)
	public void DOT_field_alert() throws IOException, InterruptedException {

		Thread.sleep(1000);
		driver.findElement(By.xpath("(//button[normalize-space()='Next'])[1]")).click();
		logger.info("*Verify DOT field alert*");

		WebElement roleSelect = driver.findElement(By.xpath("//input[@placeholder='DOT # *']"));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		String validationMessage = (String) js.executeScript("return arguments[0].validationMessage;", roleSelect);
		logger.info("DOT field Validation alert: Expected Result: Please fill in this field.  " + "Actual Result: "
				+ validationMessage);
		SoftAssert softAssert = new SoftAssert();
		AssertJUnit.assertEquals(validationMessage, "Please fill in this field.");
		softAssert.assertAll();
		driver.findElement(By.xpath("//input[@placeholder='DOT # *']")).sendKeys("232");
		logger.info("*Verified DOT field alert*");
		logger.info("*Finished Carrier_Step_3_Alerts_verificationTest *");


	}

	@Test(priority = 8)
	public void QuitBrowser() throws IOException, InterruptedException {
		Thread.sleep(3000);
		if (driver != null) {
			driver.quit();
		}
	}
}
