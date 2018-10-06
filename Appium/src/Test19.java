

import java.io.File;

import net.sourceforge.tess4j.Tesseract;
import net.sourceforge.tess4j.util.LoadLibs;

public class Test19 
{
	public static void main(String[] args) throws Exception 
	{
		//load "tessdata"folder,which have characters in various font
		File f1=LoadLibs.extractTessResources("tessdata");
		//create object to apply OCR on image
		Tesseract obj =new Tesseract();
		obj.setDatapath(f1.getAbsolutePath());//src
		//take screenshot file,which have text in context
		File f =new File("E:\\testingtools\\mindq\\Map.PNG");
		String result=obj.doOCR(f);
		Thread.sleep(20000);
		System.out.println(result);


	}

}
