package TestPackge;



import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
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
import org.testng.asserts.SoftAssert;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import Facebookpompackage.LoginorSignUp;
import Facebookpompackage.MessengerPage;
import Facebookpompackage.RoomsPage;
import browserSetUp.BaseClass;
import utilspackage.Utilityclass;

public class TestNGclass extends BaseClass
{
	private WebDriver driver;
	private LoginorSignUp loginorSignUp;
	private MessengerPage messengerPage;
	private RoomsPage roomsPage;
	private SoftAssert soft;
	private int testid;
	static ExtentTest test;
	static ExtentHtmlReporter reporter;
	@Parameters("browser")
	/*@BeforeSuite
	public void beforesuite()
	{
		System.out.println("before suite TestNGClass");
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
	public void createPOMObjects()
	{
		loginorSignUp =new LoginorSignUp (driver);
		messengerPage =new MessengerPage (driver);
		roomsPage= new RoomsPage(driver);
	}


	@BeforeMethod
	public void verifymessgener()
	{
		//System.out.println("application launch successfully");
		driver.get("https://www.facebook.com");
		loginorSignUp.openmessengerlink();
		messengerPage.openRooms();
		 soft= new SoftAssert();
	}
	@Test
	public void openmessgenerpage()
	{
		testid =1111;
		System.out.println("messenger page display");
		roomsPage.goBackToMessenger();
		
		String url=driver.getCurrentUrl();
		String title=driver.getTitle();
		
		System.out.println(url);
		System.out.println(title);
		
		soft.assertEquals(url, "https://www.messenger","url of openmessnger is not working");
		soft.assertEquals(title, "Messenger","title of page is wrong");
		soft.assertAll();
	//	Assert.assertEquals(url, "https://www.messenger./","url of openmessnger is not working");
	//	Assert.assertEquals(title, "https://www.messenger.com/");
	//	 boolean result=url.equals("sffdg");
	//	 Assert.assertTrue(result);
	//	Assert.fail();
	
	}
	@Test
	public void opencontacttohelpcenterpage()
	{
		testid=1112;
		System.out.println("contact to help center  page display");
		roomsPage.contactToHelpCenter();
		
		String url=driver.getCurrentUrl();
		String title=driver.getTitle();
		
		System.out.println(url);
		System.out.println(title);
		
		soft.assertEquals(url, "https://www.messenger.com/help","url of contact to help center  is not working");
		soft.assertEquals(title, "Messenger  Centre","title of page is wrong");
		soft.assertAll();
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
	public void removeobjects()
	{
		loginorSignUp = null;
		messengerPage =null;
		roomsPage= null;
	}
	@AfterTest
	public void closeBrowser()
	{
		System.out.println("close browser successfully");
		driver.close();
		driver= null;
		System.gc();  // garbage collector
		
		
		
	}
	/*@AfterSuite
	public void aftersuite()
	{
		System.out.println("after suite TestNGClass");
	}*/
}
