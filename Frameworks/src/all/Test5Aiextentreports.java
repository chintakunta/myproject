package all;

import java.io.File;
import java.util.Locale;
import javax.speech.Central;
import javax.speech.synthesis.Synthesizer;
import javax.speech.synthesis.SynthesizerModeDesc;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import jxl.Sheet;
import jxl.Workbook;

public class Test5Aiextentreports 
{
	public static void main(String[] args) throws Exception  
	{
		//get data to be search as voice in google site
		//open Excel file for reading using "JXL"
				File f=new File("E:\\testingtools\\mindq\\Excel files\\Book3.xls");
				Workbook rwb=Workbook.getWorkbook(f);
				Sheet rsh=rwb.getSheet(0); //0 for sheet1
				int nour=rsh.getRows();
				//create result file using extend reports
				ExtentReports er=new ExtentReports("googlettress1.html",false);//false to append result
				ExtentTest et=er.startTest("Google title test");
				try
				{
				for(int i=1;i<nour;i++)
				{
					String x=rsh.getCell(0,i).getContents();
				//Launch google site
				System.setProperty("webdriver.chrome.driver","E:\\testingtools\\mindq\\chromedriver.exe");
				ChromeOptions co=new ChromeOptions();
				co.addArguments("--use-fake-ui-for-media-stream=1");
				ChromeDriver driver=new ChromeDriver(co);
				driver.get("https://www.google.co.in/");
				WebDriverWait wait=new WebDriverWait(driver,20);
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='gsri_ok0']")));
				driver.manage().window().maximize();
				driver.findElement(By.xpath("//*[@id='gsri_ok0']")).click();
				Thread.sleep(1500);
				//set property as kevin dictionary (or) voicerss
						System.setProperty("freetts.voices", "com.sun.speech.freetts.en.us.cmu_us_kal.KevinVoiceDirectory");
						//Register Engine
						Central.registerEngineCentral("com.sun.speech.freetts.jsapi.FreeTTSEngineCentral");
						//create a synthesizer
						Synthesizer synthesizer=Central.createSynthesizer(new SynthesizerModeDesc(Locale.US));
						//Allocate synthesizer
						synthesizer.allocate();
						//resume synthesizer
						synthesizer.resume();
						//speaks the given text until queue in empty
						synthesizer.speakPlainText(x, null);
						synthesizer.waitEngineState(Synthesizer.QUEUE_EMPTY);
						//deallocate the synthesizer
						synthesizer.deallocate();
						//validate result
						wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='rhscol']")));
						String y =driver.getTitle();
						x=x.toLowerCase();
						y=y.toLowerCase();
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
						Thread.sleep(5000);
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
