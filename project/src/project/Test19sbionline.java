package project;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Test19sbionline 
{

	public static void main(String[] args) throws InterruptedException 
	{
		System.setProperty("webdriver.gecko.driver","E:\\testing tools\\mindq\\geckodriver.exe");
		FirefoxDriver driver = new FirefoxDriver();
		//open website
		driver.get("https://retail.onlinesbi.com/retail/login.htm");
		driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//*[starts-with(text(),'CONTINUE')]")).click();
		driver.findElement(By.name("userName")).sendKeys("kiranreddy9912");
		driver.findElement(By.name("password")).sendKeys("kiran@99126");
		driver.findElement(By.id("Button2")).click();
		Thread.sleep(5000);
		driver.close();
		
		

	}

}
