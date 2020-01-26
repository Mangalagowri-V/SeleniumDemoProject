package com.Banking.TestCase;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;


import org.openqa.selenium.NoAlertPresentException;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.Banking.PageObject.LoginPage;
import com.Banking.Utilities.Xls_Reader;

public class TC_LoginDDTTest_002 extends BaseClass {

	public static Xls_Reader read;

	@Test(dataProvider = "Login")
	public void LoginDDT(String user, String pwd) throws InterruptedException, IOException {
		driver.get(baseUrl);
		logger.info("URL Launched");

		LoginPage lp = new LoginPage(driver);

		lp.setUserName(user);
		logger.info("Entered User Name");

		lp.setPassword(pwd);
		logger.info("Entered Password");
		
		Thread.sleep(3000);

		lp.clickLogin();
		logger.info("Login form submitted");
		
		Thread.sleep(3000);

		if (isAlertPresent() == true) {
			driver.switchTo().alert().accept();
			captureScreen(driver, "TC_LoginDDTTest_002");
			driver.switchTo().defaultContent();
			Assert.assertTrue(false);
		} else {
			Assert.assertTrue(true);
			lp.clickLogout();
			
			Thread.sleep(3000);
			logger.info("Logout the Page");
			driver.switchTo().alert().accept();
			driver.switchTo().defaultContent();
		}
	}

	public boolean isAlertPresent() {

		try {
			driver.switchTo().alert();
			return true;
		} catch (NoAlertPresentException e) {
			return false;
		}

	}
	

	@DataProvider(name ="Login")
	

	public Iterator<Object[]> getData()
	{
		ArrayList<Object[]> testdata = Arraylist.getdatafromexcel();
		return testdata.iterator();
	}
	

}
