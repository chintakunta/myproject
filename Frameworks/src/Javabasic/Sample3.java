package Javabasic;
public class Sample3 
{
	//Data members
	public int x;
	public float y;
	public char z;
	public boolean w;
	public String s;
	//create constroctor
	public Sample3(int temp,String word) 
	{
		x=temp;
		s=word;		
	}
	public void display()
	{
		System.out.println(x);
		System.out.println(y);
		System.out.println(z);
		System.out.println(w);
		System.out.println(s);
	}
	

}
