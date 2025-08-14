package com.crafter.patterns.twopointer;

import java.util.Arrays;

// //Problem: Move Zeros to end
/* 
 * 	Easy -- 
 	Logic : Unidirectional Two Pointers
 	 1 ,0 ,2 ,3 ,0 ,4 ,0 ,1
 	 
 	 Logic :
 	 	First, using a loop, we will place the pointer j. If we don�t find any 0,
 	 	we will not perform the following steps.
		After that, we will point i to index j+1 and start moving the pointer using a loop.
		While moving the pointer i, we will do the following:
		If a[i] != 0 i.e. a[i] is a non-zero element: We will swap a[i] and a[j].
		 Now, the current j is pointing to the non-zero element a[i].
		  So, we will shift the pointer j by 1 so that it can again point to the first zero.
		Finally, our array will be set in the right manner.
 */
public class A3_MoveZerosToEnd {
	
	public static void main(String [] args) {
		int [] arr = new int[] {1 ,0 ,2 ,3 ,0 ,4 ,0 ,1};
		moveZeros(arr);
	}
	
	public static void moveZeros(int [] arr){
		
		int first = 0;
		int second = 1;
		
		for(int i = 0; i < arr.length; i++) {
			
			if(arr[i] == 0) {
				first = i; // contains zero
				second = first+1;
				break;
			}
		}
		
		for(int i = second; i < arr.length; i++) {
			if(arr[i] != 0) {
				int temp = arr[i];
				arr[i] = arr[first];
				arr[first] = temp;
				first++;
			}
			//first++;
		}
		
		Arrays.stream(arr).forEach(data-> System.out.print(data+" , "));
		
		
	}
	
	

}
