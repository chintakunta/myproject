package Javabasic;

public class Sample15super {

	public static void main(String[] args) 
	{
		Sample13superclass obj1=new Sample13superclass();
		Sample14child obj2=new Sample14child();
		obj1.x=20;
		obj1.y=30;
		obj1.display();
		obj2.w=21;
		obj2.x=22;
		obj2.y=23;
		obj2.z=24;
		obj2.display();
		obj2.display2();		
	}
}
