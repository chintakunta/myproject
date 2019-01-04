package project;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Test21draggableanddroppable 
{
	public static void main(String[] args) throws InterruptedException 
	{
		System.setProperty("webdriver.chrome.driver","E:\\testing tools\\mindq\\chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://jqueryui.com/droppable/");
		Thread.sleep(5000);
		driver.switchTo().frame(0);
		WebElement e1=driver.findElement(By.id("draggable"));
		WebElement e2=driver.findElement(By.id("droppable"));
		Actions a=new Actions(driver);
		a.dragAndDrop(e1, e2).build().perform();
		driver.switchTo().defaultContent();
		Thread.sleep(10000);
		//close site
		driver.close();
 		

	}

}
