import java.io.IOException;
import java.net.URL;
import java.time.Duration;
import java.time.temporal.ChronoUnit;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidKeyCode;

public class Test12 
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
		dc.setCapability("automationName", "uiautomator2");
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
		driver.pressKeyCode(AndroidKeyCode.HOME);
		WebDriverWait wait=new WebDriverWait(driver,20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@content-desc='Apps list']")));
		driver.findElement(By.xpath("//*[@content-desc='Apps list']")).click();
		int w=driver.manage().window().getSize().getWidth();
		int h=driver.manage().window().getSize().getHeight();
		while(2>1)
		{
			try
			{
				driver.findElement(By.xpath("//*[@text='Wikipedia']")).click();
				break;
			}
			catch(Exception ex)
			{
				TouchAction ta = new TouchAction(driver);
				driver.context("NATIVE_APP");
				int x1=w/2;
				int y1=(int) (h*0.9);
				int x2=w/2;
				int y2=(int) (h*0.3);
				Duration d=Duration.of(5,ChronoUnit.SECONDS);
				ta.press(x1,y1).waitAction(d).moveTo(x2,y2).release().perform();
				
			}
		}
		driver.pressKeyCode(AndroidKeyCode.HOME);
		//swipe from right to left 3 times
		TouchAction ta =new TouchAction(driver);
		   int x1=(int)(w*0.7);
		   int y1=(int)(h/2);
		   int x2=(int)(w*0.4);
		   int y2=(int)(h/2);
		   
		for(int i=0; i<=2;i++)
		{
			try
			{
				  ta.press(x1,y1).moveTo(x2,y2).waitAction(Duration.ofMillis(5000)).release().perform();
				  wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@text='Settings']")));
				  //Thread.sleep(10000);
				  driver.findElement(By.xpath("//*[@text='Settings']")).click();
			}
			catch(Exception ex)
			{
				System.out.println(ex.getMessage());
			}
		}
		
		driver.pressKeyCode(AndroidKeyCode.HOME);
		driver.launchApp();
		driver.closeApp();
		Runtime.getRuntime().exec("taskkill /F /IM node.exe");
		Runtime.getRuntime().exec("taskkill /F /Im cmd.exe");

	}

}
