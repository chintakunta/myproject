package project;

import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

public class Gmailcreate 
{

	public static void main(String[] args) 
	{
		System.setProperty("webdriver.chrome.driver","E:\\testing tools\\mindq\\chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();
		driver.get("http://www.gmail.com");
		driver.findElement(By.xpath("//*[text() ='Create an account']")).click();
		ArrayList<String> c=new ArrayList<String>(driver.getWindowHandles());
		driver.switchTo().window(c.get(1));
		driver.findElement(By.id("firstName")).sendKeys("kirankumar");
		driver.findElement(By.id("lastName")).sendKeys("reddy");
		driver.findElement(By.id("username")).sendKeys("ckkr931");
		driver.findElement(By.name("Passwd")).sendKeys("Sivareddy9912");
		driver.findElement(By.name("ConfirmPasswd")).sendKeys("Sivareddy9912");
		driver.findElement(By.xpath("(//*[@role='button'])[2]")).click();
		
		
	}

}
