package Responsive_Testing;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
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

public class Carrier_Responsvie_TestingTest extends XReseponsive_Testing_Pages {
	@Test(priority = 1)
	public void Carrier_Login() throws IOException, InterruptedException {
		Setup("Browser Opened");
		driver.findElement(By.xpath("//p[@class='text-sm font-medium']")).click();
		test = extent.createTest("Carrier Responsive Testing");

		Carrier_Login_Page("Carrier Login");

	}

	@Test(priority = 2)
	public void Carrier_Profile() throws IOException, InterruptedException {

		Profile_Page("Carrier Profile");

	}

	@Test(priority = 3)
	public void Carrier_Dashboard() throws IOException,

			InterruptedException {
		Dashboard_Page("Carrier Dashboard");
	}

	@Test(priority = 4)
	public void Carrier_Trucks() throws IOException, InterruptedException {
		Trucks_Page("Carrier Trucks");
	}

	@Test(priority = 5)
	public void Carrier_Drivers() throws IOException, InterruptedException {
		Drivers_Page("Carrier Drivers");
	}
	@Test(priority = 6)
	public void Carrier_Staff() throws IOException, InterruptedException {
		Staff_Page("Carrier Staff");
	}
	@Test(priority = 7)
	public void Carrier_Departments() throws IOException, InterruptedException {
		Departments_Page("Carrier Departments");
	}
	@Test(priority = 8)
	public void Carrier_Tasks() throws IOException, InterruptedException {
		Tasks_Page("Carrier Tasks");
	}


	@Test(priority = 9)
	public void Carrier_All_Loads() throws IOException, InterruptedException {
		All_Loads_Page("Carrier All Loads");
	}

	@Test(priority = 10)
	public void Carrier_Pending_Pickup_Loads() throws IOException, InterruptedException {
		Pending_Pickup_Loads_Page("Carrier Pending Pickup Loads");
	}

	@Test(priority = 11)
	public void Carrier_Pickedup_Loads() throws IOException, InterruptedException {
		Pickedup_Loads_Page("Carrier Pickedup Loads");
	}

	@Test(priority = 12)
	public void Carrier_Intransit_Loads() throws IOException, InterruptedException {
		Intransit_Loads_Page("Carrier Intransit Loads");
	}

	@Test(priority = 13)
	public void Carrier_Deliverd_Loads() throws IOException, InterruptedException {
		Deliverd_Loads_Page("Carrier Deliverd Loads");
	}

	@Test(priority = 14)
	public void Carrier_Active_Plan() throws IOException, InterruptedException {
		Active_Plan_Page("Carrier ActivePlan");
	}

	@Test(priority = 15)
	public void Carrier_Transactions() throws IOException, InterruptedException {
		Transactions_Page("Carrier Transactions");
	}

	@Test(priority = 16)
	public void Carrier_Shipment_Notes() throws IOException, InterruptedException {
		Shipment_Notes_Page("Carrier Shipment Notes");
	}

	@Test(priority = 17)
	public void Carrier_Notification() throws IOException, InterruptedException {
		Notification_Page("Carrier Notification");
	}

	@AfterClass
	public void tearDown() {
		if (driver != null) {
			extent.flush();
			driver.quit();
			logger.info("🔚 Browser closed after all tests.");
		}

	}
}
