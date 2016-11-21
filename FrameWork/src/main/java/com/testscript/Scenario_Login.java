package com.testscript;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Scenario_Login {
	WebDriver driver = null;
	@BeforeMethod
	public void initializeBrowser()
	{
		 driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get("http://books.rediff.com/");
	}
	
	@AfterMethod
	public void tearDown()
	{
		driver.quit();
	}
	
	@Test(dataProvider="ValidLogin_DP",dataProviderClass = com.dataProvider.Login_DataProvider.class)
	public void validLogin(String username, String password)
	{
		/*WebDriver driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get("http://books.rediff.com/");*/
		/*driver.findElement(By.xpath("//a[@href='/login']")).click();
		driver.findElement(By.name("logid")).sendKeys("qtpworld2008@gmail.com");
		driver.findElement(By.name("pswd")).sendKeys("learn123");
		driver.findElement(By.cssSelector(".sb1 input")).click();*/
		////*************************
		loginFunctionality(username, password);
		String actual = driver.findElement(By.xpath("//span[@id='username']/a")).getText();
		if(actual.equalsIgnoreCase("qtpworld2008 g"))
		{
			System.out.println("TC validLogin pass");
		}
		else
		{
			System.out.println("TC validLogin failed");
		}
		//driver.close();
		//logid //pswd //sb1 input
	}
	
	
	//************************************common Test Case
	
	public void loginFunctionality(String username, String password)
	{
		driver.findElement(By.xpath("//a[@href='/login']")).click();
		driver.findElement(By.name("logid")).sendKeys(username);
		driver.findElement(By.name("pswd")).sendKeys(password);
		driver.findElement(By.cssSelector(".sb1 input")).click();
		
	}
	
	
	@Test(dataProvider = "InvalidLogin_DP", dataProviderClass=com.dataProvider.Login_DataProvider.class)
	public void invalidLogin(String username, String password)
	{
		/*WebDriver driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get("http://books.rediff.com/");*/
		/*driver.findElement(By.xpath("//a[@href='/login']")).click();
		driver.findElement(By.name("logid")).sendKeys("");
		driver.findElement(By.name("pswd")).sendKeys("");
		driver.findElement(By.cssSelector(".sb1 input")).click();*/
		
		//**********************
		loginFunctionality(username,password);
		String actual = driver.findElement(By.xpath("//b[contains(text(),'Sorry')]")).getText();
		if(actual.equalsIgnoreCase("Sorry we were unable to complete this step because :"))
		{
			System.out.println("TC invalidLogin pass");
		}
		else
		{
			System.out.println("TC invalidLogin failed");
		}
		
		//driver.close();
	}

}
