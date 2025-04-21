package TC_For_Login;

import static org.testng.Assert.assertEquals;

import java.io.IOException;
import java.sql.Driver;
import java.time.Duration;
import java.util.HashMap;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;

public class LoginTest {
	WebDriver driver;

	@Test(priority = 1)
	public void setup() {
		ChromeOptions options = new ChromeOptions();

		// options.addArguments("--headless=new");

		// Enable notification of the browser

		HashMap allow = new HashMap<>();
		allow.put("profile.default_content_setting_values.notifications", 1); // 1 = allow
		allow.put("profile.default_content_setting_values.geolocation", 1); // 1 = allow
		options.setExperimentalOption("prefs", allow);
		// Apply preferences to ChromeOptions

		driver = new ChromeDriver(options);
		driver.get("https://kinda.jcsoftwaresolution.in/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.findElement(By.xpath("//p[contains(@class,'text-sm font-medium')]")).click();
	}
@Test(priority = 2)
void Enter_Valid_U_P() {
	driver.findElement(By.xpath("//input[@placeholder='Enter Email *']")).sendKeys("Carrierthree@yopmail.com");
	driver.findElement(By.xpath("//input[@placeholder='Enter Password *']")).sendKeys("Carrier@123");
	driver.findElement(By.xpath("//button[normalize-space()='Sign in']")).click();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	String url = driver.getCurrentUrl();
	System.out.println("Current URL"+url);
	assertEquals(url, "https://kinda.jcsoftwaresolution.in/profile");
	
}
	
	
	
}
