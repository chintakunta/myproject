import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;

public class Test13aicolor {

	public static void main(String[] args) throws Exception {
		/*DesiredCapabilities dc= new DesiredCapabilities();
		dc.setCapability(CapabilityType.BROWSER_NAME,""); 
		dc.setCapability("deviceName", "ZY2244H2P7");
		dc.setCapability("platformName", "android");
		dc.setCapability("platformVersion", "7.0");
		dc.setCapability("locationservicesEnabled", true);
		dc.setCapability("locationservicersAuthorizer", true);
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
		}*/
		int count=0;
		float percentage;
		Color ec=Color.GREEN;//expected color(R-255,G-255,B-255)
		File f=new File("E:\\testingtools\\mindq\\RGB.Png");
		BufferedImage fulling=ImageIO.read(f);
		//check image color pixel by pixel
		int w =fulling.getWidth();
		int h =fulling.getHeight();
		for(int i=0;i<w;i++)
		{
			for(int j=0;j<h;j++)
			{
				Color ac=new Color(fulling.getRGB(i,j));
				if(ac.getRed() == ec.getRed() && ac.getGreen() == ec.getGreen() && ac.getBlue() == ec.getBlue())
				{
					count=count+1;
				}
				
			}
		}
		System.out.println(" Total pixels is " + (w*h));
		System.out.println("Expected color pixels count: " + count);
		percentage=(count*100)/(w*h);
		System.out.println(percentage);
		

	}

}
