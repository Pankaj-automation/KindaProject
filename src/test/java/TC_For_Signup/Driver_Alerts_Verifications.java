package TC_For_Signup;

import java.io.IOException;
import java.time.Duration;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import utilities.Reuseable;

public class Driver_Alerts_Verifications {
	WebDriver driver;
	Reuseable testdata;
	Logger logger;

	@Test(priority = 1)
	public void Setup() {
		testdata = new Reuseable(); // Create instance of Reuseable
		driver = testdata.Reuseable1(); // Initialize driver from Reuseable class
		logger = LogManager.getLogger(this.getClass());
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		logger.info("*Started Driver_Alerts_Verifications*");

	}

	@Test(priority = 2)
	public void First_Step() throws InterruptedException {
		driver.findElement(By.xpath("//button[normalize-space()='Get Started Free']")).click();

		Thread.sleep(1000);
		WebElement drop = driver.findElement(By.xpath(
				"/html[1]/body[1]/div[1]/div[1]/div[1]/div[1]/div[1]/form[1]/div[2]/div[1]/div[1]/div[1]/select[1]"));
		// drop.click();
		Thread.sleep(1000);
		Select sel = new Select(drop);
		sel.selectByIndex(2);
		driver.findElement(By.xpath("//input[@placeholder='First Name *']")).sendKeys(testdata.FirstName());
		driver.findElement(By.xpath("//input[@placeholder='Last Name (Optional)']")).sendKeys(testdata.LastName());
		driver.findElement(By.xpath("//input[@placeholder='Email address *']")).sendKeys(testdata.Email());
		driver.findElement(By.xpath("//input[@placeholder='Password *']")).sendKeys("Admine51%%");
		driver.findElement(By.xpath("//input[@placeholder='Confirm Password *']")).sendKeys("Admine51%%");
		logger.info("*Filled data in Step one fields*");
		driver.findElement(By.xpath("//button[normalize-space()='Next']")).click();

	}

	@Test(priority = 3)
	public void Second_Step() throws InterruptedException {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		WebElement locationInput = driver.findElement(By.xpath("//input[@placeholder='Location']"));
		locationInput.sendKeys("Mohali");
		Thread.sleep(2000);
		locationInput.sendKeys(Keys.DOWN);
		Thread.sleep(2000);
		locationInput.sendKeys(Keys.ENTER);
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@placeholder='Zipcode *']")).sendKeys(testdata.ZipCode());
		logger.info("*Filled data in Second Step page fields*");
		driver.findElement(By.xpath("//button[normalize-space()='Next']")).click();

	}

	@Test(priority = 4)
	public void License_number_field_Verification() throws InterruptedException {
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//button[normalize-space()='Next'])[1]")).click();
		logger.info("*Verify License number field alert*");

		WebElement roleSelect =driver.findElement(By.xpath("//input[@placeholder=' License Number *']"));

		JavascriptExecutor js = (JavascriptExecutor) driver;
		String validationMessage = (String) js.executeScript("return arguments[0].validationMessage;", roleSelect);
		logger.info("License number field Validation alert: Expected Result: Please fill in this field.  "
				+ "Actual Result: " + validationMessage);
		SoftAssert softAssert = new SoftAssert();
		softAssert.assertEquals(validationMessage, "Please fill in this field.");
		softAssert.assertAll();
		driver.findElement(By.xpath("//input[@placeholder=' License Number *']")).sendKeys(testdata.PhoneNumber());
		logger.info("*Verified License number field alert*");

	}

	@Test(priority = 5)
	public void Upload_license_image_field_Verification() throws InterruptedException {
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//button[normalize-space()='Next'])[1]")).click();
		Thread.sleep(2000);
		logger.info("*Verify upload license image alert*");

		/*
		 * WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		 * WebElement toast = wait.until(ExpectedConditions.visibilityOfElementLocated(
		 * By.xpath("//div[contains(text(),'Please select any trailter type.')]") ));
		 */
		WebElement toast = driver.findElement(By.xpath("//div[contains(text(),'License image is required')]"));
		// Get the text from the toast message
		String toastText = toast.getText();
		logger.info("Toast message of upload license image: " + toastText);
		SoftAssert softAssert = new SoftAssert();
		softAssert.assertEquals(toastText, "License image is required");
		softAssert.assertAll();
		logger.info("*Verified upload license image alert*");
		WebElement upl = driver.findElement(By.cssSelector("input[type=file]"));
		upl.sendKeys("/home/jc-raj/Music/Automation/KindaProject/src/test/java/testBase/jc.jpg");
		Thread.sleep(5000);

	}

	@Test(priority = 6)
	public void Term_and_condtions_field_Verification() throws InterruptedException {
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//button[normalize-space()='Next'])[1]")).click();
		Thread.sleep(2000);
		logger.info("*Verify Term and conditions checkbox alert*");

		/*
		 * WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		 * WebElement toast = wait.until(ExpectedConditions.visibilityOfElementLocated(
		 * By.xpath("//div[contains(text(),'Please select any trailter type.')]") ));
		 */
		WebElement toast = driver
				.findElement(By.xpath("//div[contains(text(),'Please fill the check box to accept terms and cond')]"));
		// Get the text from the toast message
		String toastText = toast.getText();
		logger.info("Toast message of Term and conditions: " + toastText);
		SoftAssert softAssert = new SoftAssert();
		softAssert.assertEquals(toastText, "Please fill the check box to accept terms and conditions.");
		softAssert.assertAll();
		logger.info("*Verified Term and conditions checkbox alert*");

		driver.findElement(By.xpath("(//input[@id='checkbox1'])[1]")).click();

	}

	@Test(priority = 7)
	public void QuitBrowser() throws IOException, InterruptedException {
		Thread.sleep(3000);
		if (driver != null) {
			driver.quit();
		}
		logger.info("*Finished Driver_Alerts_Verifications*");
		logger.info("*Browser Closed*");

	}

}
