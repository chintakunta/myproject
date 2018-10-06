import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;

import javax.imageio.ImageIO;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.android.AndroidDriver;
import net.sourceforge.tess4j.Tesseract;
import net.sourceforge.tess4j.util.LoadLibs;

public class Test20 {

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
		//get screenshot of Maps
		File src =driver.getScreenshotAs(OutputType.FILE);
		File dest=new File("Mapscreen.png");
		//BufferedImage fulling=ImageIO.read(dest);
		FileUtils.copyFile(src, dest);
		//Load tessdata file which have characters
		File fo=LoadLibs.extractTessResources("tessdata");
		//create object to apply OCR on image
		Tesseract obj=new Tesseract();
		obj.setDatapath(fo.getAbsolutePath());
		String result=obj.doOCR(dest);
		Thread.sleep(20000);
		System.out.println(result);
		
			
		
		
		
		
		

	}

}
