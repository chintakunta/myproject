package project;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Test14screenshot
{
	public static void main(String[] args) throws IOException 
	{
		//get browser name from keyboard
		Scanner sc = new Scanner(System.in);
		System.out.println(" Enter browser name ");
		String x = sc.nextLine();
		WebDriver driver = null;
		if(x.equals("chrome"))
		{
			System.setProperty("webdriver.chrome.driver","E:\\testing tools\\mindq\\chromedriver.exe");
			driver = new ChromeDriver();
		}
		else if(x.equals("Firefox"))
		{
			System.setProperty("webdriver.gecko.driver","E:\\testing tools\\mindq\\geckodriver.exe");
			driver = new FirefoxDriver();
		}
		else
		{
			System.out.println("wrong browser name");
			//stop execution forcibilty
			System.exit(0);
		}
		driver.get("http://www.gmail.com");
		driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
		//get screen shot
		File src =  ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		File dest = new File("E:\\testing tools\\mindq\\screenshot.png");
		FileUtils.copyFile(src, dest);
		//close site
		driver.close();
		

	}

}
