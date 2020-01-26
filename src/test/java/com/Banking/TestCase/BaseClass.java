package com.Banking.TestCase;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang.RandomStringUtils;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;


import com.Banking.Utilities.ReadConfig;


public class BaseClass {

	

	ReadConfig read = new ReadConfig();

	public String baseUrl = read.getApplicationUrl();
	public String username = read.getusername();
	public String password = read.getpassword();
	public String chromepath = read.getchromepath();
	public String firepath = read.getfirefox();
	public String iepath = read.getIEpath();

	public static WebDriver driver;
	public static Logger logger;

	@Parameters("browser")
	@BeforeClass
	public void setup(String br) {
		logger = Logger.getLogger("eBanking");
		PropertyConfigurator.configure("log4j.properties");

		if (br.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver", chromepath);
			driver = new ChromeDriver();
			
		} else if (br.equals("firefox")) {
			System.setProperty("webdriver.gecko.driver", firepath);
			driver = new FirefoxDriver();
			
		} else if (br.equals("ie")) {
			System.setProperty("webdriver.ie.driver", iepath);
			driver = new InternetExplorerDriver();
			
		}
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		driver.get(baseUrl);
	}

	@AfterClass
	public void tearDown() {
		driver.quit();
	}
	
	 public void captureScreen(WebDriver driver,String result) throws IOException
	 {
	   TakesScreenshot ts=(TakesScreenshot)driver;
	   File source=ts.getScreenshotAs(OutputType.FILE); // capture screenshot file
	   File target=new File(System.getProperty("user.dir")+"/Screenshots/"+result+".png");	   
	   FileUtils.copyFile(source,target);
	   System.out.println("screenshot captured");
	  }
	 
	 public String randomestring() {
			String randomemail = RandomStringUtils.randomAlphabetic(6);
			return (randomemail);
		}
	 public static String randomenum() {
			String randomenum = RandomStringUtils.randomNumeric(4);
			return (randomenum);
		}
	 
	}
