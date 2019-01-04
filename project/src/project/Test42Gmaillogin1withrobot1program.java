package project;

import java.awt.HeadlessException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.StringSelection;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Test42Gmaillogin1withrobot1program {

	public static void main(String[] args) throws Exception {
		System.setProperty("webdriver.chrome.driver","E:\\testing tools\\mindq\\chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://www.gmail.com");
		driver.manage().window().maximize(); 
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElement(By.name("identifier")).sendKeys("reddy.kumar22@gmail.com");
		driver.findElement(By.xpath("//*[text()='Next']")).click();
		driver.findElement(By.name("password")).sendKeys("Sivareddy");
		WebDriverWait e=new WebDriverWait(driver,30);
		e.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[text()='Next']")));
		driver.findElement(By.xpath("//*[text()='Next']")).click();
		//click compose
		e.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[text()='COMPOSE']")));
		driver.findElement(By.xpath("//*[text()='COMPOSE']")).click();
		//fill fields(SWD)
		driver.findElement(By.name("to")).sendKeys("chintakuntakirankumarreddy@gmail.com");
		driver.findElement(By.name("subjectbox")).sendKeys("Have a great day");
		driver.findElement(By.xpath("(//*[@aria-label='Message Body'])[2]")).sendKeys("Hi kiran,\nhow r u,\nwhere are you now");
		driver.findElement(By.xpath("//*[@aria-label='Attach files']/descendant::*[3]")).click();
		StringSelection x=new StringSelection("E:\\english movies\\New KIRAN Resume .docx");
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(x, null);
		Robot r= new Robot();
		String  y=(String) Toolkit.getDefaultToolkit().getSystemClipboard().getData(DataFlavor.stringFlavor);
		Thread.sleep(2000);
		r.keyPress(KeyEvent.VK_CONTROL);
		r.keyPress(KeyEvent.VK_V);
		r.keyRelease(KeyEvent.VK_V);
		r.keyRelease(KeyEvent.VK_CONTROL);
		r.keyPress(KeyEvent.VK_ENTER);
		r.keyRelease(KeyEvent.VK_ENTER);
		Thread.sleep(1000);
		System.out.println(y);
		//send mail(SWD)
		e.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//*[@class='dQ']")));
		driver.findElement(By.xpath("//*[text()='Send']")).click();
		e.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//*[@aria-live='assertive'])[3]/descendant::*[3]")));
		String xy=driver.findElement(By.xpath("(//*[@aria-live='assertive'])[3]/descendant::*[3]")).getText();
		System.out.println(xy);
		//Do logout
		//e.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//*[@aria-live='assertive'])[3]/descendant::*[3]")));
		driver.findElement(By.xpath("//*[contains(@title,'Google Account')]/span")).click();
		//e.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Sign out")));
		driver.findElement(By.linkText("Sign out")).click();
		//close site
		driver.close();		
	}

}
