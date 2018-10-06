import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidKeyCode;

public class Test7 {

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
			Thread.sleep(5000);
			/*driver.findElement(By.xpath("//*[@content-desc='Apps list']")).click();
			driver.findElement(By.xpath("//*[@text=' WhatsApp']")).click();*/
			/*driver.findElement(By.xpath("//*[@content-desc='Folder: Google']")).click();
			Thread.sleep(10000);
			driver.findElement(By.xpath("//*[@text='YouTube']")).click();
			Thread.sleep(10000);
			driver.findElement(By.xpath("//*[@content-desc='Library']")).click();*/
			driver.pressKeyCode(AndroidKeyCode.HOME);
			driver.findElement(By.xpath("//*[@content-desc='Apps list']")).click();
			Thread.sleep(5000);
			driver.findElement(By.xpath("//*[@text='  Search Apps']")).sendKeys("what");
			Thread.sleep(10000);
			driver.findElement(By.xpath("//*[@text='WhatsApp']")).click();
			//driver.findElement(By.xpath("//*[@content-desc='WhatsApp']")).click();
			Thread.sleep(5000);
			driver.findElement(By.xpath("//*[@content-desc='More options']")).click();
			Thread.sleep(5000);
			driver.findElement(By.xpath("//*[@text='Settings']")).click();
			Thread.sleep(5000);
			driver.findElement(By.xpath("//*[@content-desc='Navigate up']")).click();
			driver.findElement(By.xpath("//*[@content-desc='Search']")).click();
			Thread.sleep(5000);
			driver.findElement(By.xpath("//*[@text='Search…']")).sendKeys("sai");
			driver.findElement(By.xpath("//*[contains(@resource-id,'contact_row_container')]")).click();
			Thread.sleep(5000);
			WebElement me=driver.findElement(By.xpath("//*[@content-desc='Voice message']"));
			TouchAction ta=new TouchAction(driver);
			ta.press(me).perform();
			Thread.sleep(5000);
			ta.release().perform();
			driver.closeApp();
			
		}
		catch(Exception ex)
		{
			
		}
		Runtime.getRuntime().exec("taskkill /F /IM node.exe");
		Runtime.getRuntime().exec("taskkill /F /IM cmd.exe");

	}

}
