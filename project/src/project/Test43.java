package project;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.chrome.ChromeDriver;
import org.sikuli.script.Button;
import org.sikuli.script.Location;
import org.sikuli.script.Match;
import org.sikuli.script.Screen;

public class Test43 
{
	public static void main(String[] args) throws Exception 
	{
		//Launch site 
				System.setProperty("webdriver.chrome.driver","E:\\testing tools\\mindq\\chromedriver.exe");
				ChromeDriver driver = new ChromeDriver();
				driver.get("https://www.youtube.com/");
				driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
				driver.manage().window().maximize();
				//search for a video(SWD)
				driver.findElement(By.id("search")).sendKeys("Abdul kalam",Keys.ENTER);
				//click on video link
				driver.findElement(By.partialLinkText("Dr. A P J Abdul Kalam in European Parliament")).click();
				//video icons automation (sikulix)
				Screen s=new Screen();
				if(s.exists("E:\\testing tools\\mindq\\Skipad.PNG")!=null)
				{
					s.click("E:\\testing tools\\mindq\\Skipad.PNG");
				}
				//move Mouse pointer to video body
				Location l=new Location(400,400);
				s.wheel(l,Button.RIGHT,0);
				s.click("E:\\testing tools\\mindq\\Fullscreen.png");
			    Thread.sleep(5000);
			    s.wheel(l,Button.LEFT,0);
			    s.click("E:\\testing tools\\mindq\\pause.png");
			    Thread.sleep(5000);
			    s.wheel(l,Button.LEFT,0);
			    s.click("E:\\testing tools\\mindq\\play.png");
			    Thread.sleep(5000);
			    s.wheel(l,Button.LEFT,0);
			    s.mouseMove("E:\\testing tools\\mindq\\Volume.png");
			    Thread.sleep(5000);
			    Match e=s.find("E:\\testing tools\\mindq\\Bubble.png");
			    int x =e.getX();
			    int y =e.getY();
			    Location dl=new Location(x-10,y);
			    s.dragDrop(e,dl);
			    Thread.sleep(5000);
			    Location dl1=new Location(x+20,y);
			    s.dragDrop(e,dl1);
			    Thread.sleep(5000);
			    //close site 
			    driver.close();
			    
			    
			    

	}

}
