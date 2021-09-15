package com.inetBanking.testCases;

import com.inetBanking.pageObjects.LoginPage;
import org.testng.annotations.Test;

public class TC_LoginTest_001 extends BaseClass {

    @Test
    public void loginTest(){
        driver.get(baseURL);
        LoginPage lp = new LoginPage(driver);
    }

}
