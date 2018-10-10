package Javabasic;

import java.util.Scanner;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Pagenationwhileloop 
{
	public static void main(String[] args) 
	{
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter a Word");
		String x=sc.nextLine();
		//Launch site 
		System.setProperty("webdriver.chrome.driver","E:\\testingtools\\mindq\\chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://www.google.co.in/");
		WebDriverWait w=new WebDriverWait(driver,20);
		w.until(ExpectedConditions.visibilityOfElementLocated(By.name("q")));
		driver.manage().window().maximize();
		//search word
		driver.findElement(By.name("q")).sendKeys(x,Keys.ENTER);
		//count no of result pages
		int count=1;
		while(2>1)//infinite loop
		{
			try
			{
				if(driver.findElement(By.xpath("//*[text()='Next']")).isDisplayed())
				{
					driver.findElement(By.xpath("//*[text()='Next']")).click();
					count=count+1;
				}
			}
			catch(Exception ex)
			{
				break;//to terminate from loop
			}
		}
		System.out.println(count);
		driver.close();
	}

}
