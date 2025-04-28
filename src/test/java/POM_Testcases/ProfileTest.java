package POM_Testcases;

import org.openqa.selenium.By;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import POM_Pages.LoginPage;
import POM_Pages.ProfilePage;
import utilities.Reuseable;

public class ProfileTest extends Reuseable {
	 @BeforeClass
	    public void setup() {
		 Reuseable1();
	    }

	    @Test(priority = 1)
	    public void testLoginAndEditProfile() throws InterruptedException {
	        LoginPage loginPage = new LoginPage(driver);
	        ProfilePage profilePage = new ProfilePage(driver);
			driver.findElement(By.xpath("//p[@class='text-sm font-medium']")).click();

	        loginPage.login("Carrierthree@yopmail.com", "Carrier@123");

	        Thread.sleep(2000);
	        profilePage.clickViewProfile();
	        Thread.sleep(2000);
	        profilePage.clickEditProfile();
	        Thread.sleep(1000);
	        profilePage.uploadBannerImage("/path/to/image.jpg");
	        Thread.sleep(5000);
	        profilePage.clickNext();
	        profilePage.clickUpdate();
	    }

	    @AfterClass
	    public void teardown() {
	        driver.quit();
	    }
	}