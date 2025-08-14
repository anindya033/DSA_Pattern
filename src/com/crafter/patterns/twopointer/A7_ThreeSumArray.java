package com.crafter.patterns.twopointer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class A7_ThreeSumArray {
	// Medium
	/**
	 * [LeetCode #15] Given an integer array nums, return all the triplets [nums[i],
	  nums[j], nums[k]] such that i != j, i != k, and j != k, and nums[i] + nums[j]
	  + nums[k] == 0.
	  
	  Notice that the solution set must not contain duplicate triplets.
	  
	  Example 1:
	  
	  Input: nums = [-1,0,1,2,-1,-4] Output: [[-1,-1,2],[-1,0,1]]
	 */

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[] arr = { -1, 0, 1, 2, -1, -4 };
		int target = 0;
		threeSum(arr, target);
	}

	private static List<List<Integer>> threeSum(int[] nums, int target) {
		// TODO Auto-generated method stub
		Arrays.sort(nums); // Step 1: Sort the array
		List<List<Integer>> result = new ArrayList<>();

		int left = 0;
		int right = 0;
		int sum = Integer.MIN_VALUE;
		for (int i = 0; i < nums.length - 2; i++) {

			if (i > 0) {
				if (nums[i] == nums[i - 1]) {
					continue;
				}
			}

			left = i + 1;
			right = nums.length - 1;
			while (right > left) {

				sum = nums[i] + nums[left] + nums[right];
				if (sum == target) {
					result.add(Arrays.asList(nums[i], nums[left], nums[right]));

					while (left < right && nums[left] == nums[left + 1])
						left++; // Skip duplicate left values
					while (left < right && nums[right] == nums[right - 1])
						right--; // Skip duplicate right values

					left++; // Move to next unique element
					right--; // Move to next unique element
				} else if (sum > target) {
					right--;
				} else {
					left++;
				}
			}
		}
		System.out.println(result.toString());
		return result;
	}

}
