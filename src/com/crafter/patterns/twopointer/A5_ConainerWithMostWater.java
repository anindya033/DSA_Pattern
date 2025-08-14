package com.crafter.patterns.twopointer;
/*
	You are given an integer array height where each element represents the height of a vertical line drawn at position i. The width between each line is 1. Find two lines that together with the x-axis form a container, such that the container holds the most water.
	Input: height = [3, 9, 4, 7, 2, 8, 5, 10]
	Expected Output: 40
	
	Logic
	Use two pointer approach. We need to get the max possible �Area� from the rectangle that would form.
	�	Left = start; right = end of array
	�	Keep �maxArea� = 0
	�	Calculate area of current position:
		o	Area = Math.min(arr[left], arr[right]) * (right-left)
		o	Keep MaxArea
		o	Move left 1 point if left is smaller, else move right pointer (because moving smaller is required to get the max area


 */
public class A5_ConainerWithMostWater {
	
	public static void main(String [] args) {
		int [] height = {3, 9, 4, 7, 2, 8, 5, 10};
		System.out.println(maxArea(height));
	}
	
	public static int maxArea(int[] height) {
		
		int left = 0;
		int right = height.length -1;
		int maxArea = Integer.MIN_VALUE;
		while (right > left) {
			
			int area = Math.min(height[right], height[left]) * (right - left);
			maxArea = Math.max(maxArea, area);
			
			if(height[right] > height[left]) {
				//because moving smaller is required to get the max area
				left ++;
			}else {
				//because moving smaller is required to get the max area
				
				right --;
			}
			
		}
		
		return maxArea;
	}

}
