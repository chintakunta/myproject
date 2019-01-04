package project;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Test38explicitywait 
{
	public static void main(String[] args)
	{
		//launch site
		System.setProperty("webdriver.chrome.driver","E:\\testing tools\\mindq\\chromedriver.exe");
		ChromeDriver driver=new ChromeDriver();
		driver.get("https://demos.telerik.com/aspnet-ajax/ajaxloadingpanel/functionality/explicit-show-hide/defaultcs.aspx");
		WebDriverWait w= new WebDriverWait (driver,10);
		w.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@class='rcMainTable']")));
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		
		//click link and wait for completion of operation
		
		driver.findElement(By.linkText("25")).click();
		w.until(ExpectedConditions.invisibilityOfElementLocated(By.className("raDiv")));
		driver.close();
	}

}
