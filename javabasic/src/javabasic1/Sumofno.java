package javabasic1;

import java.util.Scanner;

public class Sumofno {
	public static void main(String[] args) 
	{
		int n;
		int temp=0;
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter the value for 'n' :");
		n=sc.nextInt();
		for (int i=0;i<=n;i++)
		{
			temp=temp+1;
		}
		System.out.println("the sum upto "+n+ " is: "+temp);
	}

}
