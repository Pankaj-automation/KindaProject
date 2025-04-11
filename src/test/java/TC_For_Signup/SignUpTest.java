package TC_For_Signup;


import org.testng.annotations.Test;
import org.testng.annotations.Test;
import org.testng.annotations.Test;
import org.testng.annotations.Test;
import org.testng.annotations.Test;
import org.apache.xmlbeans.impl.xb.xsdschema.FieldDocument.Field.Xpath;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;

public class SignUpTest {
	WebDriver driver;

	@Test(priority = 1)
	public void Openbrowser() throws InterruptedException {
		driver = new ChromeDriver();
		Thread.sleep(2000);
		driver.manage().window().maximize();
		System.out.println(">>> Running SignUp Test");

	}


		// button[normalize-space()='Ok']
	}

