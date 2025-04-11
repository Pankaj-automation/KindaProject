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
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;

public class SignUpTest {
	 WebDriver driver;

	    @BeforeClass
	    public void setUp() {

	        ChromeOptions options = new ChromeOptions();

	        // Generate a unique user-data-dir for every test run
	        String userDataDir = System.getProperty("java.io.tmpdir") + "/chrome-profile-" + System.currentTimeMillis();
	        options.addArguments("--user-data-dir=" + userDataDir);

	        driver = new ChromeDriver(options);
	    }

	    @Test
	    public void Openbrowser() {
	        driver.get("https://www.google.com");
	        System.out.println("Page title is: " + driver.getTitle());
	    }

	    @AfterClass
	    public void tearDown() {
	        if (driver != null) {
	            driver.quit();
	        }
	    }
	}

	// button[normalize-space()='Ok']

