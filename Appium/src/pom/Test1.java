package pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Test1
{
	public static void main(String[] args) 
	{
		try 
		{
		//open Browser
		System.setProperty("webdriver.chrome.driver", "E:\\testingtools\\mindq\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		//create object to page class
		Userid ui=new Userid(driver);
		Pwdnext pn=new Pwdnext(driver);
		Composepage cp=new Composepage(driver);
		//Launch site 
		driver.get("http://www.gmail.com");
		WebDriverWait w=new WebDriverWait(driver,20);
		w.until(ExpectedConditions.visibilityOf(ui.uid));
		driver.manage().window().maximize();
		//do login 
		ui.filluid("reddy.kumar22");
		ui.clickuidnext();
		w.until(ExpectedConditions.visibilityOf(pn.pwd));
		pn.fillpwd("Sivareddy");
		pn.clickpwdnext();
		w.until(ExpectedConditions.visibilityOf(cp.comp));
		//Do logout
		cp.clickprofile();
		w.until(ExpectedConditions.visibilityOf(cp.signout));
		cp.clicksignout();
		w.until(ExpectedConditions.visibilityOf(pn.pwd));
		//close site
		driver.close();
		}
		catch(Exception ex)
		{
			System.out.println(ex.getMessage());
		}
	}

}
