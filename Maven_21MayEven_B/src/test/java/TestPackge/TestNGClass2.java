package TestPackge;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import Facebookpompackage.CreateNewAccount;
import Facebookpompackage.LoginorSignUp;
import Facebookpompackage.MessengerPage;
import Facebookpompackage.RoomsPage;
import browserSetUp.BaseClass;
import utilspackage.Utilityclass;

public class TestNGClass2 extends BaseClass
{
	private WebDriver driver;
	private LoginorSignUp loginorSignUp;
	private MessengerPage  messengerPage;
	private CreateNewAccount createNewAccount;
	private RoomsPage roomsPage;
	private int testid;
	static ExtentTest test;
	static ExtentHtmlReporter reporter;
	@Parameters("browser")
	/*@BeforeSuite
	public void beforesuite()
	{
	}*/
	
	@BeforeTest
	public void launchbrowser(String browsername)
	{
		reporter = new ExtentHtmlReporter("test-output/ExtendReport/Extent.html");
		ExtentReports extend = new ExtentReports();
		extend.attachReporter(reporter);
		System.out.println("browser launch successfully");
		if(browsername.equals("chrome"))
		{
			driver=BaseClass.openChromeBrowser();
		} 
		/*if(browsername.equals("edge"))
		{
			driver= BaseClass.openEdgeBrowser();
			 
		}*/
		/*if(browsername.equals("firefox"))
		{
			driver= BaseClass.openFirefoxBrowser();
			
		}*/
	driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
	driver.manage().window().maximize();
		
	}
	
	@BeforeClass
	public void createPOMClassObjects() throws EncryptedDocumentException, IOException
	{
		loginorSignUp = new LoginorSignUp(driver);
		 messengerPage = new MessengerPage(driver);
		createNewAccount = new CreateNewAccount(driver);
		roomsPage = new RoomsPage(driver);
		
	}
	@BeforeMethod
	public void facebookloginpage()
	{
		System.out.println("application launch successfully");
		driver.get("https://www.facebook.com");
		
	}
	
	@Test(priority=1)
	public void loginpagedisplay() throws InterruptedException
	{
		//loginorSignUp.sendusername();
		//loginorSignUp.sendpassword();
		loginorSignUp.clickonloginbutton();
		System.out.println("login  button working");
		
		
	}
	
	@Test
	public void createnewaccountdisplay() throws InterruptedException
	{
		System.out.println("create new account page should display");
		
		createNewAccount.clickoncreateaccountbutton();
		Thread.sleep(3000);
		createNewAccount.sendfirstname();
		createNewAccount.sendsurname();
		createNewAccount.sendmobileno();
		createNewAccount.sendnewpassword();
		createNewAccount.clickonday();
		createNewAccount.clickonmonth();
		createNewAccount.clickonyear();
		createNewAccount.selectmalebutton();
		createNewAccount.clickonsignupbutton();
		
	}
	
	@Test(priority=3)
	public void featurepagedisplay() throws InterruptedException
	{  
		loginorSignUp.openmessengerlink();
		 messengerPage.openFeatures();
		 System.out.println("features page should display ");
		
	}
	
	@AfterMethod
	public void aftermethod(ITestResult result) throws IOException
	{
		if(ITestResult.FAILURE==result.getStatus());
		{
			Utilityclass.CaptureScreenShot(driver, testid);
		}
		System.out.println("aftermethod");
	}
	@AfterClass
	public void removePOMClssObjects()
	{
		loginorSignUp = null;
		 messengerPage = null;
		createNewAccount = null;
		roomsPage = null;
	}
		
	@AfterTest
	public void closebrowser()
	{
		System.out.println("close browser successfully");
		driver.close();
		driver= null;
		System.gc();
	}
	/*@AfterSuite
	public void aftersuite()
	{
		System.out.println("after suite TestNGClass2");
	}*/
}
