package Javabasic;

import java.util.Scanner;

public class pyramid 
{
	public static void main(String[] args) 
	{
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter a Number");
		int y=sc.nextInt();
		System.out.println("Enter 2nd number");
		int x=sc.nextInt();
		for(int i=x;i<=y;i++)
		{
			for(int j=x;j<=i;j++)
			{
				System.out.print(j);
			}
			System.out.println();
		}
	}

}
