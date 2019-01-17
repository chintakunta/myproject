package javabasic1;

import java.util.Scanner;

public class Areaofcircle 
{
	public static void main(String[] arg)
	{
		int radius;
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter the radius of the circle: ");
		radius=sc.nextInt();
		//use MATH.PI constant to get value of pi
		double area =Math.PI*radius*radius;
		System.out.println("Area of the circle is "+ area);
	}
}
