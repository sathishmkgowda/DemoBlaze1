package com.genericLib.DemoBlaze1;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.objectRepo.DemoBlaze1.Homepage;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Base 
{
	public static WebDriver driver;
	public FileLib fl=new FileLib();
	public String propPath="src/test/resources/commondata.properties";
	public static Homepage hp;
	public CommonUtils cu=new CommonUtils();
	public static ExtentReports extent;
	public static ExtentSparkReporter spark;
	public static ExtentTest test;
	
	@BeforeSuite
	public void configureBSTest() throws IOException 
	{
		extent=new ExtentReports();
		spark=new ExtentSparkReporter("DemoBlaze1.html");
		extent.attachReporter(spark);
		if(fl.getDataFromProperties(propPath, "browser").equals("chrome"))  // path and the key
		{
			driver=new ChromeDriver();	
			WebDriverManager.chromedriver().setup();
		}
		
		if(fl.getDataFromProperties(propPath, "browser").equals("firefox"))  // path and the key
		{
			driver=new FirefoxDriver();
			WebDriverManager.firefoxdriver().setup();
		}
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		driver.get(fl.getDataFromProperties(propPath,"URL"));
		}
	
	@BeforeMethod
	public void configBMTest() throws IOException
	{   hp=PageFactory.initElements(driver, Homepage.class);
		hp.getLogin().click();
		cu.waitFortheElemenToBeCickable(driver,hp.getLoginButton());
		hp.getUsername().sendKeys(fl.getDataFromProperties(propPath,"username"));
		hp.getPassword().sendKeys(fl.getDataFromProperties(propPath,"password"));
		hp.getLoginButton().click();
	    cu.waitFortheText(driver,hp.getVerifyLogin(),"Welcome QA Test");
		System.out.println(hp.getVerifyLogin().getText());
		Assert.assertTrue(hp.getVerifyLogin().getText().contains(fl.getDataFromProperties(propPath,"username")));
	}
	
	@AfterMethod
	public void configAMTest() throws IOException
	{
		hp.getLogout().click();
		test.pass("Logged out  DemoBlasze as  "+fl.getDataFromProperties(propPath, "username"));
		
	}
	
	@AfterSuite
	public void configASTest()
	{
		driver.quit();
		test.pass("close the browse");
		extent.flush();
	}
}

