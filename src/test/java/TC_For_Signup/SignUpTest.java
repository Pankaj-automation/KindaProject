package TC_For_Signup;

import org.testng.annotations.Test;
import org.testng.annotations.Test;
import org.testng.annotations.Test;
import org.testng.annotations.Test;
import org.testng.annotations.Test;

import java.util.UUID;

import org.apache.xmlbeans.impl.xb.xsdschema.FieldDocument.Field.Xpath;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;

public class SignUpTest {
	WebDriver driver;

	@Test
	public void Openbrowser() throws InterruptedException {
		ChromeOptions options = new ChromeOptions();

		  // 💡 UNIQUE user data dir
		String uniqueDir = "/tmp/chrome-profile-" + System.currentTimeMillis();
		options.addArguments("--user-data-dir=" + uniqueDir);

        String tempUserDataDir = System.getProperty("java.io.tmpdir") + "/chrome-user-data-" + UUID.randomUUID();
        options.addArguments("--user-data-dir=" + tempUserDataDir);

        // Optional but useful for Jenkins/Linux
        options.addArguments("--headless=new");
        options.addArguments("--no-sandbox");
        options.addArguments("--disable-dev-shm-usage");

		driver = new ChromeDriver();

		driver.manage().window().maximize();
		Thread.sleep(2000);
		driver.get("https://www.google.com");
		driver.quit();
	}

	// button[normalize-space()='Ok']
}
