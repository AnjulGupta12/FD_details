package com.FDdetail.pages;

import com.FDdetail.base.TestBase;

import org.openqa.selenium.By;
import org.testng.Assert;

public class Credential extends TestBase{
	
	

	By userNameLoc = By.id("body_txtUserID");
	By passwordLoc = By.id("body_txtPassword");
	By loginButtonLoc = By.id("body_btnLogin");
	
	
	public void login(String uName, String pwd)
	{
		wait(1000);
		driver.findElement(userNameLoc).clear();
		wait(300);
		driver.findElement(userNameLoc).sendKeys(uName);
		driver.findElement(passwordLoc).clear();
		wait(300);
		driver.findElement(passwordLoc).sendKeys(pwd);
		wait(1000);
		driver.findElement(loginButtonLoc).click();
		wait(1000);
		System.out.println("LogIn Successful");
		wait(300);
		String expect_login = "Welcome "+uName;
		String actual_login = driver.findElement(By.id("divWelcome")).getText();
		Assert.assertEquals(expect_login, actual_login);
		System.out.println(actual_login);
		wait(1000);
	}
	

}
