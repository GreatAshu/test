package com.dataProvider;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.testng.annotations.DataProvider;

public class Login_DataProvider {
	
	@DataProvider(name="ValidLogin_DP")
	public static Iterator<Object[]> DP_validLogin()
	{
		List<Object[]> ls = new ArrayList<Object[]>();
		Object[] obj = new Object[2];
		obj[0] = "qtpworld2008@gmail.com";
		obj[1]="learn123";
		ls.add(obj);
		return ls.iterator();
	}
	
	
	
	
	@DataProvider(name = "InvalidLogin_DP")
	public static Iterator<Object[]> DP_InvalidLogin()
	{
		List<Object[]> ls = new ArrayList<Object[]>();
		Object[] obj = new Object[2];
		obj[0]= "";
		obj[1]="";
		ls.add(obj);
		return ls.iterator();
	}
	
	public void getXLData()
	{
		
	}

}
