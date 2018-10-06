package pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Userid 
{
	public WebDriver driver;
	@FindBy(name="identifier")
	public WebElement uid;
	
	@FindBy(xpath="//*[text()='Next']")
	public WebElement uidnext;
	public Userid(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	public void filluid(String x)
	{
		uid.sendKeys(x);
	}
	public void clickuidnext()
	{
		uidnext.click();
	}

}
