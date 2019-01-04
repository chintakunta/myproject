package project;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Test23divdraganddrop 
{
	public static void main(String[] args) throws InterruptedException 
	{
		//Launch site 
		System.setProperty("webdriver.chrome.driver","E:\\testing tools\\mindq\\chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://semantic-ui.com/modules/dropdown.html");
		Thread.sleep(5000);
		//Automatic drop-down, which for allow char matching 
		WebElement e1=driver.findElement(By.xpath("(//*[@class='ui dropdown'])[1]"));
		Actions a =new Actions(driver);
		a.click(e1).build().perform();
		Thread.sleep(5000);
		for(int i=1;i<=2;i++)
		{
			a.sendKeys(Keys.DOWN).build().perform();
			Thread.sleep(5000);
		}
			
		a.sendKeys(Keys.ENTER).build().perform();
		Thread.sleep(5000);
		//Automate drop-down, which can allow char matching
		WebElement e2 = driver.findElement(By.xpath("(//*[@class='ui selection dropdown'])[1]"));		
		a.click(e2).build().perform();
		a.sendKeys("f").build().perform();
		Thread.sleep(2000);
		a.sendKeys(Keys.ENTER).build().perform();
		Thread.sleep(2000);
		driver.close();
	}

}
