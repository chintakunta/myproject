package Javabasic;

import java.util.Scanner;

public class Charatreversestring 
{
	public static void main(String[] args) 
	{
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter a word");
		String x=sc.nextLine();
		String y="";
		for(int i=x.length()-1;i>=0;i--)
		{
			char z=x.charAt(i);
			y=y+z;
		}
		System.out.println(y);
	}

}
