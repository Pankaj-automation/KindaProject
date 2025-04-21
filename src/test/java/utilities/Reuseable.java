package utilities;

import java.time.Duration;
import java.util.HashMap;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.BeforeClass;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Reuseable {
	public WebDriver driver;
	public Logger logger;

	public WebDriver Reuseable() {

	//	logger = LogManager.getLogger(this.getClass());
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--headless=new");
		// Enable notification of the browser
		HashMap allow = new HashMap<>();
		allow.put("profile.default_content_setting_values.notifications", 1); // 1 = allow
		allow.put("profile.default_content_setting_values.geolocation", 1); // 1 = allow
		options.setExperimentalOption("prefs", allow);
		// Apply preferences to ChromeOptions

		driver = new ChromeDriver(options);
		driver.get("https://kinda.jcsoftwaresolution.in/");
		// driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		return driver;

	}

}
