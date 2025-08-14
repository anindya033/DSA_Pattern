package com.crafter.patterns.dynamicProgramming;

import java.util.Arrays;

/*
	 Given a number of stairs and a frog, the frog wants to climb from the 0th stair to the (N-1)th stair.
	 At a time the frog can climb either one or two steps. A height[N] array is also given.
	 Whenever the frog jumps from a stair i to stair j, the energy consumed in the jump is abs(height[i]- height[j]),
	 where abs() means the absolute difference.
	 We need to return the minimum energy that can be used by the frog to jump from stair 0 to stair N-1.
 
 	This is a follow-up question to “Frog Jump” discussed in the previous article.
 	In the previous question, the frog was allowed to jump either one or two steps at a time.
 	In this question, the frog is allowed to jump up to ‘K’ steps at a time.
 	If K=4, the frog can jump 1,2,3, or 4 steps at every index.
 
 */

public class FrogJump2 {

	public static void main(String[] args) {
		int height[] = { 15, 4, 1, 14, 15, 60 };
		int n = height.length;
		int dp[] = new int[n];
		Arrays.fill(dp, -1);
		// System.out.println(solve(n - 1, height, dp));

		System.out.println("With Tabulation " + frogJump_Tabulation(n - 1, height, 3));

		System.out.println("With Memoization " + frogJump_Memoization(n - 1, height, dp, 3));
	}

	public static int frogJump_Memoization(int n, int[] height, int[] dp, int k) {

		if (n == 0)
			return 0;
		// if (n == 1)
		// return Math.abs(height[n] - height[n - 1]);

		if (dp[n] != -1)
			return dp[n];

		int jump = Integer.MAX_VALUE;
		int min = Integer.MAX_VALUE;
		int j = 1;
		for (j = 1; j <= k; j++) {
			if (n - j >= 0) {

				jump = frogJump_Memoization(n - j, height, dp, k) + Math.abs(height[n] - height[n - j]);

				min = Math.min(min, jump);

			}
		}

		// int prev
		dp[n] = min;
		return min;

	}

	public static int frogJump_Tabulation(int n, int[] height, int k) {
	    int[] dp = new int[n+1];
	    dp[0] = 0; // Base case: cost to reach stone 0 is 0

	    for (int i = 1; i <= n; i++) {
	        int min = Integer.MAX_VALUE;

	        // Try all jump sizes from 1 to k
	        for (int j = 1; j <= k; j++) {
	            if (i - j >= 0) {
	                int cost = dp[i - j] + Math.abs(height[i] - height[i - j]);
	                min = Math.min(min, cost);
	            }
	        }

	        dp[i] = min;
	    }

	    return dp[n]; // Min cost to reach last stone
	}


}
