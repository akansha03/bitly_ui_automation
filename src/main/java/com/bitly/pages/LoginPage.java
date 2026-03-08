package com.bitly.pages;

import com.bitly.driver.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginPage {

    WebDriver driver;
    WebDriverWait wait;

    By sideMenulogin = By.cssSelector("a#sidemenu-login");
    By closeCookieSection = By.xpath("//div[@id='onetrust-close-btn-container']/button");
    By username = By.xpath("//label[div[text()='Email']]/input");
    By password = By.xpath("//label[div[text()='Password']]/input");
    By loginButton = By.xpath("//button[text()='Log in']");


    public LoginPage() {
        this.driver = DriverFactory.getDriver();
        this.wait = new WebDriverWait(this.driver, Duration.ofSeconds(10));
    }

    public void enterUsername(String user){
        driver.findElement(username).sendKeys(user);
    }

    public void enterPassword(String pass) {
        driver.findElement(password).sendKeys(pass);
    }

    public void clickLoginButton(){
        driver.findElement(loginButton).click();
    }

    public void clickSideMenuLogin(){
        driver.findElement(closeCookieSection).click();
        driver.findElement(sideMenulogin).click();
    }
}
