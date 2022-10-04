package TestPackge;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import Facebookpompackage.LoginorSignUp;
import Facebookpompackage.MessengerPage;
import Facebookpompackage.RoomsPage;

public class VisitToHelpCenter 
{
	public static void main(String[] args) throws InterruptedException 
	{
		
		System.setProperty("webdriver.chrome.driver", "D:\\Neha\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver= new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.get("https://www.facebook.com");
	
		LoginorSignUp loginorSignUp =new LoginorSignUp (driver);
		loginorSignUp.openmessengerlink();
		
		MessengerPage messengerPage =new MessengerPage (driver);
		messengerPage.openRooms();
		
		RoomsPage roomsPage= new RoomsPage(driver);
		roomsPage.contactToHelpCenter();
		
		
	}

}
