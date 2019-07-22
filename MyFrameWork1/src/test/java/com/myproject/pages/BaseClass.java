package com.myproject.pages;

import java.io.File;

import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.myproject.utility.BrowserFactory;
import com.myproject.utility.ConfigDataProvider;
import com.myproject.utility.ExcelDataProvider;
import com.myproject.utility.Helper;

public class BaseClass {
	
	public WebDriver driver;
	
	public ExcelDataProvider excel;
	public ConfigDataProvider config;
	public ExtentReports report;
	public ExtentTest logger;
	
	
	@BeforeSuite
	public void setUpSuite()
	{
		Reporter.log("Setting up report and test started",true);
		excel =new ExcelDataProvider();
		config= new ConfigDataProvider();
		ExtentHtmlReporter extent=new ExtentHtmlReporter(new File(System.getProperty("user.dir")+"/Reports/FreeCRM_"+Helper.getCurrentDateTime()+".html"));
		report = new ExtentReports();
		report.attachReporter(extent);
		Reporter.log("Setting Done-Test can be started",true);
	}
	
	@BeforeClass
	public void setUp()
	{
		Reporter.log("Starting the Browser and gettinga app ready",true);

		driver=BrowserFactory.startApplication(driver,config.getBrowser(),config.getStagingURL());	
		Reporter.log("Browser and app are up and running",true);
	}
	
	
	@AfterClass
	public void tearDown()
	{
		BrowserFactory.quitBrowser(driver);	
	}
	
	@AfterMethod
	public void tearDownMethod(ITestResult result) throws Exception
	{
		Reporter.log("Test about to end",true);
		if(result.getStatus()==ITestResult.FAILURE)
		{
		
		logger.fail("Test Failed", MediaEntityBuilder.createScreenCaptureFromPath(Helper.captureScreenShot(driver)).build());
		}
		else if(result.getStatus()==ITestResult.SUCCESS)
		{
			logger.pass("Test Success", MediaEntityBuilder.createScreenCaptureFromPath(Helper.captureScreenShot(driver)).build());
		}
		else if
		(result.getStatus()==ITestResult.SKIP)
		{
			logger.skip("Test Skipped", MediaEntityBuilder.createScreenCaptureFromPath(Helper.captureScreenShot(driver)).build());
		}
		report.flush();
		Reporter.log("Test completed and reports generated",true);
		}

}
