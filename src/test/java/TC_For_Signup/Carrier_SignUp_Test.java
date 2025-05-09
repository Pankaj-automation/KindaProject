package TC_For_Signup;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;

import org.testng.AssertJUnit;
import com.google.common.io.Files;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import net.datafaker.Faker;
import utilities.Reuseable;

import org.testng.annotations.Test;
import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.time.Duration;
import java.util.HashMap;
import java.util.List;
import java.util.Random;
import java.util.UUID;

import org.apache.logging.log4j.LogManager;
import org.apache.xmlbeans.impl.xb.xsdschema.FieldDocument.Field.Xpath;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import utilities.Reuseable;

public class Carrier_SignUp_Test {
	WebDriver driver;
	Logger logger;

	@Test(priority = 1)
	public void Setup() {

		Reuseable Reuseable = new Reuseable();
		driver = Reuseable.Reuseable1();
		logger = LogManager.getLogger(this.getClass());

	}

	@Test(priority = 2)
	public void FirstStep() throws IOException, InterruptedException {
		logger.info("*****Opening Browser*****");

		logger.info("*****Started the Carrier_SignUp_Test*****");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		driver.findElement(By.xpath("//button[normalize-space()='Get Started Free']")).click();
		WebElement activeStep = driver.findElement(By.xpath("//div[contains(text(),'1')]")); // Update
		String actualClass = activeStep.getAttribute("class");
		String expectedClass = "activebar"; // Adjust as needed
		AssertJUnit.assertEquals(actualClass, expectedClass, "Active step class mismatch!");
		if (actualClass.equals(expectedClass)) {
			logger.info("First Step - Step One is activated");

		} else {
			logger.info("First Step - Step One is not activated");
		}

	}

	@Test(priority = 3)
	public void SignUpFirstPage() throws IOException, InterruptedException {

		Faker testdata = new Faker();
		String firstName = testdata.name().firstName();
		String lastName = testdata.name().lastName();
		String email = firstName.toLowerCase() + "@yopmail.com";
		String password = firstName.toLowerCase() + "A51%%";

		WebElement drop = driver.findElement(By.xpath(
				"/html[1]/body[1]/div[1]/div[1]/div[1]/div[1]/div[1]/form[1]/div[2]/div[1]/div[1]/div[1]/select[1]"));
		// drop.click();
		Thread.sleep(1000);
		Select sel = new Select(drop);
		sel.selectByIndex(1);
		AssertJUnit.assertEquals(sel.getFirstSelectedOption().getText(), "Carrier", "❌ Dropdown 1 selection failed");
		driver.findElement(By.xpath("//input[@placeholder='First Name *']")).sendKeys(firstName);
		driver.findElement(By.xpath("//input[@placeholder='Last Name (Optional)']")).sendKeys(lastName);
		driver.findElement(By.xpath("//input[@placeholder='Email address *']")).sendKeys(email);

		WebElement drop1 = driver.findElement(By.xpath(
				"/html[1]/body[1]/div[1]/div[1]/div[1]/div[1]/div[1]/form[1]/div[2]/div[5]/div[1]/div[1]/select[1]"));
		// drop.click();
		Thread.sleep(1000);
		Select sel1 = new Select(drop1);
		sel1.selectByIndex(2);
		AssertJUnit.assertEquals(sel1.getFirstSelectedOption().getText(), "Manager", "❌ Dropdown 2 selection failed");
		driver.findElement(By.xpath("//input[@placeholder='Password *']")).sendKeys(password);
		driver.findElement(By.xpath("//input[@placeholder='Confirm Password *']")).sendKeys(password);
		driver.findElement(By.xpath("(//button[normalize-space()='Next'])[1]")).click();

		logger.info("✅ Test passed: Sign Up First Page Form filled and progressed successfully.");

	}

	@Test(priority = 4)
	public void StepTwo() throws IOException, InterruptedException {
		Thread.sleep(2000);
		WebElement activeStep = driver.findElement(By.xpath("//div[contains(text(),'2')]")); // Update
		String actualClass = activeStep.getAttribute("class");
		String expectedClass = "activebar"; // Adjust as needed
		AssertJUnit.assertEquals(actualClass, expectedClass, "Active step class mismatch!");
		if (actualClass.equals(expectedClass)) {
			logger.info("Step Two - Step two is activated");

		} else {
			logger.info("Step Two - Step two is not activated");
		}

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

		// driver.findElement(By.xpath("//div[@class='activebar']")).click();
		// driver.findElement(By.xpath("//input[@placeholder='State
		// *']")).sendKeys("Punjab");
		// driver.findElement(By.xpath("//input[@placeholder='City
		// *']")).sendKeys("Sahibzada Ajit Singh Nagar");
		driver.findElement(By.xpath("//input[@placeholder='Zipcode *']")).sendKeys("324324");
		// driver.findElement(By.xpath("//input[@placeholder='Country
		// *']")).sendKeys("India");
		driver.findElement(By.xpath("//button[normalize-space()='Next']")).click();
		logger.info("✅ Test passed: Sign Up Second Page Form filled and progressed successfully.");
	}

	@Test(priority = 6)
	public void StepThree() throws IOException, InterruptedException {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		Thread.sleep(2000);
		WebElement activeStep = driver.findElement(By.xpath("//div[contains(text(),'3')]")); // Update
		String actualClass = activeStep.getAttribute("class");
		String expectedClass = "activebar"; // Adjust as needed
		AssertJUnit.assertEquals(actualClass, expectedClass, "Active step class mismatch!");
		if (actualClass.equals(expectedClass)) {
			logger.info("Step Three - Step three is activated");

		} else {
			logger.info("Step Three - Step three is not activated");
		}
	}

	@Test(priority = 7)
	public void SignUpthirdPage() throws IOException {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		driver.findElement(By.xpath("//input[@placeholder=' Company Name *']")).sendKeys("India");
		driver.findElement(By.xpath("//input[@placeholder='Tax Number *']")).sendKeys("India");
		driver.findElement(By.xpath("//input[@placeholder='MC # *']")).sendKeys("23");
		driver.findElement(By.xpath("//input[@placeholder='DOT # *']")).sendKeys("232");

		driver.findElement(By.xpath("//button[normalize-space()='Next']")).click();
		logger.info("✅ Test passed: Sign Up Third Page Form filled and progressed successfully.");
	}

	@Test(priority = 8)
	public void StepFour() throws IOException, InterruptedException {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		Thread.sleep(2000);
		WebElement activeStep = driver.findElement(By.xpath("//div[contains(text(),'4')]")); // Update
		String actualClass = activeStep.getAttribute("class");
		String expectedClass = "activebar"; // Adjust as needed
		AssertJUnit.assertEquals(actualClass, expectedClass, "Active step class mismatch!");
		if (actualClass.equals(expectedClass)) {
			logger.info("Step Four - Step four is activated");

		} else {
			logger.info("Step Four - Step four is not activated");
		}
	}

	@Test(priority = 9)
	public void SignUpFfourthPage() throws IOException {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		driver.findElement(By.xpath("//input[@placeholder='Number of Trailers *']")).sendKeys("232");
		driver.findElement(By.xpath("//input[@placeholder='Solo Truck *']")).sendKeys("2");
		driver.findElement(By.xpath("//input[@placeholder='Team Truck *']")).sendKeys("2");
		driver.findElement(By.xpath("//input[@id='dry_van']")).click();
		driver.findElement(By.xpath("//input[@id='checkbox1']")).click();
		driver.findElement(By.xpath("//button[normalize-space()='Sign Up']")).click();
		logger.info("✅ Test passed: Sign Up Fourth Page Form filled and progressed successfully.");
	}

	@Test(priority = 10)
	public void SignUpConfirmation() throws IOException, InterruptedException {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		Thread.sleep(3000);

		WebElement titleElement = driver
				.findElement(By.xpath("//h5[normalize-space()='Thank you for Your Registration .']"));
		String titleText = titleElement.getText();
		logger.info("Modal Title: " + titleText);

		// 3. Grab the subtext (below the title)
		WebElement messageElement = driver
				.findElement(By.xpath("//h5[contains(text(),'Please wait until your profile verification is com')]"));
		String messageText = messageElement.getText();
		logger.info("Modal Message: " + messageText);

		// 4. Assert the contents
		AssertJUnit.assertEquals(titleText.trim(), "Thank you for Your Registration .");
		AssertJUnit.assertEquals(messageText.trim(), "Please wait until your profile verification is completed.");

		// 5. Click the OK button
		WebElement okButton = driver.findElement(By.xpath("//button[normalize-space()='Ok']"));
		okButton.click();

	}

	@Test(priority = 11)
	public void RedirectToHome() throws IOException, InterruptedException {
		Thread.sleep(2000);
		String actualUrl = driver.getCurrentUrl();
		logger.info("Current URL: " + actualUrl);

		// Validate the URL matches exactly
		AssertJUnit.assertEquals(actualUrl, "https://kinda.jcsoftwaresolution.in/login",
				"URL does not match the expected home page.");
		logger.info("*****Finished the Carrier_SignUp_Test*****");
	}

	@Test(priority = 12)
	public void QuitBrowser() throws IOException, InterruptedException {
		Thread.sleep(3000);
		if (driver != null) {
			driver.quit();
		}
	}

}