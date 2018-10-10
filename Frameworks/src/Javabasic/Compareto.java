package Javabasic;
public class Compareto
{
	public static void main(String[] args) 
	{
		String x="mindqsystem";
		String y="mindq";
		int z=x.compareTo(y);
		if(z==0)
		{
			System.out.println("Both are same");
		}
		else if(z>0)
		{
			System.out.println("First string is Bigger then second string");
		}
		else
		{
			System.out.println("1st string is small than 2nd string");
		}
	}

}
