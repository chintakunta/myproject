package project;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Test37
{

	public static void main(String[] args) throws Exception
	{
	//launch site 
	System.setProperty("webdriver.chrome.driver","E:\\testing tools\\mindq\\chromedriver.exe");
	ChromeDriver driver = new ChromeDriver();
	driver.get("https://www.google.co.in");
	driver.findElement(By.name("q")).sendKeys("kalam");
     Thread.sleep(5000);
     Actions a=new Actions(driver);
     int c=0;
    /* for(int i=1;i<=5;i++)
     {
    	 a.sendKeys(Keys.DOWN).build().perform();
    	 Thread.sleep(5000);
    	 a.sendKeys(Keys.ENTER).build().perform();*/
    	 
    	 //infinite loop
    	 
    	 
    	 while(2>1)
    	 {
    		 String x=driver.findElement(By.name("q")).getAttribute("value");
    		 if(x.equals("kalamandir"))
    		 {
    			 a.sendKeys(Keys.ENTER).build().perform();
    			 break;
    		 }
    		 else
    		 {
    			 a.sendKeys(Keys.DOWN).build().perform();
    			 c=c+1;
    			 if(c>10)
    			 {
    				 a.sendKeys(Keys.ESCAPE).build().perform();
    				 break;
    			 }
    			 Thread.sleep(5000);
    			 }
    			 }
    			 
    		 }
    	 }
     