package com.shopperstack_GenericUtilty;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterGroups;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeGroups;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.shopperstack_POM.Home_Page;
import com.shopperstack_POM.Login_Page;
import com.shopperstack_POM.Welcome_Page;

public class Base_Test {
	
	public File_Utility fileUtility=new File_Utility();
	public WebDriver driver;
	public static WebDriver sDriver;
	public ExtentSparkReporter spark;
	public ExtentReports reports;
	public ExtentTest test;
	public Welcome_Page welcomePage;
	public Login_Page loginPage;
	public Home_Page homePage;
	public Java_Utility javaUtility=new Java_Utility();
	public WebDriverWait wait;
	public WebDriver_Urility webDriver=new WebDriver_Urility();
	
	@BeforeSuite
	public void beforeSuit() {
	   System.out.println("@BeforSuite");	
	}
    @BeforeTest
    public void befortest()
    {
    	System.out.println("@BeforeTest");
    	spark=new ExtentSparkReporter(FrameworkConstant.extentReportsPath+javaUtility.localDateTime()+".html");
    	reports=new ExtentReports();
    	reports.attachReporter(spark);
    }
    @BeforeGroups
    public void beforgroup()
    {
    	System.out.println("@Beforegroup");
    }
    
    @BeforeClass
    public void beforclass() throws IOException
    {
    	System.out.println("@Beforeclass");
    	String browser = fileUtility.readPropertyFile("browser");
    	
    	String url= fileUtility.readPropertyFile("url");
    	
    	if(browser.contains("chrome")) {
    		driver =new ChromeDriver();
    	}
    	else if (browser.contains("firefox")) {
			driver = new FirefoxDriver();
		}
    	else if (browser.contains("edge")) {
			driver=new EdgeDriver();
		}
    	else {
    		System.out.println("Enter Valid Browser name");
    	}
    	sDriver=driver;
    	homePage=new Home_Page(driver);
    	driver.manage().window().maximize();
    	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    	driver.get(url);
    	
    	
    }
    @BeforeMethod
    public void beformethod() throws IOException, InterruptedException
    {
    	System.out.println("@Beforemethod");
    	
    	String username = fileUtility.readPropertyFile("username");
    	String password = fileUtility.readPropertyFile("password");
    	
    	welcomePage=new Welcome_Page(driver);
    	
    	wait=new WebDriverWait(driver, Duration.ofSeconds(25));
    	wait.until(ExpectedConditions.elementToBeClickable(welcomePage.getLoginBtn()));
    	Thread.sleep(3000);
    	
    	welcomePage.getLoginBtn().click();
    	
    	loginPage=new Login_Page(driver);
    	loginPage.getEmail().sendKeys(username);
    	loginPage.getPassword().sendKeys(password);
    	loginPage.getLoginbutton().click();
    }
    @AfterMethod
    public void aftermethod() throws InterruptedException {
    	System.out.println("@Aftermethod");
    	Thread.sleep(5000);
    	homePage.getSettingBtn().click();
    
    	homePage.getLogoutbtn().click();
    }
	@AfterClass
	public void afterclass() throws InterruptedException {
		System.out.println("@AfterClass");
		Thread.sleep(3000);
		driver.quit();
	}
	@AfterGroups
	public void aftergroup() {
		System.out.println("@AfterGroups");
	}
	@AfterTest
	public void aftertest() {
		System.out.println("@AfterTest");
		reports.flush();
	}
	@AfterSuite
	public void aftersuite() {
		System.out.println("@AfterSuite");
	}
	
	
}
