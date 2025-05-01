package Responsive_Testing;

import java.io.IOException;
import java.security.Signature;

import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

public class Website_Responsive_TestingTest extends XReseponsive_Testing_Pages {
	@Test(priority = 1)
	public void Home() throws IOException, InterruptedException {
		Setup("Browser Opened");
		test = extent.createTest("Website Responsive Testing");
		Home_Page("Home");

	}

	@Test(priority = 2)
	public void Aboutus() throws IOException, InterruptedException {

		Aboutus_Page("Aboutus");

	}

	@Test(priority = 3)
	public void Contact() throws IOException,

			InterruptedException {
		Contact_Page("Contact");
	}

	@Test(priority = 4)
	public void Login() throws IOException, InterruptedException {
		Login_Page("Login");
	}

	@Test(priority = 5)
	public void SignUp() throws IOException, InterruptedException {
		SignUp_Page("Sign Up");
	}

	@Test(priority = 6)
	public void Forgot_Password() throws IOException, InterruptedException {
		Forgot_Password_Page("Forgot Password");
	}

	@Test(priority = 7)
	public void Privacy_Policy() throws IOException, InterruptedException {
		Privacy_Policy_Page("Privacy Policy");
	}

	@Test(priority = 8)
	public void Terms_and_Conditions() throws IOException, InterruptedException {
		Terms_and_Conditions_Page("Terms and Conditions");
	}

	@AfterClass
	public void QuitBrowser() throws IOException, InterruptedException {
		Thread.sleep(1000);
		extent.flush(); // Writes everything to the file

		if (driver != null) {
			driver.quit();
		}

	}

}