package com.bitly.base;

import com.bitly.driver.DriverFactory;
import com.bitly.pages.HomePage;
import com.bitly.pages.LoginPage;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseTest {

    protected LoginPage loginPage;
    protected HomePage homePage;

    @BeforeMethod
    public void setup(){
        DriverFactory.initDriver();
        DriverFactory.getDriver().get("https://bitly.com/");

        loginPage = new LoginPage();
        homePage = new HomePage();
    }

    @AfterMethod
    public void tearDown() {
        DriverFactory.quitDriver();
    }

}
