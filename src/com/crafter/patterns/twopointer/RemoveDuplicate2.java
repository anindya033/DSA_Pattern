package com.crafter.patterns.twopointer;

import java.util.Arrays;

/*Problem:
  		Given an integer array nums sorted in non-decreasing order,
		remove some duplicates in-place such that each unique element appears at most twice.
		The relative order of the elements should be kept the same.
*/
/*
 Medium -- 
 	Input : [1,1,1,2,2,3]
 	Output: 5, nums = [1,1,2,2,3,_]
 */
public class RemoveDuplicate2 {
	public static void main(String[] args) {

		int[] arr = new int[] { 1,1,2,2,2,3}; // Expected : 4
		int length = arr.length;
		System.out.println(removeDupl(arr, length));
		
		for (int i = 0; i < length; i++) {
		    System.out.print(arr[i] + " , ");
		}
	}
	
	private static int removeDupl(int[] nums, int length) {
		// TODO Auto-generated method stub
		
		if (nums.length <= 2) return nums.length; // If 2 or fewer elements, return directly

        int j = 2; // Start from index 2, since first two elements are always allowed

        for (int i = 2; i < nums.length; i++) {
            if (nums[i] != nums[j - 2]) { // Ensure at most two occurrences
                nums[j] = nums[i];
                j++;
            }
        }
        return j; // New length of the modified array
		
	}
}
