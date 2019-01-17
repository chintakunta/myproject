package Way2sms;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Vinod {

	public static void main(String[] args) throws Exception {
		System.setProperty("webdriver.chrome.driver", "E:\\testingtools\\mindq\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.get("https://ap4.salesforce.com/setup/forcecomHomepage.apexp?setupid=ForceCom");
		driver.findElement(By.id("username")).sendKeys("vinodp@gmail.com");
		driver.findElement(By.id("password")).sendKeys("Anitha123");
		driver.findElement(By.name("Login")).click();
		Thread.sleep(30000);
		driver.findElement(By.id("EmailAdmin")).click();
		
		
	}

}
