package com.Banking.TestCase;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.Banking.PageObject.LoginPage;
import com.Banking.PageObject.AddCustomerDetaisPage;


public class TC_AddNewCustomer_003 extends BaseClass {

	@Test
	public void addcustomer() throws InterruptedException, IOException {
		
		
		LoginPage lp = new LoginPage(driver);
		driver.get(baseUrl);

		lp.setUserName(username);
		logger.info("Entered User Name");

		lp.setPassword(password);
		logger.info("Entered Password");

		lp.clickLogin();
		logger.info("Login form submitted");

		Thread.sleep(3000);

		AddCustomerDetaisPage addcus = new AddCustomerDetaisPage(driver);

		addcus.clickaddcustomer();
		addcus.setname("Gowri");
		addcus.selectgender("m");
		addcus.setdob("03", "20", "2010");
		Thread.sleep(3000);
		addcus.setaddress("India");
		addcus.setcity("TUP");
		addcus.setstate("TN");
		addcus.setpin("750356");
		Thread.sleep(3000);
		addcus.setphonenum("12345678901");
		String passemail = randomestring() + "gmail.com";
		addcus.setemail(passemail);
		addcus.setpwd("Passes1");
		addcus.submit();

		Thread.sleep(3000);

		String result = driver.getTitle();
		if (result == "Guru99 Bank New Customer Entry") {
              Assert.assertTrue(true);
		}
		else
		{
			captureScreen(driver, "addcustomer");
			Assert.assertTrue(false);
		}
	}
	


}
