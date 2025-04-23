package testBase;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.apache.commons.io.FileUtils; // This one is important!

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ScreenshotBase {

	/* public static ExtentReports extent;
	    public static ExtentTest test;

	    static {
	        ExtentSparkReporter spark = new ExtentSparkReporter("./reports/ExtentReport.html");
	        extent = new ExtentReports();
	        extent.attachReporter(spark);
	    }*/
	}