package all;
import java.io.File;
import java.net.URL;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.android.AndroidDriver;
import jxl.Sheet;
import jxl.Workbook;
import jxl.write.Label;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
public class Test6mobiletesting 
{
	public static void main(String[] args) throws Exception 
	{
		//open excel file for reading
		File f = new File("E:\\testingtools\\mindq\\Excel files\\Book4.xls");
		Workbook rwb=Workbook.getWorkbook(f);
		Sheet rsh=rwb.getSheet(0);//0 for sheet1
		int nour=rsh.getRows();
		int nouc=rsh.getColumns();
		//open same excel for writing
		WritableWorkbook wwb=Workbook.createWorkbook(f,rwb);
		WritableSheet wsh=wwb.getSheet(0);//0 for sheet1
		//Details of mobile 
		DesiredCapabilities dc= new DesiredCapabilities();
		dc.setCapability(CapabilityType.BROWSER_NAME,"chrome"); 
		dc.setCapability("deviceName", "ZY2244H2P7");
		dc.setCapability("platformName", "android");
		dc.setCapability("platformVersion", "7.0");
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
		   try
		   {
			   Date d=new Date();
				Label l1=new Label(nouc,0,"Result on"+d.toString());
				wsh.addCell(l1);
			   for(int i=1; i<nour;i++)
				{
					String x=rsh.getCell(0,i).getContents();
					//launch site
		       driver.get("https://www.google.co.in");
		       //driver.context("NATIVE_APP");
		       //driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		       WebDriverWait w=new WebDriverWait(driver,20);
		       w.until(ExpectedConditions.visibilityOfElementLocated(By.name("q")));
		       //search word
		       //driver.manage().window().maximize();
		       driver.findElement(By.name("q")).sendKeys(x,Keys.ENTER);
		       //check title
		       String y=driver.getTitle();
		       if(y.contains(x))
		       {
		    	   Label l2=new Label(nouc,i,"Test Passed");
		    	   wsh.addCell(l2);
		       }
		       else
				{
					File src=driver.getScreenshotAs(OutputType.FILE);
					File dest=new File("failed on "+d.toString()+".png");
					FileUtils.copyFile(src,dest);
					Label l3=new Label(nouc,i,"Test failed"+dest.getAbsolutePath());
					wsh.addCell(l3);
				}
			       }
		        }
			   	catch(Exception ex)
			   	{
			   		System.out.println(ex.getMessage());
			   	}
		   driver.closeApp();
		   //save and close excel file
			wwb.write();//save
			wwb.close();
			rwb.close();
		    //stop appium server
			Runtime.getRuntime().exec("taskkill /F /IM node.exe");
			Runtime.getRuntime().exec("taskkill /F /IM cmd.exe");
	}
}
