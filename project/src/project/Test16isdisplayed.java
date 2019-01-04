package project;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Test16isdisplayed 
{
	public static void main(String[] args) throws Exception 
	{
		System.setProperty("webdriver.chrome.driver","E:\\testing tools\\mindq\\chromedriver.exe");
		ChromeDriver x = new ChromeDriver();
	
		x.get("https://www.amazon.in/");

		x.findElement(By.xpath("//*[@id='nav-link-shopall']")).click();

		Thread.sleep(5000);

		WebElement e=x.findElement(By.linkText("Headphones"));
		try
		{
		if(e.isDisplayed())

		{
		  if(e.isEnabled())

		  {
		  e.click();

		
		  System.out.println("enabled");


		  }

		  else
		  {
		  System.out.println("disabled");
		   }
		}
		
		else
		{
			System.out.println("not displayed");
		}


		

		

	}
		catch(Exception ex)
		{
			System.out.println(ex.getMessage());
		}
		x.close();
}
}
