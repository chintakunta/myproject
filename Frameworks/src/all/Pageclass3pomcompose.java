package all;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Pageclass3pomcompose 
{
	public WebDriver driver;
	@FindBy(xpath="//*[@role='button']")
	public WebElement comp;
	@FindBy(xpath="//*[contains(@aria-label,'Google Account')]/span")
	public WebElement profile;
	@FindBy(linkText="Sign out")
	public WebElement signout;
	public Pageclass3pomcompose(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	public void clickprofile()
	{
		profile.click();
	}
	public void clicksignout()
	{
		signout.click();
	}

}
