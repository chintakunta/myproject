package javabasic1;

import java.util.Arrays;

public class ListTest {
	
	int position = 0;
	static int[] intArray = new int[20];

	public void add(int value) {
		int arraySize = intArray.length;
		if(position >= arraySize) {
			System.out.println("position         "+position);
			System.out.println("arraySize         "+arraySize);
			int[] temp = Arrays.copyOf(intArray, intArray.length*2);
			intArray = null;
			intArray = temp;
			temp = null;
			
		}
		arraySize = intArray.length;
		if (position < arraySize) {
			if(position < 100) {
				intArray[position] = value;
				position++;
				value = value + 10;
				add(value);
			}
		}
		
	}
	
	public static void main(String[] args) {
		ListTest test = new ListTest();
		test.add(10);
		for (int test1 : intArray) {
			System.out.println("" + test1);
		}
	}

}
