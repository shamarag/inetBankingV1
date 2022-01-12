package com.inetBanking.testCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.inetBanking.pageObjects.AddCustomerPage;
import com.inetBanking.pageObjects.LoginPage;

public class TC_AddCustomerTest_003 extends BaseClass{

	@Test
	public void addNewCustomer() throws InterruptedException, IOException
	{
		logger.info("URL is opened");
		LoginPage lp = new LoginPage(driver);//driver is declared as a public field in the base class
		lp.setUserName(getUsername());
		logger.info("User name is entered");
		
		lp.setPassword(getPassword());
		logger.info("Password is entered");
		
		lp.clickSubmit();
		
		Thread.sleep(3000); //wait for 3s after logging into the home page
		
		AddCustomerPage addCust = new AddCustomerPage(driver);
		
		addCust.clickAddNewCust();
		addCust.setCustName("Sam");
		addCust.setGender("male");
		addCust.setDOB("10", "10", "1986");
		addCust.setAddress("Hallam");
		addCust.setCity("Melbourne");
		addCust.setState("VIC");
		addCust.setMobileNo("12345677");
		addCust.setPinNo("654321");
		addCust.setEmail(randomString()+"@gmail.com");
		addCust.setPwd("asdfg");
		addCust.clickSubmit();
		
		Thread.sleep(3000);
		logger.info("Validation starts...");
		//if successfully added the page shows a message "Custmer added successfully". Need to validate for that.
		
		if(driver.getPageSource().contains("Customer Registered Successfully!!!"))
		{
			Assert.assertTrue(true);
			logger.info("Add Customer test case passed");
		}
		else
		{
			captureScreen(driver, "addNewCustomer");
			Assert.assertTrue(false);
			logger.info("Add Customer test case passed");
		}
		
	
	}
	
}
