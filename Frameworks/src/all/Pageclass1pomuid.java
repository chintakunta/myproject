package all;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Pageclass1pomuid 
{
	public WebDriver driver;
	@FindBy(name="identifier")
	public WebElement uid;
	@FindBy(xpath="//*[text()='Next']")
	public WebElement uidnext;
	public Pageclass1pomuid(WebDriver driver)
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
 