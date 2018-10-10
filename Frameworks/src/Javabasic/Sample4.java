package Javabasic;
public class Sample4 
{
	//Data members
	public int x;
	public float y;
	public double z;
	public char c;
	public boolean b;
	public String s;
	//methods
	public Sample4()
	{
		x=10;
		s="mindq";
	}
	public Sample4(String temp, int num)
	{
		x=num;
		s=temp;
	}
	public void display()
	{
		System.out.println(x);
		System.out.println(y);
		System.out.println(z);
		System.out.println(c);
		System.out.println(b);
		System.out.println(s);
	}

}
