import java.io.IOException;
import java.net.URL;
import java.time.Duration;
import java.time.temporal.ChronoUnit;

import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;

public class Test34Horizontalswipe 
{
	public static void main(String[] args) throws Exception 
	{
		//Details of AVD and App
		DesiredCapabilities dc =new DesiredCapabilities();
		dc.setCapability(CapabilityType.BROWSER_NAME, "");
		dc.setCapability("deviceName", "emulator-5554");
		dc.setCapability("platformName", "android");
		dc.setCapability("platformVersion", "4.2.2");
		dc.setCapability("appPackage", "com.android.calendar");
		dc.setCapability("appActivity", "com.android.calendar.AllInOneActivity");
		//start Appium server
		Runtime.getRuntime().exec("cmd.exe /c start cmd.exe /k \"appium -a 0.0.0.0 -p 4723\"");
		URL u =new URL("http://0.0.0.0:4723/wd/hub");
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
		//Automation
		try
		{
			//swipe on app screen
			driver.context("NATIVE_APP");
			int w= driver.manage().window().getSize().getWidth();
			int h= driver.manage().window().getSize().getHeight();
			TouchAction ta =new TouchAction(driver);
			//swipe from right to left 5 time
			int x1=(int) (w*0.8);
			int y1=h/2;
			int x2=(int) (w*0.3);
			int y2=y1;
			for(int i=1;i<=5;i++)
			{
				Duration d=Duration.of(5, ChronoUnit.SECONDS);
				ta.press(x1,y1).moveTo(x2,y2).waitAction(d).release().perform();
			}
			//swipe from left to right 5 times
			x1=(int) (w*0.3);
			x2=(int) (w*0.8);
			for(int i=1;i<=5;i++)
			{
				Duration d=Duration.of(5, ChronoUnit.SECONDS);
				ta.press(x1,y1).moveTo(x2,y2).waitAction(d).release().perform();
			}
			//close App
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
