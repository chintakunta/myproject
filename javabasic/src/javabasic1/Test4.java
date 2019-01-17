package javabasic1;
public class Test4 
{
	//Data members
	public int x;
	public float y;
	public char z;
	public boolean w;
	public String s;
	//Method
	public Test4()  //constructor method
	{
		x=10;
		s="mindq";
	}
	public Test4(String temp)
	{
		x=10;
		s=temp;
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
