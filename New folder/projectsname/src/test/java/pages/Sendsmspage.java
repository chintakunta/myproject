package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Sendsmspage 
{
	public WebDriver driver;
	@FindBy(xpath="//*[text()='SendSMS']")
	public WebElement sendsms;
	
	@FindBy(xpath="(//*[contains(@class,'menu-bar')])[1]")
	public WebElement menu;
	
	@FindBy(xpath="(//*[contains(text(),'Logout')])[1]")
	public WebElement logout;
	public Sendsmspage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	public void clickmenu()
	{
		menu.click();
	}
	public void logoutclick()
	{
		logout.click();
	}
	
}
