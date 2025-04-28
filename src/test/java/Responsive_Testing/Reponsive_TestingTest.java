package Responsive_Testing;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.imageio.ImageIO;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;
import ru.yandex.qatools.ashot.shooting.ShootingStrategies;
import utilities.Extentreportmanager;
import utilities.Reuseable;

public class Reponsive_TestingTest {
	WebDriver driver;
	Reuseable testdata;
	Logger logger = LogManager.getLogger(this.getClass());
	ExtentReports extent = Extentreportmanager.getExtentReports();
	ExtentTest test;

	@Test(priority = 1)
	public void Home() throws IOException, InterruptedException {
		testdata = new Reuseable();
		driver = testdata.Reuseable1();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		test = extent.createTest("Responsive Testing");

		test.info("*Started Home Responsive Test*");
		logger.info("*Started Home Responsive Test*");

		driver.get("https://kinda.jcsoftwaresolution.in/");
		Dimensions();

		test.info("*Finished Home Responsive Test*");
		logger.info("*Finished Home Responsive Test*");
	}

	/*
	 * @Test(priority = 2) public void Aboutus() throws IOException {
	 * test.info("*Started About Us Responsive Test*");
	 * logger.info("*Started About Us Responsive Test*");
	 * 
	 * driver.get("https://kinda.jcsoftwaresolution.in/aboutus"); Dimensions();
	 * 
	 * test.info("*Finished About Us Responsive Test*");
	 * logger.info("*Finished About Us Responsive Test*"); }
	 * 
	 * @Test(priority = 3) public void Contact() throws IOException {
	 * test.info("*Started Contact Responsive Test*");
	 * logger.info("*Started Contact Responsive Test*");
	 * 
	 * driver.get("https://kinda.jcsoftwaresolution.in/contactus"); Dimensions();
	 * 
	 * test.info("*Finished Contact Responsive Test*");
	 * logger.info("*Finished Contact Responsive Test*"); }
	 * 
	 * @Test(priority = 4) public void Login() throws IOException,
	 * InterruptedException { test.info("*Started Login Responsive Test*");
	 * logger.info("*Started Login Responsive Test*");
	 * 
	 * driver.get("https://kinda.jcsoftwaresolution.in/login"); Dimensions();
	 * 
	 * test.info("*Finished Login Responsive Test*");
	 * logger.info("*Finished Login Responsive Test*"); }
	 * 
	 * /*
	 * 
	 * @Test(priority = 5) public void SignUp() throws IOException {
	 * test.info("*Started SignUp Responsive Test*");
	 * logger.info("*Started SignUp Responsive Test*");
	 * 
	 * driver.get("https://kinda.jcsoftwaresolution.in/signup"); Dimensions();
	 * 
	 * test.info("*Finished SignUp Responsive Test*");
	 * logger.info("*Finished SignUp Responsive Test*"); }
	 * 
	 * @Test(priority = 6) public void Forgot_Password() throws IOException {
	 * test.info("*Started SignUp Responsive Test*");
	 * logger.info("*Started SignUp Responsive Test*");
	 * 
	 * driver.get("https://kinda.jcsoftwaresolution.in/forgotpassword");
	 * Dimensions();
	 * 
	 * test.info("*Finished SignUp Responsive Test*");
	 * logger.info("*Finished SignUp Responsive Test*"); }
	 */
	@Test(priority = 7)
	public void Carrier_Login() throws IOException, InterruptedException {
		test.info("*Started Carrier_Login Responsive Test*");
		logger.info("*Started Carrier_Login Responsive Test*");

		driver.get("https://kinda.jcsoftwaresolution.in/login");
		driver.findElement(By.xpath("//input[@placeholder='Enter Email *']")).sendKeys("Carrierthree@yopmail.com");
		driver.findElement(By.xpath("//input[@placeholder='Enter Password *']")).sendKeys("Carrier@123");
		driver.findElement(By.xpath("//button[normalize-space()='Sign in']")).click();
		Thread.sleep(4000);
		Dimensions();
		Thread.sleep(1000);
		((JavascriptExecutor) driver).executeScript("window.scrollBy(0, -500);");
		Thread.sleep(1000);

		driver.findElement(By.xpath("(//a[@href='/trucks'])[1]")).click();
		Thread.sleep(3000);

		Dimensions();
		Thread.sleep(1000);
		((JavascriptExecutor) driver).executeScript("window.scrollBy(0, -500);");
		Thread.sleep(1000);

		driver.findElement(By.xpath("(//a[@href='/drivers'])[1]")).click();
		Thread.sleep(3000);

		Dimensions();
		Thread.sleep(1000);
		((JavascriptExecutor) driver).executeScript("window.scrollBy(0, -500);");
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//a[contains(@href,'/carrierstaff')])[1]")).click();
		Thread.sleep(3000);

		Dimensions();
		Thread.sleep(1000);
		((JavascriptExecutor) driver).executeScript("window.scrollBy(0, -500);");
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//a[contains(@href,'/department')])[1]")).click();
		Thread.sleep(3000);

		Dimensions();
		Thread.sleep(1000);
		((JavascriptExecutor) driver).executeScript("window.scrollBy(0, -500);");
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//a[contains(@href,'/tasks')])[1]")).click();
		Thread.sleep(3000);

		Dimensions();
		Thread.sleep(2000);
		((JavascriptExecutor) driver).executeScript("window.scrollBy(0, -500);");
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//button[contains(@class, 'w-full') and contains(@class, 'p-2.5') and contains(@class, 'rounded-lg')]")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//a[@href='/loads'])[1]")).click();
		Thread.sleep(3000);

		Dimensions();
		Thread.sleep(1000);
		((JavascriptExecutor) driver).executeScript("window.scrollBy(0, -500);");
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//a[contains(@href,'/pendingpickuploads')])[1]")).click();
		Thread.sleep(3000);

		Dimensions();
		Thread.sleep(1000);
		((JavascriptExecutor) driver).executeScript("window.scrollBy(0, -500);");
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//a[contains(@href,'/intransitloads')])[1]")).click();
		Thread.sleep(3000);

		Dimensions();
		Thread.sleep(1000);
		((JavascriptExecutor) driver).executeScript("window.scrollBy(0, -500);");
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//a[contains(@href,'/deliveredloads')])[1]")).click();
		Thread.sleep(3000);

		Dimensions();
		Thread.sleep(1000);
		((JavascriptExecutor) driver).executeScript("window.scrollBy(0, -500);");
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//a[contains(@href,'/activeplan')])[1]")).click();
		Thread.sleep(3000);

		Dimensions();
		Thread.sleep(1000);
		((JavascriptExecutor) driver).executeScript("window.scrollBy(0, -500);");
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//a[contains(@href,'/transaction')])[1]")).click();
		Thread.sleep(3000);

		Dimensions();
		Thread.sleep(1000);
		((JavascriptExecutor) driver).executeScript("window.scrollBy(0, -500);");
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//a[contains(@href,'/shipmentnotes')])[1]")).click();
		Thread.sleep(3000);

		Dimensions();
		Thread.sleep(1000);
		((JavascriptExecutor) driver).executeScript("window.scrollBy(0, -500);");
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//a[contains(@href,'/notification')])[1]")).click();
		Thread.sleep(3000);

		test.info("*Finished Carrier_Login Responsive Test*");
		logger.info("*Finished Carrier_Login Responsive Test*");
	}

	/*
	 * @Test(priority = 8) public void Driver_Login() throws IOException {
	 * test.info("*Started Driver_Login Responsive Test*");
	 * logger.info("*Started Driver_Login Responsive Test*");
	 * 
	 * driver.get("https://kinda.jcsoftwaresolution.in/forgotpassword");
	 * Dimensions();
	 * 
	 * test.info("*Finished Driver_Login Responsive Test*");
	 * logger.info("*Finished Driver_Login Responsive Test*"); }
	 * 
	 * @Test(priority = 9) public void Staff_Login() throws IOException {
	 * test.info("*Started Staff_Login Responsive Test*");
	 * logger.info("*Started Staff_Login Responsive Test*");
	 * 
	 * driver.get("https://kinda.jcsoftwaresolution.in/forgotpassword");
	 * Dimensions();
	 * 
	 * test.info("*Finished Staff_Login Responsive Test*");
	 * logger.info("*Finished Staff_Login Responsive Test*"); }
	 */
	public void Dimensions() throws IOException, InterruptedException {
		Dimension[] sizes = { new Dimension(375, 812), // iPhone X
				// new Dimension(768, 1024), // iPad
				// new Dimension(1024, 768), // Tablet landscape
				// new Dimension(1440, 900) // Desktop

		};
		for (Dimension size : sizes) {
			driver.manage().window().setSize(size);
			logger.info("✅ Testing on resolution: " + size);

			try {
				Thread.sleep(2000); // Let layout adjust
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

			JavascriptExecutor js = (JavascriptExecutor) driver;

			// Scroll to top before doing anything
			js.executeScript("window.scrollTo(0, 0);");

			// ⛔ Convert sticky header to static so it shows only once
			js.executeScript("Array.from(document.querySelectorAll('*')).forEach(el => {"
					+ "if (getComputedStyle(el).position === 'fixed' || getComputedStyle(el).position === 'sticky') "
					+ "el.style.position = 'static';" + "});");

			Screenshot screenshot = new AShot().shootingStrategy(ShootingStrategies.viewportPasting(1000))
					.takeScreenshot(driver);

			String methodName = Thread.currentThread().getStackTrace()[2].getMethodName(); // 2 gets the actual caller
			String timestamp = new SimpleDateFormat("yyyy.MM.dd_HH.mm.ss").format(new Date());

			String filePath = "/home/jc-raj/Music/Automation/KindaProject/src/test/java/Responsive_Testing/"
					+ methodName + "_" + size.getWidth() + "x" + size.getHeight() + "_" + timestamp + ".png";
			new File("screenshots").mkdirs();
			ImageIO.write(screenshot.getImage(), "PNG", new File(filePath));

			logger.info("📸 Saved screenshot at: " + filePath);
			logger.info("✅ Tested on resolution: " + size);
		}

	}

	/*
	 * @AfterClass public void tearDown() { if (driver != null) { driver.quit();
	 * logger.info("🔚 Browser closed after all tests."); }
	 */
}
