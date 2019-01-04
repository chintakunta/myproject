package project;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.chrome.ChromeDriver;

public class Test6parentframe {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver","E:\\testing tools\\mindq\\chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();
		driver.get("http://the-internet.herokuapp.com/iframe");
		//WebElement e = driver.findElement(By.xpath("//*[text()='Your content goes here.']"));
		Thread.sleep(5000);
		driver.switchTo().parentFrame();
		Thread.sleep(5000);
		driver.findElement(By.xpath("//*[@id='mce_0_ifr']")).sendKeys(Keys.ENTER,"hello i am rajini kanth");
		//driver.findElement(By.xpath("//*[text()='Your content goes here.']")).sendKeys("hello");
		//driver.findElement(by)
		//driver.findElement(By.xpath("//*[@id='tinymce']")).sendKeys("hello");
		Thread.sleep(5000);
		//driver.close();
	}

}
