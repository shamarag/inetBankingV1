package com.inetBanking.testCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.inetBanking.pageObjects.LoginPage;

public class TC_LoginTest_001 extends BaseClass{//follow test case name format
	
	@Test
	public void loginTest() throws IOException
	{
		
		logger.info("URL is opened");
		LoginPage lp = new LoginPage(driver);
		lp.setUserName(getUsername());
		logger.info("User name is entered");
		
		lp.setPassword(getPassword());
		logger.info("Password is entered");
		
		lp.clickSubmit();
		
		if(driver.getTitle().equals("Guru99 Bank Manager HomePage"))
		{
			Assert.assertTrue(true, "Login test passed");
			logger.info("Login test case passed");
		}
		else
		{
			Assert.assertTrue(false, "Login test failed");
			logger.info("Login test case failed");
			captureScreen(driver, "loginTest");
		}
		
	}
	
}
