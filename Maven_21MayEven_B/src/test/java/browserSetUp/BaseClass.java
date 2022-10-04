package browserSetUp;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BaseClass 
{
	public static WebDriver openChromeBrowser()
	{
		System.setProperty("webdriver.chrome.driver", "D:\\Neha\\chromedriver_win32\\chromedriver.exe");
		WebDriver  driver= new ChromeDriver();
		return driver;
	}

	public static WebDriver openEdgeBrowser()
	{
		System.setProperty("webdriver.edge.driver", "D:\\Neha\\edgedriver_win64\\msedgedriver.exe");
		WebDriver  driver= new EdgeDriver();
		return driver;
	}
	public static WebDriver openFirefoxBrowser()
	{
		System.setProperty("webdriver.gecko.driver", "D:\\Neha\\geckodriver-v0.31.0-win64\\geckodriver.exe");
		WebDriver  driver= new FirefoxDriver();
		return driver;
	}
}
