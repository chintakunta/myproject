package project;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Test28
{
	public static void main(String[] args) throws InterruptedException 
	{
		//get details
		Scanner sc = new Scanner(System.in);
		System.out.println("No: items to select");
		int n = Integer.parseInt(sc.nextLine());
		ArrayList<String> al=new ArrayList<String>();
		System.out.println("Enter items to be selected");
		for(int i=0;i<n;i++)
		{
			al.add(sc.nextLine());
			Collections.sort(al);
		}
		//launch site
		System.setProperty("webdriver.chrome.driver","E:\\testing tools\\mindq\\chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://semantic-ui.com/modules/dropdown.html");
		Thread.sleep(5000);
		//open multi-select drop downs
		driver.findElement(By.xpath("//*[@class='ui fluid dropdown selection multiple']")).click();
		Thread.sleep(5000);
		Actions a =new Actions(driver);
		//select items
		for(int i=0;i<n;i++)
		{
			while(2>1)
			{
				String x=driver.findElement(By.xpath("(//*[@class='item selected'])[1]")).getAttribute("data-value");
				if(x.equalsIgnoreCase(al.get(i)))
				{
					a.sendKeys(Keys.ENTER).build().perform();
					break;//terminate from whileloop
				}
				else 
				{
					a.sendKeys(Keys.DOWN).build().perform();
					Thread.sleep(5000);
				}
			}
		}
	
		Thread.sleep(5000);
		//de-select items in selected item
		driver.findElement(By.xpath("(//*[@class='delete icon'])[2]")).click();
		sc.close();
		//close site
		driver.close();
		
		
	}

}
