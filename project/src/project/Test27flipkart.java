package project;

import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Test27flipkart 
{
	public static void main(String[] args) throws InterruptedException 
	{
		//Launch site 
		System.setProperty("webdriver.chrome.driver","E:\\testing tools\\mindq\\chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://www.flipkart.com/");
		Thread.sleep(5000);
		driver.manage().window().maximize();
		driver.manage().window().maximize();
		//close banner if exist
		if(driver.findElement(By.xpath("//*[@id='container']/following::*[9]")).isDisplayed());
		
		{
			
			driver.findElement(By.xpath("(//*[@type='text'])[2]")).sendKeys("8652644687");
			driver.findElement(By.xpath("//*[@type='password']")).sendKeys("kiran@9912");
			driver.findElement(By.xpath("(//*[text()='Login'])[2]")).click();
		}
		//open drop-down by clicking
		Thread.sleep(4000);
		WebElement e=driver.findElement(By.xpath("//*[text()='TVs & Appliances']"));
		Actions a=new Actions(driver);
		Thread.sleep(4000);
		a.moveToElement(e).build().perform();
		Thread.sleep(5000);
		WebElement d=driver.findElement(By.xpath("//*[text()='Split ACs']"));
		Thread.sleep(5000);
		a.click(d).build().perform();
		Thread.sleep(5000);
		/*WebElement ac=driver.findElement(By.xpath("(//*[text()='Midea 1 Ton 3 Star BEE Rating 2018 Split AC  - White'])[1]"));
		Thread.sleep(5000);
		a.click(ac).build().perform();*/
		driver.findElement(By.partialLinkText(" BEE Rating 2018 Split")).click();
		 Thread.sleep(2000);
		ArrayList<String> c=new ArrayList<String>(driver.getWindowHandles());
		driver.switchTo().window(c.get(1));
		Thread.sleep(5000);
		driver.findElement(By.xpath(("//*[@class='_2AkmmA _2Npkh4 _2MWPVK']"))).click();
		Thread.sleep(10000);
		driver.findElement(By.xpath("//*[text()='Continue shopping']")).click();
		//a.click(ac1).build().perform();
		
		
		//close site
		driver.close();
	}

}
