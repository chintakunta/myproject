package all;

import java.io.File;
import java.io.IOException;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.bridj.cpp.com.OLEAutomationLibrary.DATE;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Mymethod 
{
	public WebDriver driver;
	public WebDriverWait wait;
	public String Launch(String e, String d, String c)
	{
		if(e.equals("chrome"))
		{
			System.setProperty("webdriver.chrome.driver", "E:\\testingtools\\mindq\\chromedriver.exe");
			driver=new ChromeDriver();
		}
		else if(e.equals("firefox"))
		{
			System.setProperty("webdriver.chrome.driver", "E:\\testingtools\\mindq\\geckodriver.exe");
			driver=new FirefoxDriver();
		}
		else
		{
			return("unknown Browser");
		}
		//open url from excel sheet
		driver.get(d);
		wait=new WebDriverWait(driver,20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@name='mobileNo']")));
		driver.manage().window().maximize();
		return("done");
	}
	public String fill(String e,String d,String c) throws Exception
	{
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(e)));
		driver.findElement(By.xpath(e)).sendKeys(d);
		return("done");
	}
	public String Click(String e,String d,String c) throws Exception
	{
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(e)));
		driver.findElement(By.xpath(e)).click();
		return("Done");
	}
	public String ValidateLogin(String e,String d,String c) throws Exception
	{
		try
		{
			if(c.equals("all_valid")&& driver.findElement(By.xpath("[//*[text()='Send SMS']")).isDisplayed())
			{
				return("passed");
			}
			else if (c.equals("mbno_blank")&& driver.findElement(By.xpath("//*[text()='Enter your mobile number']")).isDisplayed())
			{
				return("passed");
			}
			else if(c.equals("mbno_invalid")&& driver.findElement(By.xpath("//*[text()='Enter valid mobile number']")).isDisplayed())
			{
				return("passed");
			}
			else if(c.equals("pwd_blank")&& driver.findElement(By.xpath("//*[text()='Enter password']")).isDisplayed())
			{
				return("passed");
			}
			else if (c.equals("pwd_invalid")&& driver.findElement(By.xpath("(//*[contains(text(),'Try Again.')])[1]")).isDisplayed())
			{
				return("passed");
			}
			else
			{
				String temp=this.screenshot();
				return("Test Failed & goto"+temp+".png");
			}
		}
		catch(Exception ex)
		{
			String temp=this.screenshot();
			return("Test interupted & goto "+temp+".png");
		}
	}
		public String Closesite(String e,String d,String c) throws Exception
		{
			driver.close();
			return("done");
		}
		public String screenshot() throws Exception
		{
			Date dt=new Date();
			String ssname=dt.toString();
			File src=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			File dest=new File(ssname+".png");
			FileUtils.copyFile(src, dest);
			return(ssname);
			
		}
		
	}
	
	


