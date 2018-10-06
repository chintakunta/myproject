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

public class Calcmoto {

	public static void main(String[] args) throws IOException, InterruptedException 
	{
		Scanner sc = new Scanner(System.in);
		System.out.println("enter first number");
		String x=sc.nextLine();
		System.out.println("enter second number");
		String y=sc.nextLine();
		DesiredCapabilities dc= new DesiredCapabilities();
		dc.setCapability(CapabilityType.BROWSER_NAME,""); 
		dc.setCapability("deviceName", "330093772aa714d1");
		dc.setCapability("platformName", "android");
		dc.setCapability("platformVersion", "7.0");
		dc.setCapability("appPackage", "com.sec.android.app.popupcalculator");
		dc.setCapability("appActivity", "com.sec.android.app.popupcalculator.Calculator");
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
		try
		{
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	    for(int i=0;i<x.length();i++)
	    {
	    	char c=x.charAt(i);
	    	driver.findElement(By.xpath("//*[@text='"+c+"']")).click();
	    	
	    }
	    driver.findElement(By.xpath("//*[@content-desc='Plus']")).click();
	    for(int i=0;i<y.length();i++)
	    {
	    	char c=y.charAt(i);
	    	driver.findElement(By.xpath("//*[@text='"+c+"']")).click();
	    	
	    }
	    driver.findElement(By.xpath("//*[@content-desc='Equal']")).click();
	    Thread.sleep(10000);
	    String z=driver.findElement(By.xpath("//*[contains(@resource-id,'txtCalc')]")).getAttribute("text");
	    System.out.println(z);
	   if(Integer.parseInt(z)== Integer.parseInt(x)+Integer.parseInt(y))
	   {
		  System.out.println("test passed");
		  File src=driver.getScreenshotAs(OutputType.FILE);
				  File dest =new File("calc1.png");
				  FileUtils.copyFile(src, dest);
				  
	   }
	   else
	   {
		   System.out.println("test failed");
		   File src=driver.getScreenshotAs(OutputType.FILE);
			  File dest =new File("calc.png");
			  FileUtils.copyFile(src, dest);
	   }
	   driver.closeApp();
	   
		}
		catch(Exception ex)
		{
			System.out.println(ex.getMessage());
		}
		Runtime.getRuntime().exec("taskkill /F /IM node.exe");
		Runtime.getRuntime().exec("taskkill /F /IM cmd.exe");	
	}

}
