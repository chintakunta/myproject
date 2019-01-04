package project;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Test13screenshot 
{
	public static void main(String[] args) throws IOException 
	{
		//launch site
		System.setProperty("webdriver.gecko.driver","E:\\testing tools\\mindq\\geckodriver.exe");
		FirefoxDriver driver = new FirefoxDriver();
		driver.get("http://www.gmail.com");
		driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
		//get screen shot
		File src = driver.getScreenshotAs(OutputType.FILE);
		File dest = new File("E:\\testing tools\\mindq\\screenshot.png");
		FileUtils.copyFile(src, dest);
		//close site
		driver.close();
	}

}
