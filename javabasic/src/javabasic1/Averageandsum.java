package javabasic1;

import java.util.Scanner;

public class Averageandsum 
{
	public static void main(String[] args) 
	{
		int a,b,sum;
		float avg;
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter first no :  ");
		a=sc.nextInt();
		System.out.println("Enter second no +  ");
		b=sc.nextInt();
		//calculate sum and average
		sum=a+b;
		avg=(float)((a+b)/2);
		System.out.println("sum : "+sum +"\nAverage : "+ avg);
	}

}
