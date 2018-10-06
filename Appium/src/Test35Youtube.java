import java.io.IOException;
import java.net.URL;
import java.util.Scanner;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.android.AndroidDriver;

public class Test35Youtube 
{
	public static void main(String[] args) throws Exception 
	{
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter platform as computer/mobile");
		String x=sc.nextLine();
		if(x.equalsIgnoreCase("computer"))
		{
			//selenium webdriver with skiuli
			
		}
		else 
		{
			//start appium server
			DesiredCapabilities dc= new DesiredCapabilities();
			dc.setCapability(CapabilityType.BROWSER_NAME,"chrome"); 
			dc.setCapability("deviceName", "ZY2244H2P7");
			dc.setCapability("platformName", "android");
			dc.setCapability("platformVersion", "7.0");
			/*dc.setCapability("locationservicesEnabled", true);
			dc.setCapability("locationservicersAuthorizer", true);*/
			//dc.setCapability("appPackage", "com.flipkart.android");
			//dc.setCapability("appActivity", "com.flipkart.android.activity.HomeFragmentHolderActivity");
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
			//Launch site 
			driver.get("https://www.youtube.com");
			//change contex from site(WEB_VIEW TO NATIVE_APP)
			driver.context("NATIVE_APP");
			WebDriverWait  wait=new WebDriverWait(driver,10);
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@text='Search YouTube']")));
			driver.findElement(By.xpath("//*[@text='Search YouTube']")).click();
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@class='android.widget.EditText']")));
			driver.findElement(By.xpath("//*[@class='android.widget.EditText']")).sendKeys("kalam");
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@text='Search YouTube']")));
			driver.findElement(By.xpath("//*[@text='Search YouTube']")).click();
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@class='android.view.View'][@index='4']")));
			driver.findElement(By.xpath("//*[@class='android.view.View'][@index='4']")).click();
			
			
			
			
		}

	}

}
