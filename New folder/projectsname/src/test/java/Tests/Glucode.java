package Tests;

import java.io.FileInputStream;
import java.util.List;
import java.util.Properties;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import cucumber.api.DataTable;
import cucumber.api.Scenario;
import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import pages.Homepage;
import pages.Sendsmspage;

public class Glucode 
{
	public WebDriver driver;
	public WebDriverWait wait;
	public Homepage hp;
	public Sendsmspage sp;
	public Scenario s;
	public Properties pro;
	
	@Before
	public void method1(Scenario s) throws Exception
    {
		//use scenario object for current scenario
		this.s=s;
		//Load properties file for current scenario
		pro=new Properties();
		FileInputStream fip=new FileInputStream("E:\\testing tools\\mindq\\projectsname\\src\\test\\resources\\kiran\\propertie1.properties");
		pro.load(fip);
    }
	@Given("^launch site using\"(.*)\"$")
	public void method2(String b)
	{
		//open Browser for current scenario
		if(b.equals("chrome"))
		{
			System.setProperty("webdriver.chrome.driver", pro.getProperty("cdriver"));
			driver=new ChromeDriver();
		}
		else if(b.equals("firefox"))
		{
			System.setProperty("webdriver.gecko.driver", pro.getProperty("ffdriver"));
			driver=new FirefoxDriver();
		}
		else
		{
			System.out.println("Wrong Browser");
		}
		//create object for pages classes for current scenario
		hp=new Homepage(driver);
		sp=new Sendsmspage(driver);
		//open site
		driver.get(pro.getProperty("url"));
		wait =new WebDriverWait(driver,20);
		wait.until(ExpectedConditions.visibilityOf(hp.mbno));
		driver.manage().window().maximize();
	}
	@Then ("^title contains\"(.*)\"$")
	public void method3(String a)
	{
		wait.until(ExpectedConditions.visibilityOf(hp.mbno));
		String t=driver.getTitle();
		if(t.contains(a))
		{
			s.write("Title test pass");
		}
		else
		{
			byte ssbytes[]=((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
			s.embed(ssbytes, "title test failed");
			Assert.fail();
		}
	}
	@And("^close site$")
	public void method4()
	{
		driver.close();		
	}
	@When("^enter mobile number as\"(.*)\"$")
	public void method5(String u)
	{
		wait.until(ExpectedConditions.visibilityOf(hp.mbno));
		hp.fillmbno(u);
	}
	@And("^enter password as\"(.*)\"$")
	public void method6(String p)
	{
		wait.until(ExpectedConditions.visibilityOf(hp.pwd));
		hp.fillpwd(p);
	}
	@And("^click login$")
	public void method7()
	{
		wait.until(ExpectedConditions.visibilityOf(hp.signin));
		hp.clicksignin();
	}
	@Then("^validate output for criteria\"(.*)\"$")
	public void method8(String c) throws Exception
	{
		//wait.until(temp->((JavascriptExecutor)driver).executeScript("return document.ready state").equals("complete"));
		Thread.sleep(5000);
		try
		{
			if(c.equals("all_valid")&& sp.sendsms.isDisplayed())
			{
				s.write("Test passed for vaild data");
			}
			else if(c.equals("all_valid")&& driver.findElement(By.xpath("//*[@href='send-sms'][@class='active']/span")).isDisplayed())
			{
				s.write("Test passed for valid data");
			}
			else if(c.equals("mbno_blank")&& hp.mbno_blank_err.isDisplayed())
			{
				s.write("Test passer for blank mobile number");
			}
			else if(c.equals("pwd_blank")&& hp.pwd_blank_err.isDisplayed())
			{
				s.write("Test passed for blank password ");
			}
			else if(c.equals("mbno_invalid")&& hp.mbno_invalid_err.isDisplayed())
			{
				s.write("Test passed for invalid mobile number");
			}
			else if(c.equals("pwd_invalid")&& hp.pwd_invalid_err.isDisplayed())
			{
				s.write("Test passed for invalid password");
			}
			else 
			{
				byte ssbytes[]=((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
				s.embed(ssbytes, "Login test failed");
				Assert.fail();
			}
		}
		catch(Exception ex)
		{
			byte ssbytes[]=((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
			s.embed(ssbytes,ex.getMessage());
		}
	}
	@When("^do login with valid data$")
	public void method9(DataTable dt)
	{
		List<List<String>> l=dt.asLists(String.class);
		hp.fillmbno(l.get(1).get(0));
		hp.fillpwd(l.get(1).get(1));
		hp.clicksignin();		
	}
	@And("^do logout$")
	public void method10()
	{
		//wait.until(temp->((JavascriptExecutor)driver).executeScript("return document.ready state").equals("complete"));
		try 
		{
			Thread.sleep(5000);
			if(sp.menu.isDisplayed())
			{
				Thread.sleep(5000);
				sp.clickmenu();
				wait.until(ExpectedConditions.visibilityOf(sp.logout));
				sp.logoutclick();
			}
		}
		catch(Exception ex)
		{
			driver.findElement(By.xpath(" //*[@class='logout']")).click();
		}
	}
	@Then("^home page will be reopened$")
	public void method11()
	{
		if(hp.mbno.isDisplayed())
		{
			s.write("Logout successfully");
		}
		else
		{
			byte ssbytes[]=((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
			s.embed(ssbytes, "unsuccessfull Logout");
			Assert.fail();
		}
	}
}
