import java.io.IOException;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

public class Test30Flipkart 
{
	public static void main(String[] args) throws Exception 
	{
		DesiredCapabilities dc= new DesiredCapabilities();
		dc.setCapability(CapabilityType.BROWSER_NAME,""); 
		dc.setCapability("deviceName", "ZY2244H2P7");
		dc.setCapability("platformName", "android");
		dc.setCapability("platformVersion", "7.0");
		/*dc.setCapability("locationservicesEnabled", true);
		dc.setCapability("locationservicersAuthorizer", true);*/
		dc.setCapability("appPackage", "com.flipkart.android");
		dc.setCapability("appActivity", "com.flipkart.android.activity.HomeFragmentHolderActivity");
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
		WebDriverWait wait=new WebDriverWait(driver,20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@text='Existing User? SIGN IN']")));
		driver.findElement(By.xpath("//*[@text='Existing User? SIGN IN']")).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@text='Email/Mobile no.']")));
		WebElement e=driver.findElement(By.xpath("//*[@text='Email/Mobile no.']"));
		e.click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@text='NONE OF THE ABOVE']")));
		driver.findElement(By.xpath("//*[@text='NONE OF THE ABOVE']")).click();
		e.sendKeys("8652644687");
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@text='Password']")));
		WebElement d=driver.findElement(By.xpath("//*[@text='Password']"));
		d.clear();
		d.sendKeys("kiran@99126");
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@text='SIGN IN']")));
		driver.findElement(By.xpath("//*[@text='SIGN IN']")).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@text=' Search for Products, Brands and More']")));
		WebElement c=driver.findElement(By.xpath("//*[@text=' Search for Products, Brands and More']"));
		c.clear();
		c.sendKeys("redmi note 5 pro");
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@text='CONTINUE']")));
		driver.findElement(By.xpath("//*[@text='CONTINUE']")).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@text='ALLOW']")));
		driver.findElement(By.xpath("//*[@text='ALLOW']")).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@content-desc='open search']")));
		driver.findElement(By.xpath("//*[@content-desc='open search']")).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@content-desc='Search grocery products in Supermart']")));
		driver.findElement(By.xpath("//*[@content-desc='Search grocery products in Supermart']")).clear();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@text='Search for Products, Brands..']")));
		MobileElement g=(MobileElement) driver.findElement(By.xpath("//*[@text='Search for Products, Brands..']"));
		g.sendKeys("redmi note 5 pro");
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@class='android.widget.RelativeLayout'][@index='0']")));
		driver.findElement(By.xpath("//*[@class='android.widget.RelativeLayout'][@index='0']")).click();
		

	}

}
