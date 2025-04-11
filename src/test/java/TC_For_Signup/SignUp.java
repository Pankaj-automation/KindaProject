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

public class SignUp {
	WebDriver driver;

	@Test(priority = 1)
	public void Openbrowser() throws InterruptedException {

		driver = new ChromeDriver();
		Thread.sleep(2000);
		driver.manage().window().maximize();
		System.out.println(">>> Running SignUp Test");

	}

	@Test(priority = 2)
	public void enterurl() throws InterruptedException {
		driver.get("https://kinda.jcsoftwaresolution.in/");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//button[normalize-space()='Get Started Free']")).click();
		System.out.println(">>> Running SignUp Test");

	}

	@Test(priority = 3)
	public void filldatainfields() throws InterruptedException {
		Thread.sleep(3000);
		WebElement dropdown = driver.findElement(By.xpath("//select[@id='headlessui-control-:r2:']"));
		dropdown.click();
		Thread.sleep(2000);
		// Create an instance of the Select class
		Select select = new Select(dropdown);
		select.selectByVisibleText("Carrier");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@placeholder='First Name *']")).sendKeys("Pnkj");
		driver.findElement(By.xpath("//input[@placeholder='Last Name (Optional)']")).sendKeys("Srmaa");
		driver.findElement(By.xpath("//input[@placeholder='Email address *']")).sendKeys("pnkjsrmaa@yopmail.com");

		WebElement dropdown1 = driver.findElement(By.xpath("//select[@id='headlessui-control-:r4:']"));
		dropdown1.click();
		// Create an instance of the Select class
		Select select1 = new Select(dropdown1);
		Thread.sleep(2000);
		select1.selectByVisibleText("Manager");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@placeholder='Password *']")).sendKeys("Admine51%%");
		driver.findElement(By.xpath("//input[@placeholder='Confirm Password *']")).sendKeys("Admine51%%");
		driver.findElement(By.xpath("//button[normalize-space()='Next']")).click();
		System.out.println(">>> Running SignUp Test");

	}

	@Test(priority = 4)
	public void SignuppageSecond() throws InterruptedException {
		Thread.sleep(2000);
		WebElement dropdown = driver.findElement(By.xpath("//input[@placeholder='Location']"));
		dropdown.sendKeys("Mohali");
		Thread.sleep(2000);
		// Create an instance of the Select class
		Select select = new Select(dropdown);
		select.selectByVisibleText("Mohali");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@placeholder='Zipcode *']")).sendKeys("34242");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//button[normalize-space()='Next']")).click();
		System.out.println(">>> Running SignUp Test");

	}

	@Test(priority = 5)
	public void Signupthird() throws InterruptedException {
		driver.findElement(By.xpath("//input[@placeholder=' Company Name *']")).sendKeys("My company");
		driver.findElement(By.xpath("//input[@placeholder='Fax Number (Optional)']")).sendKeys("543");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@placeholder='Tax Number *']")).sendKeys("5453");
		driver.findElement(By.xpath("//input[@placeholder='MC # *']")).sendKeys("35");
		driver.findElement(By.xpath("//input[@placeholder='DOT # *']")).sendKeys("5335");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//button[normalize-space()='Next']")).click();
		Thread.sleep(2000);
	}

	@Test(priority = 6)
	public void Signupfourth() throws InterruptedException {
		driver.findElement(By.xpath("//input[@placeholder='Number of Trailers *']")).sendKeys("1");
		driver.findElement(By.xpath("//input[@placeholder='Solo Truck *']")).sendKeys("543");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@placeholder='Team Truck *']")).sendKeys("5453");
		driver.findElement(By.xpath("//input[@id='dry_van']")).click();
		driver.findElement(By.xpath("//input[@id='checkbox1']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//button[normalize-space()='Sign Up']")).click();
		Thread.sleep(2000);
		Alert alert = driver.switchTo().alert();
		Thread.sleep(2000);
		alert.accept();
		driver.close();
		System.out.println(">>> Running SignUp Test");

		// button[normalize-space()='Ok']
	}
}
