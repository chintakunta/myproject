package project;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.chrome.ChromeDriver;

public class Test30fillelementtext 
{
	public static void main(String[] args) throws InterruptedException 
	{
		System.setProperty("webdriver.chrome.driver","E:\\testing tools\\mindq\\chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://www.facebook.com");
		Thread.sleep(5000);
		JavascriptExecutor ki=(JavascriptExecutor)driver;
		ki.executeScript("document.getElementById('email').value='reddy.kumar22';");
		Thread.sleep(5000);
		driver.close();

	}

}
