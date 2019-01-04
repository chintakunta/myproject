package project;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

public class Test5gettext {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver","E:\\testing tools\\mindq\\chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://www.whatsapp.com/features/");
		//String x = driver.findElement(By.name("email")).getCssValue("text-indent");
		//System.out.println(x);
		String x=driver.findElement(By.xpath("//*[starts-with(text(),'Keep the')]")).getText();
		System.out.println(x);
		driver.close();
	}

}
