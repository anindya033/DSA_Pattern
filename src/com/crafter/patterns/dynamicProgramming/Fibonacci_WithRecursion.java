package com.crafter.patterns.dynamicProgramming;

import java.util.Arrays;

/**
 * Demonstrates 3 methods to calculate the nth Fibonacci number:
 * 1. Pure recursion
 * 2. Recursion with memoization
 * 3. Bottom-up tabulation
 */
public class Fibonacci_WithRecursion {

    public static void main(String[] args) {
        int n = 4;

        System.out.println(" Fibonacci using Recursion: " + fibonacci_Recursive(n));

        int[] dp = new int[n + 1];
        Arrays.fill(dp, -1);
        System.out.println(" Fibonacci using Memoization: " + fibonacci_Memoization(n, dp));

        System.out.println(" Fibonacci using Tabulation: " + fibonacci_Tabulation(n));

        System.out.println(" Fibonacci using Space Optimization: " + fibonacci_SpaceOptimized(n));
    }

    /**
     * Calculates nth Fibonacci number using pure recursion
     *
     * Time Complexity: O(2^n)
     * Space Complexity: O(n) — due to call stack
     */
    public static int fibonacci_Recursive(int n) {
        if (n == 0) return 0;
        if (n == 1) return 1;
        return fibonacci_Recursive(n - 1) + fibonacci_Recursive(n - 2);
    }

    /**
     * Calculates nth Fibonacci number using memoization (top-down DP)
     *
     * Time Complexity: O(n)
     * Space Complexity: O(n) — due to recursion stack and DP array
     */
    public static int fibonacci_Memoization(int n, int[] dp) {
        if (n == 0) return 0;
        if (n == 1) return 1;
        if (dp[n] != -1) return dp[n];
        return dp[n] = fibonacci_Memoization(n - 1, dp) + fibonacci_Memoization(n - 2, dp);
    }

    /**
     * Calculates nth Fibonacci number using tabulation (bottom-up DP)
     *
     * Time Complexity: O(n)
     * Space Complexity: O(n)
     */
    public static int fibonacci_Tabulation(int n) {
        if (n == 0) return 0;
        if (n == 1) return 1;

        int[] dp = new int[n + 1];
        dp[0] = 0;
        dp[1] = 1;

        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }
    
    public static int fibonacci_SpaceOptimized(int n) {
        if (n == 0) return 0;
        if (n == 1) return 1;

        int prev2 = 0;
        int prev = 1;
        for (int i = 2; i <= n; i++) {
        	int curr = prev + prev2;
        	prev2= prev;
        	prev = curr;
        }
        return prev;
    }
}
