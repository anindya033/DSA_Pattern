package com.crafter.patterns.dynamicProgramming;

import java.util.Arrays;

/*
	 Given a number of stairs and a frog, the frog wants to climb from the 0th stair to the (N-1)th stair.
	 At a time the frog can climb either one or two steps. A height[N] array is also given.
	 Whenever the frog jumps from a stair i to stair j, the energy consumed in the jump is abs(height[i]- height[j]),
	 where abs() means the absolute difference.
	 We need to return the minimum energy that can be used by the frog to jump from stair 0 to stair N-1.
 */

public class A3_FrogJump {

	public static void main(String[] args) {
		int height[] = { 30, 10, 60, 10, 60, 50 };
		int n = height.length;
		int dp[] = new int[n];
		Arrays.fill(dp, -1);
		// System.out.println(solve(n - 1, height, dp));

		System.out.println("With Recursion " + frogJump_Recursion(n - 1, height));

		System.out.println("With Memoization " + frogJump_Memoization(n - 1, height, dp));
	}

	public static int frogJump_Memoization(int n, int[] height, int[] dp) {

		if (n == 0)
			return 0;
		if (n == 1)
			return Math.abs(height[n] - height[n - 1]);
		
		int left = Integer.MAX_VALUE ;
		int right = Integer.MAX_VALUE ;
		
		if (dp[n] == -1){

			left = frogJump_Memoization(n - 1, height, dp) + Math.abs(height[n] - height[n - 1]);
			right = Integer.MAX_VALUE;
			if (n > 1)
				right = frogJump_Memoization(n - 2, height, dp) + Math.abs(height[n] - height[n - 2]);
		}else {
			return dp[n];
		}
		int min = Integer.MAX_VALUE;
		min = Integer.min(left, right);
		// int prev
		dp[n] = min;
		return min;

	}

	public static int frogJump_Recursion(int n, int[] height) {

		if (n == 0)
			return 0;
		if (n == 1)
			return Math.abs(height[n] - height[n - 1]);
		int left = frogJump_Recursion(n - 1, height) + Math.abs(height[n] - height[n - 1]);
		int right = Integer.MAX_VALUE;
		if (n > 1)
			right = frogJump_Recursion(n - 2, height) + Math.abs(height[n] - height[n - 2]);

		int min = Integer.MAX_VALUE;
		min = Integer.min(left, right);
		// int prev

		return min;

	}

}
