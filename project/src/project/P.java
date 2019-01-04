package project;

import java.util.Scanner;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class P 
{

	public static void main(String[] args) throws Exception
	{
		//get details
		Scanner sc = new Scanner(System.in);
		String v=sc.nextLine();
		String b=sc.nextLine();
		String c=sc.nextLine();
		//launch site
				System.setProperty("webdriver.chrome.driver","E:\\testing tools\\mindq\\chromedriver.exe");
				ChromeDriver driver = new ChromeDriver();
				driver.get("https://semantic-ui.com/modules/dropdown.html");
				Thread.sleep(5000);
				driver.findElement(By.xpath("//*[@class='ui fluid dropdown selection multiple']")).click();
				Thread.sleep(5000);
				Actions a =new Actions(driver);
				while(2>1)
				{
					String x=driver.findElement(By.xpath("(//*[@class='item selected'])[1]")).getAttribute("data-value");
					if(x.equalsIgnoreCase(v))
					{
						a.sendKeys(Keys.ENTER).build().perform();
						break;//terminate from whileloop
					}
					else 
					{
						a.sendKeys(Keys.DOWN).build().perform();
						Thread.sleep(2000);
					}
				}
				while(2>1)
				{
					String x=driver.findElement(By.xpath("(//*[@class='item selected'])[1]")).getAttribute("data-value");
					if(x.equalsIgnoreCase(b))
					{
						a.sendKeys(Keys.ENTER).build().perform();
						break;//terminate from while loop
					}
					else 
					{
						a.sendKeys(Keys.DOWN).build().perform();
						Thread.sleep(2000);
						
					}
				}
				while(2>1)
				{
					
					driver.findElement(By.xpath("//*[@class='ui fluid dropdown selection multiple']")).click();
					Thread.sleep(2000);
					String x=driver.findElement(By.xpath("(//*[@class='item selected'])[1]")).getAttribute("data-value");
					if(x.equalsIgnoreCase(c))
					{
						a.sendKeys(Keys.ENTER).build().perform();
						break;//terminate from whileloop
					}
					else 
					{
						a.sendKeys(Keys.UP).build().perform();
						Thread.sleep(2000);
					}
				}
				

	}

}
