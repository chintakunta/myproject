package Javabasic;

import java.util.Scanner;

public class Primeno {
	public static void main(String[] args) 
	{
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter a number");
		int x=sc.nextInt();
		int flag=0;
		for (int i=2;i<x;i++)
		{
			if(x%i==0)
			{
				flag=1;
			}
		}
		if(flag==0)
		{
			System.out.println(x+  "is a prime number");
		}
		else
		{
			System.out.println(x+  "is not a prime number");
		}

	}

}
