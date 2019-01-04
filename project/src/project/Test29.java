package project;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Test29 {

	public static void main(String[] args) throws InterruptedException {
				Scanner sc = new Scanner(System.in);
		System.out.println("No: items to select");
		int n = Integer.parseInt(sc.nextLine());
		ArrayList<String> inputList = new ArrayList<String>();
		System.out.println("Enter items to be selected");
		Thread.sleep(10000);
		// launch site
				System.setProperty("webdriver.chrome.driver", "E:\\testing tools\\mindq\\chromedriver.exe");
				ChromeDriver driver = new ChromeDriver();
				driver.get("https://semantic-ui.com/modules/dropdown.html");
				Thread.sleep(5000);

		// OPEN DROP DOWN BY CLICKING
		WebElement e = driver.findElement(By.xpath("//*[@class='ui fluid dropdown selection multiple']"));
		Actions a = new Actions(driver);
		a.click(e).build().perform();
		Thread.sleep(5000);
		// COLLECT ITEMS IN DROP DOWN
		List<WebElement> list = driver.findElements(By.xpath("//*[@class='menu transition visible']/div"));
		
		for (int i = 0; i < n; i++) {
			inputList.add(sc.nextLine());
		}

		for (int loop = 0; loop < inputList.size(); loop++) {
			for (int i = 0; i < list.size(); i++) {
				String x = list.get(i).getAttribute("data-value");
				if (x.equalsIgnoreCase(inputList.get(loop))) 
				{
					a.sendKeys(Keys.ENTER).build().perform();
					System.out.println(x);
					break;
				}
			}
		}
		Thread.sleep(5000);
		sc.close();
		System.out.println("End");
	}
}
