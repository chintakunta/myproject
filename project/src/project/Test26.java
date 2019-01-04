package project;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Test26 
{
	public static void main(String[] args) throws InterruptedException
	{
		//Launch site 
		System.setProperty("webdriver.chrome.driver","E:\\testing tools\\mindq\\chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://semantic-ui.com/modules/dropdown.html");
		Thread.sleep(5000);
		Actions a=new Actions(driver);

		//open drop-down by clicking
		driver.findElement(By.xpath("//*[@class='ui fluid dropdown selection multiple']")).click();
		while(2>1)
			
		{
			String x=driver.findElement(By.xpath("(//*[@class='item selected'])[1]")).getAttribute("data-value");
			if(x.equalsIgnoreCase("Meteor"))
			{
				 
				a.sendKeys(Keys.ENTER).build().perform();
				break;
			}
			else
			{
				//a.sendKeys("m").build().perform();
				a.sendKeys(Keys.DOWN).build().perform();
				Thread.sleep(2000);
				//a.sendKeys(Keys.ENTER).build().perform();
			}
			
		}
		
		Thread.sleep(5000);
		//close driver
		driver.close();
		
			}

}
