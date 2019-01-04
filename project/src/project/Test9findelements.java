package project;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Test9findelements 
{
	public static void main(String[] args) 
	{
		//launch website
				System.setProperty("webdriver.chrome.driver","E:\\testing tools\\mindq\\chromedriver.exe");
				ChromeDriver driver = new ChromeDriver();
				driver.get("http://www.way2sms.com/content/index.html");
				//get count of image
				List<WebElement> l1=driver.findElements(By.tagName("img"));
				List<WebElement> l2=driver.findElements(By.xpath("//input[@type='image']"));
				int c =l1.size()+l2.size();
				System.out.println(c);
				//int c = driver.findElements(By.xpath("(//img)|(//input[@type='image'])")).size();
				//System.out.println(c);
				driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
				driver.close();
		
	}

}
