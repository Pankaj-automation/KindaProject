package Identify_links;

import java.awt.List;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.time.Duration;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

import utilities.Extentreportmanager;
import utilities.Reuseable;


public class broken_links_on_websiteTest {
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
		test = extent.createTest("broken_links_on_websiteTest");
		driver.manage().window().maximize();
		test.info("*Started broken_links_on_website*");
		logger.info("*Started broken_links_on_website*");

	}

	public void Brokenlinkcode() {
		java.util.List<WebElement> links = driver.findElements(By.tagName("a"));
		test.info("Total links: " + links.size());
		logger.info("Total links: " + links.size());

		for (WebElement link : links) {
			String url = link.getAttribute("href");

			if (url == null || url.isEmpty()) {
				test.info("⚠️ URL is either not configured for anchor tag or it is empty "+url);
				logger.info("⚠️ URL is either not configured for anchor tag or it is empty "+url);

				continue;
			}

			try {
				HttpURLConnection connection = (HttpURLConnection) (new URL(url).openConnection());
				connection.setRequestMethod("HEAD");
				connection.connect();
				int responseCode = connection.getResponseCode();

				if (responseCode >= 400) {
					test.pass("❌ Broken link: " + url + " — Status Code: " + responseCode);
					logger.info("❌ Broken link: " + url + " — Status Code: " + responseCode);

				} else {
					test.pass("✅ Valid link: " + url + " — Status Code: " + responseCode);
					logger.info("✅ Valid link: " + url + " — Status Code: " + responseCode);

				}

			} catch (Exception e) {
				test.pass("❌ Exception for URL: " + url + " — " + e.getMessage());
				logger.info("❌ Exception for URL: " + url + " — " + e.getMessage());

			}
		}
	}


	@Test(priority = 2)
	public void Home_Page_BL() throws IOException, InterruptedException {
		Thread.sleep(3000);
		test.info("⚠️ Verify Home Page Links");
		logger.info("⚠️ Verify Home Page Links");
		Brokenlinkcode();
		test.info("⚠️ Verified Home Page Links");
		logger.info("⚠️ Verified Home Page Links");

	}

	@Test(priority = 3)
	public void About_US_BL() throws IOException, InterruptedException {
		test.info("⚠️ Verify About US Page Links");
		logger.info("⚠️ Verify About US Page Links");
		driver.findElement(By.xpath(
				"//a[@class='text-gray-600 hover:bg-[#3E549D] hover:text-white rounded-md px-3 py-2 text-sm font-medium'][normalize-space()='About']"))
				.click();
		Thread.sleep(3000);
		Brokenlinkcode();
		test.info("⚠️ Verified About US Page Links");
		logger.info("⚠️ Verified About US Page Links");
	}

	@Test(priority = 4)
	public void Plan_BL() throws IOException, InterruptedException {
		test.info("⚠️ Verify Plan Page Links");
		logger.info("⚠️ Verify Plan Page Links");
		driver.findElement(By.xpath("//a[normalize-space()='Plan']")).click();
		Thread.sleep(3000);
		Brokenlinkcode();
		test.info("⚠️ Verified Plan Page Links");
		logger.info("⚠️ Verified Plan Page Links");
	}

	@Test(priority = 5)
	public void Contact() throws IOException, InterruptedException {
		driver.findElement(By.xpath("//a[normalize-space()='Contact']")).click();
		test.info("⚠️ Verify Contact Page Links");
		logger.info("⚠️ Verify Contact Page Links");
		Thread.sleep(3000);
		Brokenlinkcode();
		test.info("⚠️ Verified Contact Page Links");
		logger.info("⚠️ Verified Contact Page Links");
	}

	@Test(priority = 6)
	public void QuitBrowser() throws IOException, InterruptedException {
		Thread.sleep(3000);
		test.info("*Finished broken_links_on_website*");
		logger.info("*Finished broken_links_on_website*");
		if (driver != null) {
			driver.quit();
		}
	}
	@AfterClass
	public void tearDownReport() {
		extent.flush(); // Writes everything to the file
	}
}
