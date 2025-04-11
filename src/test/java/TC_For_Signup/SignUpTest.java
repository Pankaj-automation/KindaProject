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
	    	ChromeOptions options = new ChromeOptions();

	    	// Create a clean user data dir
	    	//File tempProfile = Files.createTempDir();
	    	//options.addArguments("--user-data-dir=" + tempProfile.toString());

	    	// Optional: headless and stability flags
	    	//options.addArguments("--no-sandbox");
	    	//options.addArguments("--disable-dev-shm-usage");
	    	options.addArguments("--headless=new");

	    	WebDriver driver = new ChromeDriver(options);	
	        driver.get("https://www.google.com");
	        System.out.println("Page title is: " + driver.getTitle());
	            driver.quit();
	        }
	    }
	

	// button[normalize-space()='Ok']

