package TC_For_Signup;

import org.testng.annotations.Test;

import com.google.common.io.Files;

import org.testng.annotations.Test;
import org.testng.annotations.Test;
import org.testng.annotations.Test;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
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

	    @Test
	    public void setUp() throws IOException {
	    	 try {
	             // Terminate all Chrome processes
	             Runtime.getRuntime().exec("pkill -9 chrome");
	             // Proceed with setting up ChromeOptions and WebDriver
	         } catch (IOException e) {
	             e.printStackTrace();
	         }
	        File tempDir;
	        tempDir = Files.createTempDir();
			System.out.println("Temporary directory created at: " + tempDir.toString());
			// Proceed with setting up ChromeOptions and WebDriver
	        ChromeOptions options = new ChromeOptions();
	        options.addArguments("--user-data-dir=" + tempDir.toString());
	        WebDriver driver = new ChromeDriver(options);
	        options.addArguments("--no-sandbox");
	        options.addArguments("--disable-dev-shm-usage");
	        driver.get("https://www.google.com");
	        System.out.println("Page title is: " + driver.getTitle());
	            driver.quit();
	        }
	    }
	

	// button[normalize-space()='Ok']

