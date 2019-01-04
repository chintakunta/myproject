package project;

import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Test31 
{
	public static void main(String[] args) throws InterruptedException 
	{
		System.setProperty("webdriver.chrome.driver","E:\\testing tools\\mindq\\chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://www.flipkart.com/");
		driver.findElement(By.xpath("//*[@class='_2zrpKA']")).sendKeys("dinesh.rajan47@gmail.com");
		 Thread.sleep(3000);
		         driver.findElement(By.xpath("//*[@type='password']")).sendKeys("9703097999");
		         Thread.sleep(3000);
		 driver.findElement(By.xpath("(//*[contains(text(),'Login')])[3]")).click();
		 Thread.sleep(3000);
		 driver.manage().window().maximize();
		 WebElement e=driver.findElement(By.xpath("//*[text()='TVs & Appliances']"));
		 Thread.sleep(3000);
		 Actions a=new Actions(driver);
		 Thread.sleep(3000);
		 a.moveToElement(e).build().perform();
		 Thread.sleep(3000);
		 driver.findElement(By.xpath("//*[text()='Split ACs']")).click();
		 Thread.sleep(2000);
		 driver.manage().window().maximize();
		 driver.findElement(By.partialLinkText(" BEE Rating 2018 Split")).click();
		 Thread.sleep(2000);
		 ArrayList<String> b=new ArrayList<String>(driver.getWindowHandles());
		 Thread.sleep(2000);
		 driver.switchTo().window(b.get(1));
		 Thread.sleep(2000);
		 driver.findElement(By.xpath(("//*[@class='_2AkmmA _2Npkh4 _2MWPVK']"))).click();
		 Thread.sleep(2000);

	}

}
