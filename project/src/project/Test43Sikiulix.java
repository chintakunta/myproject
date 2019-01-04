package project;

import org.sikuli.script.Screen;

public class Test43Sikiulix 
{
	public static void main(String[] args) throws Exception 
	{
		Screen s=new Screen();
		Thread.sleep(5000);
		s.click("E:\\testing tools\\mindq\\Vlc.PNG");
		Thread.sleep(5000);
		s.doubleClick("E:\\testing tools\\mindq\\Vlc.PNG");
		s.rightClick("E:\\testing tools\\mindq\\Vlc.PNG");
		s.type("E:\\testing tools\\mindq\\Vlc.PNG","");
		Screen.closePrompt();
		
		

	}

}

