import java.io.IOException;
import java.net.URL;
import java.util.Scanner;

import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.android.AndroidDriver;

public class Test28Youtube 
{
	public static void main(String[] args) throws Exception 
	{
	/*	//Get Environment
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter Environment computer/mobile");
		String p=sc.nextLine();*/
		/*if(p.equalsIgnoreCase("computer"))
		{
			
		}*/
		//Details of ARD with Browser
		DesiredCapabilities dc= new DesiredCapabilities();
		dc.setCapability(CapabilityType.BROWSER_NAME,"chrome"); 
		dc.setCapability("deviceName", "ZY2244H2P7");
		dc.setCapability("platformName", "android");
		dc.setCapability("platformVersion", "7.0");
		//start appium server
		/*Runtime.getRuntime().exec("cmd.exe /c start cmd.exe /k \"appium -a 0.0.0.0 -p 4723\"");*/
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
		driver.get("https://www.youtube.com");
		//change context from site(web_view to app/Native_App)
		driver.context("NATIVE_APP");
		
	
		

	}

}
