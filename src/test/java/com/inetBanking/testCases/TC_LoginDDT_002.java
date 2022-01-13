package com.inetBanking.testCases;

import java.io.IOException;

import org.openqa.selenium.NoAlertPresentException;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.inetBanking.pageObjects.LoginPage;
import com.inetBanking.utilities.XLUtils;

public class TC_LoginDDT_002 extends BaseClass {

	@Test(dataProvider="LoginData")
	public void loginDDT(String user, String pwd) throws InterruptedException
	{
		logger.info("URL is opened");
		LoginPage lp = new LoginPage(driver);
		lp.setUserName(user);
		logger.info("User name is entered");
		
		lp.setPassword(pwd);
		logger.info("Password is entered");
		
		lp.clickSubmit();
		
		Thread.sleep(3000);//so that it will pause, and we can see what happens
		
		if(isAlertPresent())
		{
			Assert.assertTrue(false);
			logger.info("Login failed");
			driver.switchTo().alert().accept();//close the alert
			driver.switchTo().defaultContent();
		}
		else
		{
			Assert.assertTrue(true);
			logger.info("Login passed.");
			lp.clickLogout();
			Thread.sleep(3000);
			driver.switchTo().alert().accept();//close logout alert
			driver.switchTo().defaultContent();
		}
	}
	
	
	
	@DataProvider(name="LoginData") //marks that this method as a method that supplies data for a test method
	public String[][] getData() throws IOException
	{
		String path = System.getProperty("user.dir")+"/src/test/java/com/inetBanking/testData/LoginData.xlsx";
		int rownum = XLUtils.getRowCount(path, "Sheet1");
		int colnum = XLUtils.getCellCount(path, "Sheet1", 1);
		
		String logindata[][] = new String[rownum][colnum];
		for(int i=1; i<=rownum; i++)
		{
			for(int j=0; j<colnum; j++)
			{
				logindata[i-1][j] = XLUtils.getCellData(path, "Sheet1", i, j);
			}
		}
		return logindata;
	}
}
