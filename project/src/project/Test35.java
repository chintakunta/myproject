package project;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Test35 
{
	public static void main(String[] args) throws InterruptedException 
	{
		//launch site
		System.setProperty("webdriver.chrome.driver","E:\\testing tools\\mindq\\chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://www.google.co.in");
		driver.manage().window().maximize();
		Thread.sleep(5000);
		WebElement e = driver.findElement(By.name("q"));
		//call for java script
		JavascriptExecutor ji=(JavascriptExecutor)driver;
		//call for disable
		ji.executeScript("arguments[0].setAttribute('disable',true);", e);
		Thread.sleep(10000);
		//call for enable
		ji.executeScript("arguments[0].removeAttribute('disable');", e);
		Thread.sleep(5000);
		//close site
		driver.close();
		}

}
