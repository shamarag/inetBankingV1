package com.inetBanking.testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.inetBanking.pageObjects.EditCustomerPage;
import com.inetBanking.pageObjects.LoginPage;

public class TC_EditCustomerTest_004 extends BaseClass {

	@Test
	public void editCCustomer() throws InterruptedException
	{
		logger.info("URL is opened");
		LoginPage lp = new LoginPage(driver);//driver is declared as a public field in the base class
		lp.setUserName(getUsername());
		logger.info("User name is entered");
		
		lp.setPassword(getPassword());
		logger.info("Password is entered");
		
		lp.clickSubmit();
		
		Thread.sleep(3000); //wait for 3s after logging into the home page
		
		EditCustomerPage editCust = new EditCustomerPage(driver);
		
		editCust.clickEditCust();
		editCust.setCustId("654321");
		editCust.clickSubmit();
		
		Thread.sleep(3000); //wait for 3s after logging into the home page
		
		if(isAlertPresent())
		{
			Assert.assertTrue(false);
			logger.info("Customer not found alert..");
			driver.switchTo().alert().accept();//close the alert
			driver.switchTo().defaultContent();
		}
		else
		{
			Assert.assertTrue(true);
			logger.info("Customer found..");
			Thread.sleep(3000);
			driver.switchTo().defaultContent();
		}
	}
}
