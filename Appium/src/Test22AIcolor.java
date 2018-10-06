import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

import javax.imageio.ImageIO;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidKeyCode;

public class Test22AIcolor 
{
	public static void main(String[] args) throws Exception
	{
		//Give color name 
		Scanner sc =new Scanner(System.in);
		System.out.println("Enter red/blue/green/black");
		String cname=sc.nextLine();
		int count=0;
		int percentage;
		Color ec=null;
		switch(cname)
		{
		    case"black":
			ec=Color.BLACK;
			break;
		    case"blue":
		    	ec=Color.BLUE;
		    	break;
		    case"red":
		    	ec=Color.RED;
		    	break;
		    case"green":
		    	ec=Color.GREEN;
		    	break;
		    	default:
		    		System.out.println("wrong color");
		    		System.exit(0);
		}
		//details of ARD and app
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
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@text='  Search Apps']")));
			driver.findElement(By.xpath("//*[@text='  Search Apps']")).sendKeys("vod");
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@text='VodQAReactNative']")));
			driver.findElement(By.xpath("//*[@text='VodQAReactNative']")).click();
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@text='LOG IN']")));
			driver.findElement(By.xpath("//*[@text='LOG IN']")).click();
			//swipe for whellpicker option
			while(2>1)
			{
				try
				{
					driver.findElement(By.xpath("//*[@text='Wheel Picker']")).click();
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
					ta.press(x1,y1).moveTo(x2, y2).release().perform();					
				}
			}
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@class='android.widget.Spinner']")));
			driver.findElement(By.xpath("//*[@class='android.widget.Spinner']")).click();
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@class='android.widget.CheckedTextView']")));
			driver.findElement(By.xpath("//*[@text='"+cname+"']")).click();
			WebElement e=driver.findElement(By.xpath("//*[@bounds='[0,204][1080,331]']"));
			//Get the location of element on the app screen
			int x=e.getLocation().getX();
			int y=e.getLocation().getY();
			//Get width and height of the element
			int eleWidth=e.getSize().getWidth();
			int eleHeight=e.getSize().getHeight();
			//Get entire page screenshot
			File screenshot=driver.getScreenshotAs(OutputType.FILE);
			BufferedImage fullimg=ImageIO.read(screenshot);
			//crop the full screenshot to get element screenshot
			BufferedImage elescreenshot=fullimg.getSubimage(x, y, eleWidth, eleHeight);
			//check image color to validate
			for(int i=0;i<eleWidth;i++)
			{
				for(int j=0;j<eleHeight;j++)
				{
					Color ac=new Color(elescreenshot.getRGB(i, j));
					if(ac.getRed()==ec.getRed()&&ac.getBlue()==ec.getBlue()&&ac.getGreen()==ec.getGreen())
					{
						count=count+1;
					}
					
				}
			}
			System.out.println(count);
			percentage=(count*100)/(eleWidth*eleHeight);
			if(percentage>=85)
			{
				System.out.println("Test passed");
			}
			else
			{
				System.out.println("Test failed");
			}
			driver.closeApp();			
	}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
		//stop Appium server
		Runtime.getRuntime().exec("taskkill /F /IM node.exe");
		Runtime.getRuntime().exec("taskkill /F /IM cmd.exe");
	}
}
