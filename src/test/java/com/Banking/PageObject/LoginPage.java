package com.Banking.PageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	
	WebDriver ldriver;
	
	public LoginPage(WebDriver rdriver)
	{		
		ldriver = rdriver;		
		PageFactory.initElements(rdriver, this);		
	}
    
	
	      @FindBy(name="uid")
	      WebElement txtUserName;
    
	      @FindBy(name="password")
	      WebElement txtpassword;
	      
	      @FindBy(name="btnLogin")
	      WebElement btnLogin;
	      
	      @FindBy(xpath="//a[contains(text(),'Log out')]")
	      WebElement btnLogout;
	      
	      public void setUserName(String uname)
	      {
	    	  txtUserName.sendKeys(uname);
	      }
	      
	      public void setPassword(String pswd)
	      {
	    	  txtpassword.sendKeys(pswd);
	      }
	      
	      public void clickLogin()
	      {
	    	  btnLogin.click();
	      }
	      public void clickLogout()
	      {
	    	  btnLogout.click();
	      }
}

