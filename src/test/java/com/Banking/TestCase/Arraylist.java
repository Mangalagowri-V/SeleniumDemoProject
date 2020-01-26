package com.Banking.TestCase;

import java.util.ArrayList;

import com.Banking.Utilities.Xls_Reader;

public class Arraylist {
	
	static Xls_Reader reader;
	
	
	public static ArrayList<Object[]> getdatafromexcel() {
		
		ArrayList<Object[]> mydata = new ArrayList<Object[]>();

		try {
			reader = new Xls_Reader("C:\\Users\\csvel\\MavenJenkins\\BankingTest\\src\\test\\java\\com\\Banking\\TestData\\ddt (1).xlsx");
					
		} catch (Exception e) {
			e.printStackTrace();
		}
		

		for (int row=2; row <= reader.getRowCount("Logincredential"); row++)
		  {
			String name = reader.getCellData("Logincredential", "username", row);
			String password = reader.getCellData("Logincredential", "password", row);
			
			Object obj[] = {name,password};
			mydata.add(obj);
			System.out.println(mydata);
			}
			 
		return mydata;
		
	}		
	
}
