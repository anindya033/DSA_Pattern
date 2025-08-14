package com.crafter.patterns.dynamicProgramming;

public class ClimbingStairs {
	
	/**
	 	Problems :--------
	 	
	 	You are climbing a staircase. It takes n steps to reach the top.
		Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?

		Example 1:
		-------------------------------------------------------
		Input: n = 2
		Output: 2
		Explanation: There are two ways to climb to the top.
		1. 1 step + 1 step
		2. 2 steps
		
		Example 2:
		-------------------------------------------------------
		Input: n = 3
		Output: 3
		Explanation: There are three ways to climb to the top.
		1. 1 step + 1 step + 1 step
		2. 1 step + 2 steps
		3. 2 steps + 1 step
	 */

    public static void main(String[] args) {
        int n = 4;
        
        System.out.println("Climbing stairs using Recursion: " + climbStairsRecursive(n));
        
        int[] dpMemo = new int[n + 1];
        // Fill the dp array with -1 to indicate uncalculated values
        for (int i = 0; i <= n; i++) dpMemo[i] = -1;
        System.out.println("Climbing stairs using Memoization: " + climbStairsMemoization(n, dpMemo));
        
        System.out.println("Climbing stairs using Tabulation: " + climbStairsTabulation(n));
    }

    // Recursion (Exponential time complexity)
    public static int climbStairsRecursive(int n) {
        if (n == 0 || n == 1) return 1;
        return climbStairsRecursive(n - 1) + climbStairsRecursive(n - 2);
    }

    // Memoization (Top-Down DP) - Time: O(n), Space: O(n)
    public static int climbStairsMemoization(int n, int[] dp) {
        if (n == 0 || n == 1) return 1;

        // If result already calculated
        if (dp[n] != -1) return dp[n];

        // Store result in dp and return
        dp[n] = climbStairsMemoization(n - 1, dp) + climbStairsMemoization(n - 2, dp);
        return dp[n];
    }

    // Tabulation (Bottom-Up DP) - Time: O(n), Space: O(n)
    public static int climbStairsTabulation(int n) {
        if (n == 0 || n == 1) return 1;

        int[] dp = new int[n + 1];
        dp[0] = 1; // 1 way to stay at step 0 (do nothing)
        dp[1] = 1; // 1 way to climb to step 1

        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2]; // sum of ways from previous 2 steps
        }

        return dp[n];
    }
}

