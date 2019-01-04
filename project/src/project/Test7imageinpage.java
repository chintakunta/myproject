package project;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.chrome.ChromeDriver;

public class Test7imageinpage 
{
	public static void main(String[] args) 
	{
			System.setProperty("webdriver.chrome.driver","E:\\testing tools\\mindq\\chromedriver.exe");
			ChromeDriver driver = new ChromeDriver();
			driver.get("http://newtours.demoaut.com/");
			//find tagname
			//way-1(by using findelements in tagname)
			//List <WebElement> k = driver.findElements(By.tagName("a"));
			//k.get(3).click();
			//find tagname
			//way-2 (by using x-path)
			//driver.findElement(By.xpath("(//a)[3]"));
			//System.out.println(k.get(3));
			//get and display "src" value of 8th image in page
			//way-1(finding elements by using list)
			//List <WebElement> l= driver.findElements(By.tagName("img"));
			//String x=l.get(7).getAttribute("src");
			//System.out.println(x);
			//get and display "src" value of 8th image in page
			//way-2(by using x-path)
			//String x= driver.findElement(By.xpath("(//img)[8]")).getAttribute("src");
			//System.out.println(x);
			driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
			driver.close();
	}

}
