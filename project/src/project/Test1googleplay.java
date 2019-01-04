package project;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

public class Test1googleplay {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver","E:\\testing tools\\mindq\\chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();
		driver.get("http://www.way2sms.com/content/index.html?");
		Thread.sleep(5000);
		//click on google play
		driver.findElement(By.xpath("//*[contains(@src,'../images/android-button.png')]")).click();
		Thread.sleep(5000);
		driver.close();
		

	}

}
