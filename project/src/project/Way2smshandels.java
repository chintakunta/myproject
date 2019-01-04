package project;

import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Way2smshandels {
	public static void main(String[] args) throws Exception 
	{
		System.setProperty("webdriver.chrome.driver","E:\\testingtools\\mindq\\chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();
		driver.get("http://www.way2sms.com/");
		Thread.sleep(5000);
		driver.findElement(By.xpath("//*[text()='Facebook']")).click();
		Thread.sleep(5000);
		//driver.findElement(By.xpath("//*[text()='Twitter']")).click();
		WebDriverWait w=new WebDriverWait(driver,20);
		Thread.sleep(20000);
		ArrayList<String> a=new ArrayList<String>(driver.getWindowHandles());
		driver.manage().window().maximize();
		Thread.sleep(5000);
		driver.switchTo().window(a.get(0));
		Thread.sleep(5000);	
		driver.switchTo().window(a.get(1));
		Thread.sleep(5000);
		driver.findElement(By.xpath("//*[text()='Create New Account']")).click();
		/*Thread.sleep(10000);
		driver.switchTo().window(a.get(0));
		driver.switchTo().window(a.get(2));
		driver.findElement(By.xpath("(//a[text()='Sign up'])[1]")).click();*/
		driver.close();
		}

}
