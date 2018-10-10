package Javabasic;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Counttextbox 
{
	public static void main(String[] args) throws Exception 
	{
		//Launch site 
		System.setProperty("webdriver.chrome.driver","E:\\testingtools\\mindq\\chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://jqueryui.com/button");
		Thread.sleep(5000);
		//Get count of text boxs and buttons in page except frames
		List<WebElement> t1=driver.findElements(By.xpath("//input[@type='text']"));
		System.out.println("No:of text boxes in page are "+ t1.size());
		List<WebElement> b1=driver.findElements(By.xpath("(//button)|(//input[@type='button'or@type='submit'])|(//a[@role='button'])"));
		System.out.println("No of buttons in page are "+ b1.size());
		//Get all frames in pages
		List<WebElement> f1=driver.findElements(By.tagName("iframe"));
		for(int i=0;i<f1.size();i++)
		{
			//change driver focus from page to frame
			driver .switchTo().frame(f1.get(i));
			List<WebElement>t1f=driver.findElements(By.xpath("//input[@type='text']"));
			System.out.println("No of text box in frame "+(i+1)+" are " + t1f.size());
			List<WebElement>b1f=driver.findElements(By.xpath("(//button)|(//input[@type='button'or@type='submit'])|(//a[@role='button'])"));
			System.out.println("No of button in frame "+(i+1)+ "  are  " + b1f.size());
			driver.switchTo().parentFrame();
		}
		driver.switchTo().defaultContent();
		//close site
		driver.close();
		
		}

}
