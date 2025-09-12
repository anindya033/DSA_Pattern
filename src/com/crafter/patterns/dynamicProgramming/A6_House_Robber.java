package com.crafter.patterns.dynamicProgramming;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class A6_House_Robber {

	public static void main(String[] args) {
		int[] arr = new int[] { 2,1,4,9};
		int index = arr.length - 1;
		int maxSum = Integer.MIN_VALUE;

		//int sum = nonAdjacent(arr, index);
		//System.out.println("With Recursion : "+sum);
		
		int sum1 = nonAdjacent1(arr, index, new ArrayList<Integer>(), 0);
		System.out.println(sum1);
		
		//allSubSeq(arr, 0, new ArrayList<Integer>());
		int dp[] = new int[arr.length];
		Arrays.fill(dp, -1);
		int sum2 = nonAdjacent_Memorization(arr, index, dp);
		System.out.println("With Memorization : "+sum2);
	}

	public static int nonAdjacent(int[] nums, int index) {

		if (index == 0)
			return nums[index];
		if (index < 0)
			return 0;

		int pick = nums[index] + nonAdjacent(nums, index - 2);
		int notPick = 0 + nonAdjacent(nums, index - 1);
		return Math.max(notPick, pick);

	}
	
	public static int nonAdjacent_Memorization(int[] nums, int index, int[] dp) {

		if (index == 0)
			return nums[index];
		if (index < 0)
			return 0;
		int pick = Integer.MIN_VALUE;
		int notPick = Integer.MIN_VALUE;
		if (dp[index] == -1){
			pick = nums[index] + nonAdjacent(nums, index - 2);
			notPick = 0 + nonAdjacent(nums, index - 1);
		}else {
			return dp[index];
		}
		
		dp[index] = Math.max(notPick, pick) ;
		return dp[index] ;

	}
	
	private static int nonAdjacent1(int[] arr, int index, List<Integer> list, int sum) {
		// TODO Auto-generated method stub
		
		if (index == 0) {
			return arr[index];
			
		}else if (index < 0){
			return 0;
		}
		
		List<Integer> newList = new ArrayList<>(list);
		if (!newList.isEmpty()) {
		    newList.remove(newList.size() - 1);
		}
		
		int pick = arr[index]+ nonAdjacent1(arr, index-2, newList, sum);
		
		int notpick = 0 + nonAdjacent1(arr, index-1, newList, sum);
		
		return Math.max(pick, notpick);
	}

}
