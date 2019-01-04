package project;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Test36autocompletjavascript {

	public static void main(String[] args) throws InterruptedException 
	{
		//launch site 
		System.setProperty("webdriver.chrome.driver","E:\\testing tools\\mindq\\chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://www.google.co.in");
		driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
		//Thread.sleep(5000);
		//driver.findElement(By.name("q")).sendKeys("kalam");
	    //fill text box
		 WebDriverWait w=new WebDriverWait(driver,100);
		 w.until(ExpectedConditions.visibilityOfElementLocated(By.name("q")));
	    driver.findElement(By.name("q")).sendKeys("ashok");
	   
	    //get options visible in auto-complete/cache
	    List<WebElement> l=driver.findElements(By.xpath("//*[@role='presentation']/div/div[2]"));
	    //Thread.sleep(5000);
	   
	    System.out.println(l.size());
	    for(int i=0;i<l.size();i++)
	    {
	    	
	    	JavascriptExecutor js=(JavascriptExecutor) driver;
	    	js.executeScript("var v=arguments[0].textContent;alert(v);", l.get(i));
	    	String x=driver.switchTo().alert().getText();
	    	//Thread.sleep(2000);
	    	driver.switchTo().alert().dismiss();
	    	System.out.println(x);
	    	if(x.equals("ashoka university"))
	    	{
	    		driver.findElement(By.name("q")).clear();
	    		driver.findElement(By.name("q")).sendKeys(x);
	    		Actions a =new Actions(driver);
		    	a.sendKeys(Keys.ENTER).build().perform();
	    		break;//terminate from loop
	    	}
	    	
	    }
	    //close site
	    //driver.close();
	    	}
}
