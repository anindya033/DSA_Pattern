package com.crafter.patterns.binarysearch;

import java.util.Arrays;

/*
===============================================================================
 PROBLEM STATEMENT
===============================================================================

You are given:
1. stalls[] -> positions of stalls
2. k -> number of aggressive cows

Task:
Place all cows in stalls such that the MINIMUM distance between any
two cows is MAXIMUM possible.

Example:
stalls = [1,2,4,8,9]
k = 3

Possible placement:
1,4,8

Distances:
4-1 = 3
8-4 = 4

Minimum distance = 3

Answer = 3


===============================================================================
 INTUITION
===============================================================================

We are NOT trying to maximize every distance.

We only care about:
"minimum distance between any two cows"

And we want to maximize that minimum value.

-------------------------------------------------------------------------------
IMPORTANT OBSERVATION
-------------------------------------------------------------------------------

If distance 3 is possible,
then distance 2 and 1 are also possible.

If distance 4 is NOT possible,
then 5,6,7... will also NOT be possible.

Pattern becomes:

YES YES YES NO NO NO

This monotonic behavior allows Binary Search.


===============================================================================
 APPROACH
===============================================================================

1. Sort stalls
2. Binary search on possible DISTANCES
3. For every distance:
      Check feasibility using greedy placement

-------------------------------------------------------------------------------
FEASIBILITY CHECK
-------------------------------------------------------------------------------

Question:
Can we place all cows such that every cow is at least D distance apart?

Greedy Logic:
Always place next cow at earliest valid stall.

Why greedy works?
Because placing early leaves maximum space for remaining cows.

===============================================================================
 TIME COMPLEXITY
===============================================================================

Sorting      -> O(N log N)
Binary Search -> O(log(maxDistance))
Feasibility   -> O(N)

Overall:
O(N log N + N log(maxDistance))

===============================================================================
*/

public class AggressiveCows {

    /*
     * Stores latest valid feasible distance found during binary search
     */
    static int feasibleDistance = 0;

    public static void main(String[] args) {

        /*
         * Stall positions
         */
        int[] stalls = new int[] { 1, 2, 4, 8, 9 };

        /*
         * Number of cows to place
         */
        int numberOfCows = 3;

        /*
         * Sorting is IMPORTANT.
         * 
         * Why?
         * Because greedy placement logic depends on ordered positions.
         */
        Arrays.sort(stalls);

        /*
         * Minimum possible distance between cows
         * 
         * Since stall positions are unique,
         * minimum meaningful distance starts from 1.
         */
        int low = 1;

        /*
         * Maximum possible distance
         * 
         * Best case:
         * cows placed at extreme ends.
         * 
         * Example:
         * 9 - 1 = 8
         */
        int high = stalls[stalls.length - 1] - stalls[0];

        /*
         * Start binary search on answer
         */
        int answer = checkAggressiveCowsPlacement(
                stalls,
                low,
                high,
                numberOfCows);

        System.out.println(answer);
    }

    /*
     * ===========================================================================
     * BINARY SEARCH ON ANSWER
     * ===========================================================================
     * 
     * We binary search on POSSIBLE DISTANCES.
     * 
     * mid represents:
     * "Can cows maintain at least mid distance?"
     * 
     * If feasible:
     * try bigger distance
     * 
     * Else:
     * try smaller distance
     * ===========================================================================
     */
    private static int checkAggressiveCowsPlacement(
            int[] stalls,
            int low,
            int high,
            int numberOfCows) {

        /*
         * Binary search completed
         * 
         * low crossed high means:
         * we already explored all possibilities
         */
        if (low > high) {
            return feasibleDistance;
        }

        /*
         * Mid distance to test
         * 
         * Overflow safe formula
         */
        int mid = low + (high - low) / 2;

        /*
         * Check if current distance is possible
         */
        boolean isFeasible = checkFeasible(stalls, numberOfCows, mid);

        /*
         * If current distance works
         */
        if (isFeasible) {

            /*
             * mid itself is a valid answer
             * 
             * Store it.
             */
            feasibleDistance = mid;

            /*
             * Try finding even larger minimum distance
             */
            return checkAggressiveCowsPlacement(
                    stalls,
                    mid + 1,
                    high,
                    numberOfCows);

        } else {

            /*
             * Current distance too large
             * 
             * Need smaller distance
             */
            return checkAggressiveCowsPlacement(
                    stalls,
                    low,
                    mid - 1,
                    numberOfCows);
        }
    }

    /*
     * ===========================================================================
     * FEASIBILITY CHECK
     * ===========================================================================
     * 
     * Question:
     * Can we place all cows such that every cow maintains
     * at least cowDistance gap?
     * 
     * Greedy Strategy:
     * Always place next cow at earliest valid stall.
     * ===========================================================================
     */
    public static boolean checkFeasible(
            int[] stalls,
            int numberOfCows,
            int cowDistance) {

        /*
         * Place first cow at first stall
         */
        int cowPlacedAt = stalls[0];

        /*
         * One cow already placed
         */
        int numOfCowPlaced = 1;

        /*
         * Start checking remaining stalls
         */
        for (int i = 1; i < stalls.length; i++) {

            /*
             * Check if current stall can place next cow
             * 
             * Required:
             * current stall - last placed cow >= required distance
             */
            if ((stalls[i] - cowPlacedAt) >= cowDistance) {

                /*
                 * Place cow
                 */
                numOfCowPlaced++;

                /*
                 * Update last placed position
                 */
                cowPlacedAt = stalls[i];
            }

            /*
             * If all cows successfully placed
             * 
             * Distance is feasible
             */
            if (numOfCowPlaced == numberOfCows) {
                return true;
            }
        }

        /*
         * Could not place all cows
         * 
         * Distance not feasible
         */
        return false;
    }
}