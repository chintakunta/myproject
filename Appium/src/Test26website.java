import java.io.IOException;
import java.net.URL;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.Select;

import io.appium.java_client.android.AndroidDriver;

public class Test26website 
{
	public static void main(String[] args) throws Exception 
	{
		//Get test Environment
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter Environment as computer/phone");
		String s=sc.nextLine();
		WebDriver driver=null;
		if(s.equalsIgnoreCase("computer"))
		{
			System.setProperty("webdriver.chrome.driver","E:\\testingtools\\mindq\\chromedriver.exe");
			driver= new ChromeDriver();
			driver.manage().window().maximize();
			}
		else
		{
			//provide device details
			DesiredCapabilities dc=new DesiredCapabilities();
			dc.setCapability(CapabilityType.BROWSER_NAME,"chrome");
			dc.setCapability("deviceName", "ZY2244H2P7");
			dc.setCapability("platformName", "android");
			dc.setCapability("platformVersion", "7.0");
			//start appium server
			Runtime.getRuntime().exec("cmd.exe /c start cmd.exe /K \"appium -a 0.0.0.0 -p 4723\"");
			URL u=new URL("http://0.0.0.0:4723/wd/hub");
			//create driver object
			while(2>1)
			{
				try
				{
					driver=new AndroidDriver(u,dc);
					break;
					
				}
				catch(Exception e)
				{
					
				}
			}
			
			}
		       //launch site
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		        driver.get("http://newtours.demoaut.com/");
		        driver.findElement(By.linkText("REGISTER")).click();
		        driver.findElement(By.name("firstName")).sendKeys("abdul");
		        driver.findElement(By.name("lastName")).sendKeys("kalam");
		        driver.findElement(By.name("phone")).sendKeys("9000624545");
		        driver.findElement(By.name("userName")).sendKeys("apjabdulkalam.com");
		        driver.findElement(By.name("address1")).sendKeys("MosqueStreet");
		        driver.findElement(By.name("address2")).sendKeys("MosqueStreet1");
		        driver.findElement(By.name("city")).sendKeys("rameswaram");
		        driver.findElement(By.name("state")).sendKeys("tamilnadu");
		        driver.findElement(By.name("postalCode")).sendKeys("600073");
		        Select s1 =new Select(driver.findElement(By.name("country")));
		        s1.selectByVisibleText("INDIA ");
		        driver.findElement(By.name("email")).sendKeys("abdulkalam11");
		        driver.findElement(By.name("password")).sendKeys("batch239sleepers");
		        driver.findElement(By.name("confirmPassword")).sendKeys("batch239sleepers");
		        driver.findElement(By.name("register")).click();
		        driver.close();
		  if(!s.equalsIgnoreCase("computer"))
		  {
			  //stop appium server\
			  Runtime.getRuntime().exec("taskkill /F /Im node.exe");
			  Runtime.getRuntime().exec("taskkill /F /Im cmd.exe");
			  
		  }
		        
		        
		        
		
		

	}

}
