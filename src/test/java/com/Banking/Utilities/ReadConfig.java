package com.Banking.Utilities;

import java.io.File;
import java.io.FileInputStream;
//import java.io.IOException;
import java.util.Properties;

public class ReadConfig {
	
	Properties pro;
	
	public ReadConfig() {
		
		File src = new File("./Configure/config.properties");
		
		try
		{
		  FileInputStream fis = new FileInputStream(src);
		  pro = new Properties();
		  pro.load(fis);
		}catch(Exception e) {
		  System.out.println("Exception is  : "+e.getMessage());
			
		}				
	}
	public String getApplicationUrl()
	{
		String url = pro.getProperty("baseUrl");
		return url;
	}
	public String getusername()
	{
		String uname = pro.getProperty("username");
		return uname;
	}
	public String getpassword()
	{
		String pwd = pro.getProperty("password");
		return pwd;
	}
	public String getchromepath()
	{
		String chromepath = pro.getProperty("chromepath");
		return chromepath;
	}
	public String getfirefox()
	{
		String firepath = pro.getProperty("firepath");
		return firepath;
	}
	public String getIEpath()
	{
		String iepath = pro.getProperty("ie");
		return iepath;
	}



}
