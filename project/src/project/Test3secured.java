package project;

import org.openqa.selenium.chrome.ChromeDriver;

public class Test3secured 
{
	public static void main(String[] args) 
	{
		System.setProperty("webdriver.chrome.driver","E:\\testing tools\\mindq\\chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://www.porsche.com/usa/");
		String x = driver.getCurrentUrl();
		if(x.contains("https"))
		{
			System.out.println("secured site");
		}
		else 
		{
		System.out.println("not secured");
	}
        driver.close();
 }
}
