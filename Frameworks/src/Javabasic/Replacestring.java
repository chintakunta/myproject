package Javabasic;
public class Replacestring 
{
	public static void main(String[] args) 
	{
		String x="27,48,785.30";
		String y=x.replace(",", "");
		double d=Double.parseDouble(y);
		System.out.println(d);
	}

}
