package Facebookpompackage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class CreateNewAccount 
{
	@FindBy(xpath="(//a[@role='button'])[2]")
	private WebElement Createaccountbutton;
	
	@FindBy(xpath="//input[@name='firstname']")
	private WebElement Firstname;
	
	@FindBy(xpath="//input[@name='lastname']")
	private WebElement surname;
	
	@FindBy(xpath="//input[@name='reg_email__']")
	private WebElement mobno;
	
	@FindBy(xpath="//input[@id='password_step_input']")
	private WebElement newpassword;
	
	@FindBy(xpath="//select[@id='day']")
	private WebElement day;
	
	@FindBy(xpath="//select[@id='month']")
	private WebElement month;
	
	@FindBy(xpath="//select[@id='year']")
	private WebElement year;
	
	@FindBy(xpath="(//input[@type='radio'])[1]")
	private WebElement female;
	
	
	@FindBy(xpath="(//input[@type='radio'])[2]")
	private WebElement male;
	
	@FindBy(xpath="(//input[@name='sex'])[3]")
	private WebElement custom;
	
	@FindBy(xpath="//button[@name='websubmit']")
	private WebElement Signupbutton;
	
	public  CreateNewAccount(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
		
	}
	public void clickoncreateaccountbutton()
	{
		Createaccountbutton.click();
	}
	
	public void sendfirstname()
	{
		Firstname.sendKeys("Devansh");
	}
	
	public void sendsurname()
	{
		surname.sendKeys("ranaware");
	}
	public void sendmobileno()
	{
		mobno.sendKeys("9874563210");
	}
	public void sendnewpassword()
	{
		newpassword.sendKeys("devansh@123");
	}
	public void clickonday()
	{
		Select s= new Select(day);
		s.selectByIndex(22);
		
	}
	public void clickonmonth()
	{
		Select s= new Select(month);
		s.selectByValue("10");
		
	}
	public void clickonyear()
	{
		Select s= new Select(year);
		s.selectByValue("2014");	
	}
	public void selectfemalebutton()
	{
		boolean result=female.isSelected();
		System.out.println(result);
	}
	public void selectmalebutton()
	{
		boolean result=male.isSelected();
		System.out.println(result);
	}
	public void selectcustombutton()
	{
		boolean result=custom.isSelected();
		System.out.println(result);
	}
	public void clickonsignupbutton()
	{
		Signupbutton.click();
	}
}
