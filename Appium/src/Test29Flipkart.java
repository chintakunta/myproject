import java.net.URL;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidKeyCode;

public class Test29Flipkart {

	public static void main(String[] args) throws Exception {
		DesiredCapabilities dc= new DesiredCapabilities();
		dc.setCapability(CapabilityType.BROWSER_NAME,""); 
		dc.setCapability("deviceName", "ZY2244H2P7");
		dc.setCapability("platformName", "android");
		dc.setCapability("platformVersion", "7.0");
		/*dc.setCapability("locationservicesEnabled", true);
		dc.setCapability("locationservicersAuthorizer", true);*/
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
		//Automation
				try
				{
					driver.pressKeyCode(AndroidKeyCode.HOME);
					WebDriverWait wait=new WebDriverWait(driver,30);
					wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@content-desc='Apps list']")));
					driver.findElement(By.xpath("//*[@content-desc='Apps list']")).click();
					//search for Flipkart
					while(2>1)
					{
						try
						{
							driver.findElement(By.xpath("//*[@text='Flipkart']")).click();
							break;//terminate from current loop
						}
						catch(Exception ex)
						{
							TouchAction ta =new TouchAction(driver);
							driver.context("NATIVE_APP");
							int w=driver.manage().window().getSize().getWidth();
							int h=driver.manage().window().getSize().getHeight();
							int x1=w/2;
							int y1=(int)(h*0.8);//near to bottom
							int x2=x1;
							int y2=(int)(h*0.3);//near to top
							ta.press(x1,y1).waitAction(Duration.ofMillis(5000)).moveTo(x2, y2).release().perform();					
						}
					}
					wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@text=' Search for Products, Brands and More']")));
					driver.findElement(By.xpath("//*[@text=' Search for Products, Brands and More']")).click();
					wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@text='Trending']")));
					WebElement e=driver.findElement(By.xpath("//*[@resource-id='com.flipkart.android:id/search_layout_with_autocomplete']"));
					e.sendKeys("redmi note 5 pro");
					driver.findElement(By.xpath("//*[@bounds='[0,187][1080,361]']")).click();
					//wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@resource-id='com.flipkart.android:id/clear_text']")));					
				}
				
				catch(Exception ex)
				{
				}

}
}
