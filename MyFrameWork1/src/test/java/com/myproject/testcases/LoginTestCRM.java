package com.myproject.testcases;


import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.myproject.pages.BaseClass;
import com.myproject.pages.LoginPage;
import com.myproject.utility.Helper;



public class LoginTestCRM extends BaseClass
{
			
	@Test(priority=1)
	public void loginApp() throws Exception 
	{
	
	logger=report.createTest("Login to CRM");	
	LoginPage loginpage=PageFactory.initElements(driver, LoginPage.class);
	logger.info("Starting application");
	loginpage.loginToCRM(excel.getStringData("Login", 0, 0),excel.getStringData("Login", 0, 1));
	logger.pass("Login success");
	
/*SoftAssert assertion =new SoftAssert();
String Expected="Homepage";
assertion.assertEquals(driver.getTitle(), Expected);
logger.fail("Login failure");*/
	}
	@Test(priority=2)
	public void loginApp1()
	{
		logger=report.createTest("Logout");
		logger.fail("logout failed");
	}
	
		
	
	
	

}
