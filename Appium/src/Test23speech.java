import java.util.Locale;
import java.util.Scanner;

import javax.speech.Central;
import javax.speech.synthesis.Synthesizer;
import javax.speech.synthesis.SynthesizerModeDesc;

public class Test23speech 
{
	public static void main(String[] args) throws Exception 
	{
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter text");
		String x=sc.nextLine();
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
		
		
	}

}
