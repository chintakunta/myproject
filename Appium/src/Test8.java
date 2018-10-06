import java.io.IOException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidKeyCode;

public class Test8 {

	public static void main(String[] args) throws Exception {
		DesiredCapabilities dc= new DesiredCapabilities();
		dc.setCapability(CapabilityType.BROWSER_NAME,""); 
		dc.setCapability("deviceName", "ZY2244H2P7");
		dc.setCapability("platformName", "android");
		dc.setCapability("platformVersion", "7.0");
		dc.setCapability("appPackage", "com.android.dialer");
		dc.setCapability("appActivity", "com.android.dialer.DialtactsActivity");
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
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		try
		{
		//back to home
		driver.pressKeyCode(AndroidKeyCode.HOME);
		driver.findElement(By.xpath("//*[@content-desc='Apps list']")).click();
		driver.findElement(By.xpath("//*[@text='  Search Apps']")).sendKeys("zoomcar");
		driver.findElement(By.xpath("//*[@text='Zoomcar']")).click();
		
		}
		catch (Exception ex)
		{
			System.out.println(ex.getMessage());
		}
	}

}
