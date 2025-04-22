package TC_For_Signup;

import java.io.File;
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
import org.testng.Assert;
import org.testng.annotations.Test;

import net.datafaker.Faker;
import utilities.Reuseable;

public class Driver_SignUp_Test {
	WebDriver driver;
	Reuseable testdata;
	Logger logger;

	@Test(priority = 1)
	public void Setup() {
		testdata = new Reuseable(); // Create instance of Reuseable
		driver = testdata.Reuseable1(); // Initialize driver from Reuseable class
		logger = LogManager.getLogger(this.getClass());
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		logger.info("*Started Driver_SignUp_Test*");

	}

	@Test(priority = 2)
	public void FirstStep() throws IOException, InterruptedException {
		logger.info("*Opening Browser*");

		logger.info("*Started the SignUp_with_valid_dataTest*");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.findElement(By.xpath("//button[normalize-space()='Get Started Free']")).click();
		logger.info("*Select role as a driver*");
		WebElement drop = driver.findElement(By.xpath(
				"/html[1]/body[1]/div[1]/div[1]/div[1]/div[1]/div[1]/form[1]/div[2]/div[1]/div[1]/div[1]/select[1]"));
		// drop.click();
		Thread.sleep(1000);
		Select sel = new Select(drop);
		sel.selectByIndex(2);
		Assert.assertEquals(sel.getFirstSelectedOption().getText(), "Driver", "❌ Dropdown 1 selection failed");
		WebElement activeStep = driver.findElement(By.xpath("(//div[@class='activebar'])[1]"));
		String actualClass = activeStep.getAttribute("class");
		String expectedClass = "activebar"; // Adjust as needed
		Assert.assertEquals(actualClass, expectedClass, "Active step class mismatch!");
		if (actualClass.equals(expectedClass)) {
			logger.info("First Step - Step One is activated");

		} else {
			logger.info("First Step - Step One is not activated");
		}
		logger.info("*Verified first step active bar is activated*");

	}

	@Test(priority = 3)
	public void SignUpFirstPage() throws IOException, InterruptedException {
		Thread.sleep(1000);
		driver.findElement(By.xpath("//input[@placeholder='First Name *']")).sendKeys(testdata.FirstName());
		driver.findElement(By.xpath("//input[@placeholder='Last Name (Optional)']")).sendKeys(testdata.LastName());
		driver.findElement(By.xpath("//input[@placeholder='Email address *']")).sendKeys(testdata.Email());
		driver.findElement(By.xpath("//input[@placeholder='Password *']")).sendKeys("Admine51%%");
		driver.findElement(By.xpath("//input[@placeholder='Confirm Password *']")).sendKeys("Admine51%%");
		logger.info("*Filled data in Step one fields*");
		driver.findElement(By.xpath("//button[normalize-space()='Next']")).click();

		logger.info("✅ Test passed: Sign Up as Driver First Page Form filled and progressed successfully.");

	}

	@Test(priority = 4)
	public void StepTwo() throws IOException, InterruptedException {
		Thread.sleep(2000);
		WebElement activeStep = driver.findElement(By.xpath("//div[contains(text(),'2')]")); // Update
		String actualClass = activeStep.getAttribute("class");
		String expectedClass = "activebar"; // Adjust as needed
		Assert.assertEquals(actualClass, expectedClass, "Active step class mismatch!");
		if (actualClass.equals(expectedClass)) {
			logger.info("Step Two - Step two is activated");

		} else {
			logger.info("Step Two - Step two is not activated");
		}
		logger.info("*Verified Second step active bar is activated*");

	}

	@Test(priority = 5)
	public void SignUpSecondPage() throws IOException, InterruptedException {
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
		logger.info("✅ Test passed: Sign Up as Driver Second Page Form filled and progressed successfully.");
	}

	@Test(priority = 6)
	public void StepThree() throws IOException, InterruptedException {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		Thread.sleep(2000);
		WebElement activeStep = driver.findElement(By.xpath("//div[contains(text(),'3')]")); // Update
		String actualClass = activeStep.getAttribute("class");
		String expectedClass = "activebar"; // Adjust as needed
		Assert.assertEquals(actualClass, expectedClass, "Active step class mismatch!");
		if (actualClass.equals(expectedClass)) {
			logger.info("Step Three - Step three is activated");

		} else {
			logger.info("Step Three - Step three is not activated");
		}
		logger.info("*Verified Third step active bar is activated*");

	}

	@Test(priority = 7)
	public void SignUpthirdPage() throws IOException, InterruptedException {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.findElement(By.xpath("//input[@placeholder='Telephone No (Optional)']")).sendKeys(testdata.PhoneNumber());
		driver.findElement(By.xpath("//input[@placeholder=' License Number *']")).sendKeys(testdata.PhoneNumber());
		logger.info("*Upload License Image*");
		WebElement upl = driver.findElement(By.cssSelector("input[type=file]"));
		upl.sendKeys("/home/jc-raj/Music/Automation/KindaProject/src/test/java/testBase/jc.jpg");
		Thread.sleep(3000);
		logger.info("*License image uploaded*");
		driver.findElement(By.xpath("(//input[@id='checkbox1'])[1]")).click();
		driver.findElement(By.xpath("//button[@type='submit' or @class='primary' or text()='Next']")).click();
		logger.info("✅ Test passed: Sign Up Third Page Form filled and progressed successfully.");
	}

	@Test(priority = 8)
	public void SignUpConfirmation() throws IOException, InterruptedException {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		Thread.sleep(3000);
		WebElement titleElement = driver
				.findElement(By.xpath("//h5[normalize-space()='Thank you for Your Registration .']"));
		String titleText = titleElement.getText();
		logger.info("Modal Title: " + titleText);
		logger.info("*Verified Confirmation message*");
		// 3. Grab the subtext (below the title)
		WebElement messageElement = driver
				.findElement(By.xpath("//h5[contains(text(),'Please wait until your profile verification is com')]"));
		String messageText = messageElement.getText();
		logger.info("Modal Message: " + messageText);
		// 4. Assert the contents
		Assert.assertEquals(titleText.trim(), "Thank you for Your Registration .");
		Assert.assertEquals(messageText.trim(), "Please wait until your profile verification is completed.");
		// 5. Click the OK button
		WebElement okButton = driver.findElement(By.xpath("//button[normalize-space()='Ok']"));
		okButton.click();

	}

	@Test(priority = 9)
	public void RedirectToHome() throws IOException, InterruptedException {
		Thread.sleep(2000);
		String actualUrl = driver.getCurrentUrl();
		System.out.println("Current URL: " + actualUrl);
		// Validate the URL matches exactly
		Assert.assertEquals(actualUrl, "https://kinda.jcsoftwaresolution.in/login",
				"URL does not match the expected home page.");
		logger.info("*Finished the Driver_SignUp_with_valid_dataTest*");
	}

	@Test(priority = 10)
	public void QuitBrowser() throws IOException, InterruptedException {
		Thread.sleep(3000);
		if (driver != null) {
			driver.quit();
		}
		logger.info("*Browser Closed*");

	}

}