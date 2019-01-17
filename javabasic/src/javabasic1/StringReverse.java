package javabasic1;

import java.util.Scanner;

public class StringReverse 
{
	public static void main(String[] args) 
	{
		String org,rev="";
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter a string to Reverse");
		org=sc.nextLine();
		int length=org.length();
		for (int i=length-1;i>=0;i--)
		{
			rev=rev+org.charAt(i);
			System.out.println("reverse of the entered string is :"+rev);
		}

	}

}
