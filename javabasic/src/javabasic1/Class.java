package javabasic1;

import java.util.Arrays;

public class Class {
	

	int position = 0;
	int[] intArray = new int[20];
	
	public int size() {
		return this.position;
	}
	
	public Integer get(int index) {
		if(index <= position) {
			return this.intArray[index];
		}
		return null;
	}

	public void add(int value) {
		int arraySize = intArray.length;
		if(position >= arraySize) {
			//System.out.println("position         "+position);
			//System.out.println("arraySize         "+arraySize);
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
		Class test = new Class();
		test.add(10);
		for(int loop=0; loop<test.size();loop++) {
			System.out.println(loop+"         "+test.get(loop));
		}
		/*for (int test1 : test.intArray) {
			System.out.println("" + test1);
		}*/
		//System.out.println(test.size());
	}
	

}
