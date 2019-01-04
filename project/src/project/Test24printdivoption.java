package project;



import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Test24printdivoption {

	public static void main(String[] args) throws Exception  {
		//Launch site 
				System.setProperty("webdriver.chrome.driver","E:\\testing tools\\mindq\\chromedriver.exe");
				ChromeDriver driver = new ChromeDriver();
				 driver.get("https://semantic-ui.com/modules/dropdown.html");
				 	Thread.sleep(5000);
				 	//OPEN DROP DOWN BY CLICKING
				       WebElement e=driver.findElement(By.xpath("//*[text()='Select Friend']"));
				       Actions a=new Actions(driver);
				       a.click(e).build().perform();
				       Thread.sleep(5000);
				      //COLLECT ITEMS IN DROP DOWN
				       List<WebElement> il=driver.findElements(By.xpath("//*[@class='menu transition visible']/div"));
				       for(int i=0;i<=il.size();i++)
				       {
				       	String x=il.get(i).getAttribute("data-value");
				       	System.out.println(x);
				       	Thread.sleep(5000);
				       }
				       	driver.close();
				/*driver.get("https://semantic-ui.com/modules/dropdown.html");
				Thread.sleep(5000);
				//open drop-down by clicking
				WebElement e=driver.findElement(By.xpath("//*[text()='Select Friend']"));
				Actions a=new Actions(driver);
				a.click(e).build().perform();
				Thread.sleep(5000);
				//collection items in drop-down
                List<WebElement> l=driver.findElements(By.xpath("//*[@class='menu transition visible']/div"));
                for(int i=0;i<l.size();i++)
                {
                	String x=l.get(i).getAttribute("data-value");
                	System.out.println(x);
                }*/
                //close site
                //driver.close();
                
                
                
                
                
                
        
                
				//close sit
				//Thread.sleep(2000);
				//driver.close();
	
	}

}
