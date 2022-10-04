package TestPackge;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import Facebookpompackage.LoginorSignUp;
import utilspackage.Utilityclass;

public class TestClass1excelsheet 
{
	private WebDriver  driver;
	private LoginorSignUp loginorSignUp;
	private int testid;
	@BeforeClass
	public void beforeclass()
	{
		System.out.println("launch browser");
	}
	@BeforeMethod
	public void beforemethod()
	{
		System.setProperty("webdriver.chrome.driver", "D:\\Neha\\chromedriver_win32\\chromedriver.exe");
		driver= new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
		driver.manage().window().maximize();
	
	}
	@Test
	public void facebook() throws EncryptedDocumentException, IOException
	{
		driver.get("https://www.facebook.com");
		LoginorSignUp loginorSignUp = new LoginorSignUp(driver);
		
		String	data= Utilityclass.fatchexcelsheetdata("velocityclass", 1, 0);
		System.out.println(data);
		loginorSignUp.sendusername(data);
		System.out.println();
		data= Utilityclass.fatchexcelsheetdata("velocityclass", 1, 1);
		System.out.println(data);
		loginorSignUp.sendpassword(data);
	}
	@AfterMethod
	public void aftermethod()
	{
		System.out.println("hello");
	}
	@AfterClass
	public void afterclass()
	{
		System.out.println("close browser");
	}
	

}
