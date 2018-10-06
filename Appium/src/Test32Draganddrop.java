import java.io.IOException;
import java.net.URL;
import java.time.Duration;
import java.time.temporal.ChronoUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.sikuli.script.RunTime;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;

public class Test32Draganddrop 
{
	public static void main(String[] args) throws Exception 
	{
		//Details of ARD and App
		DesiredCapabilities dc=new DesiredCapabilities();
		dc.setCapability(CapabilityType.BROWSER_NAME,"");
		dc.setCapability("deviceName", "ZY2244H2P7");
		dc.setCapability("platformName", "android");
		dc.setCapability("platformVersion", "7.0");
		dc.setCapability("appPackage", "com.vodqareactnative");
		dc.setCapability("appActivity", "com.vodqareactnative.MainActivity");
		//start Appium server
		Runtime.getRuntime().exec("cmd.exe /c start cmd.exe /k \"appium -a 0.0.0.0 -p 4723\"");
		URL u= new URL("http://0.0.0.0:4723/wd/hub");
		//create driver object to launch phone app
		AndroidDriver driver;
		while(2>1) //infinite loop
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
		//Automation
		try
		{
			WebDriverWait wait=new WebDriverWait(driver,20);
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@text='LOG IN']")));
			driver.findElement(By.xpath("//*[@text='LOG IN']")).click();
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@text='Drag & Drop']")));
			driver.findElement(By.xpath("//*[@text='Drag & Drop']")).click();
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@text='Drag me!']")));
			WebElement e1=driver.findElement(By.xpath("//*[@text='Drag me!']"));
			WebElement e2=driver.findElement(By.xpath("//*[@text='Drop here.']"));
			TouchAction ta=new TouchAction(driver);
			Duration d=Duration.of(10,ChronoUnit.SECONDS);
			ta.press(e1).waitAction(d).moveTo(e2).release().perform();
			try
			{
				if(driver.findElement(By.xpath("//*[@text='Circle dropped']")).isDisplayed())
				{
					System.out.println("operation was finished");
				}
				else
				{
					System.out.println("operation was failed");
				}
			}
			catch(Exception ex)
			{
				System.out.println(ex.getMessage());
			}
			//close app
			driver.closeApp();			
		}
		catch(Exception ex)
		{
			System.out.println(ex.getMessage());
		}
		//stop Appium server
		Runtime.getRuntime().exec("taskkill /F /IM node.exe");
		Runtime.getRuntime().exec("taskkill /F /IM cmd.exe");
	}

}
