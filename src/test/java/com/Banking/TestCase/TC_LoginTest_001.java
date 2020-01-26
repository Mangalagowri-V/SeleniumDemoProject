package com.Banking.TestCase;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.Banking.PageObject.LoginPage;

public class TC_LoginTest_001 extends BaseClass {

	@Test
	public void LoginTest() throws IOException {
		driver.get(baseUrl);
		logger.info("URL Launched");

		LoginPage lp = new LoginPage(driver);

		lp.setUserName(username);
		logger.info("Entered User Name");

		lp.setPassword(password);
		logger.info("Entered Password");

		lp.clickLogin();
		logger.info("Login form submitted");

		if (driver.getTitle().equals("Guru99 Bank Manager HomePage")) {
			Assert.assertTrue(true);
			logger.info("Test case Passed");
		} else {
			captureScreen(driver, "LoginTest");
			Assert.assertTrue(false);
			logger.info("Test case Faield");
		}
	}

}
