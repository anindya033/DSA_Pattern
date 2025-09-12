package com.crafter.patterns.dynamicProgramming;

import java.util.ArrayList;
import java.util.Arrays;

public class A5_Maximum_sum_of_nonAdjacent_elements {

	public static void main(String[] args) {
		int[] arr = new int[] { 1,5,2,1,6 };
		int index = arr.length - 1;
		int maxSum = Integer.MIN_VALUE;

		int sum = nonAdjacent(arr, index);
		System.out.println("With Recursion : "+sum);
		
		//int sum1 = nonAdjacent1(arr, index, new ArrayList<Integer>(), 0);
		//System.out.println(sum1);
		
		//allSubSeq(arr, 0, new ArrayList<Integer>());
		int dp[] = new int[arr.length];
		Arrays.fill(dp, -1);
		int sum2 = nonAdjacent_Memorization(arr, index, dp);
		System.out.println("With Memorization : "+sum2);
	}


	private static void allSubSeq(int[] arr, int index, ArrayList<Integer> list) {
		// TODO Auto-generated method stub
		
		if (index == arr.length) {
			System.out.println(list.toString());
			return;
			
		}
		
		list.add(arr[index]);
		allSubSeq(arr, index+1, list);
		
		list.remove(list.size() - 1);
		allSubSeq(arr, index+1, list);
		
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
	
	public static int nonAdjacent_Tabulation(int[] nums, int index, int[] dp) {


        return 1;
		

	}
	
	

}
