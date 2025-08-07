package com.crafter.patterns.twopointer;

import java.util.Arrays;

public class SortColorDNF_Algo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int [] arr = {2,0,2,1,1,0};
		int length = arr.length-1;
		int left = 0 , mid = 0;
		int right = length;
		
		 while (mid <= right) {
	            if (arr[mid] == 0) {
	                // Swap arr[mid] and arr[left]
	                int temp = arr[mid];
	                arr[mid] = arr[left];
	                arr[left] = temp;
	                left++;
	                mid++;
	            } else if (arr[mid] == 1) {
	                mid++;
	            } else { // arr[mid] == 2
	                // Swap arr[mid] and arr[right]
	                int temp = arr[mid];
	                arr[mid] = arr[right];
	                arr[right] = temp;
	                right--;
	                // Do NOT increment mid because the swapped element needs to be checked again
	            }
		 }
		Arrays.stream(arr).forEach(action-> System.out.print(action+" , "));

	}

}
