package project;

import org.openqa.selenium.chrome.ChromeDriver;

public class Test2gettitle {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver","E:\\testing tools\\mindq\\chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://www.facebook.com/");
		String x = driver.getTitle();
		System.out.println(x);
		String y = driver.getPageSource();
		System.out.println(y);
		driver.close();
	}

}
