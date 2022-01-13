package com.inetBanking.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class EditCustomerPage {

	WebDriver cDriver;
	
	public EditCustomerPage(WebDriver rDriver) {
		cDriver = rDriver;
		PageFactory.initElements(cDriver, this);
	}
	
	//UI Elements in the Login Page
	
	//@FindBy(how = How.XPATH, using = "/html/body/div[2]/div/div/ul/li[3]/a")
	@FindBy(linkText="Edit Customer")
	@CacheLookup
	WebElement linkEditCustomer;
	
	@FindBy(how = How.NAME, using="cusid")//alternative way to using simply name
	@CacheLookup
	WebElement txtCustId;
	
	@FindBy(how = How.NAME, using ="AccSubmit")
	@CacheLookup
	WebElement btnSubmit;
	
	public void setCustId(String custId)
	{
		txtCustId.sendKeys(custId);
	}
	
	public void clickEditCust()
	{
		linkEditCustomer.click();
	}
	
	public void clickSubmit()
	{
		btnSubmit.click();
	}
	
	
	
}
