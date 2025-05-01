package Responsive_Testing;

import java.io.IOException;

import org.openqa.selenium.By;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

public class Driver_Responsive_TestingTest extends XReseponsive_Testing_Pages {
	@Test(priority = 1)
	public void Carrier_Login() throws IOException, InterruptedException {
		Setup("Browser Opened");
		driver.findElement(By.xpath("//p[@class='text-sm font-medium']")).click();
		test = extent.createTest("Driver Responsive Testing");

		Driver_Login_Page("Driver Login");

	}

	@Test(priority = 2)
	public void Driver_Profile() throws IOException, InterruptedException {

		Profile_Page("Driver Profile");

	}

	@Test(priority = 3)
	public void Driver_Dashboard() throws IOException,

			InterruptedException {
		Dashboard_Page("Driver Dashboard");
	}

	

	@Test(priority = 4)
	public void Carriers() throws IOException, InterruptedException {
		Carriers_Page("Driver Carriers");
	}
	@Test(priority = 5)
	public void Carrier_Staff() throws IOException, InterruptedException {
		Staff_Page("Driver Carrier Staff");
	}
	
	@Test(priority = 6)
	public void Carrier_Tasks() throws IOException, InterruptedException {
		Task_Page("Driver Tasks");
	}


	@Test(priority = 7)
	public void Pending_Pickup_Task() throws IOException, InterruptedException {
		Pending_Pickup_Task_Page("Driver Pending Pickup Task");
	}

	@Test(priority = 8)
	public void Pickedup_Task() throws IOException, InterruptedException {
		Pickedup_Task_Page("Driver Pickedup Task");
	}

	@Test(priority = 9)
	public void Intransit_Task() throws IOException, InterruptedException {
		Intransit_Task_Page("Driver Intransit Task");
	}

	@Test(priority = 10)
	public void Deliverd_Task() throws IOException, InterruptedException {
		Deliverd_Task_Page("Driver Deliverd Task");
	}

	
	@Test(priority = 11)
	public void Shipment_Notes() throws IOException, InterruptedException {
		Shipment_Notes_Page("Driver Shipment Notes");
	}

	@Test(priority = 12)
	public void Notification() throws IOException, InterruptedException {
		Notification_Page("Driver Notification");
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
