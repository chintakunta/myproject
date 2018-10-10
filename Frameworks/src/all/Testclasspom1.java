package all;

import java.io.File;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import jxl.Sheet;
import jxl.Workbook;

public class Testclasspom1 
{
	public static void main(String[] args) throws Exception, Exception 
	{
		//open Excel file for reading using "JXL"
				File f=new File("E:\\testingtools\\mindq\\Excel files\\Testdatafile.xls");
				Workbook rwb=Workbook.getWorkbook(f);
				Sheet rsh=rwb.getSheet(0); //0 for sheet1
				int nour=rsh.getRows();
				//create result file using extend reports
				ExtentReports er=new ExtentReports("Gmailtest.html",false);//false to append result
				ExtentTest et=er.startTest("Gmail page test");
				//Automation
				try
				{
				//DDT for 2nd row(index 1)
				for(int i=1;i<nour;i++)
				{
					String bro=rsh.getCell(0,i).getContents();
					String uid=rsh.getCell(1,i).getContents();
					String uidcri=rsh.getCell(2,i).getContents();
					String pwd=rsh.getCell(3,i).getContents();
					String pwdcrit=rsh.getCell(4,i).getContents();
				WebDriver driver = null;
				if(bro.equals("chrome"))
				{
					System.setProperty("webdriver.chrome.driver","E:\\testingtools\\mindq\\chromedriver.exe");
					driver = new ChromeDriver();
				}
				else if(bro.equals("Firefox"))
				{
					System.setProperty("webdriver.gecko.driver","E:\\testingtools\\mindq\\geckodriver.exe");
					driver = new FirefoxDriver();
				}
				else
				{
					et.log(LogStatus.SKIP, "wrong browser name");
					//close and save excel
					rwb.close();
					//save and close extent report
					er.endTest(et);
					er.flush();
					//stop execution forcibilty
					System.exit(0);
				}
				//create objects to pages class
				Pageclass1pomuid p1uid=new Pageclass1pomuid(driver);
				Pageclass2pompwd p2pwd=new Pageclass2pompwd(driver);
				Pageclass3pomcompose p3comp=new Pageclass3pomcompose(driver);
				//launch site
				driver.get("http://www.gmail.com");
				WebDriverWait w=new WebDriverWait(driver,50);
				w.until(ExpectedConditions.visibilityOf(p1uid.uid));
				driver.manage().window().maximize();
				driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
				//Do login
				p1uid.filluid(uid);
				p1uid.clickuidnext();
				Thread.sleep(10000);
				//Uid Testing
				try
				{
					if(uid.length()==0 && driver.findElement(By.xpath("//*[contains(text(),'Enter an email')]")).isDisplayed())
					{
						et.log(LogStatus.PASS, "Blank uid test passed");
					}
					else if(uidcri.equals("invalid") && driver.findElement(By.xpath("(//*[contains(text() , 'find your Google Account')])[2]")).isDisplayed())
					{
						et.log(LogStatus.PASS, "Invalid uid test passed");
					}
					else if(uidcri.equals("valid") && p2pwd.pwd.isDisplayed())
					{
						et.log(LogStatus.PASS, "valid uid test passed");
						//password testing
						p2pwd.fillpwd(pwd);
						p2pwd.clickpwdnext();
						Thread.sleep(10000);
						try
						{
							if(pwd.length()==0 && driver.findElement(By.xpath("//*[text()='Enter a password']")).isDisplayed())
							{
								et.log(LogStatus.PASS, "Blank pwd test passed");
							}
							else if(pwdcrit.equals("invalid") && driver.findElement(By.xpath("//*[contains(text(),'Wrong password')]")).isDisplayed())
							{
								et.log(LogStatus.PASS, "invalid pwd test passed");
							}
							else if(pwd.equals("valid") && p3comp.comp.isDisplayed())
							{
								et.log(LogStatus.PASS, "valid pwd test passed");
								//Do logout
								Thread.sleep(10000);
								p3comp.clickprofile();
								w.until(ExpectedConditions.visibilityOf(p3comp.signout));
								p3comp.clicksignout();
								Thread.sleep(5000);
							}
							else
							{
//								File src=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
//								File dest=new File("gmailss3.png");
//								FileUtils.copyFile(src, dest);
//								et.log(LogStatus.FAIL, "pwd test failed"+ et.addScreenCapture("gmailss3.png"));
							}
						}
						catch(Exception ex2)
						{
							File src=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
							File dest=new File("gmailss4.png");
							FileUtils.copyFile(src, dest);
							et.log(LogStatus.ERROR, "pwd test interrupted"+et.addScreenCapture("gmailss4.png"));
						}
					}
					else
					{
						File src=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
						File dest=new File("gmailss1.png");
						FileUtils.copyFile(src, dest);
						et.log(LogStatus.FAIL, "uid test failed "+et.addScreenCapture("gmailss1.png"));
					}
				}
				catch(Exception ex)
				{
					File src=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
					File dest=new File("gmailss2.png");
					FileUtils.copyFile(src, dest);
					et.log(LogStatus.ERROR, "uid test interrupted"+et.addScreenCapture("gmailss2.png"));
				}
				//close site 
				driver.close();
				}//loop closing
				}
				catch(Exception ex)
				{
					et.log(LogStatus.ERROR, ex.getMessage());
				}
				//save and close excel
				rwb.close();
				//save and close extend reports
				er.endTest(et);
				er.flush();				
	}

}
