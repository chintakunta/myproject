package project;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Amazon {

	public static void main(String[] args) throws InterruptedException 
	{
		//launch site 
				System.setProperty("webdriver.chrome.driver","E:\\testing tools\\mindq\\chromedriver.exe");
				ChromeDriver driver = new ChromeDriver();
				driver.get("https://www.google.co.in");
				driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
				 driver.findElement(By.name("q")).sendKeys("amazon");
				 Actions a =new Actions(driver);
			     a.sendKeys(Keys.ENTER).build().perform();
			     driver.findElement(By.xpath("//*[text()='Amazon.in']")).click();
			     driver.manage().window().maximize();
			     JavascriptExecutor js=(JavascriptExecutor)driver;
			     /*js.executeScript("window.scrollTo(0,document.body.scrollHeight);");
			     Thread.sleep(2000);*/
			     WebElement e= driver.findElement(By.xpath("//*[text()='Back to top']"));
				 js.executeScript("arguments[0].scrollIntoView();", e);
				 a.click(e);
			     Thread.sleep(5000);
	}

}
