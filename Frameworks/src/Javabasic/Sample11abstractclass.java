package Javabasic;
public class Sample11abstractclass {
	public static void main(String[] args) 
	{
		//create object to abstract class
		Sample9abstractclass obj1=new Sample10add();
		int a = obj1.add(50, 20);
		int b = obj1.substract(40, 20);
		//create object to concrete class
		Sample10add obj2=new Sample10add();
		int c=obj2.add(10, 20);
		int d=obj2.substract(40, 20);
		System.out.println(a);
		System.out.println(b);
		System.out.println(c);
		System.out.println(d);
		
	}
}
