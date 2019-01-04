package project;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

public class Test20draganddrop
{
	public static void main(String[] args) throws InterruptedException 
	{ 
		System.setProperty("webdriver.gecko.driver","E:\\testingtools\\mindq\\geckodriver.exe");
		FirefoxDriver driver = new FirefoxDriver(); 
		driver.get("https://jqueryui.com/slider/");
		Thread.sleep(10000);
		driver.switchTo().frame(0);
		
		//identifies bubble 
		WebElement e1=driver.findElement(By.xpath("//*[contains(@class,'ui-slider-handle')]"));
		Actions a=new Actions(driver);
		int x=e1.getLocation().getX();
		int y=e1.getLocation().getY();
		
		//slide from left to right
		a.dragAndDropBy(e1, x+200, y).build().perform();
		Thread.sleep(10000);
		
		//slider from right to left
		a.dragAndDropBy(e1, x-200, y).build().perform();
		driver.switchTo().defaultContent();
		Thread.sleep(10000);
		
		//go to vertical slider
		driver.findElement(By.linkText("Vertical slider")).click();
		Thread.sleep(10000);
		driver.switchTo().frame(0);
		WebElement e2=driver.findElement(By.xpath("//*[contains(@class,'ui-slider-handle')]"));
		int p=e2.getLocation().getX();
		int q=e2.getLocation().getY();
		
		//move top to bottom
		a.dragAndDropBy(e2, p, q+100).build().perform();
		Thread.sleep(10000);
		
		//slide from bottom to top
		a.dragAndDropBy(e2, p, q-200).build().perform();
		Thread.sleep(10000);
		driver.switchTo().defaultContent();
		
		//close site
		driver.close();
			}

}
