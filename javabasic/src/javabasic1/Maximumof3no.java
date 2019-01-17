package javabasic1;

import java.util.Scanner;

public class Maximumof3no 
{
	public static void main(String[] args) 
	{
		int a,b,c;
		Scanner in=new Scanner(System.in);
		System.out.println("Enter a:");
		a=in.nextInt();
		System.out.println("Enter b:");
		b=in.nextInt();
		System.out.println("Enter c:");
		c=in.nextInt();
		if(a>b && a>c) {
			System.out.println("a is Big number");
		}
		else if (b>a && b>c)
		{
			System.out.println("b is Big number");
		}
		else
		{
			System.out.println("c is Big number");
		}
		
				
	}

}
