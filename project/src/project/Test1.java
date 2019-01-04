package project;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

public class Test1 
{
	public static void main(String[] args) throws IOException, InterruptedException 
	{
		DesiredCapabilities dc= new DesiredCapabilities();
		dc.setCapability(CapabilityType.BROWSER_NAME,""); 
		dc.setCapability("deviceName", "ZY2244H2P7");
		dc.setCapability("platformName", "android");
		dc.setCapability("platformVersion", "7.0");
		dc.setCapability("appPackage", "com.cricbuzz.android");
		dc.setCapability("appActivity", "com.cricbuzz.android.lithium.app.view.activity.NyitoActivity");
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
		driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
		System.out.println("current context is"+driver.getContext());
		Set s=driver.getContextHandles();
		System.out.println(s.size());
		System.out.println("contexts are"+s);
		driver.closeApp();
		Runtime.getRuntime().exec("taskkill /F /IM node.exe");
		Runtime.getRuntime().exec("taskkill /F /IM cmd.exe");

	}

}
