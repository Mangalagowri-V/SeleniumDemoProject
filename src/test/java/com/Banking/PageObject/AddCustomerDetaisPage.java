package com.Banking.PageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddCustomerDetaisPage {
		
WebDriver ldriver;
	
	public AddCustomerDetaisPage(WebDriver rdriver)
	{		
		ldriver = rdriver;		
		PageFactory.initElements(rdriver, this);		
	}
	
	@FindBy(xpath="//a[contains(text(),'New Customer')]")
	WebElement clickaddcustomer;
	
	@FindBy(name="name")
	WebElement name;
	
	@FindBy(name="rad1")
	WebElement radiobtn;
	
	@FindBy(id="dob")
	WebElement dob;
		
	@FindBy(xpath ="//textarea[@name='addr']")
	WebElement address;
	
	@FindBy(name="city")
	WebElement city;
	
	@FindBy(name="state")
	WebElement state;
	
	@FindBy(name="pinno")
	WebElement pincode;
	
	@FindBy(name="telephoneno")
	WebElement mobilenum;
	
	@FindBy(name="emailid")
	WebElement email;
	
	@FindBy(name="password")
	WebElement pwd;
	
	@FindBy(name="sub")
	WebElement submit;
	
	public void clickaddcustomer()
	{
		clickaddcustomer.click();
	}
	
	public void setname(String name1)
	{
		name.sendKeys(name1);
	}
	
	public void selectgender(String gender)
	{
		radiobtn.click();
	}
	public void setdob(String mm,String dd,String yyyy)
	{
		dob.sendKeys(mm);
		dob.sendKeys(dd);
		dob.sendKeys(yyyy);	
	}
	
	public void setaddress(String addr)
	{
		address.sendKeys(addr);
	}
	public void setcity(String city1)
	{
		city.sendKeys(city1);
	}
	public void setstate(String stat)
	{
		state.sendKeys(stat);
	}
	public void setpin(String pin)
	{
		pincode.sendKeys(String.valueOf(pin));
	}
	public void setphonenum(String num)
	{
		mobilenum.sendKeys(String.valueOf(num));
	}
	public void setemail(String mail)
	{
		email.sendKeys(mail);
	}
	public void setpwd(String pass)
	{
	pwd.sendKeys(pass);	
	}
	public void submit()
	{
	submit.click();	
	}

}
