package project;

import org.openqa.selenium.chrome.ChromeDriver;

public class Test12cookies 
{
	public static void main(String[] args) throws Exception
	{
		//open  browser window
		System.setProperty("webdriver.chrome.driver","E:\\testing tools\\mindq\\chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();
		//delete all existing cookies
		driver.manage().deleteAllCookies();
		//launch site
		driver.get("https://www.google.co.in");
		Thread.sleep(5000);
		//check cookies where loaded for site
		if(driver.manage().getCookies().size()!=0)
		{
			System.out.println("cookies were loaded");
		}
		else
		{
			System.out.println("cookies were not loaded");
		}
		//close site
		driver.close();

		
	}

}
