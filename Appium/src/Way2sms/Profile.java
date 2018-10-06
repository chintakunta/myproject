package Way2sms;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Profile 
{
	public WebDriver driver;
	@FindBy(xpath="//*[text()='SendSMS']")
	public WebElement send;
	@FindBy(xpath="(//*[contains(@class,'logout hidden')])[2]")
	public WebElement logout;
	public Profile(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	public void clicklogout()
	{
		logout.click();
	}

}
