package project;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Test18windowsize 
{
	public static void main(String[] args) throws InterruptedException 
	{
		System.setProperty("webdriver.gecko.driver","E:\\testing tools\\mindq\\geckodriver.exe");
		FirefoxDriver driver = new FirefoxDriver();
		//open website
		driver.get("https://www.irctc.co.in/eticketing/loginHome.jsf");
		Thread.sleep(5000);
		// maximize
		driver.manage().window().maximize();
		Thread.sleep(5000);
		// get size
		int w = driver.manage().window().getSize().getWidth();
		int h = driver.manage().window().getSize().getHeight();
		System.out.println(w+"  "+h);
		//set size width & height
		Dimension d = new Dimension(100,200);
		driver.manage().window().setSize(d);
		Thread.sleep(5000);
		//get position
		int x=driver.manage().window().getPosition().getX();
		int y= driver.manage().window().getPosition().getY();
		System.out.println(x+ "   "+y);
		//set position of x,y
		Point p = new Point(100,400);
		driver.manage().window().setPosition(p);
		Thread.sleep(5000);
		//close site
		driver.close();

	}

}
