package project;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Test8text
{
	public static void main(String[] args)
	{
		//launch website
		System.setProperty("webdriver.chrome.driver","E:\\testing tools\\mindq\\chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();
		driver.get("http://www.way2sms.com/content/index.html");
		//get count of text box in a page
		List <WebElement> k=driver.findElements(By.tagName("input"));
		int b=0;
		for (int i=0;i<k.size();i++)
		{
			String x = k.get(i).getAttribute("type");
			if(x.equals("text"))
			{
				b=b+1;
			}
		}
		System.out.println(b);
		//int c = driver.findElements(By.xpath("//input[@type='text']")).size();
		driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
		//System.out.println(c);
		driver.close();
	}
}