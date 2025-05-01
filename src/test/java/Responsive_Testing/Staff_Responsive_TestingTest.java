package Responsive_Testing;

import java.io.IOException;

import org.openqa.selenium.By;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

public class Staff_Responsive_TestingTest extends XReseponsive_Testing_Pages{
	@Test(priority = 1)
	public void Carrier_Login() throws IOException, InterruptedException {
		Setup("Browser Opened");
		driver.findElement(By.xpath("//p[@class='text-sm font-medium']")).click();
		test = extent.createTest("Staff Responsive Testing");

		Staff_Login_Page("Staff Login");

	}

	@Test(priority = 2)
	public void Staff_Profile() throws IOException, InterruptedException {

		Profile_Page("Staff Profile");

	}

	@Test(priority = 3)
	public void Staff_Dashboard() throws IOException,

			InterruptedException {
		Dashboard_Page("Staff Dashboard");
	}
	
	@Test(priority = 4)
	public void Staff_Trucks() throws IOException, InterruptedException {
		Trucks_Page("Staff Trucks");
	}

	@Test(priority = 5)
	public void Staff_Drivers() throws IOException, InterruptedException {
		Drivers_Page("Staff Drivers");
	}
	
	@Test(priority = 6)
	public void Staff_Carriers() throws IOException, InterruptedException {
		Carriers_Page("Staff Carrier");
	}
	@Test(priority = 7)
	public void Staff_Tasks() throws IOException, InterruptedException {
		Tasks_Page("Staff Tasks");
	}


	@Test(priority = 8)
	public void Staff_All_Loads() throws IOException, InterruptedException {
		All_Loads_Page("Staff All Loads");
	}

	@Test(priority = 9)
	public void Staff_Pending_Pickup_Loads() throws IOException, InterruptedException {
		Pending_Pickup_Loads_Page("Staff Pending Pickup Loads");
	}

	@Test(priority = 10)
	public void Staff_Pickedup_Loads() throws IOException, InterruptedException {
		Pickedup_Loads_Page("Staff Pickedup Loads");
	}

	@Test(priority = 11)
	public void Staff_Intransit_Loads() throws IOException, InterruptedException {
		Intransit_Loads_Page("Staff Intransit Loads");
	}

	@Test(priority = 12)
	public void Staff_Deliverd_Loads() throws IOException, InterruptedException {
		Deliverd_Loads_Page("Staff Deliverd Loads");
	}


	@Test(priority = 13)
	public void Staff_Shipment_Notes() throws IOException, InterruptedException {
		Shipment_Notes_Page("Staff Shipment Notes");
	}

	@Test(priority = 14)
	public void Staff_Notification() throws IOException, InterruptedException {
		Notification_Page("Staff Notification");
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
