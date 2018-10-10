package all;

import java.io.File;
import java.io.IOException;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;
import jxl.write.Label;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;

public class Test2Excelsheet 
{
	public static void main(String[] args) throws Exception 
	{
		//open excel file for reading
		File f = new File("E:\\testingtools\\mindq\\Excel files\\Book1.xls");
		Workbook rwb=Workbook.getWorkbook(f);
		Sheet rsh=rwb.getSheet(0);//0 for sheet1
		int nour=rsh.getRows();
		int nouc=rsh.getColumns();
		//open same excel for writing
		WritableWorkbook wwb=Workbook.createWorkbook(f,rwb);
		WritableSheet wsh=wwb.getSheet(0);//0 for sheet1
		//Automation
		try
		{
			Date d=new Date();
			Label l1=new Label(nouc,0,"Result on"+d.toString());
			wsh.addCell(l1);
			//0th row have columns headings
			for(int i=1; i<nour;i++)
			{
				String x=rsh.getCell(0,i).getContents();
				//launch site
				System.setProperty("webdriver.chrome.driver","E:\\testingtools\\mindq\\chromedriver.exe");
				ChromeDriver driver = new ChromeDriver();
				driver.get("https://www.google.co.in");
				WebDriverWait w=new WebDriverWait(driver,20);
				w.until(ExpectedConditions.visibilityOfElementLocated(By.name("q")));
				//search word
				driver.manage().window().maximize();
				driver.findElement(By.name("q")).sendKeys(x,Keys.ENTER);
				//check title
				String y=driver.getTitle();
				if(y.contains(x))
				{
					Label l2=new Label(nouc,i,"Test Passed");
					wsh.addCell(l2);
				}
				else
				{
					File src=driver.getScreenshotAs(OutputType.FILE);
					File dest=new File("failed on "+d.toString()+".png");
					FileUtils.copyFile(src,dest);
					Label l3=new Label(nouc,i,"Test failed"+dest.getAbsolutePath());
					wsh.addCell(l3);
				}
				//close site
				driver.close();
			}
		}
		catch(Exception ex)
		{
			System.out.println(ex.getMessage());
		}
		//save and close excel file
		wwb.write();//save
		wwb.close();
		rwb.close();
	}

}
