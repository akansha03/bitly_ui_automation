package com.bitly.pages;

import com.bitly.driver.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
public class HomePage {

    WebDriver driver;
    WebDriverWait wait;

    By user = By.cssSelector(".user-name");
    By destinationUrl = By.id("quick-create-input");
    By createButton = By.cssSelector("button[class='orb-button default']");
    By allowQRCode = By.cssSelector("#qr-code-checkbox");
    By bitlyText = By.xpath("//div[@class='shortlink']//a");



    public HomePage() {
        this.driver = DriverFactory.getDriver();
        this.wait = new WebDriverWait(this.driver, Duration.ofSeconds(20));
    }

    public String getUserName(){
        // wait until the username element is visible on the home page
        wait.until(ExpectedConditions.visibilityOfElementLocated(user));
        return driver.findElement(user).getText().trim();
    }

    public void enterDestinationUrl(String url){
        wait.until(ExpectedConditions.visibilityOfElementLocated(destinationUrl));
        driver.findElement(destinationUrl).click();
        driver.findElement(destinationUrl).sendKeys(url);
    }

    public void clickCreateBitlyButton(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(createButton));
        driver.findElement(createButton).click();
    }

    public void clickAllowQRCodeCheckbox() {
        driver.findElement(allowQRCode).click();
    }

    public String getShortUrl(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(bitlyText));
        return driver.findElement(bitlyText).getText().trim();
    }
}
