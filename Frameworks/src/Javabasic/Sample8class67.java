package Javabasic;
public class Sample8class67 {
	public static void main(String[] args) 
	{
		//create object to interface
		Sample6Interface obj1=new Sample7concreteclass();
		int a=obj1.add(12,34);
		System.out.println(a);
		//create object to concreat class
		Sample7concreteclass obj2=new Sample7concreteclass();
		int b=obj2.add(15,65);
		System.out.println(b);
	}

}
