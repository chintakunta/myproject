import java.io.File;
import java.io.IOException;
import java.net.URL;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidKeyCode;

public class Test21 
{
	public static void main(String[] args) throws Exception 
	{
		//Details of ARD and App
		DesiredCapabilities dc= new DesiredCapabilities();
		dc.setCapability(CapabilityType.BROWSER_NAME,""); 
		dc.setCapability("deviceName", "ZY2244H2P7");
		dc.setCapability("platformName", "android");
		dc.setCapability("platformVersion", "7.0");
		dc.setCapability("locationservicesEnabled", true);
		dc.setCapability("locationservicersAuthorizer", true);
		dc.setCapability("automationName", "uiautomator2");
		dc.setCapability("appPackage", "com.google.android.apps.maps");
		dc.setCapability("appActivity", "com.google.android.maps.MapsActivity");
		//start appium server
		Runtime.getRuntime().exec("cmd.exe /c start cmd.exe /k \"appium -a 0.0.0.0 -p 4723\"");
		URL u=new URL("http://0.0.0.0:4723/wd/hub");
		//Thread.sleep(20000);
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
		WebDriverWait w=new WebDriverWait(driver,20);
		driver.pressKeyCode(AndroidKeyCode.HOME);
		w.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@content-desc='Apps list']")));
		driver.findElement(By.xpath("//*[@content-desc='Apps list']")).click();
		w.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@text='Abhibus']")));
		driver.findElement(By.xpath("//*[@text='Abhibus']")).click();
		w.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@text='Search']")));
		driver.pressKeyCode(AndroidKeyCode.BACK);
		//get screenshot of Maps
	    File src =driver.getScreenshotAs(OutputType.FILE);
		File dest=new File("Abhibus.png");
		//BufferedImage fulling=ImageIO.read(dest);
		FileUtils.copyFile(src, dest);
		

	}

}
