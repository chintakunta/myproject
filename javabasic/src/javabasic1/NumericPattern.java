package javabasic1;

import java.util.Scanner;

public class NumericPattern {

	public static void main(String[] args) 
	{
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter number");
		int line=sc.nextInt();
		int count=0;
		for(int i=1;i<=line;i++)
		{
			for(int j=1;j<=i;j++)
			{
				count=count+1;
				System.out.print(count+" ");
			}
			System.out.println();
		}
	}

}
