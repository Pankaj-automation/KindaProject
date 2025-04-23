package Identify_links;

import java.io.IOException;
import java.time.Duration;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.devtools.v133.v133CdpInfo;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

import utilities.Extentreportmanager;
import utilities.Reuseable;

public class Links_Persent_or_NotTest {
	WebDriver driver;
	Reuseable testdata;
	Logger logger;
	ExtentReports extent;
	ExtentTest test;

	@Test(priority = 1)
	public void Setup() {
		testdata = new Reuseable(); // Create instance of Reuseable
		driver = testdata.Reuseable1(); // Initialize driver from Reuseable class
		logger = LogManager.getLogger(this.getClass());
		extent = Extentreportmanager.getExtentReports();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		test = extent.createTest("Links_Persent_or_NotTest");
		driver.manage().window().maximize();
		test.info("*Started Links_Persent_or_NotTest*");
		logger.info("*Started Links_Persent_or_NotTest*");

	}

	@Test(priority = 2)
	public void Header_Links() {

		WebElement element = driver.findElement(By.xpath("//a[normalize-space()='Home']"));
		if (element.getTagName().equalsIgnoreCase("a")) {
			logger.info("✅ Home Link is present");
			test.pass("✅ Home Link is present");
		} else {
			logger.error("❌ Home Link is not Present");
			test.fail("❌ Home Link is not Present");
		}
		WebElement element1 = driver.findElement(By.xpath(
				"//a[contains(@class,'text-gray-600 hover:bg-[#3E549D] hover:text-white rounded-md px-3 py-2 text-sm font-medium')][normalize-space()='About']"));
		if (element1.getTagName().equalsIgnoreCase("a")) {
			logger.info("✅ About Link is present");
			test.pass("✅ About Link is present");
		} else {
			logger.error("❌ About Link is not Present");
			test.fail("❌ About Link is not Present");

		}
		WebElement element2 = driver.findElement(By.xpath("//a[normalize-space()='Plan']"));
		if (element2.getTagName().equalsIgnoreCase("a")) {
			logger.info("✅ Plan Link is present");
			test.pass("✅ Plan Link is present");

		} else {
			logger.error("❌ Plan Link is not Present");
			test.fail("❌ Plan Link is not Present");

		}
		WebElement element3 = driver.findElement(By.xpath("//a[normalize-space()='Chat']"));
		if (element3.getTagName().equalsIgnoreCase("a")) {
			logger.info("✅ Chat Link is present");
			test.pass("✅ Chat Link is present");

		} else {
			logger.error("❌ Chat Link is not Present");
			test.fail("❌ Chat Link is not Present");

		}
		WebElement element4 = driver.findElement(By.xpath("//a[normalize-space()='Contact']"));
		if (element4.getTagName().equalsIgnoreCase("a")) {
			logger.info("✅ Contact Link is present");
			test.pass("✅ Contact Link is present");

		} else {
			logger.error("❌ Contact Link is not Present");
			test.fail("❌ Contact Link is not Present");

		}
		WebElement element5 = driver.findElement(By.xpath("(//p[contains(@class,'text-sm font-medium')])[1]"));
		if (element5.getTagName().equalsIgnoreCase("a")) {
			logger.info("✅ Login Link is present");
			test.pass("✅ Login Link is present");

		} else {
			logger.info("✅ Login Link is present");
			test.pass("✅ Login Link is present");

		}
		WebElement element6 = driver.findElement(By.xpath("(//button[normalize-space()='Get Started Free'])[1]"));
		if (element6.getTagName().equalsIgnoreCase("a")) {
			logger.info("✅ Sign up Link is present");
			test.pass("✅ Sign up Link is present");

		} else {
			logger.info("✅ Sign up Link is present");
			test.pass("✅ Sign up Link is present");

		}

	}

	@Test(priority = 3)
	public void Footer_Links() {

		WebElement element = driver.findElement(By.xpath("(//a[contains(@class,'text-[16px] text-[#1B1C20]')])[1]"));

		if (element.getTagName().equalsIgnoreCase("a")) {
			logger.info("✅ About Link is present");
			test.pass("✅ About Link is present");
		} else {
			logger.error("❌ About Link is not Present");
			test.fail("❌ About Link is not Present");
		}
		WebElement element1 = driver.findElement(By.xpath("//p[normalize-space()='Features']"));

		if (element1.getTagName().equalsIgnoreCase("a")) {
			logger.info("✅ Features Link is present");
			test.pass("✅ Features Link is present");
		} else {
			logger.error("❌ Features Link is not Present");
			test.fail("❌ Features Link is not Present");
		}
		WebElement element2 = driver.findElement(By.xpath("//p[normalize-space()='Works']"));

		if (element2.getTagName().equalsIgnoreCase("a")) {
			logger.info("✅ Works Link is present");
			test.pass("✅ Works Link is present");
		} else {
			logger.error("❌ Works Link is not Present");
			test.fail("❌ Works Link is not Present");
		}
		WebElement element3 = driver.findElement(By.xpath("//p[normalize-space()='Support']"));

		if (element3.getTagName().equalsIgnoreCase("a")) {
			logger.info("✅ Support Link is present");
			test.pass("✅ Support Link is present");
		} else {
			logger.error("❌ Support Link is not Present");
			test.fail("❌ Support Link is not Present");
		}
		WebElement element4 = driver
				.findElement(By.xpath("//body/div/footer/div/div/div/div[2]/p[1]//*[name()='svg']"));

		if (element4.getTagName().equalsIgnoreCase("a")) {
			logger.info("✅ X Link is present");
			test.pass("✅ X Link is present");
		} else {
			logger.error("❌ X Link is not Present");
			test.fail("❌ X Link is not Present");
		}
		WebElement element5 = driver.findElement(By.xpath("//*[name()='path' and contains(@d,'M279.14 28')]"));

		if (element5.getTagName().equalsIgnoreCase("a")) {
			logger.info("✅ Facebook Link is present");
			test.pass("✅ Facebook Link is present");
		} else {
			logger.error("❌ Facebook Link is not Present");
			test.fail("❌ Facebook Link is not Present");
		}
		WebElement element6 = driver.findElement(By.xpath("//div[2]//p[3]//*[name()='svg']"));

		if (element6.getTagName().equalsIgnoreCase("a")) {
			logger.info("✅ Instagram Link is present");
			test.pass("✅ Instagram Link is present");
		} else {
			logger.error("❌ Instagram Link is not Present");
			test.fail("❌ Instagram Link is not Present");
		}
		WebElement element7 = driver.findElement(By.xpath("//body//div//p[4]//*[name()='svg']"));

		if (element7.getTagName().equalsIgnoreCase("a")) {
			logger.info("✅ Git Link is present");
			test.pass("✅ Git Link is present");
		} else {
			logger.error("❌ Git Link is not Present");
			test.fail("❌ Git Link is not Present");
		}
		WebElement element8 = driver.findElement(By.xpath("//a[normalize-space()='Privacy Policy']"));

		if (element8.getTagName().equalsIgnoreCase("a")) {
			logger.info("✅ Privacy Policy Link is present");
			test.pass("✅ Privacy Policy Link is present");
		} else {
			logger.error("❌ Privacy Policy Link is not Present");
			test.fail("❌ Privacy Policy Link is not Present");
		}
		WebElement element9 = driver.findElement(By.xpath("//a[normalize-space()='Terms & Conditions']"));

		if (element9.getTagName().equalsIgnoreCase("a")) {
			logger.info("✅ Terms & Conditions Link is present");
			test.pass("✅ Terms & Conditions Link is present");
		} else {
			logger.error("❌ Terms & Conditions Link is not Present");
			test.fail("❌ Terms & Conditions Link is not Present");
		}
	}

	@Test(priority = 4)
	public void QuitBrowser() throws IOException, InterruptedException {
		if (driver != null) {
			driver.quit();
			test.info("*Finished Links_Persent_or_NotTest*");
			logger.info("*Finished Links_Persent_or_NotTest*");
		}
	}
	@AfterClass
	public void tearDownReport() {
		extent.flush(); // Writes everything to the file
	}
}