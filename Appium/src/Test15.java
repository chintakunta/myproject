import java.net.URL;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.MultiTouchAction;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidKeyCode;

public class Test15 
{
	public static void main(String[] args) throws Exception 
	{
		DesiredCapabilities dc= new DesiredCapabilities();
		dc.setCapability(CapabilityType.BROWSER_NAME,""); 
		dc.setCapability("deviceName", "ZY2244H2P7");
		dc.setCapability("platformName", "android");
		dc.setCapability("platformVersion", "7.0");
		dc.setCapability("locationservicesEnabled", true);
		dc.setCapability("locationservicersAuthorizer", true);
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
		//Automation vodqa 
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.pressKeyCode(AndroidKeyCode.HOME);
		WebDriverWait w=new WebDriverWait(driver,20);
		w.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@content-desc='Apps list']")));
		driver.findElement(By.xpath("//*[@content-desc='Apps list']")).click();
		w.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@text='  Search Apps']")));
		driver.findElement(By.xpath("//*[@text='  Search Apps']")).sendKeys("vod");
		w.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@text='VodQAReactNative']")));
		driver.findElement(By.xpath("//*[@text='VodQAReactNative']")).click();
		w.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@text='LOG IN']")));
		driver.findElement(By.xpath("//*[@text='LOG IN']")).click();
		w.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@text='Double Tap']")));
		driver.findElement(By.xpath("//*[@text='Double Tap']")).click();
		w.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@text='Double Tap Me']")));
		WebElement e=driver.findElement(By.xpath("//*[@text='Double Tap Me']"));
		//Double tap
		TouchAction ta1=new TouchAction(driver);
		ta1.tap(e);
		TouchAction ta2=new TouchAction(driver);
		ta2.waitAction(Duration.ofMillis(10)).tap(e);
		MultiTouchAction ma=new MultiTouchAction(driver);
		ma.add(ta1).add(ta2).perform();
		try
		{
			if(driver.findElement(By.xpath("//*[@text='Double tap successful!']")).isDisplayed())
			{
				System.out.println("operation finished");
			}
				
		}catch(Exception ex)
		{
			System.out.println("operation was not finished");
		}
		driver.pressKeyCode(AndroidKeyCode.HOME);
		driver.launchApp();
		driver.closeApp();
		Runtime.getRuntime().exec("taskkill /F /IM node.exe");
		Runtime.getRuntime().exec("taskkill /F /Im cmd.exe");

	}

}
