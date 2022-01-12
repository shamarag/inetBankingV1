package com.inetBanking.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class AddCustomerPage {
	
	WebDriver lDriver;
	
	public AddCustomerPage(WebDriver rDriver) {
		lDriver = rDriver;
		PageFactory.initElements(lDriver, this);
	}
	
	//UI Elements in the Login Page
	
	@FindBy(how = How.XPATH, using="/html/body/div[3]/div/ul/li[2]/a")
	@CacheLookup
	WebElement linkNewCustomer;
	
	@FindBy(how = How.NAME, using="name")//alternative way to using simply name
	@CacheLookup
	WebElement txtCustName;
	
	@FindBy(name="rad1")
	@CacheLookup
	WebElement radGender;
	
	@FindBy(name="dob")
	@CacheLookup
	WebElement txtDateOfBirth;
	
	@FindBy(name="addr")
	@CacheLookup
	WebElement txtAddress;
	
	@FindBy(name="city")
	@CacheLookup
	WebElement txtCity;
	
	@FindBy(name="state")
	@CacheLookup
	WebElement txtState;
	
	@FindBy(name="pinno")
	@CacheLookup
	WebElement txtPinNo;
	
	@FindBy(name="telephoneno")
	@CacheLookup
	WebElement txtPhoneNo;
	
	@FindBy(name="emailid")
	@CacheLookup
	WebElement txtEmail;
	
	@FindBy(name="password")
	@CacheLookup
	WebElement txtPwd;
	
	@FindBy(name="sub")
	@CacheLookup
	WebElement btnSubmit;
	
	@FindBy(name="res")
	@CacheLookup
	WebElement btnReset;
	
	public void setCustName(String name)
	{
		txtCustName.sendKeys(name);
	}
	
	public void setGender(String gender)
	{
		radGender.click();
	}
	
	public void setDOB(String mm, String dd, String yy)
	{
		txtDateOfBirth.sendKeys(mm);
		txtDateOfBirth.sendKeys(dd);
		txtDateOfBirth.sendKeys(yy);
	}
	
	public void setAddress(String address)
	{
		txtAddress.sendKeys(address);
	}
	
	public void setCity(String city)
	{
		txtCity.sendKeys(city);
	}
	
	public void setState(String state)
	{
		txtState.sendKeys(state);
	}
	
	public void setPinNo(String pinNo)
	{
		txtPinNo.sendKeys(pinNo);
	}
	
	public void setMobileNo(String mobileNo)
	{
		txtPhoneNo.sendKeys(mobileNo);
	}
	
	public void setEmail(String email)
	{
		txtEmail.sendKeys(email);
	}
	
	public void setPwd(String pwd)
	{
		txtPwd.sendKeys(pwd);
	}
	
	public void clickAddNewCust()
	{
		linkNewCustomer.click();
	}
	
	public void clickSubmit()
	{
		btnSubmit.click();
	}
	
	public void clickReset()
	{
		btnReset.click();
	}
	
	
}
