package Facebookpompackage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginorSignUp 
{
	//private variable declaration
	
	@FindBy(xpath="//input[@id='email']")
	private WebElement username;
	
	@FindBy(xpath="//input[@name='pass']")
	private WebElement password;
	
	@FindBy(xpath="//button[@name='login']")
	private WebElement loginbutton;
	
	@FindBy(xpath="//a[text()='Messenger']")
	private WebElement messenger;
	
	
	//variable initilization
	public LoginorSignUp(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
		
	}
	public void sendusername(String user)
	{
		username.sendKeys(user);
	}
	public void sendpassword(String pass)
	{
		password.sendKeys(pass);
	}
	/*public void sendusername()
	{
		username.sendKeys("abc@gmail.com");
	}*/
	
	/*public void sendpassword()
	{
		password.sendKeys("7894561230");
	}*/
	
	public void clickonloginbutton()
	{
		loginbutton.click();
	}
	public void openmessengerlink()
	{
		messenger.click();
	}
}
