package com.bitly;

import com.bitly.base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class ShortenLongURLTests extends BaseTest {


    @Test(dataProvider = "login", priority = 1)
    public void testLoginUser(String email, String password, String username){

        loginPage.clickSideMenuLogin();
        loginPage.enterUsername(email);
        loginPage.enterPassword(password);
        loginPage.clickLoginButton();

        String actualUsername = homePage.getUserName();
        Assert.assertEquals(actualUsername, username, "Logged in username did not match expected value.");

        homePage.enterDestinationUrl("https://stackoverflow.com/questions/74863998/");
        homePage.clickAllowQRCodeCheckbox();
        homePage.clickCreateBitlyButton();

        String shortUrl = homePage.getShortUrl();
        Assert.assertTrue(shortUrl.contains("bit.ly"));
    }


    @DataProvider(name = "login")
    public Object[][] getLoginInformation(){
        return new Object[][] {{"akkanshasaraswat9@gmail.com", "Nove@2026", "o_40kfjdkbpk"}};
    }


}
