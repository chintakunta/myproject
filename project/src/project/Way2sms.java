package project;

import org.openqa.selenium.By;
//import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Way2sms {

	public static void main(String[] args) throws InterruptedException {
			System.setProperty("webdriver.chrome.driver","E:\\testing tools\\mindq\\chromedriver.exe");
			ChromeDriver driver = new ChromeDriver();
			driver.get("http://www.way2sms.com/content/index.html?");
			String x = driver.findElement(By.xpath("//*[@class='wrap menu']/child::p")).getText();
			System.out.println(x);
			driver.findElement(By.name("username")).sendKeys("72075195050");
			driver.findElement(By.name("password")).sendKeys("kiran");
			driver.findElement(By.id("loginBTN")).click();
			driver.findElement(By.xpath("//*[text()='Send SMS']")).click();
			driver.switchTo().frame("frame");
			Thread.sleep(5000);
			driver.findElement(By.name("mobile")).sendKeys("9703097999");
            driver.findElement(By.name("message")).sendKeys("hi");
            driver.findElement(By.id("Send")).click();
            driver.switchTo().defaultContent();
			driver.close();
            
	}

}
