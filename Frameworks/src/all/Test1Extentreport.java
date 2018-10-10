package all;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class Test1Extentreport 
{
	public static void main(String[] args) throws Exception 
	{
		//Get input word		
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter any word");
		String x=sc.nextLine();
		//create result file using extent reports
		ExtentReports er=new ExtentReports("googleres.html",false);
		ExtentTest et=er.startTest("Google title test");
		//Launch site
		System.setProperty("webdriver.chrome.driver","E:\\testingtools\\mindq\\chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://www.google.co.in");
		WebDriverWait wait=new WebDriverWait(driver,20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("q")));
		//search for word
		driver.findElement(By.name("q")).sendKeys(x,Keys.ENTER);
		//check title
		String y=driver.getTitle();
		if(!y.contains(x))
		{
			File src=driver.getScreenshotAs(OutputType.FILE);
			File dest =new File("passscr.png");
			FileUtils.copyFile(src, dest);
			et.log(LogStatus.PASS, "Title Test Passed");
			et.log(LogStatus.PASS, et.addScreenCapture("passscr.png"));
		}
		else
		{
			File src=driver.getScreenshotAs(OutputType.FILE);
			File dest=new File("failsrc.png");
			et.log(LogStatus.FAIL, "Title Test Failed");
			et.log(LogStatus.FAIL, et.addScreenCapture("Failscr.png"));
		}
		//close site 
		driver.close();
		er.endTest(et);
		er.flush();
		
		
		
		}

}
