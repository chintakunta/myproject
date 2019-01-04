package project;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Test40 
{
	public static void main(String[] args) 
	{
		//launch site
		System.setProperty("webdriver.chrome.driver","E:\\testing tools\\mindq\\chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://www.w3schools.com/css/css_tooltip.asp");
		driver.manage().window().maximize();
		WebDriverWait w= new WebDriverWait(driver,10);
		//Get tool-tip via title attribute
		WebElement e1=driver.findElement(By.linkText("JAVASCRIPT"));
		w.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("JAVASCRIPT")));
		String x = e1.getAttribute("title");
		System.out.println(x);
		//scroll page to specific element
		JavascriptExecutor js= (JavascriptExecutor)driver;
		WebElement e2 = driver.findElement(By.xpath("//*[text()='Demo: Tooltip Examples']"));
		js.executeScript("arguments[0].scrollIntoView();",e2);
		//Move mouse pointer to elements for tool-tip visibility
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		WebElement e3=driver.findElement(By.xpath("(//*[@class='tooltip'])[1]"));
		Actions a =new Actions(driver);
		a.moveToElement(e3).clickAndHold().build().perform();
		WebElement e4 = driver.findElement(By.xpath("(//*[@class='tooltip'])[1]/span"));
		String y=e4.getText();
		System.out.println(y);
		a.release().build().perform();
		//close site
		driver.close();
		
	}

}
