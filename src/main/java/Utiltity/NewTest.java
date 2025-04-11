package Utiltity;

import org.testng.annotations.Test;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;

public class NewTest {
	
	WebDriver driver;
  @Test(priority = 1)
  public void Openbrowser() throws InterruptedException {
	  
	 driver = new ChromeDriver();
	 Thread.sleep(2000);
	 driver.manage().window().maximize();

  }
  @Test(priority = 2)
  public void enterURL() {
	  driver.get("https://www.google.com/");
  }
  @Test(priority = 3)
  public void enterdata() throws InterruptedException {
	  // Step 2: Find the Google search box by its name attribute
		 Thread.sleep(2000);
      WebElement searchBox = driver.findElement(By.name("q"));
      searchBox.sendKeys("Test");
      searchBox.submit();
  }
  @Test(priority = 4)
  public void waittoseesearhresult() throws InterruptedException {
	  Thread.sleep(3000);
  }
  @Test(priority = 5)
  public void enterUeRL() {
	  driver.get("https://www.google.com");
  }
  @Test(priority = 6)
  public void Pagetitle() {
	  System.out.println("Page title after search: " + driver.getTitle());
  }
  @Test(priority = 6)
  public void closebrowser() {
	  
driver.quit();  }
    
       


}
