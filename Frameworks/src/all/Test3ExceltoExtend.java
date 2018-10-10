package all;

import java.io.File;

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

import jxl.Sheet;
import jxl.Workbook;

public class Test3ExceltoExtend 
{
	public static void main(String[] args) throws Exception
	{
		//open Excel file for reading using "JXL"
		File f=new File("E:\\testingtools\\mindq\\Excel files\\Book2.xls");
		Workbook rwb=Workbook.getWorkbook(f);
		Sheet rsh=rwb.getSheet(0); //0 for sheet1
		int nour=rsh.getRows();
		//create result file using extend reports
		ExtentReports er=new ExtentReports("googlettress.html",false);//false to append result
		ExtentTest et=er.startTest("Google title test");
		//Automation
		try 
		{
			//0th row have column headings
			for(int i=1;i<nour;i++)
			{
				String x=rsh.getCell(0,i).getContents();
				//Launch site
				System.setProperty("webdriver.chrome.driver","E:\\testingtools\\mindq\\chromedriver.exe");
				ChromeDriver driver = new ChromeDriver();
				driver.get("https://www.google.co.in");
				WebDriverWait wait=new WebDriverWait(driver,20);
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("q")));
				//search word
				driver.manage().window().maximize();
				driver.findElement(By.name("q")).sendKeys(x,Keys.ENTER);
				//check title
				String y=driver.getTitle();
				if(y.contains(x))
				{
					et.log(LogStatus.PASS, "Title Test Pass");
				}
				else
				{
					File src=driver.getScreenshotAs(OutputType.FILE);
					File dest=new File("Failscr"+ i +".png");
					FileUtils.copyFile(src,dest);
					et.log(LogStatus.FAIL, "Title Test Failed");
					et.log(LogStatus.FAIL, et.addScreenCapture("Failscr"+ i +".png"));					
				}
				//close site
				driver.close();
			}
		}
		catch(Exception ex)
		{
			System.out.println(ex.getMessage());
		}
		//save and result
		er.endTest(et);
		er.flush();
		rwb.close();
	}
}