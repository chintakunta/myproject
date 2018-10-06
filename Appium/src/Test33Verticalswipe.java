import java.io.IOException;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.sikuli.script.RunTime;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;

public class Test33Verticalswipe 
{
	public static void main(String[] args) throws Exception 
	{
		//Details of AVD and App
		DesiredCapabilities dc=new DesiredCapabilities();
		dc.setCapability(CapabilityType.BROWSER_NAME,"");
		dc.setCapability("deviceName", "emulator-5554");
		dc.setCapability("platformVersion", "android");
		dc.setCapability("platformVersion", "4.2.2");
		dc.setCapability("appPackage", "com.android.deskclock");
		dc.setCapability("appActivity", "com.android.deskclock.DeskClock");
		//start Appium server
		Runtime.getRuntime().exec("cmd.exe /c start cmd.exe /k \"appium -a 0.0.0.0 -p 4723\"");
		URL u=new URL("http://0.0.0.0:4723/wd/hub");
		//create driver object to launch app in avd
		AndroidDriver driver;
		while(2>1)//infinite loop
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
		//Automate app screen
		try 
		{
			WebDriverWait wait=new WebDriverWait(driver,20);
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@content-desc='Cities']")));
			driver.findElement(By.xpath("//*[@content-desc='Cities']")).click();
			//Perform swipe for required Element(city)
			driver.context("NATIVE_APP");
			int w=driver.manage().window().getSize().getWidth();
			int h=driver.manage().window().getSize().getHeight();
			TouchAction ta=new TouchAction(driver);
			//swipe from bottom to top for required city
			int x1=w/2;
			int y1=(int) (h*0.7);
			int x2=x1;
			int y2=(int) (h*0.2);
			while(2>1)//infinite loop
			{
				try
				{
					driver.findElement(By.xpath("//*[@text='Cape Town']")).click();
					break;
				}
				catch(Exception ex)
				{
					ta.press(x1,y1).moveTo(x2,y2).release().perform();
				}
			}
			//swipe from top to bottom for required city
			y1=(int) (h*0.3);
			y2=(int) (h*0.8);
			while(2>1)
			{
				try
				{
					driver.findElement(By.xpath("//*[@text='Accra']")).click();
					break;
				}
				catch(Exception ex)
				{
					ta.press(x1,y1).moveTo(x2,y2).release().perform();
				}
			}
			//close app
			driver.closeApp();
		}
		catch(Exception ex)
		{
			System.out.println(ex.getMessage());
		}
		//stop appium server
		Runtime.getRuntime().exec("taskkill /F /IM node.exe");
		Runtime.getRuntime().exec("taskkill /F /IM cmd.exe");
	}

}
