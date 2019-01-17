package javabasic1;

import java.util.Scanner;

public class Diamond 
{
	public static void main(String[] args) 
	{
	Scanner sc=new Scanner(System.in);
	System.out.println("Enter a odd number");
	int line=sc.nextInt();
	int mid=(line+1)/2;
	//upper part
	for (int i=1;i<=mid;i++)
	{
		//spaces
		for(int s=1;s<=(mid-i);s++)
		{
			System.out.print(" ");
		}
		for(int j=1;j<=(i*2-1);j++)
		{
			System.out.print("*");
		}
		System.out.println();
		
	}
	for(int i=1;i<=(mid-1);i++)
	{
		//space
		for(int s=1;s<=i;s++)
		{
			System.out.print(" ");
		}
		for(int j=1;j<=2*(mid-i)-1;j++)
		{
			System.out.print("*");
		}
		System.out.println();
	}
	}
}
