package all;

import java.util.Scanner;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Testclasspom {
	public static void main(String[] args) 
	{
		try
		{
			Scanner sc = new Scanner(System.in);
			System.out.println(" Enter browser name ");
			String x = sc.nextLine();
			WebDriver driver = null;
			if(x.equals("chrome"))
			{
				System.setProperty("webdriver.chrome.driver","E:\\testingtools\\mindq\\chromedriver.exe");
				driver = new ChromeDriver();
			}
			else if(x.equals("Firefox"))
			{
				System.setProperty("webdriver.gecko.driver","E:\\testingtools\\mindq\\geckodriver.exe");
				driver = new FirefoxDriver();
			}
			else
			{
				System.out.println("wrong browser name");
				//stop execution forcibilty
				System.exit(0);
			}
			//create objects to page classes
			Pageclass1pomuid p1uid=new Pageclass1pomuid(driver);
			Pageclass2pompwd p2pwd=new Pageclass2pompwd(driver);
			Pageclass3pomcompose p3comp=new Pageclass3pomcompose(driver);
			//Launch site
			driver.get("http://www.gmail.com");
			WebDriverWait w=new WebDriverWait(driver,20);
			w.until(ExpectedConditions.visibilityOf(p1uid.uid));
			driver.manage().window().maximize();
			//Do login
			p1uid.filluid("reddy.kumar22");
			p1uid.clickuidnext();
			w.until(ExpectedConditions.visibilityOf(p2pwd.pwd));
			//Enter password
			p2pwd.fillpwd("Sivareddy");
			p2pwd.clickpwdnext();
			w.until(ExpectedConditions.visibilityOf(p3comp.comp));
			//Do logout
			p3comp.clickprofile();
			w.until(ExpectedConditions.visibilityOf(p3comp.signout));
			p3comp.clicksignout();
			w.until(ExpectedConditions.visibilityOf(p2pwd.pwd));
			//close site 
			driver.close();
			}
		catch(Exception ex)
		{
			System.out.println(ex.getMessage());
		}
	}

}
