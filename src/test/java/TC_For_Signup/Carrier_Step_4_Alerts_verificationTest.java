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
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import utilities.Reuseable;

public class Carrier_Step_4_Alerts_verificationTest {
	WebDriver driver;
	Reuseable testdata;
	Logger logger;

	@Test(priority = 1)
	public void Setup() {
		testdata = new Reuseable(); // Create instance of Reuseable
		driver = testdata.Reuseable1(); // Initialize driver from Reuseable class

		logger = LogManager.getLogger(this.getClass());
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		logger.info("*Started Carrier_Step_4_Alerts_verificationTest *");
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
		Thread.sleep(2000);
		locationInput.sendKeys(Keys.DOWN);
		Thread.sleep(2000);
		locationInput.sendKeys(Keys.ENTER);
		Thread.sleep(1000);
		driver.findElement(By.xpath("//input[@placeholder='Zipcode *']")).sendKeys("324324");
		driver.findElement(By.xpath("//button[normalize-space()='Next']")).click();
		logger.info("✅ Test passed: Sign Up Second Page Form filled and progressed successfully.");
	}

	@Test(priority = 4)
	public void SignUpthirdPage() throws IOException {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		driver.findElement(By.xpath("//input[@placeholder=' Company Name *']")).sendKeys("India");
		driver.findElement(By.xpath("//input[@placeholder='Tax Number *']")).sendKeys("India");
		driver.findElement(By.xpath("//input[@placeholder='MC # *']")).sendKeys("23");
		driver.findElement(By.xpath("//input[@placeholder='DOT # *']")).sendKeys("232");

		driver.findElement(By.xpath("//button[normalize-space()='Next']")).click();
		logger.info("✅ Test passed: Sign Up Third Page Form filled and progressed successfully.");
	}

	@Test(priority = 5)
	public void trailers_field_alert() throws IOException, InterruptedException {
		Thread.sleep(1000);
		driver.findElement(By.xpath("//button[normalize-space()='Sign Up']")).click();
		logger.info("*Verify Trailers field alert*");

		WebElement roleSelect = driver.findElement(By.xpath("//input[@placeholder='Number of Trailers *']"));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		String validationMessage = (String) js.executeScript("return arguments[0].validationMessage;", roleSelect);
		logger.info("Trailers field Validation alert: Expected Result: Please fill in this field.  " + "Actual Result: "
				+ validationMessage);
		SoftAssert softAssert = new SoftAssert();
		AssertJUnit.assertEquals(validationMessage, "Please fill in this field.");
		softAssert.assertAll();
		driver.findElement(By.xpath("//input[@placeholder='Number of Trailers *']")).sendKeys("232");
		logger.info("*Verified Trailers field alert*");

	}

	@Test(priority = 6)
	public void solo_truck_field_alert() throws IOException, InterruptedException {
		Thread.sleep(1000);
		driver.findElement(By.xpath("//button[normalize-space()='Sign Up']")).click();
		logger.info("*Verify Solo Truck field alert*");

		WebElement roleSelect = driver.findElement(By.xpath("//input[@placeholder='Solo Truck *']"));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		String validationMessage = (String) js.executeScript("return arguments[0].validationMessage;", roleSelect);
		logger.info("Solo Truck  field Validation alert: Expected Result: Please fill in this field.  "
				+ "Actual Result: " + validationMessage);
		SoftAssert softAssert = new SoftAssert();
		AssertJUnit.assertEquals(validationMessage, "Please fill in this field.");
		softAssert.assertAll();
		driver.findElement(By.xpath("//input[@placeholder='Solo Truck *']")).sendKeys("1");
		logger.info("*Verified Solo Truck  field alert*");

	}

	@Test(priority = 7)
	public void team_truck_field_alert() throws IOException, InterruptedException {
		Thread.sleep(1000);
		driver.findElement(By.xpath("//button[normalize-space()='Sign Up']")).click();
		logger.info("*Verify Team truck field alert*");

		WebElement roleSelect = driver.findElement(By.xpath("//input[@placeholder='Team Truck *']"));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		String validationMessage = (String) js.executeScript("return arguments[0].validationMessage;", roleSelect);
		logger.info("Team truck field Validation alert: Expected Result: Please fill in this field.  "
				+ "Actual Result: " + validationMessage);
		SoftAssert softAssert = new SoftAssert();
		AssertJUnit.assertEquals(validationMessage, "Please fill in this field.");
		softAssert.assertAll();
		driver.findElement(By.xpath("//input[@placeholder='Team Truck *']")).sendKeys("2");
		logger.info("*Verified Team truck field alert*");

	}

	@Test(priority = 8)
	public void dryvan_or_reefer_field_alert() throws IOException, InterruptedException {
		Thread.sleep(1000);
		driver.findElement(By.xpath("//button[normalize-space()='Sign Up']")).click();
		Thread.sleep(2000);
		logger.info("*Verify Dry van or Reefer checkbox alert*");

		/*
		 * WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		 * WebElement toast = wait.until(ExpectedConditions.visibilityOfElementLocated(
		 * By.xpath("//div[contains(text(),'Please select any trailter type.')]") ));
		 */
		WebElement toast = driver.findElement(By.xpath("//div[contains(text(),'Please select any trailter type.')]"));
		// Get the text from the toast message
		String toastText = toast.getText();
		logger.info("Toast message of Dry van or Reefer: " + toastText);
		SoftAssert softAssert = new SoftAssert();
		AssertJUnit.assertEquals(toastText, "Please select any trailter type.");
		softAssert.assertAll();
		logger.info("*Verified Dry van or Reefer checkbox alert*");

		driver.findElement(By.xpath("//input[@id='dry_van']")).click();

	}

	@Test(priority = 9)
	public void terms_and_condition_field_alert() throws IOException, InterruptedException {
		Thread.sleep(1000);
		driver.findElement(By.xpath("//button[normalize-space()='Sign Up']")).click();
		Thread.sleep(2000);
		logger.info("*Verify Terms and conditions checkbox alert*");

		/*
		 * WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		 * WebElement toast = wait.until(ExpectedConditions.visibilityOfElementLocated(
		 * By.xpath("//div[contains(text(),'Please select any trailter type.')]") ));
		 */
		WebElement toast = driver
				.findElement(By.xpath("//div[contains(text(),'Please fill the check box to accept terms and cond')]"));
		// Get the text from the toast message
		String toastText = toast.getText();
		logger.info("Toast message of Terms and conditions : " + toastText);
		SoftAssert softAssert = new SoftAssert();
		AssertJUnit.assertEquals(toastText, "Please fill the check box to accept terms and conditions.");
		softAssert.assertAll();
		driver.findElement(By.xpath("//input[@id='checkbox1']")).click();
		logger.info("*Verified Terms and conditions checkbox alert*");

		driver.findElement(By.xpath("//button[normalize-space()='Sign Up']")).click();
		logger.info("*Finished Carrier_Step_4_Alerts_verificationTest *");

	}

	@Test(priority = 12)
	public void QuitBrowser() throws IOException, InterruptedException {
		Thread.sleep(3000);
		if (driver != null) {
			driver.quit();
		}

	}
}
