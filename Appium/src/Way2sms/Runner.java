package Way2sms;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Runner {

	public static void main(String[] args) 
	{
		try
		{
		//open browser
		System.setProperty("webdriver.chrome.driver", "E:\\testingtools\\mindq\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		//create object to page classes
		Signin s=new Signin(driver);
		Profile p=new Profile(driver);
		//launch site 
		driver.get("http://www.way2sms.com/");
		WebDriverWait w=new WebDriverWait(driver,20);
		w.until(ExpectedConditions.visibilityOf(s.mobno));
		driver.manage().window().maximize();
		//do login
		s.fillmobno("7207519505");
		s.fillpwd("kiran");
		s.clicklogin();
		w.until(ExpectedConditions.visibilityOf(p.send));
		//logout
		p.clicklogout();
		w.until(ExpectedConditions.visibilityOf(s.mobno));
		//close site 
		driver.close();
		}
		catch(Exception ex)
		{
			System.out.println(ex.getMessage());
		}
	}

}
