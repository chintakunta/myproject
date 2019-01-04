package project;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

public class Test4maxlength {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver","E:\\testing tools\\mindq\\chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();
		driver.get("http://www.google.co.in");
		String x = driver.findElement(By.name("q")).getAttribute("maxlength");
		System.out.println(x);
		driver.close();
	}

}
