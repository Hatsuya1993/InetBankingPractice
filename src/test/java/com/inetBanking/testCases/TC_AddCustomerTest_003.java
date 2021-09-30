package com.inetBanking.testCases;

import com.inetBanking.pageObjects.AddCustomerPage;
import com.inetBanking.pageObjects.LoginPage;
import org.apache.commons.lang3.RandomStringUtils;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;

public class TC_AddCustomerTest_003 extends BaseClass {

    @Test
    public void addNewCustomer() throws InterruptedException, IOException {

        logger.info("URL is opened");
        LoginPage lp = new LoginPage(driver);
        lp.setUserName(username);
        logger.info("username");
        lp.setPassword(password);
        logger.info("password");
        lp.clickSubmit();
        logger.info("submit");

        Thread.sleep(3000);

        AddCustomerPage addcust = new AddCustomerPage(driver);
        addcust.clickAddNewCustomer();

        addcust.custName("Pavan");
        logger.info("customer name");
        addcust.custgender("male");
        logger.info("customer gender");
        addcust.custdob("10","15","1985");
        logger.info("customer DOB");
        Thread.sleep(5000);
        addcust.custaddress("INDIA");
        logger.info("customer address");
        addcust.custcity("HYD");
        logger.info("customer city");
        addcust.custstate("AP");
        logger.info("customer state");
        addcust.custpinno("5000074");
        logger.info("customer pinno");
        addcust.custtelephoneno("987890091");
        logger.info("customer phone");
        String email = randomString()+"@test.com";
        addcust.custemailid(email);
        logger.info("customer email");
        addcust.custpassword("asdfgh");
        logger.info("customer password");
        addcust.custsubmit();
        logger.info("customer submit ");

        Thread.sleep(3000);

        boolean results = driver.getPageSource().contains("Customer Registered Successfully!!!");
        if(results) {
            Assert.assertTrue(true);
            logger.info("Test passed");
        }

        else {
            captureScreen(driver, "addNewCustomer");
            Assert.fail();
            logger.info("Test failed");
        }
    }

    public String randomString() {
       String generatedString = RandomStringUtils.randomAlphabetic(8);
       return generatedString;
    }

    public static String randomNum() {
        String generatedString2 = RandomStringUtils.randomNumeric(4);
        return generatedString2;
    }
}
