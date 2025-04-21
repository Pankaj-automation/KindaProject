package TC_For_Signup;

import java.time.Duration;
import java.util.HashMap;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;

import utilities.Reuseable;

public class Step_4_Alerts_verificationTest {
	WebDriver driver;

	 @Test (priority = 1)
	  public void Setup() {
		  Reuseable Reuseable = new Reuseable();
		  Reuseable.Reuseable();
		}
	 void verifyalerts() {
			driver.findElement(By.xpath("//button[normalize-space()='Get Started Free']")).click();

	 }
  }

