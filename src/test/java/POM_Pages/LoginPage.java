package POM_Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

public class LoginPage {
	WebDriver driver;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    private By emailField = By.xpath("//input[@placeholder='Enter Email *']");
    private By passwordField = By.xpath("//input[@placeholder='Enter Password *']");
    private By signInButton = By.xpath("//button[normalize-space()='Sign in']");

    public void login(String email, String password) {
        driver.findElement(emailField).sendKeys(email);
        driver.findElement(passwordField).sendKeys(password);
        driver.findElement(signInButton).click();
    }
}
