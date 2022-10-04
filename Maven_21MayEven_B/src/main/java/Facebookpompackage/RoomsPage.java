package Facebookpompackage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RoomsPage 
{
	@FindBy(xpath="//a[text()=' Return to messenger.com ']")
	private WebElement returntomessnger;

	@FindBy(xpath="//a[text()=' Visit our help center ']")
	private WebElement helpcenter;
	
	public RoomsPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	public void goBackToMessenger()
	{
		returntomessnger.click();
	}
	public void contactToHelpCenter()
	{
		 helpcenter.click();
	}
}
