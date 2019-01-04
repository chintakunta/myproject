package project;

import java.util.Scanner;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Test15windowcompatability 
{
	public static void main(String[] args) 
	{
		Scanner sc = new Scanner(System.in);
		System.out.println(" Enter browser name ");
		String x = sc.nextLine();
		WebDriver driver = null;
		if(x.equals("chrome"))
		{
			System.setProperty("webdriver.chrome.driver","E:\\testing tools\\mindq\\chromedriver.exe");
			driver = new ChromeDriver();
		}
		else if(x.equals("Firefox"))
		{
			System.setProperty("webdriver.gecko.driver","E:\\testing tools\\mindq\\geckodriver.exe");
			driver = new FirefoxDriver();
		}
		else
		{
			System.out.println("wrong browser name");
			//stop execution forcibilty
			System.exit(0);
		}
		driver.get("");

	}

}
