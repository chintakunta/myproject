package Javabasic;

import java.time.LocalDateTime;
import java.util.Scanner;

public class sraven {

	public static void main(String[] args) 
	{
		System.out.println(LocalDateTime.now());
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter a word");
		String x=sc.nextLine();
		String rev="";
		for(int i=x.length()-1;i>=0;i--)
		{
			rev=rev+x.charAt(i);
			//System.out.print(x.charAt(i));
		}
		
		if(x.equals(rev))
		{
			System.out.println(rev + " is palindrome  ");
		}
		else
		{
			System.out.println(rev + " is not  a palindrome");
		}
		}

}
