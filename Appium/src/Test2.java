import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.android.AndroidDriver;

public class Test2 
{
	public static void main(String[] args) throws Exception 
	{
	Scanner sc = new Scanner(System.in);
	System.out.println("Enter first no");
	String x=sc.nextLine();
	System.out.println("Enter second no");
	String y=sc.nextLine();
	//Details of avd and app
	DesiredCapabilities dc= new DesiredCapabilities();
	dc.setCapability(CapabilityType.BROWSER_NAME,""); 
	dc.setCapability("deviceName", "emulator-5554");
	dc.setCapability("platformName", "android");
	dc.setCapability("platformVersion", "4.2.2");
	dc.setCapability("appPackage", "com.android.calculator2");
	dc.setCapability("appActivity", "com.android.calculator2.Calculator");
	//start appium server
	Runtime.getRuntime().exec("cmd.exe /c start cmd.exe /k \"appium -a 0.0.0.0 -p 4723\"");
	URL u=new URL("http://0.0.0.0:4723/wd/hub");
	Thread.sleep(20000);
	AndroidDriver driver;
	while(2>1)
	{
		try 
		{
	     driver=new AndroidDriver(u,dc);
         break;
		}
		catch(Exception ex)
		{
			
		}
	}
	//Locate and operate elements 
	try
	{
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		for(int i=0;i<x.length();i++)
		{
			char c = x.charAt(i);
			driver.findElement(By.xpath("//*[@text='"+c+"']")).click();			
		}
		driver.findElement(By.xpath("//*[@content-desc='multiply']")).click();
		for(int i=0;i<y.length();i++)
		{
			char c =y.charAt(i);
			driver.findElement(By.xpath("//*[@text='"+c+"']")).click();
		}
		driver.findElement(By.xpath("//*[@content-desc='equals']")).click();
		String z=driver.findElement(By.xpath("//*[@class='android.widget.EditText']")).getAttribute("text");
		
		if(Integer.parseInt(z)==Integer.parseInt(x)*Integer.parseInt(y))
		{
			System.out.println("Test passed");
			File src = driver.getScreenshotAs(OutputType.FILE);
			File dest = new File("kiran.png");
			FileUtils.copyFile(src, dest);
		}
		else
		{
			System.out.println("Test failed");
			File src=driver.getScreenshotAs(OutputType.FILE);
			File detc = new File("kiran1.png");
			FileUtils.copyFile(src, detc);
		}
		driver.close();
	}
	catch(Exception ex)
	{
		System.out.println(ex.getMessage());
			
	}
//stop Appium server
	Runtime.getRuntime().exec("taskkill /F /IM node.exe");
	Runtime.getRuntime().exec("taskkill /F /IM cmd.exe");
	}

}
