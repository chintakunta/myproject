import java.io.IOException;
import java.net.URL;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidKeyCode;

public class Test6 {

	public static void main(String[] args) throws Exception {
		/*Scanner sc = new Scanner(System.in);
		System.out.println("Enter phone no");
		String x=sc.nextLine();*/
		//Details of avd and app
		DesiredCapabilities dc= new DesiredCapabilities();
		dc.setCapability(CapabilityType.BROWSER_NAME,""); 
		dc.setCapability("deviceName", "ZY2244H2P7");
		dc.setCapability("platformName", "android");
		dc.setCapability("platformVersion", "8.1.0");
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
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		try
		{
			//back to home
			driver.pressKeyCode(AndroidKeyCode.HOME);
			Thread.sleep(5000);
			//goto otherapp and operate element
			driver.findElement(By.xpath("//*[@text='Contacts']")).click();
			driver.findElement(By.xpath("//*[@content-desc='Search']")).click();
			driver.findElement(By.xpath("//*[@text='Find contacts']")).sendKeys("kanth");
		}
		catch(Exception ex)
		{
			
		}
		
		//stop Appium server
				Runtime.getRuntime().exec("taskkill /F /IM node.exe");
				Runtime.getRuntime().exec("taskkill /F /IM cmd.exe");



	}

}
