import java.io.IOException;
import java.net.URL;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;

public class Test27context 
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
		dc.setCapability("appPackage", "com.cricbuzz.android");
		dc.setCapability("appActivity", "com.cricbuzz.android.lithium.app.view.activity.NyitoActivity");
		//start appium server
		Runtime.getRuntime().exec("cmd.exe /c start cmd.exe /k \"appium -a 0.0.0.0 -p 4723\"");
		URL u=new URL("http://0.0.0.0:4723/wd/hub");
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
		WebDriverWait wait =new WebDriverWait(driver,20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@package='com.cricbuzz.android']")));
		driver.findElement(By.xpath("//*[@package='com.cricbuzz.android']")).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@text='TOP STORIES']")));
		/*while(2>1)
		try
		{
			driver.findElement(By.xpath("//*[@text='Windies vs Bangladesh, 3rd ODI - Live Blog']")).click();
			break;
		}
		catch(Exception ex)
		{
			TouchAction ta=new TouchAction(driver);
			driver.context("NATIVE_APP");
			int w=driver.manage().window().getSize().getWidth();
			int h=driver.manage().window().getSize().getHeight();
			int x1=w/2;
			int y1=(int) (h*0.5);
			int x2=x1;
			int y2=(int) (h*0.4);
			ta.press(x1,y1).waitAction(Duration.ofMillis(5000)).moveTo(x2,y2).release().perform();
		}*/
		
	}

}
