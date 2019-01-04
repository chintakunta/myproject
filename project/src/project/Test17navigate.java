package project;

import org.openqa.selenium.firefox.FirefoxDriver;

public class Test17navigate 
{
	public static void main(String[] args) throws InterruptedException 
	{
		//launch site
				System.setProperty("webdriver.gecko.driver","E:\\testingtools\\mindq\\geckodriver.exe");
				FirefoxDriver driver = new FirefoxDriver();
				//open website
				driver.get("https://www.irctc.co.in/eticketing/loginHome.jsf");
				Thread.sleep(5000);
				//open new page in same tab
				driver.navigate().to("https://www.google.co.in/");
				Thread.sleep(5000);
				//tours pager 
				driver.navigate().back();
				Thread.sleep(5000);
				//google page
				driver.navigate().forward();
				Thread.sleep(5000);
				//google page
				driver.navigate().refresh();
				Thread.sleep(5000);
				driver.close();
				
				
				
	}

}
