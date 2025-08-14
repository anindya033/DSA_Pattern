package com.crafter.patterns.twopointer;

import java.util.Arrays;

//Problem: Remove duplicates from a sorted array in place and return the new length.
/*
 Easy -- 
 Logic - Unidirectional
 	-	1.	Use two pointers:
�	i � Points to the position where the next unique element should go
�	j � Traverses the array to find unique elements
2.	check
a.	 if arr[i] == arr[j]
i.	J++
b.	Else
i.	i++
ii.	arr[i] = arr[j] ; it will replace the duplicate element with unique element. Because its unique that�s why it is not matched with the prev value.

 */
public class A1_RemoveDuplicate {
	public static void main(String[] args) {

		int[] arr = new int[] { 1, 2, 3, 3, 4 }; // Expected : 4
		// int[] arr = new int[] { 1, 2, 3, 4, 5}; // Expected : 5
		int length = arr.length;
		removeDuplAnother(arr, length);

	}

	private static void removeDuplAnother(int[] arr, int length) {
		// TODO Auto-generated method stub

		int i = 0; // Pointer `i` starts at index 0 (first element)
		int j = i + 1; // Pointer `j` starts at index 1 (second element)

		while (j < length) { // Loop runs until `j` reaches the end of the array
			if (arr[i] == arr[j]) {
				// If `arr[i]` and `arr[j]` are the same, move `j` forward
				j++;
			} else {
				// If `arr[i]` and `arr[j]` are different, swap `arr[i+1]` and `arr[j]`

				int temp = arr[i + 1]; // Store the next element of `i` in `temp`
				arr[i + 1] = arr[j]; // Move the unique element `arr[j]` to `i+1`
				arr[j] = temp; // Place the original `i+1` element at `j`

				i++; // Move `i` forward to the next unique element's position
			}
		}

		Arrays.stream(arr).forEach(action -> System.out.print(action + " , "));
	}

	private static void removeDupl(int[] arr, int length) {
		// TODO Auto-generated method stub

		int p1 = 0;

		for (int j = 1; j < length; j++) {

			if (arr[p1] != arr[j]) {
				p1++;
				arr[p1] = arr[j];
			} else {

			}
			Arrays.stream(arr).forEach(action -> System.out.print(action + " , "));
			System.out.println("---------------------------------------------i = " + p1);
		}

		System.out.println("Updated length after remove duplicate : " + (p1 + 1));

	}
}
