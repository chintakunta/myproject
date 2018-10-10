package all;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class Paralleltest {
	public WebDriver driver;
  @Test(priority=0)
  @Parameters({"browser"})
  public void launch(String e) throws Exception
  {
	  if(e.equals("chrome"))
	  {
		  System.setProperty("webdriver.chrome.driver","E:\\testingtools\\mindq\\chromedriver.exe");
		  driver = new ChromeDriver(); 
	  }
	  else if(e.equals("firefox"))
	  {
		  System.setProperty("webdriver.gecko.driver","E:\\testingtools\\mindq\\geckodriver.exe");
			driver = new FirefoxDriver();
	  }
	  else
	  {
		  Assert.assertTrue("unknown browser",false);
	  }
	  driver.get("https://www.google.co.in/");
	  Thread.sleep(5000);
  }
  @Test(priority=1,dependsOnMethods= {"launch"})
  @Parameters({"searchword"})
  public void search(String x) throws Exception
  {
	  driver.findElement(By.name("q")).sendKeys(x,Keys.ENTER);
	  Thread.sleep(5000);
  }
  @Test(priority=2,dependsOnMethods= {"search"})
  public void close()
  {
	  driver.close();
  }
}











