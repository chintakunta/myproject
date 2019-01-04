package project;

import java.util.Scanner;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Test39 {

	public static void main(String[] args) throws InterruptedException 
	{
		
		Scanner sc=new Scanner(System.in);
		System.out.println("enter a word");
		String x=sc.nextLine();
		
		System.setProperty("webdriver.chrome.driver","E:\\testing tools\\mindq\\chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://angularjs.org");
		WebDriverWait w=new WebDriverWait(driver,10);
		w.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//*[@href='https://angular.io'])[1]")));
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		driver.findElement(By.xpath("//*[@ng-model='yourName']")).sendKeys(x);
		Thread.sleep(5000);
		String y=driver.findElement(By.xpath("//*[@ng-model='yourName']/following-sibling::*[2]")).getText();
		if(y.contains(x))
		{
			System.out.println("Test passed");
		}
		else
		{
			System.out.println("Test failed");
		}
		sc.close();
		//close site
		driver.close();
		
	}

}
