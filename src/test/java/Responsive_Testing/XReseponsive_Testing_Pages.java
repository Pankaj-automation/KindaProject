package Responsive_Testing;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

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

public class XReseponsive_Testing_Pages {
	WebDriver driver;
	Reuseable testdata;
	Logger logger = LogManager.getLogger(this.getClass());
	ExtentReports extent = Extentreportmanager.getExtentReports();
	ExtentTest test;

	public void Setup(String methodName) throws IOException, InterruptedException {
		String callingMethodName = Thread.currentThread().getStackTrace()[2].getMethodName();

		testdata = new Reuseable();
		driver = testdata.Reuseable1();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		//test = extent.createTest("Responsive Testing");

	
	}
	public void Home_Page(String methodName) throws IOException, InterruptedException {

		test.info("*Started " + methodName + " Responsive Test*");
		logger.info("*Started " + methodName + " Responsive Test*");

		driver.get("https://kinda.jcsoftwaresolution.in/");
		List<String> screenshotPaths = Dimensions(methodName);

		// Loop through all the screenshots and add them to the report
		for (String screenshotPath : screenshotPaths) {
			test.pass("Responsive screenshot attached for resolution: " + screenshotPath)
					.addScreenCaptureFromPath(screenshotPath); // Attach each screenshot
		}
		test.info("*Finished " + methodName + " Responsive Test*");
		logger.info("*Finished " + methodName + " Responsive Test*");
	}

	public void Aboutus_Page(String methodName) throws IOException, InterruptedException {
		test.info("*Started " + methodName + " Responsive Test*");
		logger.info("*Started " + methodName + " Responsive Test*");

		driver.get("https://kinda.jcsoftwaresolution.in/aboutus");
		List<String> screenshotPaths = Dimensions(methodName);

		// Loop through all the screenshots and add them to the report
		for (String screenshotPath : screenshotPaths) {
			test.pass("Responsive screenshot attached for resolution: " + screenshotPath)
					.addScreenCaptureFromPath(screenshotPath); // Attach each screenshot
		}
		test.info("*Finished " + methodName + " Responsive Test*");
		logger.info("*Finished " + methodName + " Responsive Test*");
	}

	public void Contact_Page(String methodName) throws IOException, InterruptedException {

		test.info("*Started " + methodName + " Responsive Test*");
		logger.info("*Started " + methodName + " Responsive Test*");

		driver.get("https://kinda.jcsoftwaresolution.in/contactus");
		List<String> screenshotPaths = Dimensions(methodName);

		// Loop through all the screenshots and add them to the report
		for (String screenshotPath : screenshotPaths) {
			test.pass("Responsive screenshot attached for resolution: " + screenshotPath)
					.addScreenCaptureFromPath(screenshotPath); // Attach each screenshot
		}
		test.info("*Finished " + methodName + " Responsive Test*");
		logger.info("*Finished " + methodName + " Responsive Test*");
	}

	public void Login_Page(String methodName) throws IOException, InterruptedException {

		test.info("*Started " + methodName + " Responsive Test*");
		logger.info("*Started " + methodName + " Responsive Test*");

		driver.get("https://kinda.jcsoftwaresolution.in/login");
		List<String> screenshotPaths = Dimensions(methodName);

		// Loop through all the screenshots and add them to the report
		for (String screenshotPath : screenshotPaths) {
			test.pass("Responsive screenshot attached for resolution: " + screenshotPath)
					.addScreenCaptureFromPath(screenshotPath); // Attach each screenshot
		}
		test.info("*Finished " + methodName + " Responsive Test*");
		logger.info("*Finished " + methodName + " Responsive Test*");
	}

	public void SignUp_Page(String methodName) throws IOException, InterruptedException {

		test.info("*Started " + methodName + " Responsive Test*");
		logger.info("*Started " + methodName + " Responsive Test*");

		driver.get("https://kinda.jcsoftwaresolution.in/signup");
		List<String> screenshotPaths = Dimensions(methodName);

		// Loop through all the screenshots and add them to the report
		for (String screenshotPath : screenshotPaths) {
			test.pass("Responsive screenshot attached for resolution: " + screenshotPath)
					.addScreenCaptureFromPath(screenshotPath); // Attach each screenshot
		}
		test.info("*Finished " + methodName + " Responsive Test*");
		logger.info("*Finished " + methodName + " Responsive Test*");
	}

	public void Forgot_Password_Page(String methodName) throws IOException, InterruptedException {

		test.info("*Started " + methodName + " Responsive Test*");
		logger.info("*Started " + methodName + " Responsive Test*");

		driver.get("https://kinda.jcsoftwaresolution.in/forgotpassword");
		List<String> screenshotPaths = Dimensions(methodName);

		// Loop through all the screenshots and add them to the report
		for (String screenshotPath : screenshotPaths) {
			test.pass("Responsive screenshot attached for resolution: " + screenshotPath)
					.addScreenCaptureFromPath(screenshotPath); // Attach each screenshot
		}
		test.info("*Finished " + methodName + " Responsive Test*");
		logger.info("*Finished " + methodName + " Responsive Test*");
	}

	public void Carrier_Login_Page(String methodName) throws IOException, InterruptedException {
		test.info("*Carrier Login*");
		logger.info("*Carrier Login*");

		driver.get("https://kinda.jcsoftwaresolution.in/login");
		driver.findElement(By.xpath("//input[@placeholder='Enter Email *']")).sendKeys("Carrierthree@yopmail.com");
		driver.findElement(By.xpath("//input[@placeholder='Enter Password *']")).sendKeys("Carrier@123");
		driver.findElement(By.xpath("//button[normalize-space()='Sign in']")).click();
		Thread.sleep(4000);
		test.info("*Carrier Logged in*");
		logger.info("*Carrier Logged in*");
	}

	public void Driver_Login_Page(String methodName) throws IOException, InterruptedException {
		test.info("*Driver login*");
		logger.info("*Driver login*");

		driver.get("https://kinda.jcsoftwaresolution.in/login");
		driver.findElement(By.xpath("//input[@placeholder='Enter Email *']")).sendKeys("threedriver@yopmail.com");
		driver.findElement(By.xpath("//input[@placeholder='Enter Password *']")).sendKeys("Three@123");
		driver.findElement(By.xpath("//button[normalize-space()='Sign in']")).click();
		Thread.sleep(4000);
		test.info("*Driver logged in*");
		logger.info("*Driver logged in*");
	}

	public void Staff_Login_Page(String methodName) throws IOException, InterruptedException {
		test.info("*Staff Login *");
		logger.info("*Staff Login *");

		driver.get("https://kinda.jcsoftwaresolution.in/login");
		driver.findElement(By.xpath("//input[@placeholder='Enter Email *']")).sendKeys("threestaff@yopmail.com");
		driver.findElement(By.xpath("//input[@placeholder='Enter Password *']")).sendKeys("Staff@123");
		driver.findElement(By.xpath("//button[normalize-space()='Sign in']")).click();
		Thread.sleep(4000);
		test.info("*Staff Logged in*");
		logger.info("*Staff Logged in*");
	}

	public void Profile_Page(String methodName) throws IOException, InterruptedException {

		test.info("*Started " + methodName + " Responsive Test*");
		logger.info("*Started " + methodName + " Responsive Test*");

		driver.get("https://kinda.jcsoftwaresolution.in/profile");
		List<String> screenshotPaths = Dimensions(methodName);

		// Loop through all the screenshots and add them to the report
		for (String screenshotPath : screenshotPaths) {
			test.pass("Responsive screenshot attached for resolution: " + screenshotPath)
					.addScreenCaptureFromPath(screenshotPath); // Attach each screenshot
		}
		test.info("*Finished " + methodName + " Responsive Test*");
		logger.info("*Finished " + methodName + " Responsive Test*");
	}

	public void Dashboard_Page(String methodName) throws IOException, InterruptedException {

		test.info("*Started " + methodName + " Responsive Test*");
		logger.info("*Started " + methodName + " Responsive Test*");

		driver.get("https://kinda.jcsoftwaresolution.in/dashboard");
		List<String> screenshotPaths = Dimensions(methodName);

		// Loop through all the screenshots and add them to the report
		for (String screenshotPath : screenshotPaths) {
			test.pass("Responsive screenshot attached for resolution: " + screenshotPath)
					.addScreenCaptureFromPath(screenshotPath); // Attach each screenshot
		}
		test.info("*Finished " + methodName + " Responsive Test*");
		logger.info("*Finished " + methodName + " Responsive Test*");
	}

	public void Trucks_Page(String methodName) throws IOException, InterruptedException {

		test.info("*Started " + methodName + " Responsive Test*");
		logger.info("*Started " + methodName + " Responsive Test*");

		driver.get("https://kinda.jcsoftwaresolution.in/trucks");
		List<String> screenshotPaths = Dimensions(methodName);

		// Loop through all the screenshots and add them to the report
		for (String screenshotPath : screenshotPaths) {
			test.pass("Responsive screenshot attached for resolution: " + screenshotPath)
					.addScreenCaptureFromPath(screenshotPath); // Attach each screenshot
		}
		test.info("*Finished " + methodName + " Responsive Test*");
		logger.info("*Finished " + methodName + " Responsive Test*");
	}

	public void Drivers_Page(String methodName) throws IOException, InterruptedException {

		test.info("*Started " + methodName + " Responsive Test*");
		logger.info("*Started " + methodName + " Responsive Test*");

		driver.get("https://kinda.jcsoftwaresolution.in/drivers");
		List<String> screenshotPaths = Dimensions(methodName);

		// Loop through all the screenshots and add them to the report
		for (String screenshotPath : screenshotPaths) {
			test.pass("Responsive screenshot attached for resolution: " + screenshotPath)
					.addScreenCaptureFromPath(screenshotPath); // Attach each screenshot
		}
		test.info("*Finished " + methodName + " Responsive Test*");
		logger.info("*Finished " + methodName + " Responsive Test*");
	}
	public void Staff_Page(String methodName) throws IOException, InterruptedException {

		test.info("*Started " + methodName + " Responsive Test*");
		logger.info("*Started " + methodName + " Responsive Test*");

		driver.get("https://kinda.jcsoftwaresolution.in/carrierstaff");
		List<String> screenshotPaths = Dimensions(methodName);

		// Loop through all the screenshots and add them to the report
		for (String screenshotPath : screenshotPaths) {
			test.pass("Responsive screenshot attached for resolution: " + screenshotPath)
					.addScreenCaptureFromPath(screenshotPath); // Attach each screenshot
		}
		test.info("*Finished " + methodName + " Responsive Test*");
		logger.info("*Finished " + methodName + " Responsive Test*");
	}


	public void Departments_Page(String methodName) throws IOException, InterruptedException {

		test.info("*Started " + methodName + " Responsive Test*");
		logger.info("*Started " + methodName + " Responsive Test*");

		driver.get("https://kinda.jcsoftwaresolution.in/department");
		List<String> screenshotPaths = Dimensions(methodName);

		// Loop through all the screenshots and add them to the report
		for (String screenshotPath : screenshotPaths) {
			test.pass("Responsive screenshot attached for resolution: " + screenshotPath)
					.addScreenCaptureFromPath(screenshotPath); // Attach each screenshot
		}
		test.info("*Finished " + methodName + " Responsive Test*");
		logger.info("*Finished " + methodName + " Responsive Test*");
	}

	public void Tasks_Page(String methodName) throws IOException, InterruptedException {

		test.info("*Started " + methodName + " Responsive Test*");
		logger.info("*Started " + methodName + " Responsive Test*");

		driver.get("https://kinda.jcsoftwaresolution.in/tasks");
		List<String> screenshotPaths = Dimensions(methodName);

		// Loop through all the screenshots and add them to the report
		for (String screenshotPath : screenshotPaths) {
			test.pass("Responsive screenshot attached for resolution: " + screenshotPath)
					.addScreenCaptureFromPath(screenshotPath); // Attach each screenshot
		}
		test.info("*Finished " + methodName + " Responsive Test*");
		logger.info("*Finished " + methodName + " Responsive Test*");
	}
	public void Task_Page(String methodName) throws IOException, InterruptedException {

		test.info("*Started " + methodName + " Responsive Test*");
		logger.info("*Started " + methodName + " Responsive Test*");

		driver.get("https://kinda.jcsoftwaresolution.in/task");
		List<String> screenshotPaths = Dimensions(methodName);

		// Loop through all the screenshots and add them to the report
		for (String screenshotPath : screenshotPaths) {
			test.pass("Responsive screenshot attached for resolution: " + screenshotPath)
					.addScreenCaptureFromPath(screenshotPath); // Attach each screenshot
		}
		test.info("*Finished " + methodName + " Responsive Test*");
		logger.info("*Finished " + methodName + " Responsive Test*");
	}
	public void Pending_Pickup_Task_Page(String methodName) throws IOException, InterruptedException {

		test.info("*Started " + methodName + " Responsive Test*");
		logger.info("*Started " + methodName + " Responsive Test*");

		driver.get("https://kinda.jcsoftwaresolution.in/pendingpickuptask");
		List<String> screenshotPaths = Dimensions(methodName);

		// Loop through all the screenshots and add them to the report
		for (String screenshotPath : screenshotPaths) {
			test.pass("Responsive screenshot attached for resolution: " + screenshotPath)
					.addScreenCaptureFromPath(screenshotPath); // Attach each screenshot
		}
		test.info("*Finished " + methodName + " Responsive Test*");
		logger.info("*Finished " + methodName + " Responsive Test*");
	}
	public void Pickedup_Task_Page(String methodName) throws IOException, InterruptedException {

		test.info("*Started " + methodName + " Responsive Test*");
		logger.info("*Started " + methodName + " Responsive Test*");

		driver.get("https://kinda.jcsoftwaresolution.in/pickeduptask");
		List<String> screenshotPaths = Dimensions(methodName);

		// Loop through all the screenshots and add them to the report
		for (String screenshotPath : screenshotPaths) {
			test.pass("Responsive screenshot attached for resolution: " + screenshotPath)
					.addScreenCaptureFromPath(screenshotPath); // Attach each screenshot
		}
		test.info("*Finished " + methodName + " Responsive Test*");
		logger.info("*Finished " + methodName + " Responsive Test*");
	}
	public void Intransit_Task_Page(String methodName) throws IOException, InterruptedException {

		test.info("*Started " + methodName + " Responsive Test*");
		logger.info("*Started " + methodName + " Responsive Test*");

		driver.get("https://kinda.jcsoftwaresolution.in/intransittask");
		List<String> screenshotPaths = Dimensions(methodName);

		// Loop through all the screenshots and add them to the report
		for (String screenshotPath : screenshotPaths) {
			test.pass("Responsive screenshot attached for resolution: " + screenshotPath)
					.addScreenCaptureFromPath(screenshotPath); // Attach each screenshot
		}
		test.info("*Finished " + methodName + " Responsive Test*");
		logger.info("*Finished " + methodName + " Responsive Test*");
	}
	public void Deliverd_Task_Page(String methodName) throws IOException, InterruptedException {

		test.info("*Started " + methodName + " Responsive Test*");
		logger.info("*Started " + methodName + " Responsive Test*");

		driver.get("https://kinda.jcsoftwaresolution.in/deliveredtask");
		List<String> screenshotPaths = Dimensions(methodName);

		// Loop through all the screenshots and add them to the report
		for (String screenshotPath : screenshotPaths) {
			test.pass("Responsive screenshot attached for resolution: " + screenshotPath)
					.addScreenCaptureFromPath(screenshotPath); // Attach each screenshot
		}
		test.info("*Finished " + methodName + " Responsive Test*");
		logger.info("*Finished " + methodName + " Responsive Test*");
	}

	public void All_Loads_Page(String methodName) throws IOException, InterruptedException {

		test.info("*Started " + methodName + " Responsive Test*");
		logger.info("*Started " + methodName + " Responsive Test*");

		driver.get("https://kinda.jcsoftwaresolution.in/loads");
		List<String> screenshotPaths = Dimensions(methodName);

		// Loop through all the screenshots and add them to the report
		for (String screenshotPath : screenshotPaths) {
			test.pass("Responsive screenshot attached for resolution: " + screenshotPath)
					.addScreenCaptureFromPath(screenshotPath); // Attach each screenshot
		}
		test.info("*Finished " + methodName + " Responsive Test*");
		logger.info("*Finished " + methodName + " Responsive Test*");
	}

	public void Pending_Pickup_Loads_Page(String methodName) throws IOException, InterruptedException {

		test.info("*Started " + methodName + " Responsive Test*");
		logger.info("*Started " + methodName + " Responsive Test*");

		driver.get("https://kinda.jcsoftwaresolution.in/pendingpickuploads");
		List<String> screenshotPaths = Dimensions(methodName);

		// Loop through all the screenshots and add them to the report
		for (String screenshotPath : screenshotPaths) {
			test.pass("Responsive screenshot attached for resolution: " + screenshotPath)
					.addScreenCaptureFromPath(screenshotPath); // Attach each screenshot
		}
		test.info("*Finished " + methodName + " Responsive Test*");
		logger.info("*Finished " + methodName + " Responsive Test*");
	}

	public void Pickedup_Loads_Page(String methodName) throws IOException, InterruptedException {

		test.info("*Started " + methodName + " Responsive Test*");
		logger.info("*Started " + methodName + " Responsive Test*");

		driver.get("https://kinda.jcsoftwaresolution.in/pickeduploads");
		List<String> screenshotPaths = Dimensions(methodName);

		// Loop through all the screenshots and add them to the report
		for (String screenshotPath : screenshotPaths) {
			test.pass("Responsive screenshot attached for resolution: " + screenshotPath)
					.addScreenCaptureFromPath(screenshotPath); // Attach each screenshot
		}
		test.info("*Finished " + methodName + " Responsive Test*");
		logger.info("*Finished " + methodName + " Responsive Test*");
	}

	public void Intransit_Loads_Page(String methodName) throws IOException, InterruptedException {

		test.info("*Started " + methodName + " Responsive Test*");
		logger.info("*Started " + methodName + " Responsive Test*");

		driver.get("https://kinda.jcsoftwaresolution.in/intransitloads");
		List<String> screenshotPaths = Dimensions(methodName);

		// Loop through all the screenshots and add them to the report
		for (String screenshotPath : screenshotPaths) {
			test.pass("Responsive screenshot attached for resolution: " + screenshotPath)
					.addScreenCaptureFromPath(screenshotPath); // Attach each screenshot
		}
		test.info("*Finished " + methodName + " Responsive Test*");
		logger.info("*Finished " + methodName + " Responsive Test*");
	}

	public void Deliverd_Loads_Page(String methodName) throws IOException, InterruptedException {

		test.info("*Started " + methodName + " Responsive Test*");
		logger.info("*Started " + methodName + " Responsive Test*");

		driver.get("https://kinda.jcsoftwaresolution.in/deliveredloads");
		List<String> screenshotPaths = Dimensions(methodName);

		// Loop through all the screenshots and add them to the report
		for (String screenshotPath : screenshotPaths) {
			test.pass("Responsive screenshot attached for resolution: " + screenshotPath)
					.addScreenCaptureFromPath(screenshotPath); // Attach each screenshot
		}
		test.info("*Finished " + methodName + " Responsive Test*");
		logger.info("*Finished " + methodName + " Responsive Test*");
	}

	public void Active_Plan_Page(String methodName) throws IOException, InterruptedException {

		test.info("*Started " + methodName + " Responsive Test*");
		logger.info("*Started " + methodName + " Responsive Test*");

		driver.get("https://kinda.jcsoftwaresolution.in/activeplan");
		List<String> screenshotPaths = Dimensions(methodName);

		// Loop through all the screenshots and add them to the report
		for (String screenshotPath : screenshotPaths) {
			test.pass("Responsive screenshot attached for resolution: " + screenshotPath)
					.addScreenCaptureFromPath(screenshotPath); // Attach each screenshot
		}
		test.info("*Finished " + methodName + " Responsive Test*");
		logger.info("*Finished " + methodName + " Responsive Test*");

	}

	public void Transactions_Page(String methodName) throws IOException, InterruptedException {

		test.info("*Started " + methodName + " Responsive Test*");
		logger.info("*Started " + methodName + " Responsive Test*");

		driver.get("https://kinda.jcsoftwaresolution.in/transaction");
		List<String> screenshotPaths = Dimensions(methodName);

		// Loop through all the screenshots and add them to the report
		for (String screenshotPath : screenshotPaths) {
			test.pass("Responsive screenshot attached for resolution: " + screenshotPath)
					.addScreenCaptureFromPath(screenshotPath); // Attach each screenshot
		}
		test.info("*Finished " + methodName + " Responsive Test*");
		logger.info("*Finished " + methodName + " Responsive Test*");
	}

	public void Shipment_Notes_Page(String methodName) throws IOException, InterruptedException {

		test.info("*Started " + methodName + " Responsive Test*");
		logger.info("*Started " + methodName + " Responsive Test*");

		driver.get("https://kinda.jcsoftwaresolution.in/shipmentnotes");
		List<String> screenshotPaths = Dimensions(methodName);

		// Loop through all the screenshots and add them to the report
		for (String screenshotPath : screenshotPaths) {
			test.pass("Responsive screenshot attached for resolution: " + screenshotPath)
					.addScreenCaptureFromPath(screenshotPath); // Attach each screenshot
		}
		test.info("*Finished " + methodName + " Responsive Test*");
		logger.info("*Finished " + methodName + " Responsive Test*");

	}
	public void Carriers_Page(String methodName) throws IOException, InterruptedException {

		test.info("*Started " + methodName + " Responsive Test*");
		logger.info("*Started " + methodName + " Responsive Test*");

		driver.get("https://kinda.jcsoftwaresolution.in/carriers");
		List<String> screenshotPaths = Dimensions(methodName);

		// Loop through all the screenshots and add them to the report
		for (String screenshotPath : screenshotPaths) {
			test.pass("Responsive screenshot attached for resolution: " + screenshotPath)
					.addScreenCaptureFromPath(screenshotPath); // Attach each screenshot
		}
		test.info("*Finished " + methodName + " Responsive Test*");
		logger.info("*Finished " + methodName + " Responsive Test*");

	}

	public void Notification_Page(String methodName) throws IOException, InterruptedException {

		test.info("*Started " + methodName + " Responsive Test*");
		logger.info("*Started " + methodName + " Responsive Test*");

		driver.get("https://kinda.jcsoftwaresolution.in/notification");
		List<String> screenshotPaths = Dimensions(methodName);

		// Loop through all the screenshots and add them to the report
		for (String screenshotPath : screenshotPaths) {
			test.pass("Responsive screenshot attached for resolution: " + screenshotPath)
					.addScreenCaptureFromPath(screenshotPath); // Attach each screenshot
		}
		test.info("*Finished " + methodName + " Responsive Test*");
		logger.info("*Finished " + methodName + " Responsive Test*");
	}

	public void Privacy_Policy_Page(String methodName) throws IOException, InterruptedException {

		test.info("*Started " + methodName + " Responsive Test*");
		logger.info("*Started " + methodName + " Responsive Test*");

		driver.get("https://kinda.jcsoftwaresolution.in/privacypolicy");
		List<String> screenshotPaths = Dimensions(methodName);

		// Loop through all the screenshots and add them to the report
		for (String screenshotPath : screenshotPaths) {
			test.pass("Responsive screenshot attached for resolution: " + screenshotPath)
					.addScreenCaptureFromPath(screenshotPath); // Attach each screenshot
		}
		test.info("*Finished " + methodName + " Responsive Test*");
		logger.info("*Finished " + methodName + " Responsive Test*");
	}

	public void Terms_and_Conditions_Page(String methodName) throws IOException, InterruptedException {

		test.info("*Started " + methodName + " Responsive Test*");
		logger.info("*Started " + methodName + " Responsive Test*");

		driver.get("https://kinda.jcsoftwaresolution.in/termcondtitons");
		List<String> screenshotPaths = Dimensions(methodName);

		// Loop through all the screenshots and add them to the report
		for (String screenshotPath : screenshotPaths) {
			test.pass("Responsive screenshot attached for resolution: " + screenshotPath)
					.addScreenCaptureFromPath(screenshotPath); // Attach each screenshot
		}
		test.info("*Finished " + methodName + " Responsive Test*");
		logger.info("*Finished " + methodName + " Responsive Test*");
	}

	public List<String> Dimensions(String methodName) throws IOException, InterruptedException {
		Dimension[] sizes = { new Dimension(375, 812), // iPhone X
				// new Dimension(768, 1024), // iPad
				// new Dimension(1024, 768), // Tablet landscape
				// new Dimension(1440, 900) // Desktop
		};

		List<String> screenshotPaths = new ArrayList<>(); // This will hold all screenshot paths
		String currentMethodName = Thread.currentThread().getStackTrace()[2].getMethodName(); // Index 2 gets the actual
																								// caller method

		for (Dimension size : sizes) {
			driver.manage().window().setSize(size);
			logger.info("✅ Testing on resolution: " + size);

			Thread.sleep(2000); // Allow layout to adjust

			JavascriptExecutor js = (JavascriptExecutor) driver;

			// Scroll to top
			js.executeScript("window.scrollTo(0, 0);");

			// Make sticky headers static (ensure header doesn't move when resizing)
			js.executeScript("Array.from(document.querySelectorAll('*')).forEach(el => {"
					+ "if (getComputedStyle(el).position === 'fixed' || getComputedStyle(el).position === 'sticky') "
					+ "el.style.position = 'static';" + "} );");

			// Use the viewportPasting strategy to capture a full-page screenshot
			Screenshot screenshot = new AShot().shootingStrategy(ShootingStrategies.viewportPasting(1000))
					.takeScreenshot(driver);

			String timestamp = new SimpleDateFormat("yyyy.MM.dd_HH.mm.ss").format(new Date());

			// Save screenshots to a directory
			String directory = "/home/jc-raj/Music/Automation/KindaProject/src/test/java/Responsive_Testing/";
			new File(directory).mkdirs(); // Ensure directory exists

			String filePath = directory + methodName + "_" + size.getWidth() + "x" + size.getHeight() + "_" + timestamp
					+ ".png";
			ImageIO.write(screenshot.getImage(), "PNG", new File(filePath));

			logger.info("📸 Saved screenshot at: " + filePath);
			logger.info("✅ Tested on resolution: " + size);

			screenshotPaths.add(filePath); // Add the file path to the list
		}

		return screenshotPaths; // Return the list of screenshot paths
	}

	/*
	 * @AfterClass public void tearDown() { if (driver != null) { driver.quit();
	 * logger.info("🔚 Browser closed after all tests."); }
	 */
}
