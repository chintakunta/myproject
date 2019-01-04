package project;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Test32 
{

	public static void main(String[] args) throws InterruptedException 
	{
		//launch site
				System.setProperty("webdriver.chrome.driver","E:\\testing tools\\mindq\\chromedriver.exe");
				ChromeDriver driver = new ChromeDriver();
				driver.get("https://semantic-ui.com/modules/dropdown.html");
				driver.manage().window().maximize();
				Thread.sleep(5000);
				//scroll to botton
				JavascriptExecutor js=(JavascriptExecutor)driver;
				js.executeScript("window.scrollTo(0,document.body.scrollHeight);");
			    Thread.sleep(5000);
			    //scroll to top
			    js.executeScript("window.scrollTo(document.body.scrollHeight,0);");
			    Thread.sleep(5000);
			    //scroll to specific elementin page
			    WebElement e= driver.findElement(By.xpath("(//*[text()='Select Country'])[2]"));
			    js.executeScript("arguments[0].scrollIntoView();", e);
			    Thread.sleep(5000);
			    //js.executeScript("arguments[0].style.border='2px dotted blue';", e);
			    
			    //close site
			    driver.close();
			    
				

	}

}
