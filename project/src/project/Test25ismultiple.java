package project;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Test25ismultiple 
{
	public static void main(String[] args) throws InterruptedException 
	{
		System.setProperty("webdriver.chrome.driver","E:\\testing tools\\mindq\\chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://www.w3schools.com/tags/tryit.asp?filename=tryhtml_select_multiple");
		Thread.sleep(5000);
		driver.switchTo().frame("iframeResult");
	    WebElement e=driver.findElement(By.name("cars"));
	    Select s=new Select(e);
	    if(s.isMultiple())
	    {
	    System.out.println("MULTISELECT");
	    }
	    else
	    {
	    System.out.println("SINGLESELECT");
	    }
	    driver.switchTo().defaultContent();
	    driver.close();
		/*WebElement e= driver.findElement(By.name("cars")); 
		Select s= new Select(e);
		Actions a = new Actions(driver);
		a.sendKeys(Keys.CONTROL).click();
		/*Actions a= new Actions(driver);
		WebElement e1=driver.findElement(By.xpath("//*[text()='Volvo']"));
		WebElement e2=driver.findElement(By.xpath("//*[text()='Audi']"));
		a.click(e1).build().perform();
		a.click(e2).build().perform();*/
		/*if(s.isMultiple())
		{
			System.out.println("Multiple select");
		}
		else
		{
			System.out.print("single select");
		}*/
	

	}

}
