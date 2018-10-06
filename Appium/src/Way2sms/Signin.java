package Way2sms;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Signin 
{
	public WebDriver driver;
	@FindBy(name="mobileNo")
	public WebElement mobno;
	@FindBy(name="password")
	public WebElement pwd;
	@FindBy(xpath="(//button[contains(text(),'Login')])[1]")
	public WebElement login;
	public Signin(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	public void fillmobno(String x)
	{
		mobno.sendKeys(x);
	}
	public void fillpwd(String y)
	{
		pwd.sendKeys(y);
	}
	public void clicklogin()
	{
		login.click();
	}

}
