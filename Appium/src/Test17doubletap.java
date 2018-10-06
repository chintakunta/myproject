import java.io.IOException;
import java.net.URL;
import java.time.Duration;
import java.time.temporal.ChronoUnit;
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

public class Test17doubletap {

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
				driver.findElement(By.xpath("//*[@text='VodQAReactNative']")).click();
				break;
			}
			catch(Exception ex)
			{
				TouchAction ta = new TouchAction(driver);
				driver.context("NATIVE_APP");
				int x1=w/2;
				int y1=(int) (h*0.8);
				int x2=w/2;
				int y2=(int) (h*0.5);
				Duration d=Duration.of(5,ChronoUnit.SECONDS);
				ta.press(x1,y1).waitAction(d).moveTo(x2,y2).release().perform();
				
			}
		}
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@text='LOG IN']")));
		driver.findElement(By.xpath("//*[@text='LOG IN']")).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@text='Photo View']")));
		driver.findElement(By.xpath("//*[@text='Photo View']")).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@class='android.widget.ImageView']")));
		WebElement e=driver.findElement(By.xpath("//*[@class='android.widget.ImageView']")); 
		Thread.sleep(5000);
		//zoom out
		int x=e.getLocation().getX();
		int y=e.getLocation().getY();
		int a=e.getSize().getWidth();
		int f=e.getSize().getHeight();
		TouchAction ta1=new TouchAction(driver);
		Thread.sleep(5000);
		ta1.press(520,910).waitAction(Duration.ofMillis(5000)).moveTo(520,700).release();
		TouchAction ta2=new TouchAction(driver);
		Thread.sleep(5000);
		ta2.press(520,940).waitAction(Duration.ofMillis(5000)).moveTo(520,1150).release();
		MultiTouchAction ma=new MultiTouchAction(driver);
		ma.add(ta1).add(ta2).perform();
		//double tap
		/*TouchAction ta1=new TouchAction(driver);
		ta1.tap(e).release();
		TouchAction ta2=new TouchAction(driver);
		ta2.tap(e).waitAction(Duration.ofMillis(5)).release();
		MultiTouchAction b= new MultiTouchAction(driver);
		Thread.sleep(10000);
		b.add(ta1).add(ta2).perform();*/
		//driver.pressKeyCode(AndroidKeyCode.HOME);
		/*driver.launchApp();
		driver.closeApp();*/
		Runtime.getRuntime().exec("taskkill /F /IM node.exe");
		Runtime.getRuntime().exec("taskkill /F /IM cmd.exe");
	}

}
