import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidKeyCode;
import io.appium.java_client.android.Connection;

public class Test10 {

	public static void main(String[] args) throws IOException, InterruptedException
	{
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
		driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
		driver.longPressKeyCode(AndroidKeyCode.BACK);
		String x=driver.getRemoteAddress().getPath();
		System.out.println(x);
		String y=driver.getRemoteAddress().getProtocol();
		System.out.println(y);
		int z=driver.getRemoteAddress().getPort();
		System.out.println(z);
		String h=driver.getRemoteAddress().getHost();
		System.out.println(h);
		long w=driver.getDisplayDensity();
		System.out.println(w);
		String t=driver.getDeviceTime();
		Connection c =driver.getConnection();
		System.out.println(t);
		driver.lockDevice();	
		Runtime.getRuntime().exec("taskkill /F /IM node.exe");
		Runtime.getRuntime().exec("taskkill /F /IM cmd.exe");
	}

}
