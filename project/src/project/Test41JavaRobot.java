package project;

import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;

public class Test41JavaRobot 
{
	public static void main(String[] args) throws Exception 
	{
		//Launch calculator
		Runtime.getRuntime().exec("calc.exe");
		Thread.sleep(5000);
		//Enter input1
		StringSelection x=new StringSelection("258");
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(x, null);
		Robot k=new Robot();
		k.keyPress(KeyEvent.VK_CONTROL);
		k.keyPress(KeyEvent.VK_V);
		k.keyRelease(KeyEvent.VK_V);
		k.keyRelease(KeyEvent.VK_CONTROL);
		Thread.sleep(5000);
		//click +
		k.keyPress(KeyEvent.VK_ADD);
		k.keyRelease(KeyEvent.VK_ADD);
		Thread.sleep(5000);
		//Enter input2
		StringSelection y = new StringSelection("852");
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(y, null);
		k.keyPress(KeyEvent.VK_CONTROL);
		k.keyPress(KeyEvent.VK_V);
		k.keyRelease(KeyEvent.VK_V);
		k.keyRelease(KeyEvent.VK_CONTROL);
		Thread.sleep(5000);
		// click =
		k.keyPress(KeyEvent.VK_EQUALS);
		k.keyRelease(KeyEvent.VK_EQUALS);
		Thread.sleep(5000);
		//Get output
		k.keyPress(KeyEvent.VK_CONTEXT_MENU);
		k.keyRelease(KeyEvent.VK_CONTEXT_MENU);
		Thread.sleep(5000);
		/*//Pointer down
		k.keyPress(KeyEvent.VK_DOWN);
		k.keyRelease(KeyEvent.VK_DOWN);
		Thread.sleep(5000);*/
		//press enter
		k.keyPress(KeyEvent.VK_ENTER);
		k.keyRelease(KeyEvent.VK_ENTER);
		Thread.sleep(5000);
		String z=(String) Toolkit.getDefaultToolkit().getSystemClipboard().getData(DataFlavor.stringFlavor);
		System.out.println(z);
		//close calculator
		k.keyPress(KeyEvent.VK_ALT);
		k.keyPress(KeyEvent.VK_F4);
		k.keyRelease(KeyEvent.VK_F4);
		k.keyRelease(KeyEvent.VK_ALT);

	}

}
