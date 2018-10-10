package Javabasic;

import java.util.Scanner;

public class Countstring 
{
	public static void main(String[] args) 
	{
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter a String");
		String x=sc.nextLine();
		int nol=0;//no of lower case 
		int nou=0;//no of upper case
		int nod=0;//no of digits
		int nosc=0;//no of special char
		for (int i=0;i<x.length();i++)
		{
			char y=x.charAt(i);
			if(y<=122 && y>=97)
			{
				nol=nol+1;
			}
			else if(y<=90&&y>=65)
			{
				nou=nou+1;
			}
			else if(y<=57&&y>=48)
			{
				nod=nod+1;
			}
			else
			{
				nosc=nosc+1;
			}
		}
		System.out.println("No of lower case is :" + nol);
		System.out.println("No of upper case is : " + nou);
		System.out.println("No of digits is : " + nod);
		System.out.println("No of special char is : " + nosc);
	}

}
