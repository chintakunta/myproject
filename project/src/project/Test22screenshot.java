package project;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.chrome.ChromeDriver;

public class Test22screenshot
{

	public static void main(String[] args) throws IOException 
	{
		System.setProperty("webdriver.chrome.driver","E:\\testing tools\\mindq\\chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://www.gmail.com/");
		driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
		File scr=driver.getScreenshotAs(OutputType.FILE);
		File dest = new File("E:\\testing tools\\mindq\\sec.png");
		FileUtils.copyFile(scr, dest);
		driver.close();

	}

}
