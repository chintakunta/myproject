import java.net.URL;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;

public class Test18suji 
{
	public static void main(String[] args) throws Exception 
	{
		DesiredCapabilities dc=new DesiredCapabilities();
		dc.setCapability(CapabilityType.BROWSER_NAME,"");
		dc.setCapability("deviceName","emulator-5554");
		dc.setCapability("platformName","android");
		dc.setCapability("platformVersion","4.2.2");
		dc.setCapability("appPackage","com.android.calendar");
		dc.setCapability("appActivity","com.android.calendar.AllInOneActivity");
		//start appium server
		Runtime.getRuntime().exec("cmd.exe /c start cmd.exe /k \"appium -a 0.0.0.0 -p 4723\"");
		URL u=new URL("http://0.0.0.0:4723/wd/hub");
		//create driver object to launch app
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
		//automation
		try
		{
			driver.context("NATIVE_APP");
			/*WebDriverWait wait= new WebDriverWait(driver,20);
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@text='January 1970']")));*/
			//driver.findElement(By.xpath("//*[@text='January 1970']"));
			//HOrizontal Swiping
			int w=driver.manage().window().getSize().getWidth();
			int h=driver.manage().window().getSize().getHeight();
			//From Right to Left 5 times
			TouchAction ta=new TouchAction(driver);
			int x1= (int) (w*0.7);
			int y1= (int) (h/2);
			int x2= (int) (w*0.4);
			int y2= (int) (h/2);
			for(int i=1; i<=5; i++)
			{
			ta.press(x1,y1).moveTo(x2,y2).waitAction(Duration.ofMillis(1000)).release().perform();
			}
			//From Left to Right 5 times
			x1= (int) (w*0.4);
			x2= (int) (w*0.7);
			for(int i=1; i<=5; i++)
			{
			ta.press(x1,y1).moveTo(x2,y2).waitAction(Duration.ofMillis(1000)).release().perform();
			}
			driver.closeApp();
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
		
	}

}
