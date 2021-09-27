package com.inetBanking.testCases;

import com.inetBanking.pageObjects.LoginPage;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;

public class TC_LoginTest_001 extends BaseClass {

    @Test
    public void loginTest() throws IOException {
        logger.info("URL is opened");
        LoginPage lp = new LoginPage(driver);
        lp.setUserName(username);
        logger.info("Username entered");
        lp.setPassword(password);
        logger.info("Password is entered");
        lp.clickSubmit();
        if(driver.getTitle().equalsIgnoreCase("Guru99 Bank Manager HomePage")){
            Assert.assertTrue(true);
            logger.info("Test Pass");
        }
        else {
            captureScreen(driver, "logintest");
            Assert.fail();
            logger.info("Test Failed");
        }
    }

}
