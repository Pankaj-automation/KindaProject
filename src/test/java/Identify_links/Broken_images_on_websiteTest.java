package Identify_links;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.time.Duration;
import java.util.List;

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

public class Broken_images_on_websiteTest {
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
		test = extent.createTest("Broken_images_on_websiteTest");
		driver.manage().window().maximize();
		test.info("*Started Broken_images_on_websiteTest*");
		logger.info("*Started Broken_images_on_websiteTest*");

	}

	public void BrokenImagecode() {
		
		List<WebElement> images = driver.findElements(By.tagName("img"));
	        System.out.println("Total images: " + images.size());

	        for (WebElement img : images) {
	            String imageURL = img.getAttribute("src");

	            if (imageURL == null || imageURL.isEmpty()) {
	                System.out.println("Image src is empty or null");
	                continue;
	            }

	            try {
	                HttpURLConnection connection = (HttpURLConnection) (new URL(imageURL).openConnection());
	                connection.setRequestMethod("HEAD");
	                connection.connect();
	                int responseCode = connection.getResponseCode();

	                if (responseCode >= 400) {
	                    System.out.println("🔴 Broken Image: " + imageURL + " | Response Code: " + responseCode);
	                } else {
	                    System.out.println("🟢 Valid Image: " + imageURL + " | Response Code: " + responseCode);
	                }
	            } catch (Exception e) {
	                System.out.println("⚠️ Exception for: " + imageURL + " -> " + e.getMessage());
	            }
	        }}


	@Test(priority = 2)
	public void Home_Page_BL() throws IOException, InterruptedException {
		Thread.sleep(3000);
		test.info("⚠️ Verify Home Page Images");
		logger.info("⚠️ Verify Home Page Images");
		BrokenImagecode();
		test.info("⚠️ Verified Home Page Images");
		logger.info("⚠️ Verified Home Page Images");

	}

	@Test(priority = 3)
	public void About_US_BL() throws IOException, InterruptedException {
		test.info("⚠️ Verify About US Page Images");
		logger.info("⚠️ Verify About US Page Images");
		driver.findElement(By.xpath(
				"//a[@class='text-gray-600 hover:bg-[#3E549D] hover:text-white rounded-md px-3 py-2 text-sm font-medium'][normalize-space()='About']"))
				.click();
		Thread.sleep(3000);
		BrokenImagecode();
		test.info("⚠️ Verified About US Page Images");
		logger.info("⚠️ Verified About US Page Images");
	}

	@Test(priority = 4)
	public void Plan_BL() throws IOException, InterruptedException {
		test.info("⚠️ Verify Plan Page Images");
		logger.info("⚠️ Verify Plan Page Images");
		driver.findElement(By.xpath("//a[normalize-space()='Plan']")).click();
		Thread.sleep(3000);
		BrokenImagecode();
		test.info("⚠️ Verified Plan Page Images");
		logger.info("⚠️ Verified Plan Page Images");
	}

	@Test(priority = 5)
	public void Contact() throws IOException, InterruptedException {
		driver.findElement(By.xpath("//a[normalize-space()='Contact']")).click();
		test.info("⚠️ Verify Contact Page Images");
		logger.info("⚠️ Verify Contact Page Images");
		Thread.sleep(3000);
		BrokenImagecode();
		test.info("⚠️ Verified Contact Page Images");
		logger.info("⚠️ Verified Contact Page Images");
	}

	@Test(priority = 6)
	public void QuitBrowser() throws IOException, InterruptedException {
		Thread.sleep(3000);
		test.info("*Finished Broken_images_on_websiteTest*");
		logger.info("*Finished Broken_images_on_websiteTest*");
		if (driver != null) {
			driver.quit();
		}
	}
	@AfterClass
	public void tearDownReport() {
		extent.flush(); // Writes everything to the file
	}
}
