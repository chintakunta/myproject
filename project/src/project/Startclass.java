package project;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Startclass 
{
	public static void main(String[] args) 
	{
		System.setProperty("webdriver.chrome.driver","E:\\testing tools\\mindq\\chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();
		driver.get("http://www.google.co.in");
		driver.findElement(By.name("q")).sendKeys("new tours demoaut",Keys.TAB,Keys.ENTER);
		driver.findElement(By.linkText("Mercury Tours - Demoaut.com")).click();
		driver.findElement(By.linkText("REGISTER")).click();
		driver.findElement(By.name("firstName")).sendKeys("kirankumarreddy",Keys.TAB,"c",Keys.TAB,"7207519505",Keys.TAB,"reddy.kumar22@gmail.com",Keys.TAB,"hyderabad",Keys.TAB,"ts",Keys.TAB,"hyd",Keys.TAB,"ts",Keys.TAB,"500048");
		//sdriver.findElement(By.name("firstName")).clear();
		Select s = new Select(driver.findElement(By.name("country")));
		s.selectByIndex(107);

	}

}
