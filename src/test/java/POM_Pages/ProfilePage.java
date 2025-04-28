package POM_Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

public class ProfilePage {
	WebDriver driver;

    public ProfilePage(WebDriver driver) {
        this.driver = driver;
    }

    private By viewProfile = By.xpath("(//button[normalize-space()='View profile'])[1]");
    private By editProfile = By.xpath("//a[normalize-space()='Edit Profile']");
    private By imageUpload = By.id("bannerImage");
    private By nextButton = By.xpath("//a[normalize-space()='Next']");
    private By updateButton = By.xpath("//button[normalize-space()='Update']");

    public void clickViewProfile() {
        driver.findElement(viewProfile).click();
    }

    public void clickEditProfile() {
        driver.findElement(editProfile).click();
    }

    public void uploadBannerImage(String imagePath) {
        driver.findElement(imageUpload).sendKeys(imagePath);
    }

    public void clickNext() {
        driver.findElement(nextButton).click();
    }

    public void clickUpdate() {
        driver.findElement(updateButton).click();
    }
}