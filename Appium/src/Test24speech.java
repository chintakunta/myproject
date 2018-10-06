import java.util.Locale;
import java.util.Scanner;

import javax.speech.Central;
import javax.speech.synthesis.Synthesizer;
import javax.speech.synthesis.SynthesizerModeDesc;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Test24speech 
{
	public static void main(String[] args) throws Exception 
	{
		//get data to be search as voice in google site
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter text");
		String x=sc.nextLine();
		//Launch google site
		System.setProperty("webdriver.chrome.driver", "E:\\testingtools\\mindq\\chromedriver.exe");
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
				synthesizer.waitEngineState(synthesizer.QUEUE_EMPTY);
				//deallocate the synthesizer
				synthesizer.deallocate();
				//validate result
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='rhscol']")));
				String y =driver.getTitle();
				x=x.toLowerCase();
				y=y.toLowerCase();
				if(y.contains(x))
				{
					System.out.println("Test is passed");
				}
				else
				{
					System.out.println("Test is failed");
				}
				//close site
				driver.close();
	}

}
