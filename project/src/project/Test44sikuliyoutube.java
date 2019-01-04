package project;

import java.util.Scanner;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.sikuli.script.Button;
import org.sikuli.script.Location;
import org.sikuli.script.Screen;

public class Test44sikuliyoutube 
{
	public static void main(String[] args) throws Exception 
	{
		//give input from keyboard
		Scanner sc=new Scanner(System.in);
		System.out.println("search in youtube");
		String x=sc.nextLine();
		//launch site
		System.setProperty("webdriver.chrome.driver", "E:\\testingtools\\mindq\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		//search for video in youtube
		driver.get("https://www.youtube.com/");
		driver.findElement(By.id("search")).sendKeys(x,Keys.ENTER);
		WebDriverWait wait=new WebDriverWait(driver,20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//*[@class='style-scope ytd-item-section-renderer'])[5]")));
		driver.findElement(By.xpath("(//*[@class='style-scope ytd-item-section-renderer'])[5]")).click();
		Thread.sleep(2000);
		Screen s=new Screen();
		//move mouse pointer to video body
		Location l=new Location(300,300);
		s.wheel(l, Button.LEFT,0);
		s.click("E:\\testingtools\\mindq\\pause.PNG");
		Thread.sleep(5000);
		s.wheel(l, Button.LEFT,0);
		s.click("E:\\testingtools\\mindq\\play.PNG");
		s.wheel(l, Button.LEFT,0);
		s.click(" E:\\testingtools\\mindq\\Volume.PNG");
		
		//close site 
		driver.close();
	
	
	
	}

}
