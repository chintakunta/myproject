package javabasic1;

import java.util.Scanner;

public class Fibonacciseries {
	public static void main(String[] args) 
	{
		int num;
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter number :");
		num=sc.nextInt();
		int f1, f2=0 , f3=1;
		for(int i=1;i<=num;i++)
		{
			System.out.print(f3+"   ");
			f1=f2;
			f2=f3;
			f3=f1+f2;
		}
		
	}

}
