package testCases;

import java.net.URL;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;

public class grid {
	WebDriver driver;

	@Test
	public void testGoogleInGrid() throws Exception {
		// Set Grid Hub URL
		URL gridUrl = new URL("http://192.168.1.23:4444");

		// Set desired capabilities
		DesiredCapabilities caps = new DesiredCapabilities();
		caps.setBrowserName("chrome"); // or "firefox"

		// RemoteWebDriver connects to Grid
		WebDriver driver = new RemoteWebDriver(gridUrl, caps);

		driver.get("https://www.google.com");
		System.out.println("Title: " + driver.getTitle());

		driver.quit();
	}
}