package com.inetBanking.testCases;

import com.inetBanking.pageObjects.LoginPage;
import com.inetBanking.utilities.XLUtils;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.IOException;

public class TC_LoginDDT_002 extends BaseClass {

    @Test(dataProvider = "LoginData")
    public void loginDDT(String user, String pwd) throws IOException {
        logger.info("URL is opened");
        LoginPage lp = new LoginPage(driver);
        lp.setUserName(user);
        logger.info("Username entered");
        lp.setPassword(pwd);
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

    @DataProvider(name = "LoginData")
    Object[][] getData() throws IOException {
        String path = System.getProperty("user.dir")+"/src/test/java/com/inetBanking/utilities/XLUtils.java";
        int rownum = XLUtils.getRowCount(path, "Sheet1");
        int cocount = XLUtils.getCellCount(path, "Sheet1", 1);
        String logindata[][] = new String[rownum][cocount];
        for(int i = 0; i < rownum; i++){
            for(int y = 0; y < cocount; y++){
                logindata[i][y] = XLUtils.getCellData(path, "Sheet1", i, y);
            }
        }
        return logindata;
    }

}
