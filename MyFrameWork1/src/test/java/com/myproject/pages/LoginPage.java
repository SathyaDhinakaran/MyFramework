package com.myproject.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class LoginPage {
	
	WebDriver driver;
	
	//This to test new commit from Sathya

	public LoginPage(WebDriver ldriver)
	{
		this.driver=ldriver;
	}
        @FindBy(xpath="//span[text()='Log In']") WebElement signin;	
		@FindBy(name="email") WebElement uname;
		@FindBy(name="password") WebElement pass;	
		@FindBy(xpath="//div[text()='Login']") WebElement loginButton;
		
		public void loginToCRM(String unameApp,String passApp) throws Exception
		{
			signin.click();
			Thread.sleep(3000);
			uname.sendKeys(unameApp);
			pass.sendKeys(passApp);
			loginButton.click();
		}
		
	
	
	
}
