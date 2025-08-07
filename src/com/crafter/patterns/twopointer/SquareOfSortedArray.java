package com.crafter.patterns.twopointer;

// Easy
/*
 Problem:
Given an integer array nums sorted in non-decreasing order, return an array of the squares of each number sorted in non-decreasing order.
Input: nums = [-4,-1,0,3,10]
Output: [0,1,9,16,100]
Explanation: After squaring, the array becomes [16,1,0,9,100].
After sorting, it becomes [0,1,9,16,100].

 */

/*
 The largest square values could be either
-	The leftmost negative number (if squared) or
-	The rightmost positive number (if squared).
•	Initialize Two Pointers:
	o	left : Start of the array (points to the smallest negative number).
	o	right : End of the array (points to the largest positive number).
•	Compare Values at Both Ends:
	o	If nums[left]^2 > nums[right]^2, place nums[left]^2 in the result array and move left one step forward.
	o	Otherwise, place nums[right]^2 in the result array and move right one step backward.
•	Continue until both pointers meet.

 */
public class SquareOfSortedArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int[] nums = new int [] {-4,-1,0,3,10};
		int [] reutrnArry = new int[nums.length];
		int start = 0;
		int end = nums.length-1;
		int i = reutrnArry.length-1;
		while(end >= start )
		{
			if(Math.pow(nums[end], 2) > Math.pow(nums[start], 2)) {
				reutrnArry[i] = (int) Math.pow(nums[end], 2);
				end--;
			}else {
				reutrnArry[i] = (int) Math.pow(nums[start], 2);
				start++;
			}
			i--;
		}
		
		for(int c : reutrnArry){
			System.out.println(c);
		}

	}

}
