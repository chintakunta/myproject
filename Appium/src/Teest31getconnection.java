import java.net.URL;

import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidKeyCode;
import io.appium.java_client.android.Connection;

public class Teest31getconnection 
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
		//dc.setCapability("automationName", "uiautomator2");
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
		driver.pressKeyCode(AndroidKeyCode.HOME);
		Connection c=driver.getConnection();
		if(c.compareTo(Connection.AIRPLANE)==0)
		{
			System.out.println("Airplane is on");
		}
		else
		{
			System.out.println("Airplane is off");
		}
		if(c.compareTo(Connection.DATA)==0)
		{
			System.out.println("DATA is ON");
		}
		else
		{
			System.out.println("DATA is OFF");
		}
		if(c.compareTo(Connection.WIFI)==0)
		{
			System.out.println("WIFI is ON");
		}
		else
		{
			System.out.println("WIFI is OFF");
			driver.setConnection(Connection.WIFI);
		}
		//stop appium server
		Runtime.getRuntime().exec("taskkill /F /IM node.exe");
		Runtime.getRuntime().exec("taskkill /F /IM cmd.exe");

	}

}
