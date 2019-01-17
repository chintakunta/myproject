package javabasic1;

import java.util.Scanner;

public class Swap2no 
{
	public static void main(String[] args) 
	{
		int num1,num2;
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter num1: ");
		num1=sc.nextInt();
		System.out.println("Enter num2: ");
		num2=sc.nextInt();
		//Logic
		num1=num1+num2;
		num2=num1-num2;
		num1=num1-num2;
		System.out.println("num1 is "+num1);
		System.out.println("num2 is "+num2);

	}

}
