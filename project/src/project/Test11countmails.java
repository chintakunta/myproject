package project;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Test11countmails {

	public static void main(String[] args) throws InterruptedException {
		//launch site
		System.setProperty("webdriver.gecko.driver","E:\\testing tools\\mindq\\geckodriver.exe");
		FirefoxDriver driver = new FirefoxDriver();
		driver.get("http://www.gmail.com");
		driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
		//do login
		driver.findElement(By.name("identifier")).sendKeys("reddy.kumar22");
		driver.findElement(By.xpath("//*[text()='Next']")).click();
		Thread.sleep(5000);
		driver.findElement(By.name("password")).sendKeys("Sivareddy");
		driver.findElement(By.xpath("//*[text()='Next']")).click();
		Thread.sleep(5000);
		//Get count of mails in a mailbox table
		int c = driver.findElements(By.xpath("(//*[@role='tabpanel'])[1]/descendant::table/tbody/tr")).size();
		System.out.println(c);
		//select 12th mail in mailbox
		driver.findElement(By.xpath("(//*[@role='tabpanel'])[1]/descendant::table/tbody/tr[1]/td[2]/div")).click();
		Thread.sleep(5000);
		//delete mail
		driver.findElement(By.xpath("//*[contains(@style,'margin-right')]/descendant::div[11]/div[3]")).click();
		Thread.sleep(5000);
		//do logout
		driver.findElement(By.xpath("//*[@aria-label='Account Information']/preceding::span[1]")).click();
		Thread.sleep(5000);
		driver.findElement(By.linkText("Sign out")).click();
		Thread.sleep(5000);
		//close site
		driver.close();

	}

}
